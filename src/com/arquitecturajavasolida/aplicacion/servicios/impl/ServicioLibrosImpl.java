package com.arquitecturajavasolida.aplicacion.servicios.impl;

import java.util.List;

import com.arquitecturajavasolida.aplicacion.bo.Categoria;
import com.arquitecturajavasolida.aplicacion.bo.Libro;
import com.arquitecturajavasolida.aplicacion.dao.CategoriaDAO;
import com.arquitecturajavasolida.aplicacion.dao.LibroDAO;
import com.arquitecturajavasolida.aplicacion.servicios.ServicioLibros;

public class ServicioLibrosImpl implements ServicioLibros {

	private LibroDAO libroDAO = null;
	private CategoriaDAO categoriaDAO = null;

	@Override
	public void insertarLibro(Libro libro) {
		libroDAO.insertar(libro);
	}

	@Override
	public void salvarLibro(Libro libro) {
		libroDAO.salvar(libro);
	}

	@Override
	public void borrarLibro(Libro libro) {
		libroDAO.borrar(libro);
	}

	@Override
	public List<Libro> buscarTodosLosLibros() {
		return libroDAO.buscarTodos();
	}

	@Override
	public List<Categoria> buscarCategoriasLibros() {
		return categoriaDAO.buscarTodos();
	}

	@Override
	public Libro buscarLibroPorClave(String isbn) {
		return libroDAO.buscarPorClave(isbn);
	}

	@Override
	public Categoria buscarCategoriaPorClave(int id) {
		return categoriaDAO.buscarPorClave(id);
	}

	@Override
	public List<Libro> buscarLibrosPorCategoria(int id) {
		Categoria categoria = categoriaDAO.buscarPorClave(id);
		return libroDAO.buscarPorCategoria(categoria);
	}

	@Override
	public LibroDAO getLibroDAO() {
		return libroDAO;
	}

	@Override
	public void setLibroDAO(LibroDAO libroDAO) {
		this.libroDAO = libroDAO;
	}

	@Override
	public CategoriaDAO getCategoriaDAO() {
		return categoriaDAO;
	}

	@Override
	public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
		this.categoriaDAO = categoriaDAO;
	}
}
