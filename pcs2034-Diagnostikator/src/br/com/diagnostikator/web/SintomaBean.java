package br.com.diagnostikator.web;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.diagnostikator.business.SintomaBR;
import br.com.diagnostikator.model.Sintoma;

@ManagedBean(name = "sintomaBean")
public class SintomaBean {

	private Sintoma sintoma = new Sintoma();
	private List<Sintoma> list;

	public Sintoma getSintoma() {
		return this.sintoma;
	}

	public void setSintoma(Sintoma sintoma) {
		this.sintoma = sintoma;
	}

	public String create() {
		this.sintoma = new Sintoma();
		return "sintomaEdit";
	}

	public String edit() {
		return "sintomaEdit";
	}
	
	public String view() {
		return "sintomaView";
	}
	
	public String list() {
		return "sintomaList";
	}

	public String delete() {
		SintomaBR sintoma = new SintomaBR();
		sintoma.delete(this.sintoma);

		// para atualizar a lista
		this.list = null;

		return null;
	}

	public String save() {
		SintomaBR sintomaBR = new SintomaBR();
		sintomaBR.save(this.sintoma);

		return "sintomaSaved";
	}

	public List<Sintoma> getList() {
		if (this.list == null || this.list.isEmpty()) {
			SintomaBR sintomaBR = new SintomaBR();
			this.list = sintomaBR.list();
		}
		return this.list;
	}

	public void setList(List<Sintoma> list) {
		this.list = list;
	}

}
