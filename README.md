# Projeto Final - Dungeons and Dragons

# Descrição 
   O porpósito do jogo é escapar da Dungeon vivo, mas no caminho, o jogador terá que encontrar as chaves correspondentes de cada porta e enfrentar Dragões que estaram impedindo sua passagem, e causaram dano caso o ataque do jogador falhe. O jogador pode escolher entre as classes : Mago, Guerreiro, Bárbaro e Arqueiro, cujos ataques e caraterísticas inicias variam. Com um mix de sorte ao jogar os dados e habilidade o jogador pode percorrer por várias Dungeons acumulando pontuação. 

# Pasta do Projeto
  * [Acesso-MVC : src](https://github.com/MC322-java/ProjetoFinal/tree/main/POO/POO/core/src/com/mygdx/game)
  * [Imagens : assets](https://github.com/MC322-java/ProjetoFinal/tree/main/POO/POO/assets) 



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


# Diagramas

## Diagrama Geral da Arquitetura do Jogo

![Arquitetra2](https://user-images.githubusercontent.com/82724293/177400910-825c3263-94c1-4b4b-a67a-db3a79aa9345.png)



## Relatório de Evolução

# Evolução e Difuculdades enfrentadas.

   Para o projeto, inicialmente idealizamos apenas fazer a tela de jogo com os status do persoagem, onde o tabuleiro seria uma imagem que geramos em um site e o personagem seria apenas um quadrado no mapa. Entretanto, ao estudar mais a fundo o workframe que utiliziaríamos, o LibGDX, conseguimos ter mais noção do que conseguiríamos fazer, assim aumentando a complexidade do que tínhamos planejado, deixando o projeto mais detalhado e polído em sua versão final.
   
   Com isso, a partir de softwares gráficos como GIMP, pode-se criar uma interface melhor, com texturas para o labirinto e adicionando um inventário para o personagem,além de que, possibilitou colocar uma imagem para cada personagem. No projeto inicial, idealizamos o personagem com Mana, que caso acabasse o personagem não conseguiria mais atacar, porém revogamos essa ideia, pois a dificuldade principal do jogo seria baseada na sorte nos dados nas batalhas contra os Dragões e não na gestão de mana que o personagem tem que ter. Com isso, substituímos essa Mana com a possibilidade do Dano e do Alcance do ataque variar dependendo da sorte nos baús (Comparação feita na Imagem 1).
   
   A partir do estudo das telas do LibGDX, pode-se fazer uma sequência de telas, com uma tela de inicio e fim de jogo, e uma de seleção de personagem,que abre uma aba com os status iniciais deles, podendo em todas elas fechar e voltar a tela de início novamente (Imagem 2).

 * Imagem 1
![Evolução](https://user-images.githubusercontent.com/82724293/177206724-49e7c51b-150c-431a-9876-c518f3bf3d35.png)

 * Imagem 2
![Telas](https://user-images.githubusercontent.com/82724293/177350998-4f291cad-0e28-42f4-831d-fb8490baec66.png)


# Lições e Melhorias

Como lição aprendida destacou-se a importância de uma organização bem fundamenteada. Como o projeto foi iniciado sem uma arquitetura totalmente definida, tinhamos apenas as ideias e alguns diagramas feitos. Com isso, tivemos dificulade na hora criar as classes e suas relações e deixar o código simples de ser seguido e organizado. Uma vez que, ao decidirmos utilizar uma Arquitetura Model-View-Controller, queriamos respeitar as comunicações entre eles, o que, necessitava uma grande organização provisória.

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

Utilizou-se uma classe abstrata Personagem que herda de Componente, e nessa classe apresenta dois métodos abstratos que serão sobrescritos pelas classes Mago, Guerreiro, Barbaro e Arqueiro que são possíveis personagens para se jogar. Tendo em vista que a forma como eles atacam variam e a área do seus ataques também variam, foi de suma importancia esse Polimorfismo para a execução do Ataque deles.

## Diagrama de Classes usada no destaque OO:

![Classes](https://user-images.githubusercontent.com/82724293/177408125-e13a8597-cfa0-4fee-9cf0-746fe2da46cb.jpg)


## Código do Destaque OO
~~~java
public class Componente {
	protected int linha, coluna;
	...
}
~~~
~~~java
public abstract class Personagem extends Componente {
	protected Texture imgDireita, imgEsquerda;
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



# Destaques de Pattern
> Destaque de patterns adotados pela equipe. Sugestão de estrutura:

## Diagrama do Pattern
> Diagrama do pattern dentro do contexto da aplicação.

## Código do Pattern
~~~java
// Recorte do código do pattern seguindo as mesmas diretrizes de outros destaques
public void algoInteressante(…) {
   …
   trechoInteressante = 100;
}
~~~

> Explicação de como o pattern foi adotado e quais suas vantagens, referenciando o diagrama.

# Conclusões e Trabalhos Futuros

> Apresente aqui as conclusões do projeto e propostas de trabalho futuro. Esta é a oportunidade em que você pode indicar melhorias no projeto a partir de lições aprendidas e conhecimentos adquiridos durante a realização do projeto, mas que não puderam ser implementadas por questões de tempo. Por exemplo, há design patterns aprendidos no final do curso que provavelmente não puderam ser implementados no jogo -- este é o espaço onde você pode apresentar como aplicaria o pattern no futuro para melhorar o jogo.

# Documentação dos Componentes

O vídeo a seguir apresenta um detalhamento de um projeto baseado em componentes:

[![Projeto baseado em Componentes](http://img.youtube.com/vi/1LcSghlin6o/0.jpg)](https://youtu.be/1LcSghlin6o)

# Diagramas

## Diagrama Geral da Arquitetura do Jogo

> Apresente um diagrama geral da arquitetura do jogo. O formato é livre. A escolha de um ou mais estilos arquiteturais será considerado um diferencial.

> Faça uma breve descrição do diagrama.

## Diagrama Geral de Componentes

> Se você adotou componentes de software, apresente a documentação de componentes conforme o modelo.

### Exemplo 1

Este é o diagrama compondo componentes para análise:

![Diagrama Analise](diagrama-componentes-analise.png)

### Exemplo 2

Este é um diagrama inicial do projeto de jogos:

![Diagrama Jogos](diagrama-componentes-jogos.png)

### Exemplo 3

Este é outro diagrama de um projeto de vendas:

![Diagrama Vendas](diagrama-componentes-vendas.png)

Para cada componente será apresentado um documento conforme o modelo a seguir:

## Componente `<Nome do Componente>`

> Resumo do papel do componente e serviços que ele oferece.

![Componente](diagrama-componente.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `<caminho completo da classe com pacotes>` <br> Exemplo: `pt.c08componentes.s20catalog.s10ds.DataSetComponent`
Autores | `<nome dos membros que criaram o componente>`
Interfaces | `<listagem das interfaces do componente>`

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](diagrama-interfaces.png)

Interface agregadora do componente em Java:

~~~java
public interface IDataSet extends ITableProducer, IDataSetProperties {
}
~~~

## Detalhamento das Interfaces

### Interface `<nome da interface>`

`<Resumo do papel da interface.>`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`

## Exemplo:

### Interface `ITableProducer`

Interface provida por qualquer fonte de dados que os forneça na forma de uma tabela.

~~~java
public interface ITableProducer {
  String[] requestAttributes();
  String[][] requestInstances();
}
~~~

Método | Objetivo
-------| --------
`requestAttributes` | Retorna um vetor com o nome de todos os atributos (colunas) da tabela.
`requestInstances` | Retorna uma matriz em que cada linha representa uma instância e cada coluna o valor do respectivo atributo (a ordem dos atributos é a mesma daquela fornecida por `requestAttributes`.

### Interface `IDataSetProperties`

Define o recurso (usualmente o caminho para um arquivo em disco) que é a fonte de dados.

~~~java
public interface IDataSetProperties {
  public String getDataSource();
  public void setDataSource(String dataSource);
}
~~~

Método | Objetivo
-------| --------
`getDataSource` | Retorna o caminho da fonte de dados.
`setDataSource` | Define o caminho da fonte de dados, informado através do parâmetro `dataSource`.


