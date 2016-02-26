package com.arquitecturajavasolida.aplicacion.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajavasolida.aplicacion.bo.Libro;
import com.arquitecturajavasolida.aplicacion.servicios.ServicioLibros;

public class BorrarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		String isbn = request.getParameter("isbn");
		ServicioLibros servicio = (ServicioLibros) getBean("servicioLibros", request);
		
		Libro libro = new Libro(isbn);
		servicio.borrarLibro(libro);
		
		return "MostrarLibros.do";
	}

}
