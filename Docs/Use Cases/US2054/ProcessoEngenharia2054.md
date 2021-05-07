# Adicionar Tipo de Equipa
=======================================


# 1. Requisitos

**Demo1**
Como RRH, eu pretendo registar um novo tipo de equipa.

Demo1.1. Adicionar tipo de equipa

Demo1.2. Editar tipo de equipa

Demo1.3. Remover tipo de equipa

A interpretação feita deste requisito foi no sentido de criar uma forma de carregar para a base de dados a informação dos tipos de equipa. Para além disso, também é possível editar os seus dados e remover um tipo de equipa, bem como consultar a informação sempre que necessário.

# 2. Análise

Enquanto é desenvolvido o programa é de interesse que não se tenha de inserir informação na base de dados de cada vez que o programa precisa ser testado. Sendo assim, faz-se bootstrap de tipo de equipa de forma a agilizar e a rentabilizar melhor o tempo da equipa no desenvolvimento do software.

# 3. Design

A forma encontrada para resolver este problema foi criar uma classe AdicionarTipoEquipaUI que faz uso do AdicionarTipoEquipaController para criar instâncias de forma a garantir as regras de negócio dadas pelo cliente.

## 3.1. Realização da Funcionalidade

![AdicionarTipoEquipaSD](AdicionarTipoEquipaSD.jpg)

## 3.2. Diagrama de Classes

![AdicionarTipoEquipaCD](AdicionarTipoEquipaCD.jpg)

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



