package br.com.diagnostikator.dao;

import java.util.List;

import br.com.diagnostikator.model.Funcionario;

public interface FuncionarioDAO {
	public void save(Funcionario funcionario);
	public void delete(Funcionario funcionario);
	public void alter(Funcionario funcionario);
	public Funcionario getByCodigo(int codigo);	
	public List<Funcionario> getByNome(String nome);	
	public Funcionario getByRg(String rg);	
	public Funcionario getByCpf(String cpf);	
	public List<Funcionario> list();
}
