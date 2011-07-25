package br.com.diagnostikator.dao.implementation.hibernate;

import java.util.List;

import org.hibernate.Session;

import br.com.diagnostikator.dao.ConsultaAgendadaDAO;
import br.com.diagnostikator.model.ConsultaAgendada;

public class ConsultaAgendadaDAOHibernate implements ConsultaAgendadaDAO {

	private Session session;
	
	public void setSession(Session s){
		session = s;
	}
	
	@Override
	public void save(ConsultaAgendada consultaAgendada) {
		session.save(consultaAgendada);
	}

	@Override
	public void delete(ConsultaAgendada consultaAgendada) {
		session.delete(consultaAgendada);
	}

	@Override
	public void alter(ConsultaAgendada consultaAgendada) {
		session.update(consultaAgendada);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ConsultaAgendada> getByPaciente(String nomePaciente) {
		return session.createQuery("FROM ConsultaAgendada c WHERE c.nomePaciente LIKE '%" + nomePaciente + "%' ").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ConsultaAgendada> getByMedico(String nomeMedico) {
		return session.createQuery("FROM ConsultaAgendada c WHERE c.nomeMedico LIKE '%" + nomeMedico + "%' ").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ConsultaAgendada> list() {
		return session.createCriteria(ConsultaAgendada.class).list();
	}

//	@Override
//	public ConsultaAgendada getByHorario(Date dataConsulta) {
//		return (ConsultaAgendada) session.createQuery("FROM Consulta_Agendada c where c.dataConsulta='" + dataConsulta + "' ").uniqueResult();
//	}

}
