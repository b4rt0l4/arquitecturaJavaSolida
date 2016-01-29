package com.arquitecturajavasolida.aplicacion.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajavasolida.aplicacion.bo.Libro;

public class FiltrarLibrosPorCategoriaAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		List<Libro> listaDeLibros = null;
		List<Libro> listaDeCategorias = Libro.buscarTodasLasCategorias();

		String categoria = request.getParameter("categoria");
		if (categoria == null || categoria.equals("seleccionar")) {
			listaDeLibros = Libro.buscarTodos();
		} else {
			listaDeLibros = Libro.buscarPorCategoria(request.getParameter("categoria"));
		}
		
		request.setAttribute("listaDeLibros", listaDeLibros);
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		
		return "MostrarLibros.jsp";
	}

}
