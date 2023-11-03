package com.livraria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import com.livraria.model.Authors;
import com.livraria.model.Books;

public class AuthorDAO extends ConnectionDAO {
    
        public List<Authors> searchAuthorsTitle(String name, String fName) {

        List<Authors> searchAuthorList = new ArrayList<>();

        try(Connection dbconn = DriverManager.getConnection(URL, USER, PASS)){

            String query = ""
                    + "SELECT * FROM authors "
                    + "WHERE LOWER(name) "
                    + "LIKE LOWER(?) "
                    + "AND LOWER(fName) "
                    + "LIKE LOWER(?)";

            PreparedStatement statement = dbconn.prepareStatement(query);
            statement.setString(1, '%'+name+'%');
            statement.setString(2, '%'+fName+'%');  

            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                System.out.println("WHILE TA FUNCIONANDO"); // DE TESTE
                Authors author = new Authors(
                        rs.getString("name"), rs.getString("fName"));
                searchAuthorList.add(author);
            }
        }catch(SQLIntegrityConstraintViolationException e) {
            System.out.println("Nao foi possivel adicionar: " + e.getMessage());
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("DEU CERTO, MEU BOM!"); // DE TESTE
        System.out.println(searchAuthorList.get(0));
        return searchAuthorList;

    }

    public boolean addAuthors(Authors author) throws SQLIntegrityConstraintViolationException {

        try (Connection dbconn = DriverManager.getConnection(URL, USER, PASS)) {
            String query = "INSERT INTO Authors(name, fName) VALUES (?, ?)";
            PreparedStatement statement = dbconn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
    
            statement.setString(1, author.getName());
            statement.setString(2, author.getFName());
    
            int rowsInserted = statement.executeUpdate();
    
            if (rowsInserted > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedAuthorId = generatedKeys.getInt(1);
                    author.setAuthorId(generatedAuthorId);
                }
                return true;
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Não foi possível adicionar o autor: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteAuthorsAndBooks(int authorId) throws SQLIntegrityConstraintViolationException {
		
		Authors author = null;
		
		try(Connection dbconn = DriverManager.getConnection(URL, USER, PASS)){
            dbconn.setAutoCommit(false);
			
			String firstQuery = "DELETE FROM BooksAuthors WHERE author_id = ?";
			PreparedStatement firstStatement = dbconn.prepareStatement(firstQuery);
			firstStatement.setInt(1, authorId);
			int firstRes = firstStatement.executeUpdate();
            firstStatement.close();

            String secondQuery = "DELETE FROM Books WHERE isbn NOT IN (SELECT isbn FROM BooksAuthors)";
			PreparedStatement secondStatement = dbconn.prepareStatement(secondQuery);
			// secondStatement.setInt(1, authorId);
			int secondRes = secondStatement.executeUpdate();
            secondStatement.close();

            String thirdQuery = "DELETE FROM Authors WHERE author_id = ?";
			PreparedStatement thirdStatement = dbconn.prepareStatement(thirdQuery);
			thirdStatement.setInt(1, authorId);
			int thirdRes = thirdStatement.executeUpdate();
            thirdStatement.close();

            dbconn.commit();

			return (firstRes > 0) && (secondRes > 0) && (thirdRes > 0);
		}catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("Nao foi possivel apagar: " + e.getMessage());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
}
