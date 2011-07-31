package br.com.diagnostikator.business;

import java.util.List;

import br.com.diagnostikator.dao.FuncionarioDAO;
import br.com.diagnostikator.model.Funcionario;
import br.com.diagnostikator.util.DAOFactory;

public class FuncionarioBR {
	private FuncionarioDAO funcionarioDAO;
	
	public FuncionarioBR(){
		funcionarioDAO = DAOFactory.createFuncionarioDAO();
	}

	public void save(Funcionario funcionario){
		long id = funcionario.getId();
		if(id == 0){
			funcionarioDAO.save(funcionario);
		}
		else{
			funcionarioDAO.alter(funcionario);
		}
	}
	
	public void delete(Funcionario funcionario) {
		funcionarioDAO.delete(funcionario);
	}
	
	public Funcionario getByCpf(String cpf) {
		return funcionarioDAO.getByCpf(cpf);
	}
	
	public Funcionario getByRg(String rg) {
		return funcionarioDAO.getByRg(rg);
	}
	
	public Funcionario getById(long id){
		return funcionarioDAO.getById(id);
	}

	public List<Funcionario> getByNome(String nome) {
		return funcionarioDAO.getByNome(nome);
	}	
	
	public List<Funcionario> getByTipo(String tipo) {
		return funcionarioDAO.getByTipo(tipo);
	}	
	
	public List<Funcionario> list(){
		return funcionarioDAO.list();
	}	
}
