package com.arquitecturajavasolida.aplicacion.servicios;

import java.util.List;

import com.arquitecturajavasolida.aplicacion.bo.Categoria;
import com.arquitecturajavasolida.aplicacion.bo.Libro;
import com.arquitecturajavasolida.aplicacion.dao.CategoriaDAO;
import com.arquitecturajavasolida.aplicacion.dao.LibroDAO;

public interface ServicioLibros {
	public void insertarLibro(Libro libro);
	public void salvarLibro(Libro libro);
	public void borrarLibro(Libro libro);
	public List<Libro> buscarTodosLosLibros();
	public List<Categoria> buscarCategoriasLibros();
	public Libro buscarLibroPorClave(String isbn);
	public Categoria buscarCategoriaPorClave(int id);
	public List<Libro> buscarLibrosPorCategoria(int categoria);
	public LibroDAO getLibroDAO();
	public void setLibroDAO(LibroDAO libroDAO);
	public CategoriaDAO getCategoriaDAO();
	public void setCategoriaDAO(CategoriaDAO categoriaDAO);
}
