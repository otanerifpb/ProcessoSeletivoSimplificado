package model;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class State {
	Candidato candidato;
	
	State(Candidato candidato) {
		this.candidato = candidato;
	}
	
	public abstract String clasificacao() throws NumberFormatException, IOException;
	
	public void processando() {
		System.out.println();
		System.out.print("Sistema Processando Inscrição do Candidato: "+candidato.getNome());
		for (int i = 1; i < 5; i++) {
			System.out.print(  " . ");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		System.out.println("     Candidato Inscrito com sucesso!");
	}

}
