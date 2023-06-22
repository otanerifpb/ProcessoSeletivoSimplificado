package model;

public class Candidato {
	private String nome;
	private Integer RG;
	private State state;
	private boolean process = false;
	private String status;
	private Integer nota;
	
	/*Construtor 1, para usar caso necessário*/
//	public Candidato() {
//		
//	}

	/*Construtor 2, Usado para Realizar o Cadastro do Candidato*/
	public Candidato(String nome, Integer RG) {
		this.nome = nome;
		this.RG = RG;
		this.state = new DesenpenhoState(this);
		setProcess(true);
	}

	/*Construtor 3, para usar caso necessário, Status do Candidato*/
//	public Candidato(String nome, String status) {
//		this.nome = nome;
//		this.state = new DesenpenhoState(this);
//		setProcess(true);
//		this.status = status;
//	}
	
	/*Construtor 4, para usar caso necessário, Status e Nota*/
//	public Candidato(String nome, String status,Integer nota) {
//		this.nome = nome;
//		this.state = new DesenpenhoState(this);
//		setProcess(true);
//		this.status = status;
//		this.nota = nota;
//	}

	public void setProcess(boolean process) {
		this.process = process;
	}
	
	public boolean isProcess() {
		return process;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getRG() {
		return RG;
	}

	public void setRG(Integer rG) {
		RG = rG;
	}
	
	public void changeState(State state) {
		this.state = state;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}
	
	/*Teste para o toString chamar o método de acordo com o Status*/
//	public String toString() {
//		if (this.status == "Classificado") {
//			return toStringClassificado();
//		} else if(this.status == "Não Classificado") {
//			return toStringDesclassificado();
//		}
//	}
	
	/*Opção para mostrar dados pessoais do Candidato*/
	public String toString() {
		return "Nome: " +nome+ " - Status: " +status+ " - RG: " +RG;
	}
	
	/*Opção para chamar a lista dos Candidatos Classificados*/
	public String toStringClassificado() {
		//System.out.println("Resultado dos Candidatos Classificados");
		return "Nome: " +nome+ " - Status: " +status+ " - Nota: " +nota;
	}
	
	/*Opção para chamar a lista dos Candidatos Desclassificados*/
	public String toStringDesclassificado() {
		//System.out.println("Resultado dos Candidatos Não Classificado");
		return "Nome: " +nome+ " - Status: " +status;
	}
	
}
