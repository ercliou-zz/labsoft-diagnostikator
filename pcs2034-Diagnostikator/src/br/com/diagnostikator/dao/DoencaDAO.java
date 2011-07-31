package br.com.diagnostikator.dao;

import java.util.List;

import br.com.diagnostikator.model.Doenca;

public interface DoencaDAO {
	public void save(Doenca doenca);
	public void delete(Doenca doenca);
	public void alter(Doenca doenca);	
	public Doenca getByID(long id);	
	public List<Doenca> getByNome(String nome);
	public List<Doenca> list();
}
