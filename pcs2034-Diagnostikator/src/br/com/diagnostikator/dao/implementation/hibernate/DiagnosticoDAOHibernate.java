package br.com.diagnostikator.dao.implementation.hibernate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import br.com.diagnostikator.dao.DiagnosticoDAO;
import br.com.diagnostikator.model.Diagnostico;
import br.com.diagnostikator.model.Doenca;
import br.com.diagnostikator.model.Sintoma;

public class DiagnosticoDAOHibernate implements DiagnosticoDAO {

	private Session session;

	public void setSession(Session s) {
		session = s;
	}

	@Override
	public void save(Diagnostico diagnostico) {
		session.save(diagnostico);

	}

	@Override
	public void delete(Diagnostico diagnostico) {
		session.delete(diagnostico);

	}

	@Override
	public void alter(Diagnostico diagnostico) {
		session.update(diagnostico);

	}

	@Override
	public Diagnostico getByID(long id) {
		return (Diagnostico) session.get(Diagnostico.class, id);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Doenca> getDoencas(List<Sintoma> sintomas) {
		ArrayList<Doenca> doencasObj = new ArrayList<Doenca>();
		
		if (sintomas == null || sintomas.size() <= 0) {
			return doencasObj;
		}

		StringBuilder sb = new StringBuilder();
		sb.append("(s.nome = '" + sintomas.get(0).getNome() + "'");

		for (int i = 1; i < sintomas.size(); i++) {
			sb.append(" OR s.nome = '" + sintomas.get(i).getNome() + "'");
		}

		sb.append(")");
		List doencas = session
				.createSQLQuery(
						"SELECT d.id, d.descricao, d.nome FROM doenca d, sintoma s, doenca_sintoma ds WHERE d.id = ds.doenca_id AND s.id = ds.sintomas_id AND "
								+ sb.toString() + " GROUP BY d.nome")
				.addEntity("d", Doenca.class).list();

		for (Iterator it = doencas.iterator(); it.hasNext();) {

			doencasObj.add((Doenca) it.next());
		}

		@SuppressWarnings("unchecked")
		ArrayList<Doenca> tmp = (ArrayList<Doenca>) doencasObj.clone();

		for (Doenca d : tmp) {
			for (Sintoma s : sintomas) {
				boolean temSintoma = false;
				for (Sintoma sd : d.getSintomas()) {
					if (sd.equals(s)) {
						temSintoma = true;
					}
				}
				if (temSintoma == false) {
					doencasObj.remove(d);
				}
			}
		}

		/*
		 * Lista as doencas encontradas for (Doenca d : doencasObj) {
		 * System.out.println(d.getNome()); }
		 */

		return doencasObj;
	}

}
