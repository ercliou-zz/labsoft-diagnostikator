package br.com.diagnostikator.web;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.diagnostikator.business.PacienteBR;
import br.com.diagnostikator.model.Paciente;

@ManagedBean(name = "pacienteBean")
public class PacienteBean {

	private Paciente paciente = new Paciente();
	private List<Paciente> list;
	private String target;

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String create() {
		this.target = "pacienteSaved";
		this.paciente = new Paciente();
		return "pacienteEdit";
	}

	public String edit() {
		return "pacienteEdit";
	}

	public String delete() {
		PacienteBR paciente = new PacienteBR();
		paciente.delete(this.paciente);

		// para atualizar a lista
		this.list = null;

		return null;
	}

	public String save() {
		PacienteBR pacienteBR = new PacienteBR();
		pacienteBR.save(this.paciente);

		return this.target;
	}

	public List<Paciente> getList() {
		if (this.list == null || this.list.isEmpty()) {
			PacienteBR pacienteBR = new PacienteBR();
			this.list = pacienteBR.list();
		}
		return this.list;
	}

	public void setList(List<Paciente> list) {
		this.list = list;
	}

	public String getTarget() {
		return this.target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

}
