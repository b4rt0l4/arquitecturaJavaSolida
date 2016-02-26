package com.arquitecturajavasolida.aplicacion.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.arquitecturajavasolida.aplicacion.controlador.ControladorLibrosException;
import com.arquitecturajavasolida.aplicacion.dao.jpa.JPAHelper;

public abstract class Accion {
	
	private static final Logger log = LogManager.getLogger(JPAHelper.class.getPackage().getName());
	
	//Constantes de error
	private final static String CLASENOENCONTRADA = "Clase no encontrada";
	private final static String ERRORDEINSTANCIACION = "Error de instanciación";
	private final static String ERRORDEACCESOILEGAL = "Error de acceso ilegal";
	
	public abstract String ejecutar(HttpServletRequest request,	HttpServletResponse response);
	
	public  static Accion getAccion(String tipo) {

		Accion accion = null;
		try {
			accion = (Accion) Class.forName(getPackage() + "." + tipo + "Accion").newInstance();
		} catch (InstantiationException e) {
			log.error(ERRORDEINSTANCIACION + ": " + e.getMessage());
			throw new ControladorLibrosException(ERRORDEINSTANCIACION + ": ", e);
		} catch (IllegalAccessException e) {
			log.error(ERRORDEACCESOILEGAL + ": " + e.getMessage());
			throw new ControladorLibrosException(ERRORDEACCESOILEGAL + ": ", e);
		} catch (ClassNotFoundException e) {
			log.error(CLASENOENCONTRADA + ": " + e.getMessage());
			throw new ControladorLibrosException(CLASENOENCONTRADA + ": ", e);
		}
		return accion;
	}
	
	private static  String getPackage() {
		return Accion.class.getPackage().getName();
	}

	public Object getBean (String nombre, HttpServletRequest request) {
		WebApplicationContext factoria = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
		return factoria.getBean(nombre);
	}
}
