# Projeto Final - Dungeons and Dragons

# Descrição 
   O propósito do jogo é escapar da Dungeon vivo, mas no caminho, o jogador terá que encontrar as chaves correspondentes de cada porta e enfrentar Dragões que estarão impedindo sua passagem, e causarão dano caso o ataque do jogador falhe. O jogador pode escolher entre as classes : Mago, Guerreiro, Bárbaro e Arqueiro, cujos ataques e caraterísticas iniciais variam. Com um mix de sorte ao jogar os dados e habilidade o jogador pode percorrer várias Dungeons acumulando pontuação. 


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

	
A primeira dificuldade enfrentada foi a familiarização com a interface gráfica, tendo em vista que não tínhamos muito conhecimento a respeito. Escolhemos para esse projeto o LibGDX que tem uma associação ampla com projetos em Java, além das informações de fácil acesso para seu uso. Sendo assim, contextualizando o projeto inicial, idealizamos apenas fazer a tela de jogo com os status do personagem, onde o tabuleiro seria uma imagem que geramos em um site e o personagem seria apenas um quadrado no mapa. Entretanto, ao estudar mais a fundo o framework que utiliziaríamos conseguimos ter mais noção do que conseguiríamos fazer, aumentando assim a complexidade do que tínhamos planejado, deixando o projeto mais detalhado e polído em sua versão final.

   Com isso, a partir de softwares gráficos como GIMP, pode-se criar uma interface melhor, com texturas para o labirinto e adicionando um inventário para o personagem,além de que, possibilitou colocar uma imagem para cada personagem. No projeto inicial, idealizamos o personagem com Mana, que caso acabasse o personagem não conseguiria mais atacar, porém revogamos essa ideia, pois a dificuldade principal do jogo seria baseada na sorte nos dados nas batalhas contra os Dragões e não na gestão de mana. Com isso, substituímos a Mana com a possibilidade do Dano e do Alcance do ataque variar dependendo da sorte nos baús (Comparação feita na Imagem 1).
   
   A partir do estudo das telas do LibGDX, pode-se fazer uma sequência de telas, com uma tela de inicio e fim de jogo, e uma de seleção de personagem,que abre uma aba com os status iniciais deles, podendo em todas elas fechar e voltar a tela de início novamente (Imagem 2).
Além desses desafio da abordagem gráfica , por estarmos implementando um Modelo do tipo Model-View-Controller, presou-se por ao máximo estabelecer essas relações intermediadas pelos controladores ao acessar o model ou o view. Com isso, devido ao tempo de entrega priorizou-se as mecânicas do jogo a uma maior complexidade, tendo em vista que a base deve ser forte para uma possível expansão  facilitada pela arquitetura elaborada.

 * Imagem 1
