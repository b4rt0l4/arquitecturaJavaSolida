package com.arquitecturajavasolida.aplicacion.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajavasolida.aplicacion.bo.Categoria;
import com.arquitecturajavasolida.aplicacion.bo.Libro;
import com.arquitecturajavasolida.aplicacion.servicios.ServicioLibros;
import com.arquitecturajavasolida.aplicacion.servicios.impl.ServicioLibrosImpl;

public class MostrarLibrosAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		ServicioLibros servicioLibros = new ServicioLibrosImpl();
		
		List<Libro> listaDeLibros = servicioLibros.buscarTodosLosLibros();
		List<Categoria> listaDeCategorias = servicioLibros.buscarCategoriasLibros();
		
		request.setAttribute("listaDeLibros", listaDeLibros);
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		
		return "MostrarLibros.jsp";
	}

}
