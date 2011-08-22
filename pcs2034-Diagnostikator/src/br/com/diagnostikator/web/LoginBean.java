package br.com.diagnostikator.web;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.diagnostikator.business.UsuarioBR;
import br.com.diagnostikator.util.AgendaDoDia;

@ManagedBean(name = "loginBean")
@SessionScoped()
public class LoginBean {

	private String login;
	private String senha;
	private boolean authorized;
	private String type;

	public boolean getAuthorized() {
		return authorized;
	}

	public String getType() {
		return type;
	}

	public String logout() {
		authorized = false;
		login = null;
		senha = null;
		type = null;
		return "login";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String login() {
		AgendaDoDia t = new AgendaDoDia();
		t.run();
		
		UsuarioBR usuarioBR = new UsuarioBR();
		authorized = usuarioBR.login(login, senha);
		if (authorized) {
			type = usuarioBR.resolveType(login);
			return "index2";
		}
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage("Ugh.. Login ou Senha incorreto! Ou ambos!");
		context.addMessage(null, facesMessage);
		
		

		return "login";
	}

}
