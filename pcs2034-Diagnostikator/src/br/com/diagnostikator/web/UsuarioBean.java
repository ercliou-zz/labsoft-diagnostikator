package br.com.diagnostikator.web;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.diagnostikator.business.UsuarioBR;
import br.com.diagnostikator.model.Usuario;

@ManagedBean (name="usuarioBean")
public class UsuarioBean {
	private Usuario usuario = new Usuario();
	private String confirmPassword;
	private List<Usuario> list;
	private String target;
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public String create(){
		target = "usuarioSaved";
		usuario = new Usuario();
		usuario.setActive(true);
		return "usuarioEdit";
	}

	public String edit(){
		target = "usuarioSaved";
		confirmPassword = usuario.getPassword();
		return "usuarioEdit";
	}
	
	public String active(){
		if(usuario.isActive()){
			usuario.setActive(false);
		}
		else{
			usuario.setActive(true);
		}
		
		UsuarioBR user = new UsuarioBR();
		user.save(usuario);
		
		return null;
	}
	
	public String delete() {
		UsuarioBR user = new UsuarioBR();
		user.delete(usuario);
		
		//para atualizar a lista
		list = null;
		
		return null;
	}
	
	public String save(){
		FacesContext context = FacesContext.getCurrentInstance();
		
		String password = usuario.getPassword();
		if(!password.equals(confirmPassword)){
			FacesMessage facesMessage = new FacesMessage("Senha incorreta!");
			context.addMessage(null, facesMessage);
			return null;
		}
		UsuarioBR usuarioBR = new UsuarioBR();
		usuarioBR.save(usuario);
		
		return target;
	}
	
	public List<Usuario> getList(){
		if(list == null || list.isEmpty()){
			UsuarioBR usuarioBR = new UsuarioBR();
			list = usuarioBR.list();
		}
		return list;
	}
	public void setList(List<Usuario> list) {
		this.list = list;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	
	
}
