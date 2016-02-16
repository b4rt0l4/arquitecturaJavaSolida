package com.arquitecturajavasolida.aplicacion.dao.hibernate;

import com.arquitecturajavasolida.aplicacion.dao.CategoriaDAO;
import com.arquitecturajavasolida.aplicacion.dao.DAOFactory;
import com.arquitecturajavasolida.aplicacion.dao.LibroDAO;

public class DAOHibernateFactory implements DAOFactory {
	public CategoriaDAO getCategoriaDAO() {
		return new CategoriaDAOHibernateImpl();
	}

	public LibroDAO getLibroDAO() {
		return new LibroDAOHibernateImpl();
	}
}
