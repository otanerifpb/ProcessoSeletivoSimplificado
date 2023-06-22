package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnsinoState extends State {

	EnsinoState(Candidato candidato) {
		super(candidato);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String clasificacao() throws NumberFormatException, IOException {
		if (candidato.isProcess()) {
			if (ensinoCandidato() == 1) {
				candidato.setStatus("Classificado");
				candidato.setNota(candidato.getNota() + 12);
				candidato.changeState(new GestaoState(candidato));
				return "        Candidato Classificado" + 
						"Candidato elegível para Prova de Ensino";
			} else if (ensinoCandidato() == 2){
				candidato.setStatus("Classificado");
				candidato.setNota(candidato.getNota() + 7);
				candidato.changeState(new GestaoState(candidato));
				return "        Candidato Classificado" + 
						"Candidato elegível para Prova de Ensino";
			}else if (ensinoCandidato() == 3){
				candidato.setStatus("Classificado");
				candidato.setNota(candidato.getNota() + 6);
				candidato.changeState(new GestaoState(candidato));
				return "        Candidato Classificado" + 
						"Candidato elegível para Prova de Ensino";
			}else {
				candidato.setStatus("Classificado");
				//candidato.setNota(candidato.getNota() + 0);
				candidato.changeState(new GestaoState(candidato));
				return "        Candidato Classificado" + 
						"Candidato elegível para Prova de Ensino";	
			}
		} else {
			candidato.changeState(new TituloState(candidato));
			return "Experiência de Ensino do Candidato em análise";
		}
	}
	
	public static int ensinoCandidato() throws NumberFormatException, IOException  {
		int resposta = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (resposta != 0 && resposta != 1 && resposta != 2 && resposta != 3) {
			System.out.println("            Resposta Inválida!!");
			System.out.println("Informe um Valor Dentro do Intervalo Indicado!");
		} else {
			System.out.println("Informar o Experiência de Ensino do Candidato");
		}
		System.out.println("Informe: 0 - NENHUM; 1 - Intituto Federal; "
				+ "2 - Educação Superior; 3 - Ensino Médio");
		resposta = Integer.parseInt(br.readLine());
		return resposta;
	}

}
