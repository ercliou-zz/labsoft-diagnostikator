package br.com.diagnostikator.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.diagnostikator.business.DoencaBR;
import br.com.diagnostikator.business.SintomaBR;
import br.com.diagnostikator.model.Doenca;
import br.com.diagnostikator.model.Sintoma;

@ManagedBean(name = "doencaBean")
public class DoencaBean {

	private Doenca doenca = new Doenca();
	private String nome = null;	
	private boolean listaTudo = true;
	private List<Doenca> list;
	private List<String> sintomasSelecionados;
	private String sintomaIteracao;

	//Getters and Setters
	public Doenca getDoenca() {
		return this.doenca;
	}

	public void setDoenca(Doenca doenca) {
		this.doenca = doenca;
	}	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isListaTudo() {
		return listaTudo;
	}

	public void setListaTudo(boolean listaTudo) {
		this.listaTudo = listaTudo;
	}

	public List<String> getSintomasSelecionados() {
		return sintomasSelecionados;
	}

	public void setSintomasSelecionados(List<String> sintomasSelecionados) {
		this.sintomasSelecionados = sintomasSelecionados;
	}

	public String getSintomaIteracao() {
		return sintomaIteracao;
	}

	public void setSintomaIteracao(String sintomaIteracao) {
		this.sintomaIteracao = sintomaIteracao;
	}
	
	public List<Doenca> getList() {
		if (this.list == null || this.list.isEmpty()) {
			if (listaTudo){
				DoencaBR doencaBR = new DoencaBR();
				this.list = doencaBR.list();
			}
		}
		return this.list;
	}

	public void setList(List<Doenca> list) {
		this.list = list;
	}

	//Actions
	public String create() {
		this.doenca = new Doenca();
		return "doencaEdit";
	}

	public String edit() {
		
		this.sintomasSelecionados = new ArrayList<String>();
		for (Sintoma var : doenca.getSintomas() ) {
			this.sintomasSelecionados.add(Long.toString(var.getId()));
		}
		
		return "doencaEdit";
	}
	
	public String view() {
		return "doencaView";
	}

	public String delete() {
		DoencaBR doenca = new DoencaBR();
		doenca.delete(this.doenca);

		// para atualizar a lista
		this.list = null;

		return null;
	}
	
	public String save() {
		DoencaBR doencaBR = new DoencaBR();
		SintomaBR sintomaBR = new SintomaBR();
		List<Sintoma> list = new ArrayList<Sintoma>();

		for (String sintomaId : this.sintomasSelecionados ) {
			long sintomaIdLong = Long.parseLong(sintomaId);
			list.add(sintomaBR.getByID(sintomaIdLong));
		}
		doenca.setSintomas(list);
		
		doencaBR.save(this.doenca);
		return "doencaSaved";
	}
	
	public String list() {
		return "doencaList";
	}

	public String filter() {
		DoencaBR doencaBR = new DoencaBR();
		list = new ArrayList<Doenca>();
		listaTudo = true;
		
		if (nome != null && !nome.equals("")){			
			list = doencaBR.getByNome(nome);
			listaTudo = false;
		}				
		
		return "doencaList";
	}			
}
