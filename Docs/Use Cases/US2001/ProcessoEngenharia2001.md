# Adicionar Catalogo
=======================================


# 1. Requisitos

**Demo1**
Como Gestor de Serviços de Help desk (GSH), eu pretendo criar um novo catálogo de serviços.

Demo1.1. Adicionar catálogo

Demo1.2. Editar catálogo

Demo1.3. Remover catálogo

A interpretação feita deste requisito foi no sentido de criar uma forma de carregar para a base de dados a informação dos catálogos. Para além disso, também é possível editar os seus dados e remover um catálogo, bem como consultar a informação sempre que necessário.

# 2. Análise

*Neste secção a equipa deve relatar o estudo/análise/comparação que fez com o intuito de tomar as melhores opções de design para a funcionalidade bem como aplicar diagramas/artefactos de análise adequados.*

*Recomenda-se que organize este conteúdo por subsecções.*

# 3. Design

A forma encontrada para resolver este problema foi criar uma classe AdicionarCatalogoUI que faz uso do AdicionarCatalogoController para criar instâncias de forma a garantir as regras de negócio dadas pelo cliente.

## 3.1. Realização da Funcionalidade

![AdicionarCatalogoSD](AdicionarCatalogoSD.jpg)

## 3.2. Diagrama de Classes

![AdicionarCatalogoCD](AdicionarCatalogoCD.jpg)

## 3.4. Testes 
*Nesta secção deve sistematizar como os testes foram concebidos para permitir uma correta aferição da satisfação dos requisitos.*

**Teste 1:** Verificar que não é possível criar uma instância da classe Catalogo com todos os valores nulos.

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Catalogo instance = new Catalogo(null,null,null,0,null);
	}

**Teste 2:** Verificar que não é possível criar uma instância da classe Catalogo com nenhum valor nulo.

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Catalogo instance=new Catalogo("idk","descricaoBreve",null,8,"icone.jpg");
	}

# 4. Implementação

Nada a declarar.

# 5. Integração/Demonstração

Sendo esta uma das funcionalidades com mais prioridade foi das primeiras a ser desenvolvida para que se possa dar seguimento às restantes.

# 6. Observações

Nada a observar.



