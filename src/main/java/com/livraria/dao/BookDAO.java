package com.livraria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.livraria.model.Books;

public class BookDAO extends ConnectionDAO {

public List<Books> searchBooksTitle(String name) {
		
		List<Books> searchBookList = new ArrayList<>();
		
		try(Connection dbconn = DriverManager.getConnection(URL, USER, PASS)){
			
			String query = ""
					+ "SELECT * FROM books "
					+ "WHERE LOWER(title) "
					+ "LIKE LOWER(?)";
			
			PreparedStatement statement = dbconn.prepareStatement(query);
			statement.setString(1, '%'+name+'%');
			
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
                System.out.println("WHILE TA FUNCIONANDO"); // DE TESTE
                Books book = new Books(rs.getString("title"), rs.getString("isbn"), rs.getInt("publisher_id"), rs.getDouble("price"));
				searchBookList.add(book);
			}
		}catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("Nao foi possivel adicionar: " + e.getMessage());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("DEU CERTO, MEU BOM!"); // DE TESTE
        System.out.println(searchBookList.get(0));
		return searchBookList;
		
	}

	public boolean addBooks(Books book) throws SQLIntegrityConstraintViolationException {
		try(Connection dbconn = DriverManager.getConnection(URL, USER, PASS)){
			String query = "INSERT INTO Books(title, isbn, publisher_id, price) VALUES (?, ?, ?, ?)";
			PreparedStatement statement = dbconn.prepareStatement(query);
			
			statement.setString(1, book.getTitle());
			statement.setString(2, book.getIsbn());
			statement.setInt(3, book.getPublisherId());
			statement.setDouble(4, book.getPrice());
			
			int res = statement.executeUpdate();
			System.out.println("resultado: " + res);
			return res > 0;
		}catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("Nao foi possivel adicionar: " + e.getMessage());
			throw e;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean deleteBooksAuthors(String isbn) throws SQLIntegrityConstraintViolationException {
		
		Books bookauhtor = null;
		
		try(Connection dbconn = DriverManager.getConnection(URL, USER, PASS)){
			
			String query = "DELETE FROM BooksAuthors WHERE isbn = ?";
			
			PreparedStatement statement = dbconn.prepareStatement(query);
			statement.setString(1, isbn);
			
			int res = statement.executeUpdate();
			System.out.println("resultado: " + res);
			return res > 0;
		}catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("Nao foi possivel apagar: " + e.getMessage());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

	public boolean deleteBooks(String isbn) throws SQLIntegrityConstraintViolationException {
		
		Books book = null;
		
		try(Connection dbconn = DriverManager.getConnection(URL, USER, PASS)){
			
			String query = "DELETE FROM Books WHERE isbn = ?";
			
			PreparedStatement statement = dbconn.prepareStatement(query);
			statement.setString(1, isbn);
			
			int res = statement.executeUpdate();
			System.out.println("resultado: " + res);
			return res > 0;
		}catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("Nao foi possivel apagar: " + e.getMessage());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

}
