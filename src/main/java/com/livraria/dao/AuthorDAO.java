package com.livraria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.livraria.model.Authors;

public class AuthorDAO extends ConnectionDAO {
    
        public List<Authors> searchAuthorsTitle(String name) {

        List<Authors> searchAuthorList = new ArrayList<>();

        try(Connection dbconn = DriverManager.getConnection(URL, USER, PASS)){

            String query = ""
                    + "SELECT * FROM authors "
                    + "WHERE LOWER(name) "
                    + "LIKE LOWER(?)";

            PreparedStatement statement = dbconn.prepareStatement(query);
            statement.setString(1, '%'+name+'%');

            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                System.out.println("WHILE TA FUNCIONANDO"); // DE TESTE
                Authors author = new Authors(Integer.parseInt(rs.getString("author_id")),
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
}
