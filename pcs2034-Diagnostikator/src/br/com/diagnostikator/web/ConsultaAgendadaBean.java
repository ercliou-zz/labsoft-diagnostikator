package br.com.diagnostikator.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.diagnostikator.business.ConsultaAgendadaBR;
import br.com.diagnostikator.business.ConsultaConfirmadaBR;
import br.com.diagnostikator.business.MedicoBR;
import br.com.diagnostikator.business.PacienteBR;
import br.com.diagnostikator.business.ProntuarioBR;
import br.com.diagnostikator.model.ConsultaAgendada;
import br.com.diagnostikator.model.ConsultaConfirmada;
import br.com.diagnostikator.model.Medico;
import br.com.diagnostikator.model.Paciente;
import br.com.diagnostikator.model.Prontuario;

@ManagedBean(name = "consultaAgendadaBean")
public class ConsultaAgendadaBean {

	ConsultaAgendadaBR consultaAgendadaBR = new ConsultaAgendadaBR();
	ConsultaConfirmadaBR consultaConfirmadaBR = new ConsultaConfirmadaBR();
	MedicoBR medicoBR = new MedicoBR();
	PacienteBR pacienteBR = new PacienteBR();
	ProntuarioBR prontuarioBR = new ProntuarioBR();

	private ConsultaAgendada consultaAgendada = new ConsultaAgendada();
	private String nomePaciente = null;
	private String nomeMedico = null;

	private String pacienteId;
	private String medicoId;

	private boolean listaTudo = true;
	private List<ConsultaAgendada> list;

	// Getters and Setters
	public ConsultaAgendada getConsultaAgendada() {
		return consultaAgendada;
	}

	public String getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(String pacienteId) {
		this.pacienteId = pacienteId;
	}

	public String getMedicoId() {
		return medicoId;
	}

	public void setMedicoId(String medicoId) {
		this.medicoId = medicoId;
	}

	public void setConsultaAgendada(ConsultaAgendada consultaAgendada) {
		this.consultaAgendada = consultaAgendada;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getNomeMedico() {
		return nomeMedico;
	}

	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}

	public boolean isListaTudo() {
		return listaTudo;
	}

	public void setListaTudo(boolean listaTudo) {
		this.listaTudo = listaTudo;
	}

	public List<ConsultaAgendada> getList() {
		if (this.list == null || this.list.isEmpty()) {
			if (listaTudo) {
				this.list = consultaAgendadaBR.list();
			}
		}
		return this.list;
	}

	public void setList(List<ConsultaAgendada> list) {
		this.list = list;
	}

	// Actions
	public String create() {
		this.consultaAgendada = new ConsultaAgendada();
		return "consultaAgendadaEdit";
	}

	public String edit() {
		return "consultaAgendadaEdit";
	}

	public String view() {
		return "consultaAgendadaView";
	}

	public String delete() {
		consultaAgendadaBR.delete(this.consultaAgendada);

		// para atualizar a lista
		this.list = null;

		return null;
	}

	public String save() {

		this.consultaAgendada.setMedico(medicoBR.getById(Long
				.parseLong(medicoId)));
		this.consultaAgendada.setPaciente(pacienteBR.getById(Long
				.parseLong(pacienteId)));

		consultaAgendadaBR.save(this.consultaAgendada);

		return "consultaAgendadaSaved";
	}

	public String list() {
		return "consultaAgendadaList";
	}

	public String filter() {
		list = new ArrayList<ConsultaAgendada>();
		listaTudo = true;

		if (nomePaciente != null && !nomePaciente.equals("")) {
			list = consultaAgendadaBR.getByPaciente(nomePaciente);
			listaTudo = false;
		} else if (nomeMedico != null && !nomeMedico.equals("")) {
			list = consultaAgendadaBR.getByMedico(nomeMedico);
			listaTudo = false;
		}

		return "consultaAgendadaList";
	}

	public String confirm() {

		if(consultaAgendada.getStatus().equals("CONFIRMADA")){
			return "consultaAgendadaList";
		}
		
		// cria nova consulta confirmada e marca status da consulta como
		// CONFIRMADA
		ConsultaConfirmada consultaConfirmada = new ConsultaConfirmada();
		consultaConfirmada.setData(this.consultaAgendada.getDataConsulta());
		
		this.consultaAgendada.setStatus("CONFIRMADA");
		consultaAgendadaBR.save(this.consultaAgendada);

		// verifica se paciente ja possui um prontuario, se nao, cria um novo
		Paciente paciente = this.consultaAgendada.getPaciente();
		Medico medico = this.consultaAgendada.getMedico();
		List<Prontuario> prontuarios = prontuarioBR.list(medico.getId());
		List<Prontuario> prontuariosFiltrados = new ArrayList<Prontuario>();
		for (Prontuario prontuario : prontuarios) {
			if (prontuario.getPacientePai().getId() == paciente.getId()) {
				prontuariosFiltrados.add(prontuario);
			}
		}
		if (prontuariosFiltrados.isEmpty()) {
			Prontuario novoProntuario = new Prontuario();
			novoProntuario.setMedicoPai(medico);
			novoProntuario.setPacientePai(this.consultaAgendada.getPaciente());
			prontuarioBR.save(novoProntuario);
			consultaConfirmada.setProntuario(novoProntuario);
		} else {
			consultaConfirmada.setProntuario(prontuarios.get(0));
		}
		consultaConfirmadaBR.save(consultaConfirmada);

		return "consultaAgendadaList";
	}
}
