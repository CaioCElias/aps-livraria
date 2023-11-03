package com.livraria.dao;

import com.livraria.model.Authors;
import com.livraria.model.Publishers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PublisherDAO extends ConnectionDAO {

    public List<Publishers> searchPublishersTitle(String name) {

        List<Publishers> searchPublisherList = new ArrayList<>();

        try(Connection dbconn = DriverManager.getConnection(URL, USER, PASS)){

            String query = ""
                    + "SELECT * FROM publishers "
                    + "WHERE LOWER(name) "
                    + "LIKE LOWER(?)";

            PreparedStatement statement = dbconn.prepareStatement(query);
            statement.setString(1, '%'+name+'%');

            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                System.out.println("WHILE TA FUNCIONANDO"); // DE TESTE
                Publishers publisher = new Publishers(
                        rs.getString("name"), rs.getString("url"));
                searchPublisherList.add(publisher);
            }
        }catch(SQLIntegrityConstraintViolationException e) {
            System.out.println("Nao foi possivel adicionar: " + e.getMessage());
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("DEU CERTO, MEU BOM!"); // DE TESTE
        System.out.println(searchPublisherList.get(0));
        return searchPublisherList;

    }

    public boolean addPublishers(Publishers publisher) throws SQLIntegrityConstraintViolationException {

        try (Connection dbconn = DriverManager.getConnection(URL, USER, PASS)) {
            String query = "INSERT INTO Publishers(name, url) VALUES (?, ?)";
            PreparedStatement statement = dbconn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
    
            statement.setString(1, publisher.getName());
            statement.setString(2, publisher.getUrl());
    
            int rowsInserted = statement.executeUpdate();
    
            if (rowsInserted > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedPublisherId = generatedKeys.getInt(1);
                    publisher.setPublisherId(generatedPublisherId);
                }
                return true;
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Não foi possível adicionar a editora: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean deletePublisherAndBooks(int publisherId) throws SQLIntegrityConstraintViolationException {
        try (Connection dbconn = DriverManager.getConnection(URL, USER, PASS)) {
            dbconn.setAutoCommit(false);
    
            String deleteBooksAuthorsQuery = "DELETE FROM BooksAuthors WHERE isbn IN (SELECT isbn FROM Books WHERE publisher_id = ?)";
            PreparedStatement booksAuthorsStatement = dbconn.prepareStatement(deleteBooksAuthorsQuery);
            booksAuthorsStatement.setInt(1, publisherId);
            int booksAuthorsDeleted = booksAuthorsStatement.executeUpdate();
            booksAuthorsStatement.close();
    
            String deleteBooksQuery = "DELETE FROM Books WHERE publisher_id = ?";
            PreparedStatement booksStatement = dbconn.prepareStatement(deleteBooksQuery);
            booksStatement.setInt(1, publisherId);
            int booksDeleted = booksStatement.executeUpdate();
            booksStatement.close();
    
            String deletePublisherQuery = "DELETE FROM Publishers WHERE publisher_id = ?";
            PreparedStatement publisherStatement = dbconn.prepareStatement(deletePublisherQuery);
            publisherStatement.setInt(1, publisherId);
            int publisherDeleted = publisherStatement.executeUpdate();
            publisherStatement.close();
    
            // Passo 4: Confirmar a transação
            dbconn.commit();
    
            // Se todos os passos forem bem-sucedidos, retorne true
            return (booksAuthorsDeleted > 0) && (booksDeleted > 0) && (publisherDeleted > 0);
        } catch (SQLException e) {
            System.out.println("Não foi possível apagar: " + e.getMessage());
        }
        return false;
    }
}
