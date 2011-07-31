package br.com.diagnostikator.dao;

import java.util.List;

import br.com.diagnostikator.model.Sintoma;

public interface SintomaDAO {	
	public void save(Sintoma sintoma);
	public void delete(Sintoma sintoma);
	public void alter(Sintoma sintoma);	
	public Sintoma getByID(long id);
	public List<Sintoma> getByNome(String nome);
	public List<Sintoma> list();

}
