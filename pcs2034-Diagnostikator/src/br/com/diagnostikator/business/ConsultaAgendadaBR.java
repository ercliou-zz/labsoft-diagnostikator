package br.com.diagnostikator.business;

import java.util.Date;
import java.util.List;

import br.com.diagnostikator.dao.ConsultaAgendadaDAO;
import br.com.diagnostikator.model.ConsultaAgendada;
import br.com.diagnostikator.util.DAOFactory;

public class ConsultaAgendadaBR {
	private ConsultaAgendadaDAO consultaAgendadaDAO;
	
	public ConsultaAgendadaBR(){
		consultaAgendadaDAO = DAOFactory.createConsultaAgendadaDAO();
	}

	public List<ConsultaAgendada> getByMedico(String nomeMedico){
		return consultaAgendadaDAO.getByMedico(nomeMedico);
	}
	
	public List<ConsultaAgendada> getByPaciente(String nomePaciente){
		return consultaAgendadaDAO.getByPaciente(nomePaciente);
	}
	
//	public ConsultaAgendada getByHorario(Date dataConsulta){
//		return consultaAgendadaDAO.getByHorario(dataConsulta);
//	}
	
	public void save(ConsultaAgendada consultaAgendada){
//		ConsultaAgendada consultaAgendadaExistente  = consultaAgendadaDAO.getByHorario(consultaAgendada.getDataConsulta());		
//		
//		if(consultaAgendadaExistente == null){
//			consultaAgendadaDAO.save(consultaAgendada);
//		}
//		else{
//			consultaAgendadaDAO.alter(consultaAgendada);		
//		}
//		
		long id = consultaAgendada.getId();

		if (id == 0) {
			this.consultaAgendadaDAO.save(consultaAgendada);
		} else {
			this.consultaAgendadaDAO.alter(consultaAgendada);
		}
	}
	
	public void delete(ConsultaAgendada consultaAgendada) {
		consultaAgendadaDAO.delete(consultaAgendada);
	}
	
	public List<ConsultaAgendada> list(){
		return consultaAgendadaDAO.list();
	}
}
