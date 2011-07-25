package br.com.diagnostikator.dao;

import java.util.List;

import br.com.diagnostikator.model.ConsultaConfirmada;

public interface ConsultaConfirmadaDAO {

	public void save(ConsultaConfirmada consultaConfirmada);

	public void delete(ConsultaConfirmada consultaConfirmada);

	public void alter(ConsultaConfirmada consultaConfirmada);
	
	public ConsultaConfirmada getByID(long id);
	
	public List<ConsultaConfirmada> list();
	
}
