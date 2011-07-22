package br.com.diagnostikator.web;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.diagnostikator.business.FuncionarioBR;
import br.com.diagnostikator.model.Funcionario;

@ManagedBean(name = "funcionarioBean")
public class FuncionarioBean {

	private Funcionario funcionario = new Funcionario();
	private List<Funcionario> list;
	private String confirmPassword;


	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String create() {
		this.funcionario = new Funcionario();
		return "funcionarioEdit";
	}

	public String edit() {
		return "funcionarioEdit";
	}

	public String delete() {
		FuncionarioBR funcionario = new FuncionarioBR();
		funcionario.delete(this.funcionario);

		// para atualizar a lista
		this.list = null;

		return null;
	}

	public String save() {
		
//
//		FacesContext context = FacesContext.getCurrentInstance();
//		
//		String password = funcionario.getPassword();
//		if(!password.equals(confirmPassword)){
//			FacesMessage facesMessage = new FacesMessage("Senhas diferentes!");
//			context.addMessage(null, facesMessage);
//			return null;
//		}
//		FuncionarioBR funcionarioBR = new FuncionarioBR();
//		funcionarioBR.save(this.funcionario);
//		
		return "usuarioSaved";
	}

	public List<Funcionario> getList() {
		if (this.list == null || this.list.isEmpty()) {
			FuncionarioBR funcionarioBR = new FuncionarioBR();
			this.list = funcionarioBR.list();
		}
		return this.list;
	}

	public void setList(List<Funcionario> list) {
		this.list = list;
	}


}
