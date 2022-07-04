# Projeto Final - Dungeons and Dragons

# Descrição 
   O porpósito do jogo é escapar da Dungeon vivo, mas no caminho, o jogador terá que encontrar as chaves correspondentes de cada porta e enfrentar Dragões que estaram impedindo sua passagem. O jogador pode escolher entre as classes : Mago, Guerreiro, Bárbaro e Arqueiro, cujos ataques e caraterísticas inicias variam. Com um mix de sorte e habilidade o jogador pode percorrer por várias Dungeons acumulando pontuação. 

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


![Arquitetra](https://user-images.githubusercontent.com/82724293/176232423-62e6bbbe-a8b0-4fa3-80f0-bb34f901c792.png)

## Relatório de Evolução

# Evolução e Difuculdades enfrentadas.
> Relatório de evolução, descrevendo as evoluções do design do projeto, dificuldades enfrentadas, mudanças de rumo, melhorias e lições aprendidas. Referências aos diagramas e recortes de mudanças são bem-vindos.

   Para o projeto, inicialmente idealizamos apenas fazer a tela de jogo com os status do persoagem, onde o tabuleiro seria uma imagem que geramos em um site e o personagem seria apenas um quadrado no mapa. Entretanto, ao estudar mais a fundo o workframe que utiliziaríamos, o LibGDX, conseguimos ter mais noção do que conseguiríamos fazer, assim aumentando a complexidade do que tínhamos planejado, deixando o projeto mais detalhado e polído em sua versão final.
   
   Com isso, a partir de softwares gráficos como GIMP, pode-se criar uma interface melhor, com texturas para o labirinto e adicionando um inventário para o personagem, assim como, possibilitou colocar uma imagem para cada personagem. (Comparação feita na Imagem 1 ).
   
   A partir do estudo das telas do LibGDX, pode-se fazer uma sequência de telas, com uma tela de inicio e fim de jogo, e uma de seleção de personagem, podendo em todas elas fechar e voltar a tela de início novamente.(Imagem 2)

 * Imagem 1
![Evolução](https://user-images.githubusercontent.com/82724293/177206724-49e7c51b-150c-431a-9876-c518f3bf3d35.png)

 * Imagem 2
![Telas](https://user-images.githubusercontent.com/82724293/177207102-0760c2a6-4c85-48bd-bdb4-7eeea85207e3.png)

# Lições e Melhorias

Como lição aprendida destacou-se a importância de uma organização bem fundamenteada. Como o projeto foi iniciado sem uma arquitetura totalmente definida, tinhamos apenas as ideias e alguns diagramas feitos. Com isso, tivemos dificulade na hora criar as classes e suas relações e deixar o código simples de ser seguido e organizado. Uma vez que, ao decidirmos utilizar uma Arquitetura Model-View-Controller, queriamos respeitar as comunicações entre eles, o que necessitava uma grande organização provisória.

Como melhorias, podemos destacar a implementação de mais "desing patterns", o que nos retornaria uma melhor organização e maior abstração do conjunto do projeto. Além de que, um estudo mais aprofundado sobre framework nos possibilitaria criar e colocar em prática ideais que vão surgindo ao decorrer do trabalho, como animar os atques, criar mais telas de jogo, por exemplo.
# Destaques de Código

> Escolha trechos relevantes e/ou de destaque do seu código. Apresente um recorte (você pode usar reticências para remover partes menos importantes). Veja como foi usado o highlight de Java para o código.

~~~java
// Recorte do seu código
public void algoInteressante(…) {
   …
   trechoInteressante = 100;
}
~~~

# Destaques de Orientação a Objetos
> Destaque partes do código em que a orientação a objetos foi aplicada para aprimorar seu código. Por exemplo, o uso de polimorfismo para ajustar ações conforme o contexto. Sugestão de estrutura:

## Diagrama de Classes usada no destaque OO:
> Sugere-se um diagrama de classes para o destaque, mas podem ser usados outros tipos de diagrama, conforme a necessidade.

## Código do Destaque OO
~~~java
// Recorte do código do pattern seguindo as mesmas diretrizes de outros destaques
public void algoInteressante(…) {
   …
   trechoInteressante = 100;
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

# Plano de Exceções

## Diagrama da hierarquia de exceções
> Elabore um diagrama com a hierarquia de exceções como detalhado a seguir.

![Hierarquia Exceções](exception-hierarchy.png)

## Descrição das classes de exceção

> Monte uma tabela descritiva seguindo o exemplo:

Classe | Descrição
----- | -----
DivisaoInvalida | Engloba todas as exceções de divisões não aceitas.
DivisaoInutil | Indica que a divisão por 1 é inútil.
DivisaoNaoInteira | Indica uma divisão não inteira.


