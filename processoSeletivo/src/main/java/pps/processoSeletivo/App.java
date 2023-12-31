package pps.processoSeletivo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import model.Candidato;
import model.DesenpenhoState;
import model.EnsinoState;
import model.FinalizadoState;
import model.GestaoState;
import model.State;
import model.TituloState;

/**
 * @authors 
 * 
 * Renato Ribeiro da Silva
 * Fabrycio Érico de Medeiros
 * Glaucio Alves Medeiros
 * IFPB - 2023.1 - P5 - Prof. Dr Alex Sandro da Cunha Rêgo
 * Padrões de Projetos de Software
 *
 */
public class App 
{
    public static void main( String[] args ) throws NumberFormatException, IOException {
    	
    	/*Var para definir quantidades de vagas do PSS do IFPB*/
    	int vagasDisponivel = 2;
    	System.out.println("*************************************************");
    	System.out.println("Processo Seletivo Simplificado IFPB 145-2022");
    	System.out.println("          Com " + vagasDisponivel + " vagas disponíveis");
    	System.out.println("*************************************************");
    	
    	/*Var para definir a respostas classificação da Prova de Títulos*/
    	int resposta = 0;
    	
    	/*Declareaão dos Candidaatos e do ArrayList para guardar*/
    	ArrayList<Candidato> candidatos = new ArrayList<Candidato>();
    	Candidato c1 = new Candidato("Renato", 1234);
    	Candidato c2 = new Candidato("Alex", 2345);
    	Candidato c3 = new Candidato("Glaucio", 3456);
    	Candidato c4 = new Candidato("Fabrycio", 4567);
    	Candidato c5 = new Candidato("Rivania", 5678);
    	Candidato c6 = new Candidato("Junio", 6789);
    	Candidato c7 = new Candidato("Cristina", 7891);
    	Candidato c8 = new Candidato("Jussara", 8912);
    	
    	/*Adição dos Cabdidatos no ArrayList*/
    	candidatos.add(c1);
    	candidatos.add(c2);
    	candidatos.add(c3);
    	candidatos.add(c4);
    	//candidatos.add(c5);
    	//candidatos.add(c6);
    	//candidatos.add(c7);
    	//candidatos.add(c8);
    	
    	/*Avaliação de cada Candidato nas fases do PSS*/
    	for (Candidato candidato: candidatos) {
    		andamentoCandidatura (candidato, resposta);
    		finalizarCandidatura (candidato);
    	}
    	
    	/*Teste da Lista de todos os Candidados do PSS*/
    	//System.out.println();
    	//System.out.println(candidatos);
    	
    	/*Criar a Lista dos Candidatos Classificados*/
    	ArrayList<Candidato> listaAprovado = new ArrayList<Candidato>();
    	for (Candidato candidato: candidatos) {
    		if (candidato.getStatus().equals("Aprovado")){
    			listaAprovado.add(candidato);
    		}
    	}
    	
    	/*Ordenar a Lista dos Candidatos Classificados em Decrescente pela Nota*/
    	Collections.sort(listaAprovado, new Comparator<Candidato>() {
    		public int compare(Candidato c1, Candidato c2) {
				return c2.getNota() - c1.getNota();
			}
    	});
    	
    	/*Teste da Lista dos Candidados Classificados*/
    	//System.out.println(listaClassificado);
    	//System.out.println();
    	
    	/*Prints da Lista dos Candidatos Aprovados e Classificados no PSS*/
    	System.out.println();
    	System.out.println("*********************************************************");
    	System.out.println("  Lista do(s) Candidato(s) Classificado(s) e Aprovado(s)");
    	System.out.println("*********************************************************");
    	for (Candidato candidato: listaAprovado) {
    		int index = listaAprovado.indexOf(candidato);
    		if (candidato.getStatus().equals("Aprovado")){
    			if (index <= (vagasDisponivel - 1)){
    				candidato.setStatus("Classificado");
    				System.out.println(candidato.toStringClassificado());
    			} else {
    				System.out.println(candidato.toStringClassificado());
    			}
    		}
    	}
    	
    	/*Criar a Lista dos Candidatos Desclassificados*/
//    	ArrayList<Candidato> listaDesclassificado = new ArrayList<Candidato>();
//    	for (Candidato candi: candidatos) {
//    		if (candi.getStatus().equals("Não Classificado")){
//    			listaDesclassificado.add(candi);
//    		}
//    	}
    	
    	/*Teste da Lista dos Candidados Desclassificados*/
//    	System.out.println(listaDesclassificado);
    	
    	/*Ordenar a Lista dos Candidatos Desclassificados em Crescente pelo Nome*/
    	Collections.sort(candidatos, new Comparator<Candidato>() {
    		public int compare(Candidato c1, Candidato c2) {
				return c1.getNome().compareTo(c2.getNome());
			}
    	});
    	
    	/*Prints da Lista dos Candidatos Desclassificados no PSS*/
    	System.out.println();
    	System.out.println("*************************************************");
    	System.out.println("     Lista do(s) Candidato(s) Eliminado(s)");
    	System.out.println("*************************************************");
    	for (Candidato candidato: candidatos) {
    		if (candidato.getStatus().equals("Eliminado")){
    			System.out.println(candidato.toStringDesclassificado());
    		}
    	}
    }
    
    /*Método para avançar as fases do Candidato no PSS*/
    public static void andamentoCandidatura(Candidato candidato, int resposta) 
			throws NumberFormatException, IOException {
    	
    	/*Primeira fase de classificação do Candidato, Prova de Desenpenho*/
    	State desenpenho = new DesenpenhoState(candidato);
    	desenpenho.processando();
		System.out.println(desenpenho.clasificacao());
		
		/*Segunda fase de classificação do Candidato, Etapa 1, Prova de Título*/
		 if (candidato.isProcess()){
    	State titulo = new TituloState(candidato);
		System.out.println(titulo.clasificacao());
		 }
		 
		/*Segunda fase de classificação do Candidato, Etapa 2, Prova de Ensino*/
		 if (candidato.isProcess()){
    	State ensino = new EnsinoState(candidato);
		System.out.println(ensino.clasificacao());
		 }
		 
		 /*Segunda fase de classificação do Candidato, Etapa 3, Prova de Gestão*/
		 if (candidato.isProcess()){
    	State gestao = new GestaoState(candidato);
		System.out.println(gestao.clasificacao());
		 }
    }
    
    /*Método para finalizar o processo do Candidato no PSS*/
    public static void finalizarCandidatura(Candidato candidato) 
    		throws NumberFormatException, IOException {
		
    	State finalizado = new FinalizadoState(candidato);
		System.out.println(finalizado.clasificacao());
	}
}
