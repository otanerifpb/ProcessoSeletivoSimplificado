package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class EnsinoState extends State {
	static int resposta;
	Set<Integer> respostas = new HashSet<Integer>();

	public EnsinoState(Candidato candidato) {
		super(candidato);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String clasificacao() throws NumberFormatException, IOException {
		if (candidato.isProcess()) {
			resposta = ensinoCandidato();

			while (resposta != 0) {
				if (respostas.contains(resposta)) {
					System.out.println("     Esta resposta já foi Informada, informe outra resposta!!");
					resposta = ensinoCandidato();
				}
				//System.out.println(candidato.getNota());
				resposta = ensinoCandidato();
				notaCandidato(candidato);
			}
			
			candidato.changeState(new GestaoState(candidato));
			return "     Candidato elegível para Prova de Gestão";
		} else {
			candidato.changeState(new TituloState(candidato));
			return "     Experiência de Ensino do Candidato em análise";
		}
	}
	
	public static int ensinoCandidato() throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("     Informar a Experiência de Ensino do Candidato");
		System.out.println("     Informe: Sair Experiência Ensino(0); Intituto Federal(1); "
				+ "Educação Superior(2); Ensino Médio(3)");
		resposta = Integer.parseInt(br.readLine());
		if (resposta != 0 && resposta != 1 && resposta != 2 && resposta != 3) {
		//if (resposta != 0) {
			System.out.println("     Resposta Inválida!!");
			System.out.println("     Informe um Valor Dentro do Intervalo Indicado!");
		} 
		return resposta;
	}
	
	public void notaCandidato(Candidato candidato) {
		int ensino = resposta;
		respostas.add(ensino);
		//System.out.println(respostas);
		if (ensino == 1) {
			//candidato.setStatus("Aprovado");
			candidato.setNota(candidato.getNota() + 12);	
		} else if (ensino == 2){
			//candidato.setStatus("Aprovado");
			candidato.setNota(candidato.getNota() + 7);	
		}else if (ensino == 3){
			//candidato.setStatus("Aprovado");
			candidato.setNota(candidato.getNota() + 6);
		}else {
			//candidato.setStatus("Eliminado");
			//candidato.setNota(candidato.getNota() + 0);
			candidato.changeState(new GestaoState(candidato));			
		}
	}

}
