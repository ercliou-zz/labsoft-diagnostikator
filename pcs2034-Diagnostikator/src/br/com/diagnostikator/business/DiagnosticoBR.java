package br.com.diagnostikator.business;

import br.com.diagnostikator.dao.DiagnosticoDAO;
import br.com.diagnostikator.model.Diagnostico;
import br.com.diagnostikator.util.DAOFactory;

public class DiagnosticoBR {
	private DiagnosticoDAO diagnosticoDAO;

	public DiagnosticoBR() {
		this.diagnosticoDAO = DAOFactory.createDiagnosticoDAO();
	}

	public Diagnostico getByID(long id){
		return this.diagnosticoDAO.getByID(id);
	}

	public void save(Diagnostico diagnostico) {
		long id = diagnostico.getId();

		if (id == 0) {
			this.diagnosticoDAO.save(diagnostico);
		} else {
			this.diagnosticoDAO.alter(diagnostico);
		}
	}

	public void delete(Diagnostico diagnostico) {
		this.diagnosticoDAO.delete(diagnostico);
	}

}
