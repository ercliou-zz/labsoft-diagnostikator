package br.com.diagnostikator.business;

import java.util.List;

import br.com.diagnostikator.dao.UsuarioDAO;
import br.com.diagnostikator.model.Usuario;
import br.com.diagnostikator.util.DAOFactory;

public class UsuarioBR {
	private UsuarioDAO usuarioDAO;
	
	public UsuarioBR(){
		usuarioDAO = DAOFactory.createUsuarioDAO();
	}

	public Usuario getById(long id){
		return usuarioDAO.getById(id);
	}
	
	public Usuario getByCpf(String login){
		return usuarioDAO.getByLogin(login);
	}
	
	public void save(Usuario user){
		long id = user.getId();
		if(id == 0){
			usuarioDAO.save(user);
		}
		else{
			usuarioDAO.alter(user);
		}
	}
	
	public void delete(Usuario user) {
		usuarioDAO.delete(user);
	}
	
	public List<Usuario> list(){
		return usuarioDAO.list();
	}
	
	public boolean login(String login, String senha){
		if(login == null || login.trim().equals("") || senha == null || senha.trim().equals("")){
			return false;
		}
		Usuario usuario = usuarioDAO.getByLogin(login.trim());
		if(usuario != null && usuario.getSenha().equals(senha.trim())){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String resolveType(String login){
		Usuario usuario = usuarioDAO.getByLogin(login);
		return usuario.getTipo();
	}
	
}
