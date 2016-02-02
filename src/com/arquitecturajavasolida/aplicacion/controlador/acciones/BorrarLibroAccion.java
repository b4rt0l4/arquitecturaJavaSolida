package com.arquitecturajavasolida.aplicacion.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajavasolida.aplicacion.bo.Libro;
import com.arquitecturajavasolida.aplicacion.dao.LibroDAO;
import com.arquitecturajavasolida.aplicacion.dao.jpa.LibroDAOJPAImpl;

public class BorrarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		String isbn = request.getParameter("isbn");
		LibroDAO libroDAO = new LibroDAOJPAImpl();
		
		Libro libro = new Libro(isbn);
		libroDAO.borrar(libro);
		
		return "MostrarLibros.do";
	}

}
