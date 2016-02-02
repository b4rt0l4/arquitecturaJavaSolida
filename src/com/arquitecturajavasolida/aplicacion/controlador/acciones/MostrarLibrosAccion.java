package com.arquitecturajavasolida.aplicacion.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajavasolida.aplicacion.bo.Categoria;
import com.arquitecturajavasolida.aplicacion.bo.Libro;
import com.arquitecturajavasolida.aplicacion.dao.CategoriaDAO;
import com.arquitecturajavasolida.aplicacion.dao.LibroDAO;
import com.arquitecturajavasolida.aplicacion.dao.jpa.CategoriaDAOJPAImpl;
import com.arquitecturajavasolida.aplicacion.dao.jpa.LibroDAOJPAImpl;

public class MostrarLibrosAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		LibroDAO libroDAO = new LibroDAOJPAImpl();
		CategoriaDAO categoriaDAO = new CategoriaDAOJPAImpl();
		
		List<Libro> listaDeLibros = libroDAO.buscarTodos();
		List<Categoria> listaDeCategorias = categoriaDAO.buscarTodos();
		
		request.setAttribute("listaDeLibros", listaDeLibros);
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		
		return "MostrarLibros.jsp";
	}

}
