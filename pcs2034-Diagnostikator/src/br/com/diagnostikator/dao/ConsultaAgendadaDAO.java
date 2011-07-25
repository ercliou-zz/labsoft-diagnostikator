package br.com.diagnostikator.dao;

import java.util.Date;
import java.util.List;

import br.com.diagnostikator.model.ConsultaAgendada;

public interface ConsultaAgendadaDAO {
	public void save(ConsultaAgendada consultaAgendada);
	public void delete(ConsultaAgendada consultaAgendada);
	public void alter(ConsultaAgendada consultaAgendada);
	public List<ConsultaAgendada> getByPaciente(String nomePaciente);
	public List<ConsultaAgendada> getByMedico(String nomeMedico);
//	public ConsultaAgendada getByHorario(Date dataConsulta);
	public List<ConsultaAgendada> list();
}
