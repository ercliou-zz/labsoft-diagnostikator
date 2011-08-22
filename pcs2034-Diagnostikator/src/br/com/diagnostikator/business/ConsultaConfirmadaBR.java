package br.com.diagnostikator.business;

import java.util.ArrayList;
import java.util.List;

import br.com.diagnostikator.dao.ConsultaConfirmadaDAO;
import br.com.diagnostikator.dao.DiagnosticoDAO;
import br.com.diagnostikator.model.ConsultaConfirmada;
import br.com.diagnostikator.model.Diagnostico;
import br.com.diagnostikator.model.Prontuario;
import br.com.diagnostikator.model.Sintoma;
import br.com.diagnostikator.util.DAOFactory;

public class ConsultaConfirmadaBR {
	private ConsultaConfirmadaDAO consultaConfirmadaDAO;
	private DiagnosticoDAO diagnosticoDAO;

	public ConsultaConfirmadaBR() {
		this.consultaConfirmadaDAO = DAOFactory.createConsultaConfirmadaDAO();
		this.diagnosticoDAO = DAOFactory.createDiagnosticoDAO();
	}

	public void save(ConsultaConfirmada consultaConfirmada) {
		long id = consultaConfirmada.getId();

		if (id == 0) {
			this.consultaConfirmadaDAO.save(consultaConfirmada);
		} else {
			this.consultaConfirmadaDAO.alter(consultaConfirmada);
		}
	}

	public void delete(ConsultaConfirmada consultaConfirmada) {
		this.consultaConfirmadaDAO.delete(consultaConfirmada);
	}
	
	public ConsultaConfirmada getByID(long id){
		return this.consultaConfirmadaDAO.getByID(id);
	}

	public List<ConsultaConfirmada> list() {
		return this.consultaConfirmadaDAO.list();
	}
	
	public Diagnostico gerarDiagnostico(List<Sintoma> sintomas){

		Diagnostico diagnostico = new Diagnostico();
		diagnostico.setDoencas(this.diagnosticoDAO.getDoencas(sintomas));
		
		//diagnostico.setObservacoes("observacoez");

		
		return diagnostico;
	}
	
	public List<ConsultaConfirmada> list(long idMedico, long idPaciente) {
		List<ConsultaConfirmada> filtered = new ArrayList<ConsultaConfirmada>() ;
		List<ConsultaConfirmada> full = this.list();
		for (ConsultaConfirmada consultaConfirmada : full) {
			if(consultaConfirmada.getProntuario().getMedicoPai().getId() == idMedico && consultaConfirmada.getProntuario().getPacientePai().getId() == idPaciente){
				filtered.add(consultaConfirmada);
			}
		}
		return filtered;
	}
	
	public Prontuario getProntuarioByID(long id){
		return this.consultaConfirmadaDAO.getProntuarioByID(id);
	}
}
