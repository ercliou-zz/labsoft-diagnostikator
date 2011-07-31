package br.com.diagnostikator.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.diagnostikator.business.ConsultaAgendadaBR;
import br.com.diagnostikator.model.ConsultaAgendada;

@ManagedBean(name = "consultaAgendadaBean")
public class ConsultaAgendadaBean {

	private ConsultaAgendada consultaAgendada = new ConsultaAgendada();
	private String nomePaciente = null;
	private String nomeMedico = null;
	private boolean listaTudo = true;
	private List<ConsultaAgendada> list;

	//Getters and Setters
	public ConsultaAgendada getConsultaAgendada() {
		return consultaAgendada;
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
			if(listaTudo){
				ConsultaAgendadaBR consultaAgendadaBR = new ConsultaAgendadaBR();
				this.list = consultaAgendadaBR.list();
			}
		}
		return this.list;
	}
		
	public void setList(List<ConsultaAgendada> list) {
		this.list = list;
	}	
	
	//Actions
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
		ConsultaAgendadaBR consultaAgendadaBR = new ConsultaAgendadaBR();
		consultaAgendadaBR.delete(this.consultaAgendada);

		// para atualizar a lista
		this.list = null;

		return null;
	}	

	public String save() {
		
		ConsultaAgendadaBR consultaAgendadaBR = new ConsultaAgendadaBR();
		consultaAgendadaBR.save(this.consultaAgendada);

		return "consultaAgendadaSaved";
	}
	
	public String list(){
		return "consultaAgendadaList";
	}
	
	public String filter() {
		ConsultaAgendadaBR consultaAgendadaBR = new ConsultaAgendadaBR();
		list = new ArrayList<ConsultaAgendada>();
		listaTudo = true;
		
		if (nomePaciente != null && !nomePaciente.equals("")){			
			list = consultaAgendadaBR.getByPaciente(nomePaciente);
			listaTudo = false;
		}		
		else if (nomeMedico != null && !nomeMedico.equals("")){					
			list = consultaAgendadaBR.getByMedico(nomeMedico);			
			listaTudo = false;
		}			
		
		return "consultaAgendadaList";
	}	
}