![Evolução](https://user-images.githubusercontent.com/82724293/177206724-49e7c51b-150c-431a-9876-c518f3bf3d35.png)

 * Imagem 2
![Telas](https://user-images.githubusercontent.com/82724293/177350998-4f291cad-0e28-42f4-831d-fb8490baec66.png)


# Lições e Melhorias

Como lição aprendida destacou-se a importância de uma organização bem fundamentada. Como o projeto foi iniciado sem uma arquitetura totalmente definida, tínhamos apenas as ideias e alguns diagramas feitos. Com isso, tivemos dificuldade enm criar as classes e suas relações de uma forma que mantivéssemos o código simples e organizado. Uma vez que, ao decidirmos utilizar uma Arquitetura Model-View-Controller (MVC), queriamos respeitar as comunicações entre eles, o que necessitava de uma organização provisória de melhor calibre.

Como melhorias, podemos destacar a implementação de mais "desing patterns", o que nos retornaria uma melhor organização e maior abstração do conjunto do projeto. Além de que, um estudo mais aprofundado sobre frameworks nos possibilitaria criar e colocar em prática outras ideias que possam surgir no decorrer do desenvolvimento do projeto, como animar ataques, criar mais telas de jogo, mais níveis, etc.

# Destaques de Código

As texturas foram iniciadas nos construtores das classes, para assim não sobrecarregar a memória do computador ao renderizar cada frame.

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
Nas telas principal e de seleção nós nos preocupamos em estabelecer um intervalo de tempo fixo entre um clique e outro. Esta tentativa de "discretizar" o tempo dos cliques foi feita pois uma pressão rápida no botão esquerdo do mouse pode ser contada como vários cliques.

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

Utilizamos uma classe abstrata chamada "Personagem" que herda da classe Componente. Esta classe apresenta dois métodos abstratos que são sobrescritos pelas classes Mago, Guerreiro, Barbaro e Arqueiro que são os tipos de personagens que podem ser escolhidos pelo player. Tendo em vista que todos os personagens atacam de formas distintas em regiões diferentes, o uso de Polimorfismo foi essencial. Sendo assim, a classe "PersonagemController" chama os métodos "atacar" e "area" sem precisar de nenhuma informação a respeito de qual tipo de personagem está realizando estas ações.

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

## Diagrama do Pattern Facade

![Facade](https://user-images.githubusercontent.com/82724293/177807681-939ce08b-74b5-4ba7-b20d-e0d34e60b62c.png)

## Código do Pattern Facade
~~~java
public class MainController {
	
	public static Direcao direcao;
	public static Ataque ataqueInfo;
	
	public static void setPersonagem(...) {
		PersonagemController.setP(...);
	}
	
	public static void move(...) {
		PersonagemController.move(...);
	}
	
	public static void initTabuleiro() {
		TabuleiroController.tabuleiro = new Tabuleiro();
	}
	
	public static int jogaDado() {
		return Util.jogaDado();
	}
	
	public static void setMensagem...) {
		Texto.setMensagem(...);
	}
	
	public static String getMensagem() {
		return Texto.getMensagem();
	}
	
	public static Direcao getDirecao() {
		return direcao;
	}
	
	public static void drawMap(...) {
		TabuleiroController.drawMap(...);
	}
	
	public static void plot(...) {
		TabuleiroController.plot(...);
	}
	
	public static void atacar(...) {
		ataqueInfo = PersonagemController.atacar(...);
	}
	
	public static Ataque getAtaqueInfo() {
		return ataqueInfo;
	}
	
	public static boolean acertou() {
		return ataqueInfo == Ataque.ACERTOU;
	}
	...
}
~~~

Escolhemos implementar o design pattern Facade por conta dos vários objetos utilizados no jogo. A utilização do Facade permite que a comunicação com vários sub-setores do código tenha uma complexidade mais baixa. Além disso, uma das nossas propostas iniciais foi a fácil expansão do número de componentes do jogo (personagens, dragões e bônus) e isso é algo que, com a adição do Facade, é muito simples de ser feito. Outro tópico de nosso interesse é o princípio de Acoplamento fraco (do inglês Loose coupling) que consiste em separar os componentes do sistema de modo que cada um deles tenha pouca informação a respeito dos outros. Em conclusão, decidimos utilizar este padrão pois ele traz consigo um alto grau de flexibilidade.


# Documentação dos Componentes

# Diagramas

## Diagrama Geral da Arquitetura do Jogo

![Arquitetra](https://user-images.githubusercontent.com/82724293/177673847-427c7558-e6b9-449c-8cf6-8962616eee43.png)


Nós optamos por aplicar a arquitetura MVC. Esta arquitetura consiste em particionar o código em 3 setores:
* Model - Essa partição é responsável por armazenar os dados do usuário e os objetos da aplicação.
* View - Essa partição guarda a interface de usuário (UI). Ela também é responsável por lidar com a comunicação com o usuário do sistema.
* Controller - Essa partição faz a ponte entre as duas anteriores. Ela é encarregada de transformar os pedidos do usuário em suas respectivas respostas.

Como pode ser observado na imagem acima, todos os objetos do jogo estão na área Model, todas as telas estão na área View e por fim, na área Controller estão os controladores criados para lidar com o transito de informações.

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

Essa interface importada do LibGDX tem o papel de mostrar, criar e rendenrizar todas as telas que são mostradas no jogo : Tela de Menu, Tela de Seleção, Tela de Confirmação, Mapa, Telas Finais.

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

Concluímos que sempre é possível fazer melhorias, como criar exceções para importar as imagens dos componentes, além de expandir o jogo, adicionando mais personagens, diferenciando os dragões ou até mesmo criando um "Boss". Entretanto, como a arquitetura implementada se dedicou a manter uma forma básica sólida, a expansão de novos componentes é algo simples de realizar.

Apesar de melhorias fáceis de ser identificadas, ainda assim, o projeto final conseguiu superar nossas espectativas tomando como base o nosso esboço inicial. Portanto, além de conseguirmos colocar em prática os conhecimentos de Orientação a Objetos, finalizamos um projeto que nos mostrou que o mundo da indústria de games não é algo impossível de ser alcançado. Por mais simples que o jogo criado possa ser, a sua produção foi uma grande quebra de obstáculos mentais que tínhamos em relação a esses assuntos.
	
Para finalizar, um possível trabalho futuro poderia ser uma expansão do game criado, adicionando mais mecânicas baseadas no jogo que deu nome a esse projeto "Dungeons and Dragons" que é muito baseado nas escolhas dos personagens e não em um script pronto. Sendo assim, com o aumento da complexidade do jogo, uma organização e uma arquitetura mais trabalhada em Interfaces e Desing Patterns seriam essenciais. Como por exemplo, a utilização de um Singleton para o Tabuleiro, uma vez que este poderia ser criado apenas uma vez e ser acessado apenas por um método, já que seu construtor é privado, com isso, ningúem teria mais acesso a essa parte do código, apenas o TabuleiroController, deixando as classes exercendo papéis mais específicos.
