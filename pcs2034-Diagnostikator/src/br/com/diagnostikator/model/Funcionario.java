package br.com.diagnostikator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table(name="funcionario")
public class Funcionario {	
	
	@Id
	@GeneratedValue
	private long id;
	
	private String nome;
	
	@org.hibernate.annotations.NaturalId
	private String rg;
	
	@org.hibernate.annotations.NaturalId
	private String cpf;
	
	private String endereco;
	private String tipo;
	private Date dataAdm;
	private String status;	


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getDataAdm() {
		return dataAdm;
	}

	public void setDataAdm(Date dataAdm) {
		this.dataAdm = dataAdm;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	
	
}
