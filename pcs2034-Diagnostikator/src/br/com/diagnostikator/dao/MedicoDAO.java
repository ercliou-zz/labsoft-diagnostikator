package br.com.diagnostikator.dao;

import java.util.List;
import br.com.diagnostikator.model.Medico;

public interface MedicoDAO{	
	public void save(Medico medico);
	public void delete(Medico medico);
	public void alter(Medico medico);
	public Medico getByCpf(String cpf);	
	public Medico getById(long id);	
	public List<Medico> list();
}
