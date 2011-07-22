package br.com.diagnostikator.business;

import java.util.List;

import br.com.diagnostikator.dao.SintomaDAO;
import br.com.diagnostikator.model.Sintoma;
import br.com.diagnostikator.util.DAOFactory;

public class SintomaBR {
	private SintomaDAO sintomaDAO;

	public SintomaBR() {
		this.sintomaDAO = DAOFactory.createSintomaDAO();
	}

	public Sintoma getByName(String nome) {
		return this.sintomaDAO.getByName(nome);
	}
	
	public Sintoma getByID(long id){
		return this.sintomaDAO.getByID(id);
	}

	public void save(Sintoma sintoma) {
		long id = sintoma.getId();

		if (id == 0) {
			this.sintomaDAO.save(sintoma);
		} else {
			this.sintomaDAO.alter(sintoma);
		}
	}

	public void delete(Sintoma sintoma) {
		this.sintomaDAO.delete(sintoma);
	}

	public List<Sintoma> list() {
		return this.sintomaDAO.list();
	}

}
