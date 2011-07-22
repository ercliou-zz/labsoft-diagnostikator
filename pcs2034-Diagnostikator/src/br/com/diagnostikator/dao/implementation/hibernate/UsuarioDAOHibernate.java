package br.com.diagnostikator.dao.implementation.hibernate;

import java.util.List;

import org.hibernate.Session;

import br.com.diagnostikator.dao.UsuarioDAO;
import br.com.diagnostikator.model.Usuario;

public class UsuarioDAOHibernate implements UsuarioDAO{

	private Session session;
	public void setSession(Session s){
		session = s;
	}
	
	@Override
	public void save(Usuario user) {
		session.save(user);
		
	}

	@Override
	public void delete(Usuario user) {
		session.delete(user);
		
	}

	@Override
	public void alter(Usuario user) {
		session.update(user);
		
	}

	@Override
	public Usuario getById(long idUsuario) {
		return (Usuario) session.get(Usuario.class, idUsuario);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> list() {
		return session.createCriteria(Usuario.class).list();
	}

	@Override
	public Usuario getByLogin(String login) {
		return (Usuario) session.createQuery("FROM Usuario u WHERE u.login='" + login + "' ").uniqueResult();
	}

}
