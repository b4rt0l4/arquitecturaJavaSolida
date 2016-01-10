package com.arquitecturaJavaSolida.aplicacion.controlador;

public class ControladorLibrosException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ControladorLibrosException () {
		super();
	}
	
	public ControladorLibrosException (String message, Throwable cause) {
		super (message, cause);
	}
	
	public ControladorLibrosException (String message) {
		super (message);
	}
	
	public ControladorLibrosException (Throwable cause) {
		super (cause);
	}

}
