package br.com.diagnostikator.business;

import java.util.List;

import br.com.diagnostikator.dao.DoencaDAO;
import br.com.diagnostikator.model.Doenca;
import br.com.diagnostikator.util.DAOFactory;

public class DoencaBR {
	private DoencaDAO doencaDAO;

	public DoencaBR() {
		this.doencaDAO = DAOFactory.createDoencaDAO();
	}	

	public void save(Doenca doenca) {
		long id = doenca.getId();

		if (id == 0) {
			this.doencaDAO.save(doenca);
		} else {
			this.doencaDAO.alter(doenca);
		}
	}

	public void delete(Doenca doenca) {
		this.doencaDAO.delete(doenca);
	}
	
	public List<Doenca> getByNome(String nome) {
		return this.doencaDAO.getByNome(nome);
	}
	
	public Doenca getByID(long id){
		return this.doencaDAO.getByID(id);
	}

	public List<Doenca> list() {
		return this.doencaDAO.list();
	}
}
