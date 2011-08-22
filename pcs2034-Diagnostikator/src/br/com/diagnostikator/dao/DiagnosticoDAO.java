package br.com.diagnostikator.dao;

import java.util.List;

import br.com.diagnostikator.model.Diagnostico;
import br.com.diagnostikator.model.Doenca;
import br.com.diagnostikator.model.Sintoma;

public interface DiagnosticoDAO {
	
	public List<Doenca> getDoencas(List<Sintoma> sintomas);

	public void save(Diagnostico diagnostico);

	public void delete(Diagnostico diagnostico);

	public void alter(Diagnostico diagnostico);
	
	public Diagnostico getByID(long id);
	
}
