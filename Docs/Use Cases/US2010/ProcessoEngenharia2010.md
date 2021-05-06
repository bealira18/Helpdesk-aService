# Definir Nivel de Criticidade
=======================================


# 1. Requisitos

**Demo1**
Como Gestor de Serviços de Help desk (GSH), eu pretendo proceder à definição de um novo nível de criticidade de modo a que este possa, posteriormente, caraterizar um catálogo, serviço ou tarefa

Demo1.1. Definir nivel de criticididade

A interpretação feita deste requisito foi no sentido de criar uma forma de carregar para a base de dados a informação dos níveis de criticidade. 

# 2. Análise

Enquanto é desenvolvido o programa é de interesse que não se tenha de inserir informação na base de dados de cada vez que o programa precisa ser testado. Sendo assim, faz-se bootstrap de níveis de criticidade de forma a agilizar e a rentabilizar melhor o tempo da equipa no desenvolvimento do software.

# 3. Design

A forma encontrada para resolver este problema foi criar uma classe AdicionarColaboradorUI que faz uso do AdicionarColaboradorController para criar instâncias de forma a garantir as regras de negócio dadas pelo cliente.

## 3.1. Realização da Funcionalidade

![AdicionarColaborador_SD](AdicionarColaborador_SD.jpg)

## 3.2. Diagrama de Classes

![AdicionarColaborador_CD](AdicionarColaborador_CD.jpg)

# 3. Design

A forma encontrada para resolver este problema foi criar uma classe DefinirNivelCriticidadeUI que faz uso do DefinirNivelCriticidadeController para criar instâncias de forma a garantir as regras de negócio dadas pelo cliente.

## 3.1. Realização da Funcionalidade

![DefinirNivelCriticidade_SD](DefinirNivelCriticidade_SD.jpg)

## 3.2. Diagrama de Classes

![DefinirNivelCriticidade_CD](DefinirNivelCriticidade_CD.jpg)

## 3.4. Testes 

**Teste 1:** Verificar que não é possível criar uma instância da classe NivelCriticidade com todos os valores nulos.

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		NivelCriticidade instance = new NivelCriticidade(null, 0, 0, 0, null);
	}

**Teste 2:** Verificar que não é possível criar uma instância da classe NivelCriticidade com nenhum valor nulo.

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		NivelCriticidade instance=new NivelCriticidade("qualquer coisa",25,35,5,null);
	}

# 4. Implementação

Nada a declarar

# 5. Integração/Demonstração

Sendo esta a funcionalidade definida com grande prioridade foi das primeiras a ser implementada, para que, posteriormente, as outras funcionalidades se possam associar a esta.

# 6. Observações

Nada a observar


