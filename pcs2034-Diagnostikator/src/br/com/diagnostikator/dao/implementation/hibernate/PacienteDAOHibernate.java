package br.com.diagnostikator.dao.implementation.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.diagnostikator.dao.PacienteDAO;
import br.com.diagnostikator.model.Paciente;

public class PacienteDAOHibernate implements PacienteDAO{

	private Session session;
	public void setSession(Session s){
		session = s;
	}
	
	@Override
	public void save(Paciente user) {
		session.save(user);
		
	}

	@Override
	public void delete(Paciente user) {
		session.delete(user);
		
	}

	@Override
	public void alter(Paciente user) {
		session.update(user);
		
	}

	@Override
	public Paciente getById(long id) {
		return (Paciente) session.get(Paciente.class, id);
	}

	@Override
	public Paciente getByCpf(String cpf) {
		String hql = "SELECT u FROM Paciente u WHERE u.cpf = :cpf";
		Query query = session.createQuery(hql);
		query.setString("cpf",cpf);
		return (Paciente) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Paciente> list() {
		return session.createCriteria(Paciente.class).list();
	}

}
