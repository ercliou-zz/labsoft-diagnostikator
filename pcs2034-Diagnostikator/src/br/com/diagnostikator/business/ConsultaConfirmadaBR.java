package br.com.diagnostikator.business;

import java.util.ArrayList;
import java.util.List;

import br.com.diagnostikator.dao.ConsultaConfirmadaDAO;
import br.com.diagnostikator.model.ConsultaConfirmada;
import br.com.diagnostikator.model.Diagnostico;
import br.com.diagnostikator.model.Doenca;
import br.com.diagnostikator.model.Sintoma;
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
	
	public Diagnostico gerarDiagnostico(List<Sintoma> sintomas){
		List<Doenca> doencas = new ArrayList<Doenca>();
		Diagnostico diagnostico = new Diagnostico();
		diagnostico.setDoencas(doencas);
		
		
		diagnostico.setObservacoes("observacoez");
		Doenca doenca = new Doenca();
		doenca.setDescricao("desc");
		doenca.setId(99999);
		doenca.setNome("nomeDoenca");
		doenca.setSintomas(new ArrayList<Sintoma>());
		doencas.add(doenca);
		//TODO IMPLEMENTAR A GERAÇÃO DE DIAGNOSTICO AQUI!
		
		return diagnostico;
	}
	
	public List<ConsultaConfirmada> list(long idMedico, long idPaciente) {
		List<ConsultaConfirmada> filtered = new ArrayList<ConsultaConfirmada>() ;
		List<ConsultaConfirmada> full = this.list();
		for (ConsultaConfirmada consultaConfirmada : full) {
			if(consultaConfirmada.getProntuario().getMedico().getId() == idMedico && consultaConfirmada.getProntuario().getPaciente().getId() == idPaciente){
				filtered.add(consultaConfirmada);
			}
		}
		return filtered;
	}

}
