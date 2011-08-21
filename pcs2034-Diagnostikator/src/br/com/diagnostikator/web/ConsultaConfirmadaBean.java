package br.com.diagnostikator.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.diagnostikator.business.ConsultaConfirmadaBR;
import br.com.diagnostikator.business.SintomaBR;
import br.com.diagnostikator.dao.implementation.hibernate.ConsultaConfirmadaDAOHibernate;
import br.com.diagnostikator.model.ConsultaConfirmada;
import br.com.diagnostikator.model.Diagnostico;
import br.com.diagnostikator.model.Prontuario;
import br.com.diagnostikator.model.Sintoma;

@ManagedBean(name = "consultaConfirmadaBean")
public class ConsultaConfirmadaBean {

	private ConsultaConfirmadaBR consultaConfirmadaBR = new ConsultaConfirmadaBR();
	private ConsultaConfirmada consultaConfirmada = new ConsultaConfirmada();
	private List<String> sintomasSelecionados;
	private Diagnostico diagnostico;
	private List<ConsultaConfirmada> list;
	private Prontuario prontuario;
	private String status;

	public ConsultaConfirmada getConsultaConfirmada() {
		return consultaConfirmada;
	}

	public void setConsultaConfirmada(ConsultaConfirmada consultaConfirmada) {
		this.consultaConfirmada = consultaConfirmada;
	}

	public String create() {
		this.consultaConfirmada = new ConsultaConfirmada();
		return "consultaConfirmadaEdit";
	}

	public String edit() {
		return "consultaConfirmadaEdit";
	}
	
	public String view() {
		return "consultaConfirmadaView";
	}

	public String delete() {
		consultaConfirmadaBR.delete(this.consultaConfirmada);

		// para atualizar a lista
		this.list = null;

		return null;
	}
	

	public String save() {
		
		SintomaBR sintomaBR = new SintomaBR();
		List<Sintoma> list = new ArrayList<Sintoma>();

		for (String sintomaId : this.sintomasSelecionados ) {
			long sintomaIdLong = Long.parseLong(sintomaId);
			list.add(sintomaBR.getByID(sintomaIdLong));
		}
		consultaConfirmada.setSintomas(list);
		
		Date dataAtual = new Date();
		consultaConfirmada.setData(dataAtual);
		
		consultaConfirmadaBR.save(this.consultaConfirmada);
		return "consultaConfirmadaSaved";
	}
	
	public String confirm() {
		return "";
	}
	
	public String list(){
		return "consultaConfirmadaList";
	}

	public List<ConsultaConfirmada> getList() {
		if (this.list == null || this.list.isEmpty()) {
			this.list = consultaConfirmadaBR.list();
		}
		return this.list;
	}
	
	public String gerarDiagnostico(){
		diagnostico = consultaConfirmadaBR.gerarDiagnostico(consultaConfirmada.getSintomas());
		consultaConfirmada.setDiagnostico(diagnostico);
		return "listaDeDoencas";
	}

	public void setList(List<ConsultaConfirmada> list) {
		this.list = list;
	}

	public List<String> getSintomasSelecionados() {
		return sintomasSelecionados;
	}

	public void setSintomasSelecionados(List<String> sintomasSelecionados) {
		this.sintomasSelecionados = sintomasSelecionados;
	}

	public Diagnostico getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}
	
	public Prontuario getProntuario() {
		return prontuario;
	}

	public void setProntuario(Prontuario prontuario) {
		this.prontuario = prontuario;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String imprimir(){
		Date dataAtual;
		ConsultaConfirmada consultaBanco = this.consultaConfirmadaBR.getByID(this.consultaConfirmada.getId());;
		
		if(consultaBanco == null){
			SintomaBR sintomaBR = new SintomaBR();
			List<Sintoma> lista = new ArrayList<Sintoma>();

			for (String sintomaId : this.sintomasSelecionados ) {
				long sintomaIdLong = Long.parseLong(sintomaId);
				lista.add(sintomaBR.getByID(sintomaIdLong));
			}
			consultaConfirmada.setSintomas(lista);
			
			dataAtual = new Date();
			consultaConfirmada.setData(dataAtual);
			
			consultaConfirmadaBR.save(this.consultaConfirmada);
		} else {
			this.consultaConfirmada = this.consultaConfirmadaBR.getByID(this.consultaConfirmada.getId());
		}
		
		this.prontuario = this.consultaConfirmadaBR.getProntuarioByID(this.consultaConfirmada.getId());
		return "consultaConfirmadaImpressao";
	}
	
	public String fimImprimir(){
		this.consultaConfirmada = this.consultaConfirmadaBR.getByID(this.consultaConfirmada.getId());
		if(status.equals("edit")){
			
			sintomasSelecionados = new ArrayList<String>();
			for (Sintoma sintoma : this.consultaConfirmada.getSintomas() ) {
				sintomasSelecionados.add(Long.toString(sintoma.getId()));
			}
			
			return "consultaConfirmadaEdit";
		}
		else return "consultaConfirmadaView";
	}
	
	
	
}
