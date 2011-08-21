package br.com.diagnostikator.dao;

import java.util.List;
import br.com.diagnostikator.model.Medico;

public interface MedicoDAO{	
	public void save(Medico medico);
	public void delete(Medico medico);
	public void alter(Medico medico);
	public Medico getByCpf(String cpf);	
	public Medico getById(long id);	
	public Medico getByRg(String rg);	
	public Medico getByCrm(String crm);	
	public List<Medico> getByEspecialidade(String especialidade);
	public List<Medico> getByNome(String nome);
	public List<Medico> getByTipo(String tipo);
	public Medico getByLogin(String login);
	public List<Medico> list();
}
