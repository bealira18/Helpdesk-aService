/*
 * Copyright (c) 2013-2019 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.app.backoffice.console.presentation;

import eapli.base.Application;
import eapli.base.ClientServer.HTTPServerAjax;
import eapli.base.ClientServer.ThreadClient;
import eapli.base.ClientServer.ThreadServer;
import eapli.base.app.backoffice.console.presentation.authz.AddUserUI;
import eapli.base.app.backoffice.console.presentation.authz.DeactivateUserAction;
import eapli.base.app.backoffice.console.presentation.authz.ListUsersAction;
import eapli.base.app.backoffice.console.presentation.catalogo.AddCatalogoAction;
import eapli.base.app.backoffice.console.presentation.catalogo.AssociarEquipaACatalogoAction;
import eapli.base.app.backoffice.console.presentation.catalogo.ListarCatalogoAction;
import eapli.base.app.backoffice.console.presentation.catalogo.PesquisarCatalogoAction;
import eapli.base.app.backoffice.console.presentation.clientuser.AcceptRefuseSignupRequestAction;
import eapli.base.app.backoffice.console.presentation.colaborador.*;
import eapli.base.app.backoffice.console.presentation.equipa.*;
import eapli.base.app.backoffice.console.presentation.pedido.AddPedidoAction;
import eapli.base.app.backoffice.console.presentation.pedido.CumprimentoSLAAction;
import eapli.base.app.backoffice.console.presentation.pedido.DarFeedbackAction;
import eapli.base.app.backoffice.console.presentation.pedido.PedidosColaboradorAction;
import eapli.base.app.backoffice.console.presentation.servico.*;
import eapli.base.app.backoffice.console.presentation.tarefa.ConsultarTarefaAction;
import eapli.base.app.backoffice.console.presentation.tarefa.ExecutarTarefaManualAction;
import eapli.base.app.backoffice.console.presentation.tarefa.ReivindicarTarefaAction;
import eapli.base.app.backoffice.console.presentation.tipoEquipa.AddTipoEquipaAction;
import eapli.base.app.backoffice.console.presentation.tipoEquipa.ListarTipoEquipaAction;
import eapli.base.app.backoffice.console.presentation.tipoEquipa.PesquisarTipoEquipaAction;
import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.tarefamanagement.domain.ThreadPrincipal;
import eapli.base.tarefamanagement.domain.ThreadPrincipalAutomatica;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.ShowMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

import static java.lang.Thread.sleep;

/**
 * TODO split this class in more specialized classes for each menu
 *
 * @author Paulo Gandra Sousa
 */
public class MainMenu extends AbstractUI {

    private static final String RETURN_LABEL = "Return ";

    private static final int EXIT_OPTION = 0;

    // USERS
    private static final int ADD_USER_OPTION = 1;
    private static final int LIST_USERS_OPTION = 2;
    private static final int DEACTIVATE_USER_OPTION = 3;
    private static final int ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION = 4;

    // SETTINGS
    private static final int SET_KITCHEN_ALERT_LIMIT_OPTION = 1;

    //Colaboradores
    private static final int ADICIONAR_COLABORADOR_OPTION = 1;
    private static final int LISTAR_COLABORADORES_OPTION = 2;
    private static final int PESQUISAR_COLABORADOR_OPTION = 3;
    private static final int ASSOCIAR_COLABORADOR_A_EQUIPA_OPTION = 4; //RRH
    private static final int LISTAR_CATALOGOS_SERVICOS = 5;  //COLAB
    private static final int EDITAR_COLABORADOR_OPTION = 6;
    private static final int DESATIVAR_COLABORADOR_OPTION = 7;

    //Catalogos
    private static final int ADICIONAR_CATALOGO_OPTION = 1;
    private static final int LISTAR_CATALOGO_OPTION = 2;
    private static final int PESQUISAR_CATALOGO_OPTION = 3;
    private static final int ASSOCIAR_CATALOGO_A_EQUIPA_OPTION = 4; //GSH
    private static final int EDITAR_CATALOGO_OPTION = 5;
    private static final int DESATIVAR_CATALOGO_OPTION = 6;

    //Servi??os
    private static final int ADICIONAR_SERVICO_OPTION = 1;
    private static final int LISTAR_SERVICO_OPTION = 2;
    private static final int PESQUISAR_SERVICO_OPTION = 3;
    private static final int ASSOCIAR_SERVICO_A_CATALOGO_OPTION = 4;
    private static final int ACABAR_SERVICO_OPTION = 5;
    private static final int LISTAR_SERVICOS_CATALOGO = 6;
    private static final int ADICIONAR_ATRIBUTO_A_FORMULARIO = 7; //GSH
    private static final int ATIVAR_FORMULARIO = 8; //GSH
    private static final int EDITAR_SERVICO_OPTION = 9;
    private static final int DESATIVAR_SERVICO_OPTION = 10;

