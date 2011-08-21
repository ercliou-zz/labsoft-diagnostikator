package br.com.diagnostikator.business;

import java.util.List;

import br.com.diagnostikator.dao.MedicoDAO;
import br.com.diagnostikator.model.Medico;
import br.com.diagnostikator.util.DAOFactory;

public class MedicoBR {
	private MedicoDAO medicoDAO;
	
	public MedicoBR(){
		medicoDAO = DAOFactory.createMedicoDAO();
	}

	public void save(Medico medico){
		long id = medico.getId();
		if(id == 0){
			medicoDAO.save(medico);
		}
		else{
			medicoDAO.alter(medico);
		}
	}
	
	public void delete(Medico medico) {
		medicoDAO.delete(medico);
	}
	
	public Medico getByCpf(String cpf) {
		return medicoDAO.getByCpf(cpf);
	}
	
	public Medico getById(long id){
		return medicoDAO.getById(id);
	}
	
	public Medico getByRg(String rg) {
		return medicoDAO.getByRg(rg);
	}
	
	public Medico getByCrm(String crm) {
		return medicoDAO.getByCrm(crm);
	}
	
	public List<Medico> getByEspecialidade(String especialidade) {
		return medicoDAO.getByEspecialidade(especialidade);
	}
	
	public List<Medico> getByNome(String nome) {
		return medicoDAO.getByNome(nome);
	}	
	
	public List<Medico> getByTipo(String tipo) {
		return medicoDAO.getByTipo(tipo);
	}	
	
	public Medico getByLogin(String login) {
		return medicoDAO.getByLogin(login);
	}	
	
	public List<Medico> list(){
		return medicoDAO.list();
	}	
}
