# Desafio Jokenpo

## Utilização:
###### Utilização do pattern singleton e desenvolvimento com strategy e recursão para comparar os jogadores.
###### Os jogadores podem realizar a mesma jogada.
###### No jokenpô pode existir mais de um ganhador se os jogadores utilizarem a mesma jogada.
###### As excessões tem logg e são escritas no console da IDE.
###### As listas de (jogador e jogadas) não tem testes, pois o retorno é uma lista vazia ou preenchida, não é passado nenhum parametro de pesquisa.
###### Se for deletado o jogo mais de uma vez, ele sempre vai retornar uma lista vazia e nenhuma excessão é disparada.


## Configuração:
###### IDE Spring Tool Suite
###### Spring Boot
###### Java8
###### Sem utilização de framework externo
###### Gradle

## Exemplos de como jogar:
### 1. Cadastrar os jogadores

url: http://localhost:8080/jokenpo/player

```
body: {
	"playerName" : "J35"
      }
```	

### 2. Cadastrar os movimentos/jogadas dos jogadores

url: http://localhost:8080/jokenpo/move

```
body: {
	"playerName" : "J35",
	"movement" : "PAPER"
      }
```      

**Jogadas** : SPOCK, SCISSORS, PAPER, STONE, LIZARD

		
### 3. Executar o jokenpô

url: http://localhost:8080/jokenpo/play

Essa API realiza o jokenpô informando quem venceu e zera todas as jogadas de todos jogadores. Assim os jogadores podem escolher novos movimentos/jogadas e fazer o jokenpô novamente
		
### 4. Zerar jogadas e jogadores

url: http://localhost:8080/jokenpo/play

Retorna um array vazio e o jogo é iniciado do zero
