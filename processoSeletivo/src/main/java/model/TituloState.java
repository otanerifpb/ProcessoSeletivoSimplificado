package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Random;

public class TituloState extends State {

	public TituloState(Candidato candidato) {
		super(candidato);
	}

	@Override
	public String clasificacao() throws NumberFormatException, IOException  {
		
		if (candidato.isProcess()) {
			int titulo = tituloCandidato();
			if (titulo == 1) {
				//candidato.setStatus("Classificado");
				candidato.setNota(candidato.getNota() + 25);
				candidato.changeState(new EnsinoState(candidato));
				return "     Candidato elegível para Prova de Ensino";
			} else if (titulo == 2){
				//candidato.setStatus("Classificado");
				candidato.setNota(candidato.getNota() + 18);
				candidato.changeState(new EnsinoState(candidato));
				return "     Candidato elegível para Prova de Ensino";
			}else if (titulo == 3){
				//candidato.setStatus("Classificado");
				candidato.setNota(candidato.getNota() + 10);
				candidato.changeState(new EnsinoState(candidato));
				return "     Candidato elegível para Prova de Ensino";
			}else {
				//candidato.setStatus("Não Classificado");
				candidato.setNota(candidato.getNota() + 0);
				candidato.changeState(new EnsinoState(candidato));
				return "     Candidato elegido para Prova de Ensino"; 			
			}
		} else {
			candidato.changeState(new DesenpenhoState(candidato));
			return "     Titulação Acadêmica do Candidato em análise";
		}
	}
	
	/*Entrada da Titulação do Candidatos de forma automatizada*/
//	public static int notaTitulo() {
//    	int min = 0;
//    	int max = 3;
//		Random random = new Random();
//		return random.nextInt(max - min + 1) + min;
//	}
	
	/*Entrada da Titulação do Candidatos para Prova de Título*/
	public static int tituloCandidato() throws NumberFormatException, IOException  {
		int resposta = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (resposta != 0 && resposta != 1 && resposta != 2 && resposta != 3) {
			System.out.println("     Resposta Inválida!!");
			System.out.println("     Informe um Valor Dentro do Intervalo Indicado!");
		}else {
			System.out.println("     Informar a Titulação Acadêmica do Candidato");
		}
		System.out.println("     Informe: 0 - NENHUM; 1 - Doutor; 2 - Mestre; 3 - Especialista");
		resposta = Integer.parseInt(br.readLine());
		return resposta;
	}

}
