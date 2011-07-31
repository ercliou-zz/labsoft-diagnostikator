package br.com.diagnostikator.dao.implementation.hibernate;

import java.util.List;
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
		return (Paciente) session.createQuery("FROM Paciente WHERE cpf='" + cpf + "' ").uniqueResult();
	}
	
	@Override
	public Paciente getByRg(String rg) {
		return (Paciente) session.createQuery("FROM Paciente WHERE rg='" + rg + "' ").uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Paciente> getByNome(String nome) {
		return session.createQuery("FROM Paciente WHERE nome LIKE '%" + nome + "%' ").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Paciente> list() {
		return session.createCriteria(Paciente.class).list();
	}	
}
