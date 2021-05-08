# Listar Catálogos e Serviços
=======================================


# 1. Requisitos

**Demo1**
Como utilizador da aplicação, eu pretendo proceder à de todos os catálogos e, consequentemente, de todos os serviços que posso solicitar.

Demo1.1. Listar catálogos e serviços

A interpretação feita deste requisito foi no sentido de criar uma forma de pesquisar/consultar a informação dos catálogos e serviços disponíveis para solicitação para um determinado utilizador através da base de dados.

# 2. Análise

Enquanto é desenvolvido o programa é de interesse que não se tenha de inserir informação na base de dados de cada vez que o programa precisa ser testado. Sendo assim, faz-se bootstrap de colaboradores de forma a agilizar e a rentabilizar melhor o tempo da equipa no desenvolvimento do software.

# 3. Design

A forma encontrada para resolver este problema foi criar uma classe ListarCatalogosEServicosUI que faz uso do ListarCatalogosEServicosController para originar listas para apresentar aquando o pedido de consulta, de forma a garantir as regras de negócio dadas pelo cliente.

## 3.1. Realização da Funcionalidade

![ListarCatalogosEServicos_SD](ListarCatalogosEServicos_SD.jpg)

## 3.2. Diagrama de Classes

![ListarCatalogosEServicos_CD](ListarCatalogosEServicos_CD.jpg)

## 3.4. Testes 
*Nesta secção deve sistematizar como os testes foram concebidos para permitir uma correta aferição da satisfação dos requisitos.*

**Teste 1:** Verificar que não é possível criar uma instância da classe Exemplo com valores nulos.

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Exemplo instance = new Exemplo(null, null);
	}

# 4. Implementação

*Nesta secção a equipa deve providenciar, se necessário, algumas evidências de que a implementação está em conformidade com o design efetuado. Para além disso, deve mencionar/descrever a existência de outros ficheiros (e.g. de configuração) relevantes e destacar commits relevantes;*

*Recomenda-se que organize este conteúdo por subsecções.*

# 5. Integração/Demonstração

*Nesta secção a equipa deve descrever os esforços realizados no sentido de integrar a funcionalidade desenvolvida com as restantes funcionalidades do sistema.*

# 6. Observações

*Nesta secção sugere-se que a equipa apresente uma perspetiva critica sobre o trabalho desenvolvido apontando, por exemplo, outras alternativas e ou trabalhos futuros relacionados.*



