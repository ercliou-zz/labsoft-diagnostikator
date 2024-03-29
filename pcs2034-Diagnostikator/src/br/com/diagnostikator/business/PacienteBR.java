package br.com.diagnostikator.business;

import java.util.ArrayList;
import java.util.List;

import br.com.diagnostikator.dao.PacienteDAO;
import br.com.diagnostikator.model.Paciente;
import br.com.diagnostikator.model.Prontuario;
import br.com.diagnostikator.util.DAOFactory;

public class PacienteBR {
	private PacienteDAO pacienteDAO;
	
	public PacienteBR(){
		pacienteDAO = DAOFactory.createPacienteDAO();
	}

	public void save(Paciente user){
		long id = user.getId();
		if(id == 0){
			pacienteDAO.save(user);
		}
		else{
			pacienteDAO.alter(user);
		}
	}
	
	public void delete(Paciente user) {
		pacienteDAO.delete(user);
	}
	
	public Paciente getById(long id){
		return pacienteDAO.getById(id);
	}
	
	public Paciente getByCpf(String cpf){
		return pacienteDAO.getByCpf(cpf);
	}
	
	public Paciente getByRg(String rg) {
		return pacienteDAO.getByRg(rg);
	}
	
	public List<Paciente> getByNome(String nome) {
		return pacienteDAO.getByNome(nome);
	}	
	
	public List<Paciente> list(){
		return pacienteDAO.list();
	}
	
	public List<Paciente> list(long idMedico) {
		List<Paciente> filtered = new ArrayList<Paciente>() ;
		List<Paciente> full = this.list();
		for (Paciente paciente : full) {
			for(Prontuario prontuario : paciente.getProntuarios()){
				if(prontuario.getMedicoPai().getId() == idMedico){
					filtered.add(paciente);
					break;
				}
			}
		}
		return filtered;
	}
}
