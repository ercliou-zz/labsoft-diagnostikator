package br.com.diagnostikator.util;

import br.com.diagnostikator.dao.*;
import br.com.diagnostikator.dao.implementation.hibernate.*;


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
	
	public static MedicoDAO createMedicoDAO(){
		MedicoDAOHibernate medicoDAO = new MedicoDAOHibernate();
		medicoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return medicoDAO;
	}
	
	public static DiagnosticoDAO createDiagnosticoDAO(){
		DiagnosticoDAOHibernate diagnosticoDAO = new DiagnosticoDAOHibernate();
		diagnosticoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return diagnosticoDAO;
	}
	
	public static ConsultaAgendadaDAO createConsultaAgendadaDAO(){
		ConsultaAgendadaDAOHibernate consultaAgendadaDAO = new ConsultaAgendadaDAOHibernate();
		consultaAgendadaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return consultaAgendadaDAO;
	}
	
	public static ConsultaConfirmadaDAO createConsultaConfirmadaDAO(){
		ConsultaConfirmadaDAOHibernate consultaConfirmadaDAO = new ConsultaConfirmadaDAOHibernate();
		consultaConfirmadaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return consultaConfirmadaDAO;
	}
	
	public static ProntuarioDAO createProntuarioDAO(){
		ProntuarioDAOHibernate prontuarioDAO = new ProntuarioDAOHibernate();
		prontuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return prontuarioDAO;
	}
}
