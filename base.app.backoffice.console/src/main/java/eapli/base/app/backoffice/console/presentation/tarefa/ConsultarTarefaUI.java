package eapli.base.app.backoffice.console.presentation.tarefa;

import eapli.base.colaboradormanagement.application.ColaboradorComUserController;
import eapli.base.colaboradormanagement.application.ListarColaboradoresController;
import eapli.base.colaboradormanagement.application.PesquisarColaboradorController;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipamanagement.application.PesquisarEquipaController;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.tarefamanagement.application.ConsultarTarefaController;
import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class ConsultarTarefaUI extends AbstractUI {

    private final ConsultarTarefaController controller = new ConsultarTarefaController();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ColaboradorComUserController colaboradorComUserController = new ColaboradorComUserController();
    private final ListarColaboradoresController controllercol = new ListarColaboradoresController();
    private final PesquisarColaboradorController controllerpesqcol = new PesquisarColaboradorController();

    @Override
    protected boolean doShow() {

        int numero = 0;

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.COLABORADOR)) {
            numero = colaboradorComUserController.resultColaborador().obterNumero().obterNumero();
        } else {
            //mostrar colaboradores
            Iterable<Colaborador> colaboradores = controllercol.listarColaboradores();

            for (Colaborador c : colaboradores) {
                System.out.println(c.obterNumero() + "\n");
            }

            //escolher colaborador

            numero = Console.readInteger("\nNumero pretendido: ");

            while (controllerpesqcol.procurarColaboradorNumero(numero) == null)
                numero = Console.readInteger("Titulo colaborador pretendido: ");
        }

        int op = Console.readInteger("\n1- Consultar por prioridade // 2- Consultar por data limite: ");

        while (op != 1 && op != 2)
            op = Console.readInteger("\n1- Consultar por prioridade // 2- Consultar por data limite: ");


        try {
            Iterable<InfoTarefa> infoTarefaIterable = controller.tarefasporcolab(numero);
            controller.infoMinhasTarefas(infoTarefaIterable, op, numero);

        } catch (Exception e) {
            e.printStackTrace();

        }

        return true;

    }

    @Override
    public String headline() {
        return "Listar Tarefas de um Colaborador";
    }

}
