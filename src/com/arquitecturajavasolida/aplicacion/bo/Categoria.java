package com.arquitecturajavasolida.aplicacion.bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import com.arquitecturajavasolida.aplicacion.JPAHelper;

@Entity
@Table(name = "categorias")
public class Categoria {
	@Id
	private int id;
	private String descripcion;
	@OneToMany
	@JoinColumn(name = "categoria")
	private List<Libro> listaDeLibros;
	
	@Override
	public int hashCode() {
		return id;
	}
	
	@Override
	public boolean equals (Object o) {
		int categoriaId = ((Categoria)o).getId();
		return id == categoriaId;
	}
	
	public Categoria() {
		super();
	}
	
	public Categoria(int id) {
		super();
		this.id = id;
	}
	
	public Categoria(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public List<Libro> getListaDeLibros() {
		return listaDeLibros;
	}
	
	public void setListaDeLibros(List<Libro> listaDeLibros) {
		this.listaDeLibros = listaDeLibros;
	}
	
	public static List<Categoria> buscarTodos() {
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		
		TypedQuery<Categoria> consulta = manager.createQuery("SELECT c FROM Categoria c", Categoria.class);
		List<Categoria> listaDeCategorias = null;
		
		try {
			listaDeCategorias = consulta.getResultList();
		} finally {
			manager.close();
		}
		
		return listaDeCategorias;
	}
	
	public static Categoria buscarPorClave(int id) {
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		
		TypedQuery<Categoria> consulta = manager.createQuery("Select c from Categoria c where c.id=?1", Categoria.class);
		consulta.setParameter(1, id);
		Categoria categoria = null;
		
		try {
			categoria = consulta.getSingleResult();
		} finally {
			manager.close();
		}
		
		return categoria;
	}
}