package br.com.drerp.financeiro.transferencia;

public class Transferencia {
	private Long id;
	private StatusTransferencia status;
	private Pagador pagador;
	private Beneficiario beneficiario;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public StatusTransferencia getStatus() {
		return status;
	}
	public void setStatus(StatusTransferencia status) {
		this.status = status;
	}
	public Pagador getPagador() {
		return pagador;
	}
	public void setPagador(Pagador pagador) {
		this.pagador = pagador;
	}
	public Beneficiario getBeneficiario() {
		return beneficiario;
	}
	public void setBeneficiario(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}
	
	
}
