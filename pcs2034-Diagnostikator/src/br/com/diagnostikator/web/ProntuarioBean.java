package br.com.diagnostikator.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.diagnostikator.business.ConsultaConfirmadaBR;
import br.com.diagnostikator.business.ProntuarioBR;
import br.com.diagnostikator.model.ConsultaConfirmada;
import br.com.diagnostikator.model.Medico;
import br.com.diagnostikator.model.Paciente;
import br.com.diagnostikator.model.Prontuario;

@ManagedBean(name = "prontuarioBean")
public class ProntuarioBean {

	private Prontuario prontuario = new Prontuario();
	private List<Prontuario> list;
	private List<String> consultasConfirmadas;
	private Medico medico;
	private Paciente paciente;
	
	private ConsultaConfirmadaBR consultaConfirmadaBR = new ConsultaConfirmadaBR();
	private ProntuarioBR prontuarioBR = new ProntuarioBR();

	public Prontuario getProntuario() {
		return this.prontuario;
	}

	public void setProntuario(Prontuario prontuario) {
		this.prontuario = prontuario;
	}

	public String create() {
		this.prontuario = new Prontuario();
		return "prontuarioEdit";
	}

	public String edit() {
		return "prontuarioEdit";
	}
	
	public String view() {
		return "prontuarioView";
	}
	
	public String list() {
		return "prontuarioList";
	}

	public String delete() {
		ProntuarioBR prontuario = new ProntuarioBR();
		prontuario.delete(this.prontuario);

		// para atualizar a lista
		this.list = null;

		return null;
	}

	public String save() {
		
		ProntuarioBR prontuarioBR = new ProntuarioBR();
		List<ConsultaConfirmada> list = new ArrayList<ConsultaConfirmada>();

		for (String consultaConfirmadaId : this.consultasConfirmadas ) {
			long consultaConfirmadaIdLong = Long.parseLong(consultaConfirmadaId);
			list.add(consultaConfirmadaBR.getByID(consultaConfirmadaIdLong));
		}
		prontuario.setConsultasConfirmadas(list);		
		prontuario.setMedico(medico);
		prontuario.setPaciente(paciente);
		prontuarioBR.save(this.prontuario);

		return "prontuarioSaved";
	}

	public List<Prontuario> getList() {
		if (this.list == null || this.list.isEmpty()) {
			this.list = prontuarioBR.list();
		}
		return this.list;
	}
	
	public List<ConsultaConfirmada> getConsultasConfirmadas(){
		return this.consultaConfirmadaBR.list(medico.getId(), paciente.getId());
	}

	public void setList(List<Prontuario> list) {
		this.list = list;
	}

	public void setConsultasConfirmadas(List<String> consultasConfirmadas) {
		this.consultasConfirmadas = consultasConfirmadas;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}	

}
