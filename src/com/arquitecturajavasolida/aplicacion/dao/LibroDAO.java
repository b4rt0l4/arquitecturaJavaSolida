package com.arquitecturajavasolida.aplicacion.dao;

import java.util.List;

import com.arquitecturajavasolida.aplicacion.bo.Categoria;
import com.arquitecturajavasolida.aplicacion.bo.Libro;

public interface LibroDAO extends GenericDAO<Libro, String> {
	public abstract List<Libro> buscarPorCategoria(Categoria categoria);
}