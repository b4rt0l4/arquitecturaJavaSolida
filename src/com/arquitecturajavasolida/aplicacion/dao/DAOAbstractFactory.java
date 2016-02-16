package com.arquitecturajavasolida.aplicacion.dao;

import com.arquitecturajavasolida.aplicacion.dao.hibernate.DAOHibernateFactory;
import com.arquitecturajavasolida.aplicacion.dao.jpa.DAOJPAFactory;

public abstract class DAOAbstractFactory {
	public static DAOFactory getInstance() {
		String tipo = "JPA";
		
		if (tipo.equals("Hibernate")) {
			return new DAOHibernateFactory();
		} else {
			return new DAOJPAFactory();
		}
	}

}
