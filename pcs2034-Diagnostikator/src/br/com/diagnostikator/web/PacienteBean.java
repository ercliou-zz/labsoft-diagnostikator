package br.com.diagnostikator.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.diagnostikator.business.PacienteBR;
import br.com.diagnostikator.model.Paciente;

@ManagedBean(name = "pacienteBean")
public class PacienteBean {

	private Paciente paciente = new Paciente();
	private String cpf = null;
	private String nome = null;	
	private String rg = null;	
	private boolean listaTudo = true;
	private List<Paciente> list;

	//Getters and Setters
	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}	
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public boolean isListaTudo() {
		return listaTudo;
	}

	public void setListaTudo(boolean listaTudo) {
		this.listaTudo = listaTudo;
	}

	public List<Paciente> getList() {
		if (this.list == null || this.list.isEmpty()) {
			if(listaTudo){
				PacienteBR pacienteBR = new PacienteBR();
				this.list = pacienteBR.list();
			}
		}
		return this.list;
	}

	public void setList(List<Paciente> list) {
		this.list = list;
	}
	
	//Actions
	public String create() {
		this.paciente = new Paciente();
		return "pacienteEdit";
	}

	public String edit() {
		return "pacienteEdit";
	}
	
	public String view() {
		return "pacienteView";
	}
	
	public String list() {
		return "pacienteList";
	}

	//TODO: remover?
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

		return "pacienteSaved";
	}
	
	public String filter() {
		PacienteBR pacienteBR = new PacienteBR();
		list = new ArrayList<Paciente>();
		listaTudo = true;
		
		if (nome != null && !nome.equals("")){			
			list = pacienteBR.getByNome(nome);
			listaTudo = false;
		}			
		else if (cpf != null && !cpf.equals("")){	
			paciente = pacienteBR.getByCpf(cpf);
			if (paciente != null)
				list.add(paciente);
			listaTudo = false;
		}		
		else if (rg != null && !rg.equals("")){		
			paciente = pacienteBR.getByRg(cpf);
			if (paciente != null)
				list.add(paciente);
			listaTudo = false;
		}			
		
		return "pacienteList";
	}	
}
