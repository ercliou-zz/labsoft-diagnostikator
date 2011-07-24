package br.com.diagnostikator.business;

import java.util.List;

import br.com.diagnostikator.dao.ProntuarioDAO;
import br.com.diagnostikator.model.Prontuario;
import br.com.diagnostikator.util.DAOFactory;

public class ProntuarioBR {
	private ProntuarioDAO prontuarioDAO;
	
	public ProntuarioBR(){
		prontuarioDAO = DAOFactory.createProntuarioDAO();
	}

	public Prontuario getById(long id){
		return prontuarioDAO.getById(id);
	}
	
	public void save(Prontuario user){
		long id = user.getId();
		if(id == 0){
			prontuarioDAO.save(user);
		}
		else{
			prontuarioDAO.alter(user);
		}
	}
	
	public void delete(Prontuario user) {
		prontuarioDAO.delete(user);
	}
	
	public List<Prontuario> list(){
		return prontuarioDAO.list();
	}
}
