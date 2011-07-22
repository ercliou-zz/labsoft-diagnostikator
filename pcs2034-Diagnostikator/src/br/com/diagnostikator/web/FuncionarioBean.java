package br.com.diagnostikator.web;

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
	private List<Funcionario> list;
	
	
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
	
	
	public String delete() {
		FuncionarioBR user = new FuncionarioBR();
		user.delete(funcionario);
		
		//para atualizar a lista
		list = null;
		
		return null;
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
	
	public List<Funcionario> getList(){
		if(list == null || list.isEmpty()){
			FuncionarioBR funcionarioBR = new FuncionarioBR();
			list = funcionarioBR.list();
		}
		return list;
	}
	public void setList(List<Funcionario> list) {
		this.list = list;
	}
	
	
}
