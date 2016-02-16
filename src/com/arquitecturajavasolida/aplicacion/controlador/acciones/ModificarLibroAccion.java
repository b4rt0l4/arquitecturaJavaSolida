package com.arquitecturajavasolida.aplicacion.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajavasolida.aplicacion.bo.Categoria;
import com.arquitecturajavasolida.aplicacion.bo.Libro;
import com.arquitecturajavasolida.aplicacion.servicios.ServicioLibros;
import com.arquitecturajavasolida.aplicacion.servicios.impl.ServicioLibrosImpl;

public class ModificarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String categoria = request.getParameter("categoria");
		Categoria objetoCategoria = new Categoria(Integer.parseInt(categoria));

		ServicioLibros servicioLibros = new ServicioLibrosImpl();

		Libro libro = new Libro(isbn, titulo, objetoCategoria);

		servicioLibros.salvarLibro(libro);
		
		return "MostrarLibros.do";
	}

}
