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
	public Medico getByCodigo(int codigo) {
		return (Medico) session.get(Medico.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medico> getByNome(String nome) {
		return session.createQuery("FROM Medico m WHERE m.nome LIKE '%" + nome + "%' ").list();		
	}

	@Override
	public Medico getByRg(String rg) {
		return (Medico) session.createQuery("FROM Medico m where m.rg=:rg").setString("rg", rg).uniqueResult();
	}

	@Override
	public Medico getByCpf(String cpf) {
		return (Medico) session.createQuery("FROM Medico m where m.cpf=:cpf").setString("cpf", cpf).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medico> getByEspecialide(String especialidade) {
		return session.createQuery("FROM Medico m WHERE m.especialidade LIKE '%" + especialidade + "%' ").list();
	}

	@Override
	public Medico getByCrm(int crm) {
		return (Medico) session.createQuery("FROM Medico m where m.crm=:crm").setInteger("crm", crm).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medico> list() {
		return session.createCriteria(Medico.class).list();
	}
}
