package br.com.diagnostikator.dao.implementation.hibernate;

import java.util.List;

import org.hibernate.Query;
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
	public Funcionario getByCodigo(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> getByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Funcionario getByRg(String rg) {
		String hql = "SELECT u FROM Funcionario u WHERE u.rg = :rg";
		Query query = session.createQuery(hql);
		query.setString("rg",rg);
		return (Funcionario) query.uniqueResult();
	}

	@Override
	public Funcionario getByCpf(String cpf) {
		String hql = "SELECT u FROM Funcionario u WHERE u.cpf = :cpf";
		Query query = session.createQuery(hql);
		query.setString("cpf",cpf);
		return (Funcionario) query.uniqueResult();
	}

	@Override
	public List<Funcionario> getLista() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getListaStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getListaTipos() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
