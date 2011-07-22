package br.com.diagnostikator.dao;

import java.util.List;
import br.com.diagnostikator.model.Medico;

public interface MedicoDAO{	
	public void save(Medico medico);
	public void delete(Medico medico);
	public void alter(Medico medico);
	public Medico getByCodigo(int codigo);	
	public List<Medico> getByNome(String nome);	
	public Medico getByRg(String rg);	
	public Medico getByCpf(String cpf);	
	public List<Medico> getByEspecialide(String especialidade); 	
	public Medico getByCrm(int crm);
	public List<Medico> list();
}
