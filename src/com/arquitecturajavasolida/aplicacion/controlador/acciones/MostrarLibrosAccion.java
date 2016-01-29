package com.arquitecturajavasolida.aplicacion.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajavasolida.aplicacion.bo.Libro;

public class MostrarLibrosAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		List<Libro> listaDeLibros = Libro.buscarTodos();
		List<Libro> listaDeCategorias = Libro.buscarTodasLasCategorias();
		
		request.setAttribute("listaDeLibros", listaDeLibros);
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		
		return "MostrarLibros.jsp";
	}

}
