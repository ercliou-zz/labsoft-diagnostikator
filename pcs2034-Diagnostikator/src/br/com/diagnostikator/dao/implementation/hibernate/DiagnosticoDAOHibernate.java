package br.com.diagnostikator.dao.implementation.hibernate;

import org.hibernate.Session;

import br.com.diagnostikator.dao.DiagnosticoDAO;
import br.com.diagnostikator.model.Diagnostico;

public class DiagnosticoDAOHibernate implements DiagnosticoDAO {

	private Session session;

	public void setSession(Session s) {
		session = s;
	}

	@Override
	public void save(Diagnostico diagnostico) {
		session.save(diagnostico);

	}

	@Override
	public void delete(Diagnostico diagnostico) {
		session.delete(diagnostico);

	}

	@Override
	public void alter(Diagnostico diagnostico) {
		session.update(diagnostico);

	}

	@Override
	public Diagnostico getByID(long id) {
		return (Diagnostico) session.get(Diagnostico.class, id);
	}
	
}
