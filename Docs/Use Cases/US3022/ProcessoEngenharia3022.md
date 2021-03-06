# Consultar Tarefas Pendentes e Reivindicar Tarefas Pendentes
==============================================================


# 1. Requisitos

**Demo1** 
Como utilizador, eu pretendo consultar as tarefas pendentes que eu posso reivindicar para mim e, caso o deseje, concretize essa reivindicação.

Demo1.1. Consultar Tarefas Pendentes

Demo1.2. Reivindicar Tarefas Pendentes

A interpretação feita deste requisito foi no sentido de criar uma forma de consultar na base de dados a informação das Tarefas, principalmente das Tarefas Pendentes. Para além disso, também é possível reivindicar uma tarefa que esteja pendente inserindo o número do colaborador.

# 2. Análise

Enquanto é desenvolvido o programa é de interesse que não se tenha de inserir informação na base de dados de cada vez que o programa precisa ser testado. Sendo assim, faz-se bootstrap de Tarefas de forma a agilizar e a rentabilizar melhor o tempo da equipa no desenvolvimento do software.

# 3. Design

A forma encontrada para resolver este problema foi criar as classes ReivindicarTarefaUI e ConsultarTarefaUI que fazem uso dos controllers ReivindicarTarefaController e ConsultarTarefaController para criarem instâncias de forma a garantir as regras de negócio dadas pelo cliente.

## 3.1. Realização da Funcionalidade

![ConsultarTarefaPendente_SD](ConsultarTarefaPendente_SD.jpg)

![ReivindicarTarefaPendente_SD](ReivindicarTarefaPendente_SD.jpg)

## 3.2. Diagrama de Classes

![ConsultarTarefaPendente_CD](ConsultarTarefaPendente_CD.jpg)

![ReivindicarTarefaPendente_CD](ReivindicarTarefaPendente_CD.jpg)

## 3.4. Testes 

**Teste 1:** Verificar se o a reivindicação de uma Tarefa por parte do Colaborador.

@Test
    public void reivindicarTarefa() {

        SimpleDateFormat forma = new SimpleDateFormat("dd/MM/yyyy");
        Date d1 = new Date();
        Date d2 = new Date();
        try {
            d1 = forma.parse("24/02/2022");
            d2 = forma.parse("17/12/2003");

        } catch (ParseException e) {
            e.printStackTrace();
        }
        EstadoTarefa estado = null;
        TarefaManual tarefa = new TarefaManual(d1, 5, 3);
        Colaborador colaborador = new Colaborador(123, "Pedro", "Pedro Lapa", d2, "Paredes", true,
                "pedrolapa@gmail.com", "perfil", "funçao", "912345678");
        ReivindicarTarefaController reivTar = new ReivindicarTarefaController();
        Colaborador expected = reivTar.reivindicarTarefa(tarefa, colaborador);
        TarefaManual result = null;
        for (TarefaManual colab : colaborador.tarefas()) {
            if (colab.equals(tarefa)) {
                result = colab;
                break;
            }
        }
        assertEquals(tarefa, result);
    }

# 4. Implementação

Nada a declarar

# 5. Integração/Demonstração

Sendo esta a funcionalidade definida com grande prioridade, foi das primeiras a ser implementada.

# 6. Observações

Nada a observar



