package com.arquitecturajavasolida.aplicacion.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajavasolida.aplicacion.bo.Categoria;
import com.arquitecturajavasolida.aplicacion.bo.Libro;
import com.arquitecturajavasolida.aplicacion.servicios.ServicioLibros;

public class FiltrarLibrosPorCategoriaAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServicioLibros servicio = (ServicioLibros) getBean("servicioLibros", request);

		List<Libro> listaDeLibros = null;
		List<Categoria> listaDeCategorias = servicio.buscarCategoriasLibros();

		String categoria = request.getParameter("categoria");
		if (categoria == null || categoria.equals("seleccionar")) {
			listaDeLibros = servicio.buscarTodosLosLibros();
		} else {
			listaDeLibros = servicio.buscarLibrosPorCategoria(Integer.parseInt(categoria));
		}
		
		request.setAttribute("listaDeLibros", listaDeLibros);
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		
		return "MostrarLibros.jsp";
	}

}
