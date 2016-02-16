package com.arquitecturajavasolida.aplicacion.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.arquitecturajavasolida.aplicacion.bo.Categoria;
import com.arquitecturajavasolida.aplicacion.bo.Libro;
import com.arquitecturajavasolida.aplicacion.dao.LibroDAO;

public class LibroDAOHibernateImpl extends GenericDAOHibernateImpl<Libro, String> implements LibroDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Libro> buscarTodos() {
		Session session = getManager();
		
		List<Libro> listaDeLibros = null;
		listaDeLibros = session.createQuery("from Libro libro left join fetch libro.categoria").list();
		
		session.close();
		
		return listaDeLibros;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Libro> buscarPorCategoria(Categoria categoria) {
		Session session = getManager();
		
		Query consulta = session.createQuery("from Libro libro where libro.categoria=:categoria");
		consulta.setEntity("categoria", categoria);
		
		List<Libro> listaDeLibros = consulta.list();
		session.close();
		
		return listaDeLibros;
	}

}
