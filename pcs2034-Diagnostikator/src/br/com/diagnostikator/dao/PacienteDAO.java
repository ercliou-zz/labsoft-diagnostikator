package br.com.diagnostikator.dao;

import java.util.List;
import br.com.diagnostikator.model.Paciente;

public interface PacienteDAO {
	public void save(Paciente patient);
	public void delete(Paciente patient);
	public void alter(Paciente patient);
	public Paciente getById(long id);
	public Paciente getByCpf(String cpf);
	public Paciente getByRg(String rg);
	public List<Paciente> getByNome(String nome);
	public List<Paciente> list();
	
}
