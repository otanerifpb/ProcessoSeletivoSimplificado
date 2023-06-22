package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GestaoState extends State {

	GestaoState(Candidato candidato) {
		super(candidato);
	}

	@Override
	public String clasificacao() throws NumberFormatException, IOException {
		if (candidato.isProcess()) {
			if (gestaoCandidato() == 1) {
				candidato.setStatus("Classificado");
				candidato.setNota(candidato.getNota() + 15);
				candidato.changeState(new FinalizadoState(candidato));
				return "        Candidato Classificado" + 
						"Candidato elegível para o Processo Seletivo";
			} else if (gestaoCandidato() == 2){
				candidato.setStatus("Classificado");
				candidato.setNota(candidato.getNota() + 10);
				candidato.changeState(new FinalizadoState(candidato));
				return "        Candidato Classificado" + 
						"Candidato elegível para o Processo Seletivo";
			}else {
				candidato.setStatus("Classificado");
				//candidato.setNota(candidato.getNota() + 0);
				candidato.changeState(new FinalizadoState(candidato));
				return "        Candidato Classificado" + 
						"Candidato elegível para o Processo Seletivo";	
			}
		} else {
			candidato.changeState(new EnsinoState(candidato));
			return "Experiência de Gestão Acadêmica do Candidato em análise";
		}
	}
	
	public static int gestaoCandidato() throws NumberFormatException, IOException  {
		int resposta = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (resposta != 0 && resposta != 1 && resposta != 2) {
			System.out.println("           Resposta Inválida!!");
			System.out.println("Informe um Valor Dentro do Intervalo Indicado!");
		} else {
			System.out.println("Informar o Experiência de Ensino do Candidato");
		}
		System.out.println("Informe: 0 - NENHUM; 1 - Cargo de Diretor; 2 - Coordenador de Curso");
		resposta = Integer.parseInt(br.readLine());
		return resposta;
	}

}
