package br.com.diagnostikator.dao.implementation.hibernate;

import java.util.List;

import org.hibernate.Session;

import br.com.diagnostikator.dao.FuncionarioDAO;
import br.com.diagnostikator.model.Funcionario;

public class FuncionarioDAOHibernate implements FuncionarioDAO {

	private Session session;

	public void setSession(Session s) {
		session = s;
	}

	@Override
	public void save(Funcionario user) {
		session.save(user);
	}

	@Override
	public void delete(Funcionario user) {
		session.delete(user);
	}

	@Override
	public void alter(Funcionario user) {
		session.update(user);
	}
	
	@Override
	public Funcionario getById(long id) {
		return (Funcionario) session.get(Funcionario.class, id);
	}	
	
	@Override
	public Funcionario getByCpf(String cpf) {
		return (Funcionario) session.createQuery("FROM Funcionario WHERE cpf='" + cpf + "' ").uniqueResult();
	}
	
	@Override
	public Funcionario getByRg(String rg) {
		return (Funcionario) session.createQuery("FROM Funcionario WHERE rg='" + rg + "' ").uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Funcionario> list() {
		return session.createCriteria(Funcionario.class).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Funcionario> getByNome(String nome) {
		return session.createQuery("FROM Funcionario WHERE nome LIKE '%" + nome + "%' ").list();
	}	

	@SuppressWarnings("unchecked")
	@Override
	public List<Funcionario> getByTipo(String tipo) {
		return session.createQuery("FROM Funcionario WHERE tipo LIKE '%" + tipo + "%' ").list();
	}	
}
