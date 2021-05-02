# Adicionar Colaborador
=======================================


# 1. Requisitos

**Demo1**
Como Responsável de Recursos Humanos (RRH), eu pretendo proceder à especificação de um novo colaborador de modo a que este possa, posteriormente, aceder e usar o sistema.

Demo1.1. Adicionar colaborador

Demo1.2. Editar colaborador

Demo1.3. Desativar colaborador

A interpretação feita deste requisito foi no sentido de criar uma forma de carregar para a base de dados a informação dos utilizadores. Para além disso, também é possível editar os seus dados e desativar um colaborador.

# 2. Análise

Enquanto é desenvolvido o programa é de interesse que não se tenha de inserir informação na base de dados de cada vez que o programa precisa ser testado. Sendo assim, faz-se bootstrap de colaboradores de forma a agilizar e a rentabilizar melhor o tempo da equipa no desenvolvimento do software.

# 3. Design

A forma encontrada para resolver este problema foi criar uma classe AdicionarColaboradorUI que faz uso do AdicionarColaboradorController para criar instâncias de forma a garantir as regras de negócio dadas pelo cliente.

## 3.1. Realização da Funcionalidade

![AdicionarColaborador_SD](AdicionarColaborador_SD.jpg)

## 3.2. Diagrama de Classes

![AdicionarColaborador_CD](AdicionarColaborador_CD.jpg)

## 3.4. Testes

**Teste 1:** Verificar que não é possível criar uma instância da classe Colaborador com todos os valores nulos.

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Colaborador instance = new Colaborador(0,null,null,null,null,false,null,null,null,null,null,0);
	}

**Teste 2:** Verificar que não é possível criar uma instância da classe Colaborador com nenhum valor nulos.

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Colaborador instance=new Colaborador(36,"Bea","Beatriz Lira",new Date(2001/05/18),"Gaia",true,"Ola56789",null,"idk","idk","idk",181823L);
	}

# 4. Implementação

Nada a declarar

# 5. Integração/Demonstração

Sendo esta a funcionalidade definida com máxima prioridade foi a primeira a ser implementada, para que, posteriormente, as outras funcionalidades se possam associar a esta.

# 6. Observações

Nada a observar


