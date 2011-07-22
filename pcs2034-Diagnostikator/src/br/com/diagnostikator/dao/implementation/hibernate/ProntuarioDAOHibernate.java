package br.com.diagnostikator.dao.implementation.hibernate;

import java.util.List;

import org.hibernate.Session;

import br.com.diagnostikator.dao.ProntuarioDAO;
import br.com.diagnostikator.model.Prontuario;

public class ProntuarioDAOHibernate implements ProntuarioDAO {

	private Session session;
	
	public void setSession(Session s){
		session = s;
	}
	
	@Override
	public void save(Prontuario prontuario) {
		session.save(prontuario);
	}

	@Override
	public void delete(Prontuario prontuario) {
		session.delete(prontuario);
	}

	@Override
	public void alter(Prontuario prontuario) {
		session.update(prontuario);
	}

	@Override
	public Prontuario getById(long id) {
		return (Prontuario) session.get(Prontuario.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Prontuario> list() {
		return session.createCriteria(Prontuario.class).list();
	}

}
