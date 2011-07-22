package br.com.diagnostikator.dao;

import br.com.diagnostikator.model.Diagnostico;

public interface DiagnosticoDAO {

	public void save(Diagnostico diagnostico);

	public void delete(Diagnostico diagnostico);

	public void alter(Diagnostico diagnostico);
	
	public Diagnostico getByID(long id);
	
}
