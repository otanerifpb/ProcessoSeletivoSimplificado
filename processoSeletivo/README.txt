Processo Seletivo Simplificado IFPB 145-2022
Padrão utilizado foi o State

# Passo 01 - Definição das Vagas
	Foi definido de inicio que teriam 4 Vagas disponíveis
	Onde os 4 primeiros colocados seriam Classificados
	Os demais que passarem pelas etapas ficam Aprovados
	Print no início mostra a quantidade de Vagas disponíveis

# Passo 02 - Inscrição dos Candidatos
	Para o Candidato se increver para o PSS, é necessário Nome e RG
	Neste modelo estamos utilizando 8 Candidatos
	Os Candidatos são adicionados em uma lista chamada Candidatos

# Passo 03 - Avaliação dos Candidatos
	Acessamos a lista Candidatos e fazemos avaliação para cada Candidato
	Iniciamos pelo Método andamentoCandidatura(), passando o Candidato
	Na class Abstract State temos os métodos classificacao() e procedssando()  
	Etapa 01 - Prova de Desempenho
		Nesta fase que é eliminatória, chama o State DesenpenhoState(), passando o Candidado
		Chamamos o método processando(), apenas para simular o sistema cadastrando um Candidato
		Chamamos o método classificacao(), para verificar a pontuação do Candidato na prova de Desenpenho
		A pontuação da prova de Desenpenho e de forma automática com o Random, pelo método notaDesenpenho()
		Se o Candidato obtiver nota igual ou superior a 70, é Aprovado e elegível para a fase seguinte
			*setStatus para "Aprovado", setNota para a nota recebida e changeState para TituloState()
		Se a nota for inferior a 70, o Candidato é eliminado e o processo dele é ecnerrado
			*setProcess para false, setStatus para "Eliminado" e changeState para FinalizadoState()
	Etapa 02 - Prova de Título
		Nesta fase, chama o State TituloState() passando o Candidato que foi Aprovado
		Chamamos o método classificacao(), para verificar a pontuação do Candidato na prova de Titulação Acadêmica
		A pontuação da prova de Titulo é por meio do, pelo método tituloCandidato(), onde:
			*Nenhum(0) - 0 pontos, Doutor(1) - 25 pontos, Mestrado(2) - 18 pontos, Especialista(3) - 10 pontos
		Para garantir que o valor é digitado correto, temos uma validação que só passa se for digitado uma das opções informada
		Após validação da resposta, o Candidato é elegível para a fase seguinte
			*setNota para (getNota() + nota do titulo) e changeState para EnsinoState()
			*** Se o candidato não tiver titulação, permanece a nota existente sem alteração
	Etapa 03 - Prova de Ensino
		Nesta fase, chama o State EnsinoState() passando o Candidato que foi Aprovado
		Chamamos o método classificacao(), para verificar a pontuação do Candidato na prova de Ensino Acadêmica
		A pontuação da prova de Ensino é por meio do input, pelo método ensinoCandidato(), onde:
			*Nenhum(0) - 0 pontos, Cargo de Diretor(1) - 15 pontos, Coordenador de Curso(2) - 10 pontos
		Para garantir que o valor é digitado correto, temos uma validação que só passa se for digitado uma das opções informada
		Após validação da resposta, o Candidato é elegível para a fase seguinte
			*setNota para (getNota() + nota de ensino) e changeState para GestaoState()
			*** Se o candidato não tiver Experiência de Ensino Acadêmico, permanece a nota existente sem alteração
	Etapa 04 - Prova de Gestão
		Nesta fase, chama o State GestaoState() passando o Candidato que foi Aprovado
		Chamamos o método classificacao(), para verificar a pontuação do Candidato na prova de Gestão Acadêmica
		A pontuação da prova de Gestão é por meio do input, pelo método gestaoCandidato(), onde:
			*Nenhum(0) - 0 pontos, Instituto Federal(1) - 12 pontos, Educação Superior(2) - 7 pontos, Ensino Médio(3) - 6 pontos
		Para garantir que o valor é digitado correto, temos uma validação que só passa se for digitado uma das opções informada
		Após validação da resposta, é finalizado o processo do Candidato
			*setNota para (getNota() + nota do gestão) e changeState para FinalizadoState()
			*** Se o candidato não tiver Experiência de Gestão Acadêmico, permanece a nota existente sem alteração

# Passo 04 - Lista Candidatos Classifivado e Aprovados
	Pegamos a lista Candidatos[] Aprovados e criamos uma nova lista listaAprovado[]
	Onde adicionamos apenas os Candidatos com Status igual "Aprovado"
	Ordenamos esta nova lista em ordem Decrescente pela Nota
	De acordo com as vagas disponíveis(4) mudamos o setStatus para "Classificado", os demais permanecem com Status inalterados
	Depois pedimos para imprimir a Lista dos Classificados e Aprovados

# Passo 05 - Lista Candidatos Desclassificados
	Pegamos a lista Candidatos[]
	Ordenamos a lista em ordem Crescente pelo Nome
	Depois pedimos para imprimir apenas os Candidatos Eliminados
















		