package br.com.diagnostikator.dao;

import java.util.List;

import br.com.diagnostikator.model.Usuario;

public interface UsuarioDAO {
	public void save(Usuario user);
	public void delete(Usuario user);
	public void alter(Usuario user);
	public Usuario getById(long idUsuario);
	public Usuario getByLogin(String login);
	public List<Usuario> list();
}
