package com.arquitecturajavasolida.aplicacion.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajavasolida.aplicacion.bo.Libro;

public class FormularioEditarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		String isbn = request.getParameter("isbn");

		List<Libro> listaDeCategorias = Libro.buscarTodasLasCategorias();
		Libro libro = Libro.buscarPorClave(isbn);
		
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		request.setAttribute("libro", libro);

		return "FormularioEditarLibro.jsp";
	}

}
