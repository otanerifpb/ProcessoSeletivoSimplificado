package model;

import java.io.IOException;

public class FinalizadoState extends State{

	public FinalizadoState(Candidato candidato) {
		super(candidato);
	}

	@Override
	public String clasificacao() throws NumberFormatException, IOException {
		return "     Processo do Candidato Encerrada";
	}

}
