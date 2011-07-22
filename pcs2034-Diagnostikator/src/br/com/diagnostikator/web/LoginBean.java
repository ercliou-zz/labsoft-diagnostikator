package br.com.diagnostikator.web;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.diagnostikator.business.FuncionarioBR;
import br.com.diagnostikator.model.Funcionario;
import br.com.diagnostikator.model.Medico;

@ManagedBean(name = "loginBean")
public class LoginBean {
	
	private String cpf;
	private String password;
	private boolean authorized;
	
	public boolean getAuthorized(){
		return authorized;
	}
	
	public void logout(){
		authorized = false;
		cpf=null;
		password=null;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String login(){
//		FuncionarioBR funcionarioBR = new FuncionarioBR();
//		Funcionario func = funcionarioBR.getByCpf(cpf);
//		if(func!=null && func.getPassword().equals(password)){
//			authorized = true;
//			Class funcType = func.getClass();
//			if(funcType.equals(Medico.class)){
//				return "medicoMain";
//			}
//			else {
//				return "funcionarioMain";
//			}
//		}
//		FacesMessage facesMessage = new FacesMessage("Login incorreto");
//		FacesContext context = FacesContext.getCurrentInstance();
//		context.addMessage(null, facesMessage);
		return "login";
	};
	
}
