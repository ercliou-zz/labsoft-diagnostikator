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
	
	public Usuario getByCpf(String cpf){
		return usuarioDAO.getByCpf(cpf);
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
}
