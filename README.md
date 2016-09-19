# WordGame
> Jogo integrado de adivinhação.

![](header.png) mudar essa imagem

A classe Principal deve recuperar a instância de MecanicaDoJogo de
FabricaMecanicaDoJogo e não pode conter nenhuma referência direta a uma das
implementações, apenas a interface. Da mesma forma, as implementações de
MecanicaDoJogo devem recuperar os embaralhadores de FabricaEmbaralhadores e
também não pode conter nenhuma referência direta a implementações de
Embaralhador, apenas a interface.

As implementações de embaralhador devem conter algoritmos para o
embaralhamento de palavras. 

	Exemplo: inverter string, permutar randomicamente, trocar letras impares por pares e etc...

As implementações de MecanicaDoJogo devem retratar o andamento do jogo.
Exemplos de questões que podem mudar: quando o jogo termina (após um número
fixo de palavras, após um número de erros); quantas tentativas podem ser
feitas por palavra; como são computados os pontos; qual embaralhador será
utilizado e em que momento; e etc... O importante é que independente do
funcionamento, a classe Principal deverá interagir com ele da mesma forma

Deverá ser entregue: 
*	O código criado para o jogo 
*	O diagrama de classes com todas as classes criadas 
*	Testes de unidade para as classes de embaralhamento 
*	Link para um video disponibilizado de forma aberta com a gravação de uma partida do seu jogo


Jonathan Scheibel – [@jonathansmorais](https://www.facebook.com/jonathan.tjq) – jonathansmorais@gmail.com

Minha licença aqui: ``LICENSE`` para mais informações.

[https://github.com/yourname/github-link](https://github.com/dbader/)

