package br.com.diagnostikator.dao.implementation.hibernate;

import java.util.List;

import org.hibernate.Query;
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

	@Override
	public Usuario getByEmail(String email) {
		String hql = "SELECT u FROM Usuario u WHERE u.email = :email";
		Query query = session.createQuery(hql);
		query.setString("email",email);
		return (Usuario) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> list() {
		return session.createCriteria(Usuario.class).list();
	}

}
