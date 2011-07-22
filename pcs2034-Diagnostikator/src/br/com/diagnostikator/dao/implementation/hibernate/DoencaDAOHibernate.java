package br.com.diagnostikator.dao.implementation.hibernate;

import java.util.List;

import org.hibernate.Session;

import br.com.diagnostikator.dao.DoencaDAO;
import br.com.diagnostikator.model.Doenca;

public class DoencaDAOHibernate implements DoencaDAO {

	private Session session;

	public void setSession(Session s) {
		session = s;
	}

	@Override
	public void save(Doenca doenca) {
		session.save(doenca);

	}

	@Override
	public void delete(Doenca doenca) {
		session.delete(doenca);

	}

	@Override
	public void alter(Doenca doenca) {
		session.update(doenca);

	}

	@Override
	public Doenca getByID(long id) {
		return (Doenca) session.get(Doenca.class, id);
	}
	

	@Override
	public Doenca getByName(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Doenca> list() {
		return session.createCriteria(Doenca.class).list();
	}

}
