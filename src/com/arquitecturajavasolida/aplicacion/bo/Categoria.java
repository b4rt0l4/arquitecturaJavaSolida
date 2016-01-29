package com.arquitecturajavasolida.aplicacion.bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.arquitecturajavasolida.aplicacion.HibernateHelper;

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
	
	@SuppressWarnings("unchecked")
	public static List<Categoria> buscarTodos() {
		
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		
		List<Categoria> listaDeCategorias = session.createQuery("from Categoria categoria").list();
		
		session.close();
		
		return listaDeCategorias;
	}
	
	public static Categoria buscarPorClave(int id) {

		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		Query consulta = session.createQuery("from Categoria categoria where id=:id");
		consulta.setInteger("id", id);
		
		Categoria categoria = (Categoria) ((org.hibernate.Query) consulta).uniqueResult();
		session.close();
		return categoria;

	}
}