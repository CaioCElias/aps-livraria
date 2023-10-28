package com.livraria.dao;

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
                Publishers publisher = new Publishers(Integer.parseInt(rs.getString("publisher_id")),
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
}
