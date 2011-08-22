package br.com.diagnostikator.web;

import java.util.Date;
import javax.faces.bean.ManagedBean;

import br.com.diagnostikator.business.RelatorioBR;

@ManagedBean(name = "relatorioBean")
public class RelatorioBean {

	private String tipo = null;
	private Date dataInicial = null;	
	private Date dataFinal = null;	
	private int valor = 0;

		public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	//Action
	public String generate() {
		RelatorioBR relatorio = new RelatorioBR();		
		if (dataFinal.before(dataInicial))
			return "relatorioPeriodError";
		if (tipo.equals("ConsultaConfirmada"))
			valor = relatorio.getNumConsultaConfirmadaByPeriodo(dataInicial, dataFinal);
		else
			valor = relatorio.getNumDiagnosticoByPeriodo(dataInicial, dataFinal);
		return "relatorioView";
	}
	
	public String cancel() {		
		return "relatorioGenerate";
	}	
	
	public String view() {		
		return "relatorioView";
	}
	
	public String print(){
		return "relatorioPrint";
	}
	


}
