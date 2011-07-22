package br.com.diagnostikator.dao.implementation.hibernate;

import java.util.List;

import org.hibernate.Session;

import br.com.diagnostikator.dao.ConsultaConfirmadaDAO;
import br.com.diagnostikator.model.ConsultaConfirmada;

public class ConsultaConfirmadaDAOHibernate implements ConsultaConfirmadaDAO {

	private Session session;

	public void setSession(Session s) {
		session = s;
	}

	@Override
	public void save(ConsultaConfirmada consultaConfirmada) {
		session.save(consultaConfirmada);

	}

	@Override
	public void delete(ConsultaConfirmada consultaConfirmada) {
		session.delete(consultaConfirmada);

	}

	@Override
	public void alter(ConsultaConfirmada consultaConfirmada) {
		session.update(consultaConfirmada);

	}

	@Override
	public ConsultaConfirmada getByID(long id) {
		return (ConsultaConfirmada) session.get(ConsultaConfirmada.class, id);
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<ConsultaConfirmada> list() {
		return session.createCriteria(ConsultaConfirmada.class).list();
	}

}
