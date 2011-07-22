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

	public Funcionario getByCodigo(int codigo){
		return funcionarioDAO.getByCodigo(codigo);
	}	

	public List<Funcionario> getByNome(String nome) {
		return funcionarioDAO.getByNome(nome);	
	}

	public Funcionario getByRg(String rg) {		
		return funcionarioDAO.getByRg(rg);
	}

	public Funcionario getByCpf(String cpf) {
		return funcionarioDAO.getByCpf(cpf);
	}

	public List<Funcionario> getListaFuncionarios() {
		return funcionarioDAO.getLista();
	}	

//	@Override
//	public List<String> getListaStatus() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<String> getListaTipos() {
//		// TODO Auto-generated method stub
//		return null;
//	}
		
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
	
	public List<Funcionario> list(){
		return funcionarioDAO.getLista();
	}
}
