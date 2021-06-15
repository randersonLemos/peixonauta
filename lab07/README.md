# Projeto Corridinha da Massa

# Descrição Resumida do Projeto/Jogo
Corrida da massa é um jogo de corrida em que o jogador personifica um piloto que
participa de uma competição de corrida com obstáculos. Mas essa não é uma 
corrida normal, pois a vida do piloto depende dele completar o circuito 
que é imprevisível e cheio de perigos. O circuito há obstáculos, sendo alguns 
apenas muros intransponíveis enquanto outros labaredas de fogo mortais.
Há também, no ciruito, porções mágicas que dotam o carro de habilidades
especiais e que podem ser essenciais para a sobrevivência do piloto.

![Capa](assets/capa.png)

# Equipe Peixonauta
Pablo Areia Delgado. R.: 223037

Randerson Araújo de Lemos. RA.: 103897

# Vídeos do Projeto
## Vídeo da Prévia
[vídeo](https://www.youtube.com/watch?v=wtWPpYuzdb8)

# Slides dos Projeto
## Slides da Prévia
[apresentação](./assets)


# Documentação
## Diagramas
### Diagrama Geral do Projeto

![Arquitetura](assets/arquitetura.png)

## Diagrama Geral dos Componentes

## Componente `Painel`

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `<caminho completo da classe com pacotes>`
Autores | `<Pablo e Randerson>`
Interfaces | IPainelConstrutor <br> IPainelControle <br> IRCircuitoPainel <br> IRPilotoPainel

~~~java
public interface IPainel extends 
  IPainelConstrutor
, IPainelControle
, IRCircuitoPainel
, IRPilotoPainel
{
}
~~~
## Componente `Elemento`

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `<caminho completo da classe com pacotes>`
Autores | `<Pablo e Randerson>`
Interfaces |  IPilotoControle <br> IPilotoConstrutor <br> IPilotoPainel <br> IRCircuitoPiloto

~~~java
public interface IPiloto extends
  IPilotoControle
, IPilotoConstrutor
, IPilotoPainel
, IRCircuitoPiloto
{
}
~~~
## Componente `Circuito`

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `<caminho completo da classe com pacotes>`
Autores | `<Pablo e Randerson>`
Interfaces | ICircuitoContrutor <br> ICircuitoControle <br> ICircuitoPainel <br>  ICircuitoPiloto

~~~java
public interface ICircuito extends 
  ICircuitoConstrutor
, ICircuitoControle
, ICircuitoPainel
, ICircuitoPiloto{
}
~~~
## Componente `Controle`

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `<caminho completo da classe com pacotes>`
Autores | `<Pablo e Randerson>`
Interfaces | IControleConstrutor <br> IRCircuitoControle <br> IRPilotoControle <br> IRPainelControle

~~~java
public interface IControle extends 
  IControleConstrutor 
, IRCircuitoControle
, IRPilotoControle
, IRPainelControle 
{
	public void comecarJogo();
}
~~~
## Componente `Construtor`

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `<caminho completo da classe com pacotes>`
Autores | `<Pablo e Randerson>`
Interfaces | IRCircuitoConstrutor <br> IRControleConstrutor <br> IRPilotoConstrutor <br> IRPainelConstrutor

~~~java
public interface IConstrutor extends 
  IRCircuitoConstrutor
, IRControleConstrutor
, IRPilotoConstrutor
, IRPainelConstrutor
{
	public void construir(int maxLin, int maxCol);
}
~~~
## Detalhamento das Interfaces

### Interface `IControleConstrutor`
### Interface `ICircuitoContrutor`
### Interface `ICircuitoControle`
### Interface `ICircuitoPainel`
### Interface `ICircuitoPiloto`
### Interface `IPilotoConstrutor`
### Interface `IPilotoControle`
### Interface `IPilotoPainel`
### Interface `IPainelConstrutor`
### Interface `IPainelControle`

## Plano de Exceções
