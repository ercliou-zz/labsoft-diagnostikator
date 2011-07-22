package br.com.diagnostikator.web;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.diagnostikator.business.ConsultaAgendadaBR;
import br.com.diagnostikator.model.ConsultaAgendada;

@ManagedBean(name = "consultaAgendadaBean")
public class ConsultaAgendadaBean {

	private ConsultaAgendada consultaAgendada = new ConsultaAgendada();
	private List<ConsultaAgendada> list;

	public ConsultaAgendada getConsultaAgendada() {
		return consultaAgendada;
	}

	public void setConsultaAgendada(ConsultaAgendada consultaAgendada) {
		this.consultaAgendada = consultaAgendada;
	}

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

	public List<ConsultaAgendada> getList() {
		if (this.list == null || this.list.isEmpty()) {
			ConsultaAgendadaBR consultaAgendadaBR = new ConsultaAgendadaBR();
			this.list = consultaAgendadaBR.list();
		}
		return this.list;
	}
		
	public void setList(List<ConsultaAgendada> list) {
		this.list = list;
	}	
}
