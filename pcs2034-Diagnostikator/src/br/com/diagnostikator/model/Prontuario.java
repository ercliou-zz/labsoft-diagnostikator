package br.com.diagnostikator.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="prontuario")
public class Prontuario {
	@Id
	@GeneratedValue
	private long id;
	
	@OneToMany
	@JoinColumn(name="prontuario_fk")
	private List<ConsultaConfirmada> consultasConfirmadas;	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="paciente_fk", insertable=false, updatable=false)
	private Paciente pacientePai;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="medico_fk", insertable=false, updatable=false)
	private Medico medicoPai;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<ConsultaConfirmada> getConsultasConfirmadas() {
		return consultasConfirmadas;
	}

	public void setConsultasConfirmadas(
			List<ConsultaConfirmada> consultasConfirmadas) {
		this.consultasConfirmadas = consultasConfirmadas;
	}



	public Paciente getPacientePai() {
		return pacientePai;
	}

	public void setPacientePai(Paciente pacientePai) {
		this.pacientePai = pacientePai;
	}

	public Medico getMedicoPai() {
		return medicoPai;
	}

	public void setMedicoPai(Medico medicoPai) {
		this.medicoPai = medicoPai;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((consultasConfirmadas == null) ? 0 : consultasConfirmadas
						.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((medicoPai == null) ? 0 : medicoPai.hashCode());
		result = prime * result
				+ ((pacientePai == null) ? 0 : pacientePai.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prontuario other = (Prontuario) obj;
		if (consultasConfirmadas == null) {
			if (other.consultasConfirmadas != null)
				return false;
		} else if (!consultasConfirmadas.equals(other.consultasConfirmadas))
			return false;
		if (id != other.id)
			return false;
		if (medicoPai == null) {
			if (other.medicoPai != null)
				return false;
		} else if (!medicoPai.equals(other.medicoPai))
			return false;
		if (pacientePai == null) {
			if (other.pacientePai != null)
				return false;
		} else if (!pacientePai.equals(other.pacientePai))
			return false;
		return true;
	}	
	
	
	
}
