# Projeto Final - Dungeons and Dragons

# Descrição 
   O propósito do jogo é escapar da Dungeon vivo, mas no caminho, o jogador terá que encontrar as chaves correspondentes de cada porta e enfrentar Dragões que estaram impedindo sua passagem, e causaram dano caso o ataque do jogador falhe. O jogador pode escolher entre as classes : Mago, Guerreiro, Bárbaro e Arqueiro, cujos ataques e caraterísticas inicias variam. Com um mix de sorte ao jogar os dados e habilidade o jogador pode percorrer por várias Dungeons acumulando pontuação. 


# Equipe
* `Andreas Cisi Ramos` - `246932`
* `Luiz Fernando Batista Morato` - `223406`

# Arquivo Executável do Jogo

[Executável](https://github.com/MC322-java/ProjetoFinal/blob/main/POO/desktop-1.0.jar)

# Slides do Projeto

## Slides da Prévia
 [SlidesApresentação](https://github.com/MC322-java/ProjetoFinal/files/8987255/dungeons.and.dragons-previa.pdf)


## Slides da Apresentação Final
[SlidesApresentação](https://docs.google.com/presentation/d/1J4ujRFWqHTiGbl0sQxXFE67nZM1xVLPtrip18wx18gg/edit?usp=sharing)

## Relatório de Evolução

# Evolução e Difuculdades enfrentadas.

	
A primeira dificuldade enfrentada foi a familiarização com um interface gráfica, tendo em vista que não tínhamos muito conhecimneto a respeito. Escolhemos para esse projeto o LibGDX que tem uma associação ampla com projetos em Java, além das informações de fácil acesso para seu uso. Sendo assim, contextualizando o projeto inicial, idealizamos apenas fazer a tela de jogo com os status do persoagem, onde o tabuleiro seria uma imagem que geramos em um site e o personagem seria apenas um quadrado no mapa. Entretanto, ao estudar mais a fundo o workframe que utiliziaríamos conseguimos ter mais noção do que conseguiríamos fazer, assim aumentando a complexidade do que tínhamos planejado, deixando o projeto mais detalhado e polído em sua versão final.

   Com isso, a partir de softwares gráficos como GIMP, pode-se criar uma interface melhor, com texturas para o labirinto e adicionando um inventário para o personagem,além de que, possibilitou colocar uma imagem para cada personagem. No projeto inicial, idealizamos o personagem com Mana, que caso acabasse o personagem não conseguiria mais atacar, porém revogamos essa ideia, pois a dificuldade principal do jogo seria baseada na sorte nos dados nas batalhas contra os Dragões e não na gestão de mana que o personagem tem que ter. Com isso, substituímos essa Mana com a possibilidade do Dano e do Alcance do ataque variar dependendo da sorte nos baús (Comparação feita na Imagem 1).
   
   A partir do estudo das telas do LibGDX, pode-se fazer uma sequência de telas, com uma tela de inicio e fim de jogo, e uma de seleção de personagem,que abre uma aba com os status iniciais deles, podendo em todas elas fechar e voltar a tela de início novamente (Imagem 2).
Além desses desafio da abordagem gráfica , por estarmos implementando um Modelo do tipo Model-View-Controller, presou-se por ao máximo estabelecer essas relações intermediadas pelos controladores ao acessar o model ou o view. Com isso, devido ao tempo de entrega priorizou-se as mecânicas do jogo a uma maior complexidade, tendo em vista que a base deve ser forte para uma possível expansão  facilitada pela arquitetura elaborada.

 * Imagem 1
![Evolução](https://user-images.githubusercontent.com/82724293/177206724-49e7c51b-150c-431a-9876-c518f3bf3d35.png)

 * Imagem 2
![Telas](https://user-images.githubusercontent.com/82724293/177350998-4f291cad-0e28-42f4-831d-fb8490baec66.png)


# Lições e Melhorias

Como lição aprendida destacou-se a importância de uma organização bem fundamenteada. Como o projeto foi iniciado sem uma arquitetura totalmente definida, tinhamos apenas as ideias e alguns diagramas feitos. Com isso, tivemos dificulade na hora criar as classes e suas relações e deixar o código simples de ser seguido e organizado. Uma vez que, ao decidirmos utilizar uma Arquitetura Model-View-Controller, queriamos respeitar as comunicações entre eles, o que necessitava uma grande organização provisória.

Como melhorias, podemos destacar a implementação de mais "desing patterns", o que nos retornaria uma melhor organização e maior abstração do conjunto do projeto. Além de que, um estudo mais aprofundado sobre framework nos possibilitaria criar e colocar em prática ideais que vão surgindo ao decorrer do trabalho, como animar os ataques, criar mais telas de jogo, mais níveis, por exemplo.

# Destaques de Código

As texturas foram iniciadas nos construtores das classes, para assim , não sobrecarregar a memória do computador ao renderizar cada frame.

~~~java
public class MapScreen implements Screen {
   ...
   public MapScreen(final DungeonsAndDragons game, Personagem p) {
   ...
   fundo = new Texture("TelaFundo.png");
   for (int i = 1; i <= 20; i++) {
		dadosPlayer.add(new Texture("DadoPlayer/" + i + ".png"));
		dadosDragao.add(new Texture("DadoDragao/" + i + ".png"));
	}
     ...
}
~~~
Nas telas principal e de seleção se preocupou em deixar um tempo entre um clique e outro, pois os cliques do mouse contam vários com apenas um, sendo assim um clique não afeta a próxima tela do jogo.

~~~java
public class MainMenuScreen implements Screen {
		...
		private int lastClick, contador;
		...

		public MainMenuScreen(...) {...}
		
		@Override
		public void render(float delta) {
			...
			game.batch.draw(capa, 0, 0, 1060 ,580);
			
			if (contador - lastClick >= 10) {
				if (Gdx.input.isTouched()) {
					game.setScreen(new SelectionScreen(game));
					dispose();
				}
				lastClick = contador;
			}
			contador++;
		}
}
~~~




# Destaques de Orientação a Objetos

Utilizou-se uma classe abstrata Personagem que herda de Componente, e nessa classe apresenta dois métodos abstratos que serão sobrescritos pelas classes Mago, Guerreiro, Barbaro e Arqueiro que são possíveis personagens para se jogar. Tendo em vista que a forma como eles atacam variam e a área do seus ataques também variam, foi de suma importancia esse Polimorfismo para a execução do Ataque deles. Sendo assim , o PersonagemController apenas chama esses métodos sem sabeer qual personagem que se trata.

## Diagrama de Classes usada no destaque OO:

![Classes](https://user-images.githubusercontent.com/82724293/177408125-e13a8597-cfa0-4fee-9cf0-746fe2da46cb.jpg)


## Código do Destaque OO

~~~java
public abstract class Personagem extends Componente {
	...
	public abstract Ataque atacar(...);
	public abstract ArrayList<Integer> area(...){...};
	...
}
~~~
~~~java
public class Arqueiro extends Personagem {
	...
	@Override
	public Ataque atacar(...) {...};
	@Override
	public ArrayList<Integer> area(...){...};
}
~~~
~~~java
public class Mago extends Personagem {
	...
	@Override
	public Ataque atacar(...) {...};
	@Override
	public ArrayList<Integer> area(...){...};
}
~~~
~~~java
public class Guerreiro extends Personagem {
	...
	@Override
	public Ataque atacar(...) {...};
	@Override
	public ArrayList<Integer> area(...){...};
}
~~~
~~~java
public class Barbaro extends Personagem {
	...
	@Override
	public Ataque atacar(...) {...};
	@Override
	public ArrayList<Integer> area(...){...};
}
~~~
Polimorfismo usado em :
~~~java
public class PersonagemController {
	public static Personagem p;
	
	public static Ataque atacar(...) {
		return p.atacar(...);
	}
	
	public static ArrayList<Integer> area(...) {
		return p.area(...);
	}
	...
}
~~~



# Destaques de Pattern

## Diagrama do Pattern
> Diagrama do pattern dentro do contexto da aplicação.

## Código do Pattern
~~~java
package com.mygdx.game.controller;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.model.*;
import com.mygdx.game.model.entities.*;
import com.mygdx.game.model.entities.objetos.Chave;
import com.mygdx.game.model.util.*;
import com.mygdx.game.view.MapScreen;

public class MainController {
	
	public static Direcao direcao;
	public static Ataque ataqueInfo;
	
	public static void setPersonagem(int id, int linha, int coluna, int vida, int range, int dano) {
		PersonagemController.setP(id, linha, coluna, vida, range, dano);
	}
	
	public static void move(int linha, int coluna) {
		PersonagemController.move(linha, coluna);
	}
	
	...
	
	public static void initTabuleiro() {
		TabuleiroController.tabuleiro = new Tabuleiro();
	}
	
	public static int jogaDado() {
		return Util.jogaDado();
	}
	
	public static void setMensagem(String mensagem) {
		Texto.setMensagem(mensagem);
	}
	
	public static String getMensagem() {
		return Texto.getMensagem();
	}
	
	...
	
	public static Direcao getDirecao() {
		return direcao;
	}
	
	public static void drawMap(MapScreen mapScreen, int squareSize) {
		TabuleiroController.drawMap(mapScreen, squareSize);
	}
	
	public static void plot(MapScreen mapScreen, Texture t, int squareSize) {
		TabuleiroController.plot(mapScreen, t, PersonagemController.getLinha(), PersonagemController.getColuna(),
				squareSize, squareSize);
	}
	
	public static void atacar(int idx1, int idx2) {
		ataqueInfo = PersonagemController.atacar(direcao, idx1, idx2);
	}
	
	public static Ataque getAtaqueInfo() {
		return ataqueInfo;
	}
	
	...
	
	public static boolean acertou() {
		return ataqueInfo == Ataque.ACERTOU;
	}
	...
}
~~~

> Explicação de como o pattern foi adotado e quais suas vantagens, referenciando o diagrama.


# Documentação dos Componentes

# Diagramas

## Diagrama Geral da Arquitetura do Jogo

![Arquitetra](https://user-images.githubusercontent.com/82724293/177673847-427c7558-e6b9-449c-8cf6-8962616eee43.png)


> Faça uma breve descrição do diagrama.

### Componente Model:

**Ficha Técnica**
item | detalhamento
----- | -----
Pacote | `src/com/mygdx/game/model`
Autores |  `Andreas Cisi e Fernando Morato`
Interfaces | `-`

### Componente View:

**Ficha Técnica**
item | detalhamento
----- | -----
Pacote | `src/com/mygdx/game/view`
Autores |  `Andreas Cisi e Fernando Morato`
Interfaces | `Screen - LibGDX`

### Componente Controller:


**Ficha Técnica**
item | detalhamento
----- | -----
Pacote | `src/com/mymdx/game/controller`
Autores | `Andreas Cisi e Fernando Morato`
Interfaces | `-`


## Detalhamento das Interfaces

### Interface Screen

Essa interface importada do LibGDX tem o papel de mostrar, criar e rendenrizar todas as telas que esta sendo mostrada no jogo : Tela de Menu, Tela de Seleção, Tela de Confirmação, Mapa, Telas Finais.

~~~java
public interface Screen {

	public void show ();

	public void render (float delta);

	public void resize (int width, int height);

	public void pause ();

	public void resume ();

	public void hide ();

	public void dispose ();
}
~~~

Método | Objetivo
-------| --------
`show` | `chamado quando a tela se torna a tela apresentada para o jogo`
`render` | `chamado quando a tela se autorenderiza - delta é o tempo desde a última renderização`
`resize` | `chamado quando se quer modificar o tamanho da tela de jogo`
`pause` | `chamado quando o se quer pausar o jogo`
`resume` | `chamado quando se quer continuar de um estado pausado`
`hide` | `chamado quando a tela não é mais a tela apresentada para o game`
`dispose` | `chamada quando a tela tem que liberar todos seus recursos`

# Conclusões e Trabalhos Futuros

Concluímos que sempre é possível fazer melhorias, como escrever exceções para o importar imagens que serão as texturas dos componentes, além de expandir o jogo, colocando mais classes de personagens, diferenciando dragões ou até mesmo criando um "Boss". Porém, como a arquitetura implementada se dedicou a manter uma forma básica sólida, a expansão de novos componentes seria simples de se fazer.

Apesar de óbvia melhorias que o jogo poderia ter, ainda assim, o projeto final conseguiu superar as espectativas que tinhamos baseado no esboço inicial que que fizemos. Portanto, além de conseguirmos colocar em prática os conhecimentos de Orientação a Objetos, finalizamos um projeto que nos mostrou que esse mundo da indústria de games não é algo impossível de ser alcançado. Por mais simples que o jogo criado possa ser, já é um grande degrau e uma quebra de obstáculos que tínhamos em mente sobre esses assuntos.
	
Para finalizar então, um possível trabalho futuro poderia ser uma expansão do game criado, adicionando mais mecânicas baseadas no jogo que deu nome a esse projeto "Dungeons and Dragons" que é muito baseado nas esoclhas dos personagens e não em um script pronto. Sendo assim, com o aumento da complexidade do jogo, uma organização e uma arquitetura mais trabalhada em Intrefaces e Desing Patterns seriam essensial. Como por exemplo, a utilização de um Singleton para o Tabuleiro, uma vez que este poderia ser criado apenas uma vez e ser acessado apenas por um método , já que seu construtor é privado, com isso, ningúem teria mais acesso a essa parte do código, apenas o TabuleiroController , dexando as classes exercendo papéis mais específicos, aumentando a abstração da arquitetura.
