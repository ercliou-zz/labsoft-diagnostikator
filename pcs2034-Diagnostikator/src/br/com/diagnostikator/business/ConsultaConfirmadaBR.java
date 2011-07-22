package br.com.diagnostikator.business;

import java.util.List;

import br.com.diagnostikator.dao.ConsultaConfirmadaDAO;
import br.com.diagnostikator.model.ConsultaConfirmada;
import br.com.diagnostikator.util.DAOFactory;

public class ConsultaConfirmadaBR {
	private ConsultaConfirmadaDAO consultaConfirmadaDAO;

	public ConsultaConfirmadaBR() {
		this.consultaConfirmadaDAO = DAOFactory.createConsultaConfirmadaDAO();
	}

	
	public ConsultaConfirmada getByID(long id){
		return this.consultaConfirmadaDAO.getByID(id);
	}

	public void save(ConsultaConfirmada consultaConfirmada) {
		long id = consultaConfirmada.getId();

		if (id == 0) {
			this.consultaConfirmadaDAO.save(consultaConfirmada);
		} else {
			this.consultaConfirmadaDAO.alter(consultaConfirmada);
		}
	}

	public void delete(ConsultaConfirmada consultaConfirmada) {
		this.consultaConfirmadaDAO.delete(consultaConfirmada);
	}

	public List<ConsultaConfirmada> list() {
		return this.consultaConfirmadaDAO.list();
	}

}
