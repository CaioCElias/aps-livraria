package com.livraria.dao;

// Classe para padronizar as exceções do código
public class ExceptionDAO extends Exception {

    public ExceptionDAO(String message) {
        super(message);
    }
    
}
