package br.com.diagnostikator.web;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class SessionLogin {

	public LoginBean getLoginBean() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		return (LoginBean) session.getAttribute("loginBean");
	}

}
