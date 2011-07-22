package br.com.diagnostikator.web;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.diagnostikator.business.ProntuarioBR;
import br.com.diagnostikator.model.Prontuario;

@ManagedBean(name = "prontuarioBean")
public class ProntuarioBean {

	private Prontuario prontuario = new Prontuario();
	private List<Prontuario> list;

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
		prontuarioBR.save(this.prontuario);

		return "prontuarioSaved";
	}

	public List<Prontuario> getList() {
		if (this.list == null || this.list.isEmpty()) {
			ProntuarioBR prontuarioBR = new ProntuarioBR();
			this.list = prontuarioBR.list();
		}
		return this.list;
	}

	public void setList(List<Prontuario> list) {
		this.list = list;
	}

}
