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
}
