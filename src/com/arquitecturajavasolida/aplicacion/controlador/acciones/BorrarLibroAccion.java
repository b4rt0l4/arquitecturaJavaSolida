package com.arquitecturajavasolida.aplicacion.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajavasolida.aplicacion.bo.Libro;
import com.arquitecturajavasolida.aplicacion.dao.DAOAbstractFactory;
import com.arquitecturajavasolida.aplicacion.dao.DAOFactory;
import com.arquitecturajavasolida.aplicacion.dao.LibroDAO;

public class BorrarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		String isbn = request.getParameter("isbn");
		DAOFactory factoria = DAOAbstractFactory.getInstance();
		LibroDAO libroDAO = factoria.getLibroDAO();
		
		Libro libro = new Libro(isbn);
		libroDAO.borrar(libro);
		
		return "MostrarLibros.do";
	}

}
