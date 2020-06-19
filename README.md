#Desafio Jokenpo

##IDE: Spring Tool Suite
##Spring Boot
##Java8
##Sem utilização de framework externo
##Gradle

Exemplos de como jogar:
	**1. Cadastrar os jogadores**
		url: http://localhost:8080/jokenpo/player
		body: {
				"playerName" : "J35"
			  }
	**2. Realizar as jogadas para os jogadores**
		url: http://localhost:8080/jokenpo/move
		body: {
				"playerName" : "J35",
				"movement" : "PAPER"
			  }
		**Jogadas**	  
			SPOCK
			SCISSORS
			PAPER
			STONE
			LIZARD
		
	**3. Executar o jokenpô**
		url: http://localhost:8080/jokenpo/play
		Zera a jogada de todos os participantes para os jogadores escolherem novamente suas jogadas e fazer o jokenpô
		
	**4. O jokenpô zera e os jogadores podem fazer uma nova jogada**
		Retorna um array vazio
	

######Utilização do pattern singleton e desenvolvimento com strategy e recursão para comparar os jogadores.
######Os jogadores podem realizar a mesma jogada.
######No jokenpô pode existir mais de um ganhador se os jogadores utilizarem a mesma jogada.
######As excessões tem logg e são escritas no console da IDE.
######As listas de (jogador e jogadas) não tem testes, pois o retorno é uma lista vazia ou preenchida, não é passado nenhum parametro de pesquisa.
######Se for deletado o jogo mais de uma vez, ele sempre vai retornar uma lista vazia e nenhuma excessão é disparada.




