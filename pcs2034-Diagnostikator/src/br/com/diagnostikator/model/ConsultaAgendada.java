package br.com.diagnostikator.model;

import java.util.Date;
import java.util.List;

public class ConsultaAgendada {
	private String nomePaciente;
	private String nomeMedico;
	private Date dataConsulta;
	
	public ConsultaAgendada(String nomePaciente, String nomeMedico, Date dataConsulta) {
		this.nomePaciente = nomePaciente;
		this.nomeMedico = nomeMedico;
		this.dataConsulta = dataConsulta;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public String getNomeMedico() {
		return nomeMedico;
	}

	public Date getDataConsulta() {
		return dataConsulta;
	}
	
	public List<ConsultaAgendada> getConsultaAgendadaByPaciente(String nomePaciente) {
		return null;
	}
	
	public List<ConsultaAgendada> getConsultaAgendadaByMedico(String nomeMedico) {
		return null;
	}
}
