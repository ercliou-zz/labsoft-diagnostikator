package br.com.diagnostikator.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.diagnostikator.business.FuncionarioBR;
import br.com.diagnostikator.model.Funcionario;

@ManagedBean (name="funcionarioBean")
public class FuncionarioBean {
	private Funcionario funcionario = new Funcionario();
	private String confirmSenha;
	private String cpf = null;
	private String nome = null;
	private String rg = null;
	private String tipo = null;
	private boolean listaTudo = true;
	private List<Funcionario> list;
	
	//Getters and Setters
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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
	
	public void setListaTudo(boolean listaTudo) {
		this.listaTudo = listaTudo;
	}
	
	public boolean getListaTudo() {
		return listaTudo;
	}
	
	public List<Funcionario> getList(){
		if(list == null || list.isEmpty()){
			//if((nome == null || nome.equals("")) && (cpf == null || cpf.equals("")) && (rg == null || rg.equals("")) && (tipo == null || tipo.equals(""))){
			if(listaTudo){
				FuncionarioBR funcionarioBR = new FuncionarioBR();
				list = funcionarioBR.list();
			}			
		}
		return list;
	}
	
	public void setList(List<Funcionario> list) {
		this.list = list;
	}	
	
	//Actions
	public String create(){
		funcionario = new Funcionario();
		return "funcionarioEdit";
	}

	public String edit(){
		confirmSenha = funcionario.getSenha();
		return "funcionarioEdit";
	}
	
	public String list() {
		return "funcionarioList";
	}
	
	public String view() {
		return "funcionarioView";
	}
	
	public String save(){
		FacesContext context = FacesContext.getCurrentInstance();
		
		String password = funcionario.getSenha();
		if(!password.equals(confirmSenha)){
			FacesMessage facesMessage = new FacesMessage("Senha incorreta!");
			context.addMessage(null, facesMessage);
			return null;
		}
		FuncionarioBR funcionarioBR = new FuncionarioBR();
		funcionarioBR.save(funcionario);
		
		return "funcionarioSaved";
	}	
	
	public String filter() {
		FuncionarioBR funcionarioBR = new FuncionarioBR();
		list = new ArrayList<Funcionario>();
		listaTudo = true;
		
		if (nome != null && !nome.equals("")){			
			list = funcionarioBR.getByNome(nome);
			listaTudo = false;
		}		
		else if (cpf != null && !cpf.equals("")){	
			funcionario = funcionarioBR.getByCpf(cpf);
			if (funcionario != null)
				list.add(funcionario);
			listaTudo = false;
		}		
		else if (rg != null && !rg.equals("")){		
			funcionario = funcionarioBR.getByRg(cpf);
			if (funcionario != null)
				list.add(funcionario);
			listaTudo = false;
		}		
		else if (tipo != null && !tipo.equals("")){			
			list = funcionarioBR.getByTipo(tipo);
			listaTudo = false;
		}
		return "funcionarioList";
	}
	
	//TODO: remover?
	public String delete() {
		FuncionarioBR user = new FuncionarioBR();
		user.delete(funcionario);
		
		//para atualizar a lista
		list = null;
		
		return null;
	}	
}
