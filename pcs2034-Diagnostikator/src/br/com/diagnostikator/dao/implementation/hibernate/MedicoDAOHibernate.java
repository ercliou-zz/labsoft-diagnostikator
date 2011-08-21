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

	@Override
	public Medico getByCpf(String cpf) {
		return (Medico) session.createQuery("FROM Medico WHERE cpf='" + cpf + "' ").uniqueResult();
	}
	
	public Medico getByRg(String rg) {
		return (Medico) session.createQuery("FROM Medico WHERE rg='" + rg + "' ").uniqueResult();		
	}
	
	public Medico getByCrm(String crm) {
		return (Medico) session.createQuery("FROM Medico WHERE crm='" + crm + "' ").uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Medico> getByEspecialidade(String especialidade) {
		return session.createQuery("FROM Medico WHERE especialidade LIKE '%" + especialidade + "%' ").list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Medico> getByNome(String nome) {
		return session.createQuery("FROM Medico WHERE nome LIKE '%" + nome + "%' ").list();
	}	
	
	@SuppressWarnings("unchecked")
	public List<Medico> getByTipo(String tipo) {
		return session.createQuery("FROM Medico WHERE tipo LIKE '%" + tipo + "%' ").list();		
	}
	
	@Override
	public Medico getByLogin(String login) {
			return (Medico) session.createQuery("FROM Medico WHERE login='" + login + "' ").uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medico> list() {
		return session.createCriteria(Medico.class).list();
	}	
}
