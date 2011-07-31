package br.com.diagnostikator.web;

import java.util.ArrayList;
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
	private String cpf = null;
	private String nome = null;
	private String crm = null;
	private String rg = null;
	private String tipo = null;
	private String especialidade = null;
	private boolean listaTudo = true;
	private List<Medico> list;
	
	//Getters and Setters
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
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public boolean isListaTudo() {
		return listaTudo;
	}
	public void setListaTudo(boolean listaTudo) {
		this.listaTudo = listaTudo;
	}
	
	public List<Medico> getList(){
		if(list == null || list.isEmpty()){
			if(listaTudo){
				MedicoBR medicoBR = new MedicoBR();
				list = medicoBR.list();
			}
		}
		return list;
	}
	
	public void setList(List<Medico> list) {
		this.list = list;
	}	
		
	//Actions
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

	public String filter() {
		MedicoBR medicoBR = new MedicoBR();
		list = new ArrayList<Medico>();
		listaTudo = true;
		
		if (nome != null && !nome.equals("")){			
			list = medicoBR.getByNome(nome);
			listaTudo = false;
		}		
		else if (crm != null && !crm.equals("")){		
			medico = medicoBR.getByCrm(crm);
			if (medico != null)
				list.add(medico);
			listaTudo = false;
		}	
		else if (cpf != null && !cpf.equals("")){	
			medico = medicoBR.getByCpf(cpf);
			if (medico != null)
				list.add(medico);
			listaTudo = false;
		}		
		else if (rg != null && !rg.equals("")){		
			medico = medicoBR.getByRg(cpf);
			if (medico != null)
				list.add(medico);
			listaTudo = false;
		}			
		else if (tipo != null && !tipo.equals("")){			
			list = medicoBR.getByTipo(tipo);
			listaTudo = false;
		}
		else if (especialidade != null && !especialidade.equals("")){			
			list = medicoBR.getByEspecialidade(especialidade);
			listaTudo = false;
		}
		
		return "medicoList";
	}	
	
	//TODO: remover?
	public String delete() {
		MedicoBR user = new MedicoBR();
		user.delete(medico);
		
		//para atualizar a lista
		list = null;
		
		return null;
	}
	
}
