package com.arquitecturajavasolida.aplicacion.dao.jpa;

import com.arquitecturajavasolida.aplicacion.dao.CategoriaDAO;
import com.arquitecturajavasolida.aplicacion.dao.DAOFactory;
import com.arquitecturajavasolida.aplicacion.dao.LibroDAO;

public class DAOJPAFactory implements DAOFactory {
	public CategoriaDAO getCategoriaDAO() {
		return new CategoriaDAOJPAImpl();
	}

	public LibroDAO getLibroDAO() {
		return new LibroDAOJPAImpl();
	}
}
