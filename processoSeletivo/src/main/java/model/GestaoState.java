package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class GestaoState extends State {
	static int resposta;
	Set<Integer> respostas = new HashSet<Integer>();

	public GestaoState(Candidato candidato) {
		super(candidato);
	}

	@Override
	public String clasificacao() throws NumberFormatException, IOException {
		if (candidato.isProcess()) {
			resposta = gestaoCandidato();
			
			while (resposta != 0) {
				if (respostas.contains(resposta)) {
					System.out.println("     Esta resposta já foi Informada, informe outra resposta!!");
					resposta = gestaoCandidato();
				}
				resposta = gestaoCandidato();
				notaCandidato(candidato);
			}
			
			candidato.changeState(new FinalizadoState(candidato));
			return "     Candidato elegível para o Processo Seletivo";
		} else {
			candidato.changeState(new EnsinoState(candidato));
			return "     Experiência de Gestão Acadêmica do Candidato em análise";
		}
	}
	
	public static int gestaoCandidato() throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("     Informar a Experiência de Gestão do Candidato");
		System.out.println("     Informe: Sair Experiência Gestão(0); Cargo de Diretor(1); "
				+ "Coordenador de Curso(2)");
		resposta = Integer.parseInt(br.readLine());
		if (resposta != 0 && resposta != 1 && resposta != 2) {
			System.out.println("     Resposta Inválida!!");
			System.out.println("     Informe um Valor Dentro do Intervalo Indicado!");
		} 
		return resposta;
	}
	
	public void notaCandidato(Candidato candidato) {
		int gestao = resposta;
		respostas.add(gestao);
		//System.out.println(respostas);
		if (gestao == 1) {
			//candidato.setStatus("Aprovado");
			candidato.setNota(candidato.getNota() + 15); 	
		} else if (gestao == 2){
			//candidato.setStatus("Aprovado");
			candidato.setNota(candidato.getNota() + 10);	
		} else {
			//candidato.setStatus("Eliminado");
			//candidato.setNota(candidato.getNota() + 0);
			candidato.changeState(new FinalizadoState(candidato));			
		}
	}
}
