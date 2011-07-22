package br.com.diagnostikator.util;

import br.com.diagnostikator.dao.DoencaDAO;
import br.com.diagnostikator.dao.FuncionarioDAO;
import br.com.diagnostikator.dao.PacienteDAO;
import br.com.diagnostikator.dao.SintomaDAO;
import br.com.diagnostikator.dao.UsuarioDAO;
import br.com.diagnostikator.dao.implementation.hibernate.DoencaDAOHibernate;
import br.com.diagnostikator.dao.implementation.hibernate.FuncionarioDAOHibernate;
import br.com.diagnostikator.dao.implementation.hibernate.PacienteDAOHibernate;
import br.com.diagnostikator.dao.implementation.hibernate.SintomaDAOHibernate;
import br.com.diagnostikator.dao.implementation.hibernate.UsuarioDAOHibernate;

public class DAOFactory {
	public static UsuarioDAO createUsuarioDAO(){
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}
	
	public static PacienteDAO createPacienteDAO(){
		PacienteDAOHibernate pacienteDAO = new PacienteDAOHibernate();
		pacienteDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return pacienteDAO;
	}
	
	public static DoencaDAO createDoencaDAO(){
		DoencaDAOHibernate doencaDAO = new DoencaDAOHibernate();
		doencaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return doencaDAO;
	}
	
	public static SintomaDAO createSintomaDAO(){
		SintomaDAOHibernate sintomaDAO = new SintomaDAOHibernate();
		sintomaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return sintomaDAO;
	}
	
	public static FuncionarioDAO createFuncionarioDAO(){
		FuncionarioDAOHibernate funcionarioDAO = new FuncionarioDAOHibernate();
		funcionarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return funcionarioDAO;
	}
}
