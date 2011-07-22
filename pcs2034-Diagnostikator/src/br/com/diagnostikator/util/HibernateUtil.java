package br.com.diagnostikator.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sf = buildSessionFactory();
	
	public static SessionFactory buildSessionFactory(){
		try{
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			return cfg.buildSessionFactory();
			
		}catch(Throwable e){
			System.out.println("Erro session factory " + e);
			throw new ExceptionInInitializerError(e);
		}
	}
	public static SessionFactory getSessionFactory() {
		return sf;
	}
}
