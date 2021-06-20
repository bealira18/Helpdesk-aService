package eapli.base.ClientServer;

import eapli.base.catalogomanagement.application.ListarCatálogosEServicosController;
import eapli.base.colaboradormanagement.application.ColaboradorComUserController;
import eapli.base.colaboradormanagement.application.ListarColaboradoresController;
import eapli.base.colaboradormanagement.application.PesquisarColaboradorController;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.domain.ThreadTarefa;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;

import java.util.List;

public class ThreadServer extends Thread {


    public void run() {
        MotorFluxoAtividades server = new MotorFluxoAtividades();
        try {
            server.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}