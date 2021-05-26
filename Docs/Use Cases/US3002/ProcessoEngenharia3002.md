# Solicitar serviço
=======================================


# 1. Requisitos

**Demo1**
Como utilizador, eu pretendo solicitar um serviço do catálogo de serviços que me é disponibilizado.

- Demo1.1. Pretendo iniciar a solicitação de um serviço mas deixá-lo inacabado, de modo a proceder à solicitação do mesmo mais tarde.

- Demo1.2. Pretendo finalizar a solicitação de um serviço já iniciado.

A interpretação feita deste requisito foi no sentido de criar uma forma de carregar para a base de dados a informação dos pedidos, de modo a que estes possam ficar inacabados e completos mais tarde.

# 2. Análise

Para esta funcionalidade vão ser apresentados os serviços a que o colaborador tem acesso para que depois este possa escolher um para realizar um pedido.

# 3. Design

A forma encontrada para resolver este problema foi criar uma classe AdicionarPedidoUI que faz uso do AdicionarPedidoController para iniciar um pedido relativo a um serviço a que o utilizador tenha acesso.

## 3.1. Realização da Funcionalidade

![ContinuarServico](AdicionarPedidoSD.jpg)

## 3.2. Diagrama de Classes

![AdicionarPedido](AdicionarPedidoCD.jpg)

## 3.3. Padrões Aplicados

*Nesta secção deve apresentar e explicar quais e como foram os padrões de design aplicados e as melhores práticas.*

## 3.4. Testes 
*Nesta secção deve sistematizar como os testes foram concebidos para permitir uma correta aferição da satisfação dos requisitos.*

**Teste 1:** Verificar que se pode deixar um pedido em modo rascunho (inacabado).

	@Test
    public void pedidoInacabado(){

        Rascunho instance=new Rascunho(null,null,1,1);

        Assert.assertEquals(instance.obterEstado(),0);

    }

# 4. Implementação

O utilizador escolhe um serviço para solicitar, depois são pedidos alguns dados e, por sua vez, é necessário que responda a um formulário relativamente à solicitação do mesmo.

# 5. Integração/Demonstração

Esta US depende de muitas outras, pois está relacionada com colaboradores, serviços, formularios e ainda outras.

# 6. Observações

Nada a declarar.
