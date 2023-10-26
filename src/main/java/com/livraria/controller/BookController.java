package com.livraria.controller;

import java.util.List;
import javax.swing.text.View;

import com.livraria.dao.BookDAO;
import com.livraria.view.BookView;

public class BookController {
    BookDAO model;
	BookView view;
	
	public BookController(BookDAO model, BookView view) {
		this.model = model;
		this.view = view;
	}
	
	public void init() {
		
		view.addBuscaPatoByNameListener(new AcaoBuscar());
	}

}
