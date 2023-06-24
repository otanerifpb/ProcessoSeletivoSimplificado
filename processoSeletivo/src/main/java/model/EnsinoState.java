package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnsinoState extends State {
	static int resposta;

	public EnsinoState(Candidato candidato) {
		super(candidato);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String clasificacao() throws NumberFormatException, IOException {
		if (candidato.isProcess()) {
			resposta = ensinoCandidato();
			while (resposta != 0 && resposta != 1 && resposta != 2 && resposta != 3) {
				resposta = ensinoCandidato();
			}
			
			int ensino = resposta;
			if (ensino == 1) {
				//candidato.setStatus("Aprovado");
				candidato.setNota(candidato.getNota() + 12);
				candidato.changeState(new GestaoState(candidato));
				return "     Candidato elegível para Prova de Gestão"; 	
			} else if (ensino == 2){
				//candidato.setStatus("Aprovado");
				candidato.setNota(candidato.getNota() + 7);
				candidato.changeState(new GestaoState(candidato));
				return "     Candidato elegível para Prova de Gestão"; 	
			}else if (ensino == 3){
				//candidato.setStatus("Aprovado");
				candidato.setNota(candidato.getNota() + 6);
				candidato.changeState(new GestaoState(candidato));
				return "     Candidato elegível para Prova de Gestão";
			}else {
				//candidato.setStatus("Eliminado");
				//candidato.setNota(candidato.getNota() + 0);
				candidato.changeState(new GestaoState(candidato));
				return "     Candidato elegível para Prova de Gestão";			
			}
		} else {
			candidato.changeState(new TituloState(candidato));
			return "     Experiência de Ensino do Candidato em análise";
		}
	}
	
	public static int ensinoCandidato() throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("     Informe: NENHUM (0); Intituto Federal (1); "
				+ "Educação Superior (2); Ensino Médio (3)");
		resposta = Integer.parseInt(br.readLine());
		if (resposta != 0 && resposta != 1 && resposta != 2 && resposta != 3) {
			System.out.println("     Resposta Inválida!!");
			System.out.println("     Informe um Valor Dentro do Intervalo Indicado!");
		} else {
			System.out.println("     Informar a Experiência de Ensino do Candidato");
		}
		return resposta;
	}

}
