package com.arquitecturajavasolida.aplicacion.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.arquitecturajavasolida.aplicacion.HibernateHelper;
import com.arquitecturajavasolida.aplicacion.controlador.ControladorLibrosException;

public abstract class Accion {
	
	private static final Logger log = LogManager.getLogger(HibernateHelper.class.getPackage().getName());
	
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
}
