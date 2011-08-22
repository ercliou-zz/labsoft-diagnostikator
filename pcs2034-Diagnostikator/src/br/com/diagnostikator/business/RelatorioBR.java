package br.com.diagnostikator.business;


import java.util.Date;

import br.com.diagnostikator.dao.ConsultaConfirmadaDAO;
import br.com.diagnostikator.dao.DiagnosticoDAO;
import br.com.diagnostikator.util.DAOFactory;


public class RelatorioBR {
	
	private ConsultaConfirmadaDAO consultaConfirmadaDAO;
	private DiagnosticoDAO diagnosticoDAO;
	
	public RelatorioBR(){
		consultaConfirmadaDAO = DAOFactory.createConsultaConfirmadaDAO();
		diagnosticoDAO = DAOFactory.createDiagnosticoDAO();
	}
	
	public int getNumConsultaConfirmadaByPeriodo(Date dataInicial, Date dataFinal){
		return consultaConfirmadaDAO.getNumByPeriodo(dataInicial, dataFinal);
	}
	
	public int getNumDiagnosticoByPeriodo(Date dataInicial, Date dataFinal){
		return diagnosticoDAO.getNumByPeriodo(dataInicial, dataFinal);
	}
}
