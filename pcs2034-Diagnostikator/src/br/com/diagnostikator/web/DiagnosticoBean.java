package br.com.diagnostikator.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.diagnostikator.business.ConsultaConfirmadaBR;
import br.com.diagnostikator.business.DoencaBR;
import br.com.diagnostikator.business.ProntuarioBR;
import br.com.diagnostikator.business.SintomaBR;
import br.com.diagnostikator.model.ConsultaConfirmada;
import br.com.diagnostikator.model.Diagnostico;
import br.com.diagnostikator.model.Doenca;
import br.com.diagnostikator.model.Prontuario;
import br.com.diagnostikator.model.Sintoma;

@ManagedBean(name = "consultaConfirmadaBean")
public class DiagnosticoBean {

	private ConsultaConfirmadaBR consultaConfirmadaBR = new ConsultaConfirmadaBR();
	private ProntuarioBR prontuarioBR = new ProntuarioBR();
	private DoencaBR doencaBR = new DoencaBR();
	private ConsultaConfirmada consultaConfirmada = new ConsultaConfirmada();
	private List<String> sintomasSelecionados;
	private Diagnostico diagnostico;
	private List<ConsultaConfirmada> list;
	private Prontuario prontuario;
	private long prontuarioId;
	private String dataConsulta;
	private String status;
	
	private List<Doenca> lista;

	private List<String> doencasSelecionadasId;
	private List<String> doencasSelecionadasNome;

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

	public String consult() {
		this.prontuarioId = consultaConfirmada.getProntuario().getId();
		this.dataConsulta = consultaConfirmada.getData().toString();
		return "consultaConfirmadaEdit";
	}

	public String edit() {
		this.prontuarioId = consultaConfirmada.getProntuario().getId();
		this.dataConsulta = consultaConfirmada.getData().toString();
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

	public String save() throws ParseException {

		Prontuario prontuario = prontuarioBR.getById(prontuarioId);
		SintomaBR sintomaBR = new SintomaBR();
		List<Sintoma> list = new ArrayList<Sintoma>();

		for (String sintomaId : this.sintomasSelecionados) {
			long sintomaIdLong = Long.parseLong(sintomaId);
			list.add(sintomaBR.getByID(sintomaIdLong));
		}
		consultaConfirmada.setSintomas(list);
		consultaConfirmada.setProntuario(prontuario);

		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date data = formatter.parse(dataConsulta);
		consultaConfirmada.setData(data);

		consultaConfirmadaBR.save(this.consultaConfirmada);
		return "consultaConfirmadaSaved";
	}

	public String list() {
		return "consultaConfirmadaList";
	}

	public List<ConsultaConfirmada> getList() {
		if (this.list == null || this.list.isEmpty()) {
			this.list = consultaConfirmadaBR.list();
		}
		return this.list;
	}

	public String gerarDiagnostico() throws ParseException {
		SintomaBR sintomaBR = new SintomaBR();
		List<Sintoma> sintomas = new ArrayList<Sintoma>();

		for (String sintomaId : this.sintomasSelecionados) {
			long sintomaIdLong = Long.parseLong(sintomaId);
			sintomas.add(sintomaBR.getByID(sintomaIdLong));
		}
		diagnostico = consultaConfirmadaBR.gerarDiagnostico(sintomas);
		consultaConfirmada.setDiagnostico(diagnostico);

		// porquinho
		Prontuario prontuario = prontuarioBR.getById(prontuarioId);
		List<Sintoma> list = new ArrayList<Sintoma>();

		for (String sintomaId : this.sintomasSelecionados) {
			long sintomaIdLong = Long.parseLong(sintomaId);
			list.add(sintomaBR.getByID(sintomaIdLong));
		}
		consultaConfirmada.setSintomas(list);
		consultaConfirmada.setProntuario(prontuario);

		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date data = formatter.parse(dataConsulta);
		consultaConfirmada.setData(data);

		consultaConfirmadaBR.save(this.consultaConfirmada);

		return "doencaDiagnosticadaList";
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

	public String getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(String dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getProntuarioId() {
		return prontuarioId;
	}

	public void setProntuarioId(long prontuarioId) {
		this.prontuarioId = prontuarioId;
	}

	public List<String> getDoencasSelecionadasId() {
		return doencasSelecionadasId;
	}

	public void setDoencasSelecionadasId(List<String> doencasSelecionadasId) {
		this.doencasSelecionadasId = doencasSelecionadasId;
	}

	public List<String> getDoencasSelecionadasNome() {
		return doencasSelecionadasNome;
	}

	public void setDoencasSelecionadasNome(List<String> doencasSelecionadasNome) {
		this.doencasSelecionadasNome = doencasSelecionadasNome;
	}

	public String imprimir() {
		Date dataAtual;
		ConsultaConfirmada consultaBanco = this.consultaConfirmadaBR
				.getByID(this.consultaConfirmada.getId());
		;

		if (consultaBanco == null) {
			SintomaBR sintomaBR = new SintomaBR();
			List<Sintoma> lista = new ArrayList<Sintoma>();

			for (String sintomaId : this.sintomasSelecionados) {
				long sintomaIdLong = Long.parseLong(sintomaId);
				lista.add(sintomaBR.getByID(sintomaIdLong));
			}
			consultaConfirmada.setSintomas(lista);

			dataAtual = new Date();
			consultaConfirmada.setData(dataAtual);

			consultaConfirmadaBR.save(this.consultaConfirmada);
		} else {
			this.consultaConfirmada = this.consultaConfirmadaBR
					.getByID(this.consultaConfirmada.getId());
		}

		// this.prontuario =
		// this.consultaConfirmadaBR.getProntuarioByID(this.consultaConfirmada.getId());
		this.prontuario = this.prontuarioBR.getById(prontuarioId);
		return "consultaConfirmadaImpressao";
	}

	public String fimImprimir() {
		this.consultaConfirmada = this.consultaConfirmadaBR
				.getByID(this.consultaConfirmada.getId());
		if (status.equals("edit")) {

			sintomasSelecionados = new ArrayList<String>();
			for (Sintoma sintoma : this.consultaConfirmada.getSintomas()) {
				sintomasSelecionados.add(Long.toString(sintoma.getId()));
			}

			return "consultaConfirmadaEdit";
		} else
			return "consultaConfirmadaView";
	}

	public String selecionarDoencas() {
		
		this.prontuarioId = consultaConfirmada.getProntuario().getId();
		this.dataConsulta = consultaConfirmada.getData().toString();
		
		this.consultaConfirmada = this.consultaConfirmadaBR.getByID(this.consultaConfirmada.getId());

		if (!this.doencasSelecionadasId.isEmpty()) {
			String doencasSelecionadas = "Possível(is) doença(s): ";
			Iterator<String> it = this.doencasSelecionadasId.iterator();
			while (it.hasNext()) {
				doencasSelecionadas.concat(this.doencaBR.getByID(
						Long.parseLong(it.next())).getNome());
				if (it.hasNext()) {
					doencasSelecionadas.concat(", ");
				}
			}

			this.consultaConfirmada.setInformacao(doencasSelecionadas);
		}

		
		this.sintomasSelecionados = new ArrayList<String>();
		for (Sintoma sintoma : this.consultaConfirmada.getSintomas()) {
			this.sintomasSelecionados.add(Long.toString(sintoma.getId()));
		}

		return "consultaConfirmadaEdit";
	}
	
	public List<Doenca> getLista() {
		if (this.lista == null || this.lista.isEmpty()) {
			this.lista = doencaBR.list();
		}
		return this.lista;
	}

	public void setLista(List<Doenca> lista) {
		this.lista = lista;
	}


}
