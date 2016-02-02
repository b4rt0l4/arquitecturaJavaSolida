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

public class FormularioEditarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		String isbn = request.getParameter("isbn");

		LibroDAO libroDAO = new LibroDAOJPAImpl();
		CategoriaDAO categoriaDAO = new CategoriaDAOJPAImpl();
		List<Categoria> listaDeCategorias = categoriaDAO.buscarTodos();
		Libro libro = libroDAO.buscarPorClave(isbn);
		
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		request.setAttribute("libro", libro);

		return "FormularioEditarLibro.jsp";
	}

}
