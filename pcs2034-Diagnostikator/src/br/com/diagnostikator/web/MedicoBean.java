package br.com.diagnostikator.web;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.diagnostikator.business.MedicoBR;
import br.com.diagnostikator.model.Medico;

@ManagedBean (name="medicoBean")
public class MedicoBean {
	private Medico medico = new Medico();
	private String confirmSenha;
	private List<Medico> list;
	
	
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public String getConfirmSenha() {
		return confirmSenha;
	}
	public void setConfirmSenha(String confirmSenha) {
		this.confirmSenha = confirmSenha;
	}
	
	public String create(){
		medico = new Medico();
		return "medicoEdit";
	}

	public String edit(){
		confirmSenha = medico.getSenha();
		return "medicoEdit";
	}
	
	public String list() {
		return "medicoList";
	}
	
	public String view() {
		return "medicoView";
	}
	
	
	public String delete() {
		MedicoBR user = new MedicoBR();
		user.delete(medico);
		
		//para atualizar a lista
		list = null;
		
		return null;
	}
	
	public String save(){
		FacesContext context = FacesContext.getCurrentInstance();
		
		String password = medico.getSenha();
		if(!password.equals(confirmSenha)){
			FacesMessage facesMessage = new FacesMessage("Senha incorreta!");
			context.addMessage(null, facesMessage);
			return null;
		}
		MedicoBR medicoBR = new MedicoBR();
		medicoBR.save(medico);
		
		return "medicoSaved";
	}
	
	public List<Medico> getList(){
		if(list == null || list.isEmpty()){
			MedicoBR medicoBR = new MedicoBR();
			list = medicoBR.list();
		}
		return list;
	}
	public void setList(List<Medico> list) {
		this.list = list;
	}
	
	
}
