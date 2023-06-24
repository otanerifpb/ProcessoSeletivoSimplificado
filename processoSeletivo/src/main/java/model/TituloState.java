package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Random;

public class TituloState extends State {
	static int resposta;

	public TituloState(Candidato candidato) {
		super(candidato);
	}

	@Override
	public String clasificacao() throws NumberFormatException, IOException  {
		
		if (candidato.isProcess()) {
			
			/*Validação da resposta do Candidato*/
			resposta = tituloCandidato();
			while (resposta != 0 && resposta != 1 && resposta != 2 && resposta != 3) {
				resposta = tituloCandidato();
			}
			
			int titulo = resposta;
			if (titulo == 1) {
				//candidato.setStatus("Aprovado");
				candidato.setNota(candidato.getNota() + 25);
				candidato.changeState(new EnsinoState(candidato));
				return "     Candidato elegível para Prova de Ensino";
			} else if (titulo == 2){
				//candidato.setStatus("Aprovado");
				candidato.setNota(candidato.getNota() + 18);
				candidato.changeState(new EnsinoState(candidato));
				return "     Candidato elegível para Prova de Ensino";
			}else if (titulo == 3){
				//candidato.setStatus("Aprovado");
				candidato.setNota(candidato.getNota() + 10);
				candidato.changeState(new EnsinoState(candidato));
				return "     Candidato elegível para Prova de Ensino";
			}else {
				//candidato.setStatus("Eliminado");
				//candidato.setNota(candidato.getNota() + 0);
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("     Informar a Titulação Acadêmica do Candidato");
		System.out.println("     Informe: Sem Título(0); Doutor(1); Mestre(2); Especialista(3)");
		resposta = Integer.parseInt(br.readLine());
		if (resposta != 0 && resposta != 1 && resposta != 2 && resposta != 3) {
			System.out.println("     Resposta Inválida!!");
			System.out.println("     Informe um Valor Dentro do Intervalo Indicado!");
		}
		return resposta;
	}

}
