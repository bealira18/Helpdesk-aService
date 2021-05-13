# Continuar/completar a especificação em curso de um serviço.
=======================================


# 1. Requisitos

**Demo1** 
Como GSH, eu pretendo continuar/completar a especificação em curso de um serviço.

A interpretação feita deste requisito foi no sentido de criar uma forma de completar a especificação de um serviço já iniciado, fazendo com que o mesmo só fique disponível depois de ter todos os campos devidamente preenchidos.

# 2. Análise

Com o intuito de facilitar e ajudar o colaborador são mostrados todos os serviços inacabados para que ele possa escolher aquele a que pretende acrescentar informação, ou até mesmo acabá-lo.

# 3. Design

A forma encontrada para resolver este problema foi criar uma classe ContinuarServicoUI que faz uso do EditarServicoController para acabar ou apenas adicionar informação a um serviço que ainda não está completo.

## 3.1. Realização da Funcionalidade

![ContinuarServico](ContinuarServicoSD.jpg)

## 3.2. Diagrama de Classes

![ContinuarServico](ContinuarServicoCD.jpg)

## 3.4. Testes 
*Nesta secção deve sistematizar como os testes foram concebidos para permitir uma correta aferição da satisfação dos requisitos.*

**Teste 1:** Verificar que é possível deixar um serviço inacabado.

	@Test
    public void servicoInacabado(){

        Servico instance=new Servico("titulo", "", "", "exemplo", "tituloExemplo.jpg");

        Assert.assertFalse(instance.estaAtivo());

    }

# 4. Implementação

Nada a declarar.

# 5. Integração/Demonstração

Esta funcionalidade só dependia de uma implementada no sprint anterior, portanto, foi facilmente desenvolvida.

# 6. Observações

Nada a declarar.


