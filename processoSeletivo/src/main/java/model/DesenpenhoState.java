package model;

import java.util.Random;

public class DesenpenhoState extends State{

	public DesenpenhoState(Candidato candidato) {
		super(candidato);
	}

	@Override
	public String clasificacao() {
		if (candidato.isProcess()) {
			int nota = notaDesempenho();
			if (nota >= 70) {
				candidato.setStatus("Classificado");
				candidato.setNota(nota);
				candidato.changeState(new TituloState(candidato));
				return "     Candidato Classificado\n" + 
						"     Candidato elegível para Prova de Título";
			} else {
				candidato.setProcess(false);
				candidato.setStatus("Não Classificado");
				candidato.changeState(new FinalizadoState(candidato));
				return "     Candidato Não Classificado\n" + 
						"     Nota Avaliação do Candidato Abaixo da Nota de Corte";	
			}	
		} else {
			candidato.setProcess(false);
			candidato.changeState(new FinalizadoState(candidato));
			return "     Nota da Avaliação de Desempenho está sendo processada";
		}
	}
	
	/*Nota da Prova de Desempenho, de forma automatizada*/
	public static int notaDesempenho() {
    	int min = 50;
    	int max = 100;
		Random random = new Random();
		return random.nextInt(max - min + 1) + min;
	}

}