package br.com.drerp.financeiro.transferencia;

import java.util.List;

public class Categoria {
	
	private String nome;
	private String descricao;
	private List<Categoria> subCategorias;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Categoria> getSubCategorias() {
		return subCategorias;
	}
	public void setSubCategorias(List<Categoria> subCategorias) {
		this.subCategorias = subCategorias;
	}
	
	
}
