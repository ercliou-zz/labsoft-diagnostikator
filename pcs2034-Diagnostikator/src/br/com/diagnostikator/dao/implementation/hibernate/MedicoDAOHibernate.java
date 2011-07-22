package br.com.diagnostikator.dao.implementation.hibernate;

import java.util.List;

import org.hibernate.Session;

import br.com.diagnostikator.dao.MedicoDAO;
import br.com.diagnostikator.model.Medico;

public class MedicoDAOHibernate implements MedicoDAO {

	private Session session;
	
	public void setSession(Session s){
		session = s;
	}
	
	@Override
	public void save(Medico medico) {
		session.save(medico);
	}

	@Override
	public void delete(Medico medico) {
		session.delete(medico);
	}

	@Override
	public void alter(Medico medico) {
		session.update(medico);
	}

	@Override
	public Medico getById(long id) {
		return (Medico) session.get(Medico.class, id);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Medico> list() {
		return session.createCriteria(Medico.class).list();
	}

	@Override
	public Medico getByCpf(String cpf) {
		return (Medico) session.createQuery("FROM Medico u WHERE u.cpf='" + cpf + "' ").uniqueResult();
	}
	
}
