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

public class FiltrarLibrosPorCategoriaAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		LibroDAO libroDAO = new LibroDAOJPAImpl();
		CategoriaDAO categoriaDAO = new CategoriaDAOJPAImpl();
		List<Libro> listaDeLibros = null;
		List<Categoria> listaDeCategorias = categoriaDAO.buscarTodos();

		String categoria = request.getParameter("categoria");
		if (categoria == null || categoria.equals("seleccionar")) {
			listaDeLibros = libroDAO.buscarTodos();
		} else {
			Categoria categoriaSeleccionada = categoriaDAO.buscarPorClave(Integer.parseInt(categoria));
			listaDeLibros = libroDAO.buscarPorCategoria(categoriaSeleccionada);
		}
		
		request.setAttribute("listaDeLibros", listaDeLibros);
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		
		return "MostrarLibros.jsp";
	}

}
