package br.com.diagnostikator.dao.implementation.hibernate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import br.com.diagnostikator.dao.ConsultaConfirmadaDAO;
import br.com.diagnostikator.model.ConsultaConfirmada;
import br.com.diagnostikator.model.Prontuario;

public class ConsultaConfirmadaDAOHibernate implements ConsultaConfirmadaDAO {

	private Session session;

	public void setSession(Session s) {
		session = s;
	}

	@Override
	public void save(ConsultaConfirmada consultaConfirmada) {
		session.save(consultaConfirmada);

	}

	@Override
	public void delete(ConsultaConfirmada consultaConfirmada) {
		session.delete(consultaConfirmada);

	}

	@Override
	public void alter(ConsultaConfirmada consultaConfirmada) {
		session.update(consultaConfirmada);
	}

	@Override
	public ConsultaConfirmada getByID(long id) {
		return (ConsultaConfirmada) session.get(ConsultaConfirmada.class, id);
	}	

	@SuppressWarnings({ "unchecked", "null" })
	@Override
	public int getNumByPeriodo(Date dataInicial, Date dataFinal) {
		
		SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dataIni = formatador.format(dataInicial); 
		String dataFi = formatador.format(dataFinal); 
		List<ConsultaConfirmada> consultas = session.createQuery("FROM ConsultaConfirmada WHERE data >='" + dataIni + "' AND data <= '" + dataFi + "'").list();
		if (consultas != null || !consultas.isEmpty())
			return consultas.size();
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ConsultaConfirmada> list() {
		return session.createCriteria(ConsultaConfirmada.class).list();
	}
	

	public Prontuario getProntuarioByID(long id){
		SQLQuery query = session.createSQLQuery("SELECT prontuario.* from prontuario inner join consultaConfirmada on consultaConfirmada.prontuario_fk = prontuario.id where prontuario.id=:id");
		//where owner.name=:username
		query.addEntity(Prontuario.class);
		query.setInteger("id",(int)id);
		Prontuario prontuario =(Prontuario)query.uniqueResult();
		//Prontuario prontuario = (Prontuario) session.createQuery("FROM Prontuario p, ConsultaConfirmada c WHERE c.prontuario_fk = p.id").uniqueResult();
		// AND p.id =' "+id+"'
		
		return prontuario;
	}
}