    //Equipa
    private static final int ADICIONAR_EQUIPA_OPTION = 1;
    private static final int LISTAR_EQUIPA_OPTION = 2;
    private static final int PESQUISAR_EQUIPA_OPTION = 3;
    private static final int ADICIONAR_COLABORADOR_A_EQUIPA_OPTION = 4;
    private static final int ASSOCIAR_TIPOEQUIPA_A_EQUIPA_OPTION = 5;
    private static final int LISTAR_COLABORADORES_DE_EQUIPA_OPTION = 6;
    private static final int EDITAR_EQUIPA_OPTION = 7;
    private static final int DESATIVAR_EQUIPA_OPTION = 8;

    //Tipo de Equipa
    private static final int ADICIONAR_TIPOEQUIPA_OPTION = 1;
    private static final int LISTAR_TIPOEQUIPA_OPTION = 2;
    private static final int PESQUISAR_TIPOEQUIPA_OPTION = 3;
    private static final int EDITAR_TIPOEQUIPA_OPTION = 4;
    private static final int DESATIVAR_TIPOEQUIPA_OPTION = 5;

    //Tarefa
    private static final int REIVINDICAR_TAREFA_MANUAL = 1; //COLAB
    private static final int CONSULTAR_MINHAS_TAREFAS = 2; //COLAB
    private static final int CRIAR_TAREFA_MANUAL = 3;
    private static final int EXECUTAR_TAREFA_MANUAL = 4; //COLAB

    //Pedido
    private static final int ADD_PEDIDO = 1;
    private static final int DAR_FEEDBACK = 2;
    private static final int PEDIDOS_COLABORADOR = 3;
    private static final int SLA = 4;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int USERS_OPTION = 2;
    private static final int SETTINGS_OPTION = 3;
    private static final int COLABORADORES_OPTION = 4;
    private static final int CATALOGOS_OPTION = 5;
    private static final int SERVICOS_OPTION = 6;
    private static final int EQUIPA_OPTION = 7;
    private static final int TIPOEQUIPA_OPTION = 8;
    private static final int TAREFA_OPTION = 9;
    private static final int PEDIDO_OPTION = 10;

