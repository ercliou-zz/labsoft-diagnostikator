package br.com.diagnostikator.dao.implementation.hibernate;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import br.com.diagnostikator.dao.ConsultaConfirmadaDAO;
import br.com.diagnostikator.model.ConsultaConfirmada;
import br.com.diagnostikator.model.Funcionario;
import br.com.diagnostikator.model.Prontuario;

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
	

	public Prontuario getProntuarioByID(long id){
		SQLQuery query = session.createSQLQuery("SELECT prontuario.* from prontuario inner join consultaConfirmada on consultaConfirmada.prontuario_fk = prontuario.id where prontuario.id=:id");
		//where owner.name=:username
		query.addEntity(Prontuario.class);
		query.setInteger("id",(int)id);
		Prontuario prontuario =(Prontuario)query.uniqueResult();
		//Prontuario prontuario = (Prontuario) session.createQuery("FROM Prontuario p, ConsultaConfirmada c WHERE c.prontuario_fk = p.id").uniqueResult();
		// AND p.id =' "+id+"'
		
		return prontuario;
	}

}
