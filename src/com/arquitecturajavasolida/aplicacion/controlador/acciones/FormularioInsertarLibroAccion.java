package com.arquitecturajavasolida.aplicacion.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajavasolida.aplicacion.bo.Categoria;
import com.arquitecturajavasolida.aplicacion.servicios.ServicioLibros;

public class FormularioInsertarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServicioLibros servicio = (ServicioLibros) getBean("servicioLibros", request);

		List<Categoria> listaDeCategorias = servicio.buscarCategoriasLibros();
		
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		
		return "FormularioInsertarLibro.jsp";
	}

}
