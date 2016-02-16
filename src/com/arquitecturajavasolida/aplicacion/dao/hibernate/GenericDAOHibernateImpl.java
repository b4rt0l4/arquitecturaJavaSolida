package com.arquitecturajavasolida.aplicacion.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.arquitecturajavasolida.aplicacion.dao.GenericDAO;

public class GenericDAOHibernateImpl<T, Id extends Serializable> implements GenericDAO<T, Id> {

	private Class<T> claseDePersistencia;
	
	@SuppressWarnings("unchecked")
	public GenericDAOHibernateImpl() {
		this.claseDePersistencia = (Class<T>) ( (ParameterizedType)  getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Session getManager() {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		
		return session;
	}	
	
	@Override
	public T buscarPorClave(Id id) {
		Session session = getManager();
		
		T objeto = null;
		try {
			objeto = (T) session.get(claseDePersistencia, id);
		} finally {
			session.close();
		}		
		
		return objeto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> buscarTodos() {
		Session session = getManager();
		
		List<T> listaDeObjetos = session.createQuery("from " + claseDePersistencia.getSimpleName() + " o").list();
		
		session.close();
		
		return listaDeObjetos;
	}

	@Override
	public void insertar(T objeto) {
		Session session = getManager();
		
		session.beginTransaction();
		session.save(objeto);
		session.getTransaction().commit();
		
		session.close();			
	}

	@Override
	public void salvar(T objeto) {
		Session session = getManager();
		
		session.beginTransaction();
		session.saveOrUpdate(objeto);
		session.getTransaction().commit();
		
		session.close();
	}

	@Override
	public void borrar(T objeto) {
		Session session = getManager();;
		
		session.beginTransaction();
		session.delete(objeto);
		session.getTransaction().commit();
		
		session.close();
	}	
}
