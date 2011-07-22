package br.com.diagnostikator.web;

import javax.faces.bean.ManagedBean;

import br.com.diagnostikator.business.UsuarioBR;

@ManagedBean(name = "loginBean")
public class LoginBean {
	
	private String login;
	private String senha;
	private boolean authorized;
	private String type;
	
	public boolean getAuthorized(){
		return authorized;
	}
	
	public String getType() {
		return type;
	}


	public void logout(){
		authorized = false;
		login=null;
		senha=null;
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

	public String login(){
		UsuarioBR usuarioBR = new UsuarioBR();
		authorized = usuarioBR.login(login, senha);
		if(authorized){
			type = usuarioBR.resolveType(login);
			return "index2";
		}
		return "login";
	};
	
}
