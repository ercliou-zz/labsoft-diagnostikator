package br.com.diagnostikator.dao;

import java.util.List;

import br.com.diagnostikator.model.Prontuario;

public interface ProntuarioDAO {
	public void save(Prontuario prontuario);
	public void delete(Prontuario prontuario);
	public void alter(Prontuario prontuario);
	public Prontuario getById(long id);
	public List<Prontuario> list();
}