    private static final String SEPARATOR_LABEL = "--------------";

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    /**
     * @return true if the user selected the exit option
     */
    @Override
    public boolean doShow() {
        final Menu menu;
        try {
            menu = buildMainMenu();
            final MenuRenderer renderer;
            if (Application.settings().isMenuLayoutHorizontal()) {
                renderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
            } else {
                renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
            }
            return renderer.render();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public String headline() {

        return authz.session().map(s -> "Base [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("Base [ ==Anonymous== ]");
    }

    int cont = 0;

    private Menu buildMainMenu() throws Exception {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu();
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER)) {

            ThreadPrincipal tp = new ThreadPrincipal();
            tp.start();
            ThreadPrincipalAutomatica tpa = new ThreadPrincipalAutomatica();
            tpa.start();


            final Menu usersMenu = buildUsersMenu();
            mainMenu.addSubMenu(USERS_OPTION, usersMenu);
            final Menu settingsMenu = buildAdminSettingsMenu();
            mainMenu.addSubMenu(SETTINGS_OPTION, settingsMenu);
            final Menu colaboradoresMenu = buildColaboradoresMenu();
            mainMenu.addSubMenu(COLABORADORES_OPTION, colaboradoresMenu);
            final Menu catalogosMenu = buildCatalogoMenu();
            mainMenu.addSubMenu(CATALOGOS_OPTION, catalogosMenu);
            final Menu servicosMenu = buildServicoMenu();
            mainMenu.addSubMenu(SERVICOS_OPTION, servicosMenu);
            final Menu equipasMenu = buildEquipasMenu();
            mainMenu.addSubMenu(EQUIPA_OPTION, equipasMenu);
            final Menu tiposEquipaMenu = buildTipoEquipaMenu();
            mainMenu.addSubMenu(TIPOEQUIPA_OPTION, tiposEquipaMenu);
            final Menu tarefasMenu = buildTarefasMenu();
            mainMenu.addSubMenu(TAREFA_OPTION, tarefasMenu);
            final Menu pedidoMenu = buildPedidoMenu();
            mainMenu.addSubMenu(PEDIDO_OPTION, pedidoMenu);
        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.ADMIN)) {
            final Menu usersMenu = buildUsersMenu();
            mainMenu.addSubMenu(2, usersMenu);
            final Menu settingsMenu = buildAdminSettingsMenu();
            mainMenu.addSubMenu(3, settingsMenu);
        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.RRH)) {
            final Menu colaboradoresMenu = buildColaboradoresParaRRHMenu();
            mainMenu.addSubMenu(2, colaboradoresMenu);

            final Menu equipasMenu = buildEquipasMenu();
            mainMenu.addSubMenu(3, equipasMenu);

            final Menu tipoEquipaMenu = buildTipoEquipaMenu();
            mainMenu.addSubMenu(4, tipoEquipaMenu);
        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.GSH)) {

            final Menu catalogosMenu = buildCatalogoMenu();
            mainMenu.addSubMenu(2, catalogosMenu);

            final Menu servicosMenu = buildServicoMenu();
            mainMenu.addSubMenu(3, servicosMenu);
        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.COLABORADOR)) {

            ThreadPrincipal tp = new ThreadPrincipal();
            tp.start();
            ThreadPrincipalAutomatica tpa = new ThreadPrincipalAutomatica();
            tpa.start();

            if (cont == 0) {
                Runtime.getRuntime().exec(new String[]{"cmd", "/c", "start chrome http://localhost:8080"});
                ThreadServer t1 = new ThreadServer();
                t1.start();
                sleep(5000);
                ThreadClient t2 = new ThreadClient(1, 0);
                t2.start();
                cont++;
            }

            final Menu tarefasMenu = buildTarefasMenu();
            mainMenu.addSubMenu(2, tarefasMenu);

            final Menu catalogosEServicosMenu = buildCatalogosEServicosMenuParaColaborador();
            mainMenu.addSubMenu(3, catalogosEServicosMenu);

            final Menu pedidosMenu=buildPedidoMenu();
            mainMenu.addSubMenu(4,pedidosMenu);
        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildAdminSettingsMenu() {
        final Menu menu = new Menu("Settings >");

        menu.addItem(SET_KITCHEN_ALERT_LIMIT_OPTION, "Set kitchen alert limit",
                new ShowMessageAction("Not implemented yet"));
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildUsersMenu() {
        final Menu menu = new Menu("Users >");

        menu.addItem(ADD_USER_OPTION, "Add User", new AddUserUI()::show);
        menu.addItem(LIST_USERS_OPTION, "List all Users", new ListUsersAction());
        menu.addItem(DEACTIVATE_USER_OPTION, "Deactivate User", new DeactivateUserAction());
        menu.addItem(ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION, "Accept/Refuse Signup Request",
                new AcceptRefuseSignupRequestAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildColaboradoresMenu() {
        final Menu menu = new Menu("Colaboradores >");

        menu.addItem(ADICIONAR_COLABORADOR_OPTION, "Adicionar colaborador", new AddColaboradorAction());
        menu.addItem(LISTAR_COLABORADORES_OPTION, "Listar colaboradores", new ListarColaboradorAction());
        menu.addItem(PESQUISAR_COLABORADOR_OPTION, "Pesquisar colaborador por numero", new PesquisarColaboradorAction());
        menu.addItem(ASSOCIAR_COLABORADOR_A_EQUIPA_OPTION, "Associar colaborador a equipa", new AssociarColaboradorAEquipaAction());
        menu.addItem(LISTAR_CATALOGOS_SERVICOS, "Listar catalogo e servi??os a que um utilizador tem acesso", new ListarCatalogosEServicoAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildEquipasMenu() {
        final Menu menu = new Menu("Equipas >");

        menu.addItem(ADICIONAR_EQUIPA_OPTION, "Adicionar equipa", new AddEquipaAction());
        menu.addItem(LISTAR_EQUIPA_OPTION, "Listar equipas", new ListarEquipaAction());
        menu.addItem(PESQUISAR_EQUIPA_OPTION, "Pesquisar equipa por acronimo", new PesquisarEquipaAction());
        menu.addItem(ADICIONAR_COLABORADOR_A_EQUIPA_OPTION, "Associar colaborador a equipa", new AssociarColaboradorAEquipaAction());
        menu.addItem(ASSOCIAR_TIPOEQUIPA_A_EQUIPA_OPTION, "Associar tipo de equipa a equipa", new AssociarTipoEquipaAEquipaAction());
        menu.addItem(LISTAR_COLABORADORES_DE_EQUIPA_OPTION, "Listar colaboradores de uma equipa", new ListarColaboradoresDeEquipaAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildTipoEquipaMenu() {
        final Menu menu = new Menu("Tipos de Equipa >");

        menu.addItem(ADICIONAR_TIPOEQUIPA_OPTION, "Adicionar tipo de equipa", new AddTipoEquipaAction());
        menu.addItem(LISTAR_TIPOEQUIPA_OPTION, "Listar tipos de equipa", new ListarTipoEquipaAction());
        menu.addItem(PESQUISAR_TIPOEQUIPA_OPTION, "Pesquisar tipo de equipa por nome", new PesquisarTipoEquipaAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildCatalogoMenu() {
        final Menu menu = new Menu("Catalogos >");

        menu.addItem(ADICIONAR_CATALOGO_OPTION, "Adicionar catalogo", new AddCatalogoAction());
        menu.addItem(LISTAR_CATALOGO_OPTION, "Listar catalogos", new ListarCatalogoAction());
        menu.addItem(PESQUISAR_CATALOGO_OPTION, "Pesquisar catalogo por titulo", new PesquisarCatalogoAction());
        menu.addItem(ASSOCIAR_CATALOGO_A_EQUIPA_OPTION, "Associar equipa a catalogo", new AssociarEquipaACatalogoAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildServicoMenu() {
        final Menu menu = new Menu("servi??os >");

        menu.addItem(ADICIONAR_SERVICO_OPTION, "Adicionar servi??o", new AddServicoAction());
        menu.addItem(LISTAR_SERVICO_OPTION, "Listar servi??os ativos", new ListarServicoAction());
        menu.addItem(PESQUISAR_SERVICO_OPTION, "Pesquisar servi??o por codigo", new PesquisarServicoAction());
        menu.addItem(ASSOCIAR_SERVICO_A_CATALOGO_OPTION, "Associar servi??o a catalogo", new AssociarServicoACatalogoAction());
        menu.addItem(ACABAR_SERVICO_OPTION, "Acabar servi??o", new ContinuarServicoAction());
        menu.addItem(LISTAR_SERVICOS_CATALOGO, "Listar servi??os de um catalogo", new ListarServicosDeCatalogoAction());
        menu.addItem(ADICIONAR_ATRIBUTO_A_FORMULARIO, "Adicionar atributo a formul??rio de um servi??o", new AddAtributoAFormularioAction());
        menu.addItem(ATIVAR_FORMULARIO, "Ativar formulario de um servi??o", new AtivarFormularioServicoAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildTarefasMenu() {
        final Menu menu = new Menu("Tarefas >");


        // menu.addItem(CRIAR_TAREFA_MANUAL, "Criar Tarefa Manual", new CriarTarefaAction());
        menu.addItem(REIVINDICAR_TAREFA_MANUAL, "Reivindicar Tarefa", new ReivindicarTarefaAction());
        menu.addItem(CONSULTAR_MINHAS_TAREFAS, "Consultar Minhas Tarefas", new ConsultarTarefaAction());
        menu.addItem(EXECUTAR_TAREFA_MANUAL, "Executar Tarefa Manual", new ExecutarTarefaManualAction());

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildPedidoMenu() {
        final Menu menu = new Menu("Pedido >");
        menu.addItem(ADD_PEDIDO, "Fazer um pedido", new AddPedidoAction());

        menu.addItem(DAR_FEEDBACK, "Dar feedback", new DarFeedbackAction());

        menu.addItem(PEDIDOS_COLABORADOR,"Pedidos de Colaborador",new PedidosColaboradorAction());

        menu.addItem(SLA,"Cumprimento SLA",new CumprimentoSLAAction());

        return menu;
    }

    private Menu buildColaboradoresParaRRHMenu() {

        final Menu menu = new Menu("Colaboradores >");

        menu.addItem(ADICIONAR_COLABORADOR_OPTION, "Adicionar colaborador", new AddColaboradorAction());
        menu.addItem(LISTAR_COLABORADORES_OPTION, "Listar colaboradores", new ListarColaboradorAction());
        menu.addItem(PESQUISAR_COLABORADOR_OPTION, "Pesquisar colaborador por numero", new PesquisarColaboradorAction());
        menu.addItem(ASSOCIAR_COLABORADOR_A_EQUIPA_OPTION, "Associar colaborador a equipa", new AssociarColaboradorAEquipaAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildCatalogosEServicosMenuParaColaborador() {
        final Menu menu = new Menu("Cat??logos/Servi??os >");

        menu.addItem(1, "Listar Cat??logos e Respetivos Servi??os dispon??veis", new ListarCatalogosEServicoAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

}
