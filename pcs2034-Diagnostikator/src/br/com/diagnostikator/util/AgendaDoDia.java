package br.com.diagnostikator.util;

import java.io.FileReader;
import java.text.SimpleDateFormat;

import au.com.bytecode.opencsv.CSVReader;
import br.com.diagnostikator.business.ConsultaAgendadaBR;
import br.com.diagnostikator.business.MedicoBR;
import br.com.diagnostikator.business.PacienteBR;
import br.com.diagnostikator.model.ConsultaAgendada;
import br.com.diagnostikator.model.Medico;
import br.com.diagnostikator.model.Paciente;

public class AgendaDoDia {

	private ConsultaAgendadaBR consultaAgendadaBR;
	private MedicoBR medicoBR;
	private PacienteBR pacienteBR;

	public AgendaDoDia() {
		consultaAgendadaBR = new ConsultaAgendadaBR();
		medicoBR = new MedicoBR();
		pacienteBR = new PacienteBR();
	}

	public void run() {
		try {
			if (LastScan.getInstance().shouldScan()) {
				SimpleDateFormat format = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm");
				ConsultaAgendada consultaAgendada;
				Medico medico;
				Paciente paciente;

				CSVReader reader = new CSVReader(new FileReader("C:\\Users\\Helder\\Documents\\agenda.csv"));
				String[] nextLine;
				while ((nextLine = reader.readNext()) != null) {
					if (nextLine.length == 4) {
						consultaAgendada = new ConsultaAgendada();
						// nextLine[] is an array of values from the line
						medico = this.medicoBR.getByCrm(nextLine[2]);
						paciente = this.pacienteBR.getByRg(nextLine[3]);
						consultaAgendada.setDataConsulta(format
								.parse(nextLine[0]));
						consultaAgendada.setStatus(nextLine[1]);
						consultaAgendada.setMedico(medico);
						consultaAgendada.setPaciente(paciente);

						this.consultaAgendadaBR.save(consultaAgendada);
					}

				}
				LastScan.getInstance().finishedScan();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			LastScan.getInstance().problemOnScan();
		}

	}
}