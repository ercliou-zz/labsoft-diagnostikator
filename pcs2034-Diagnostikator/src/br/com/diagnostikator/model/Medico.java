package br.com.diagnostikator.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("medico")
public class Medico extends Usuario {
	
	private String nome;
	@org.hibernate.annotations.NaturalId
	private String rg;
	@org.hibernate.annotations.NaturalId
	private String cpf;
	private String endereco;
	private Date dataAdmissao;
	private String especialidade;
	@org.hibernate.annotations.NaturalId
	private String crm;
	
	@OneToMany(mappedBy="medico", cascade = CascadeType.PERSIST)
	private List<Prontuario> prontuarios;	
	
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
	public Date getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public List<Prontuario> getProntuarios() {
		return prontuarios;
	}
	public void setProntuarios(List<Prontuario> prontuarios) {
		this.prontuarios = prontuarios;
	}
	
	
	
}
