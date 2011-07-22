package br.com.diagnostikator.dao.implementation.hibernate;

import java.util.List;

import org.hibernate.Session;

import br.com.diagnostikator.dao.SintomaDAO;
import br.com.diagnostikator.model.Sintoma;

public class SintomaDAOHibernate implements SintomaDAO {

	private Session session;

	public void setSession(Session s) {
		session = s;
	}

	@Override
	public void save(Sintoma sintoma) {
		session.save(sintoma);

	}

	@Override
	public void delete(Sintoma sintoma) {
		session.delete(sintoma);

	}

	@Override
	public void alter(Sintoma sintoma) {
		session.update(sintoma);

	}

	@Override
	public Sintoma getByID(long id) {
		return (Sintoma) session.get(Sintoma.class, id);
	}
	

	@Override
	public Sintoma getByName(String nome) {
		return (Sintoma) session.createQuery("FROM Sintoma s WHERE s.nome='" + nome + "' ").uniqueResult();		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sintoma> list() {
		return session.createCriteria(Sintoma.class).list();
	}
}
