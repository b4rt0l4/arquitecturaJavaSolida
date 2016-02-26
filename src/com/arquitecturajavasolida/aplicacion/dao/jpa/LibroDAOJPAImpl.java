package com.arquitecturajavasolida.aplicacion.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.arquitecturajavasolida.aplicacion.bo.Categoria;
import com.arquitecturajavasolida.aplicacion.bo.Libro;
import com.arquitecturajavasolida.aplicacion.dao.LibroDAO;

public class LibroDAOJPAImpl extends GenericDAOJPAImpl<Libro, String> implements LibroDAO {

	@Override
	//Sobreescribimos esta función por razones de rendimiento
	public List<Libro> buscarTodos() {
		EntityManager manager = getEntityManagerFactory().createEntityManager();
		TypedQuery<Libro> consulta = manager.createQuery("SELECT l FROM Libro l LEFT JOIN FETCH l.categoria", Libro.class);
		List<Libro> listaDeLibros = null;
		
		try {
			listaDeLibros = consulta.getResultList();
		} finally {
			manager.close();
		}
		return listaDeLibros;
	}

	public List<Libro> buscarPorCategoria(Categoria categoria) {
		EntityManager manager = getEntityManagerFactory().createEntityManager();
		
		TypedQuery<Libro> consulta = manager.createQuery("Select l from Libro l where l.categoria=?1", Libro.class);
		consulta.setParameter(1, categoria);
		List<Libro> listaDeLibros = null;
		
		try {
			listaDeLibros = consulta.getResultList();
		} finally {
			manager.close();
		}
		
		return listaDeLibros;
	}
}
