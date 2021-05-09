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
import eapli.base.app.backoffice.console.presentation.servico.*;
import eapli.base.app.backoffice.console.presentation.tipoEquipa.AddTipoEquipaAction;
import eapli.base.app.backoffice.console.presentation.tipoEquipa.ListarTipoEquipaAction;
import eapli.base.app.backoffice.console.presentation.tipoEquipa.PesquisarTipoEquipaAction;
import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.ShowMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

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
    private static final int ASSOCIAR_COLABORADOR_A_EQUIPA_OPTION = 4;
    private static final int LISTAR_CATALOGOS_SERVICOS=5;
    private static final int EDITAR_COLABORADOR_OPTION = 6;
    private static final int DESATIVAR_COLABORADOR_OPTION = 7;

    //Catalogos
    private static final int ADICIONAR_CATALOGO_OPTION = 1;
    private static final int LISTAR_CATALOGO_OPTION = 2;
    private static final int PESQUISAR_CATALOGO_OPTION = 3;
    private static final int ASSOCIAR_CATALOGO_A_EQUIPA_OPTION = 4;
    private static final int EDITAR_CATALOGO_OPTION = 5;
    private static final int DESATIVAR_CATALOGO_OPTION = 6;

    //Serviços
    private static final int ADICIONAR_SERVICO_OPTION = 1;
    private static final int LISTAR_SERVICO_OPTION = 2;
    private static final int PESQUISAR_SERVICO_OPTION = 3;
    private static final int ASSOCIAR_SERVICO_A_CATALOGO_OPTION = 4;
    private static final int ACABAR_SERVICO_OPTION=5;
    private static final int EDITAR_SERVICO_OPTION = 6;
    private static final int DESATIVAR_SERVICO_OPTION = 7;

    //Equipa
    private static final int ADICIONAR_EQUIPA_OPTION = 1;
    private static final int LISTAR_EQUIPA_OPTION = 2;
    private static final int PESQUISAR_EQUIPA_OPTION = 3;
    private static final int ADICIONAR_COLABORADOR_A_EQUIPA_OPTION = 4;
    private static final int ASSOCIAR_TIPOEQUIPA_A_EQUIPA_OPTION = 5;
    private static final int LISTAR_COLABORADORES_DE_EQUIPA_OPTION=6;
    private static final int EDITAR_EQUIPA_OPTION = 7;
    private static final int DESATIVAR_EQUIPA_OPTION = 8;

    //Tipo de Equipa
    private static final int ADICIONAR_TIPOEQUIPA_OPTION = 1;
    private static final int LISTAR_TIPOEQUIPA_OPTION = 2;
    private static final int PESQUISAR_TIPOEQUIPA_OPTION = 3;
    private static final int EDITAR_TIPOEQUIPA_OPTION = 4;
    private static final int DESATIVAR_TIPOEQUIPA_OPTION = 5;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int USERS_OPTION = 2;
    private static final int SETTINGS_OPTION = 4;
    private static final int COLABORADORES_OPTION = 5;
    private static final int CATALOGOS_OPTION = 6;
    private static final int SERVICOS_OPTION = 7;
    private static final int EQUIPA_OPTION = 8;
    private static final int TIPOEQUIPA_OPTION = 9;

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
        final Menu menu = buildMainMenu();
        final MenuRenderer renderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            renderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return renderer.render();
    }

    @Override
    public String headline() {

        return authz.session().map(s -> "Base [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("Base [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu();
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER, BaseRoles.ADMIN)) {
            final Menu usersMenu = buildUsersMenu();
            mainMenu.addSubMenu(USERS_OPTION, usersMenu);
            final Menu settingsMenu = buildAdminSettingsMenu();
            mainMenu.addSubMenu(SETTINGS_OPTION, settingsMenu);
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER, BaseRoles.ADMIN)) {
            final Menu colaboradoresMenu=buildColaboradoresMenu();
            mainMenu.addSubMenu(COLABORADORES_OPTION,colaboradoresMenu);

            final Menu catalogoMenu=buildCatalogoMenu();
            mainMenu.addSubMenu(CATALOGOS_OPTION,catalogoMenu);

            final Menu servicoMenu=buildServicoMenu();
            mainMenu.addSubMenu(SERVICOS_OPTION,servicoMenu);

            final Menu equipasMenu=buildEquipasMenu();
            mainMenu.addSubMenu(EQUIPA_OPTION,equipasMenu);

            final Menu tipoEquipaMenu=buildTipoEquipaMenu();
            mainMenu.addSubMenu(TIPOEQUIPA_OPTION,tipoEquipaMenu);
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

    private Menu buildColaboradoresMenu(){
        final Menu menu = new Menu("Colaboradores >");

        menu.addItem(ADICIONAR_COLABORADOR_OPTION,"Adicionar colaborador", new AddColaboradorAction());
        menu.addItem(LISTAR_COLABORADORES_OPTION,"Listar colaboradores",new ListarColaboradorAction());
        menu.addItem(PESQUISAR_COLABORADOR_OPTION,"Pesquisar colaborador por numero",new PesquisarColaboradorAction());
        menu.addItem(ASSOCIAR_COLABORADOR_A_EQUIPA_OPTION,"Associar colaborador a equipa",new AssociarColaboradorAEquipaAction());
        menu.addItem(LISTAR_CATALOGOS_SERVICOS,"Listar catalogo e serviços a que um utilizador tem acesso",new ListarCatalogosEServicoAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildEquipasMenu(){
        final Menu menu=new Menu("Equipas >");

        menu.addItem(ADICIONAR_EQUIPA_OPTION,"Adicionar equipa",new AddEquipaAction());
        menu.addItem(LISTAR_EQUIPA_OPTION,"Listar equipas",new ListarEquipaAction());
        menu.addItem(PESQUISAR_EQUIPA_OPTION,"Pesquisar equipa por acronimo",new PesquisarEquipaAction());
        menu.addItem(ADICIONAR_COLABORADOR_A_EQUIPA_OPTION,"Associar colaborador a equipa",new AssociarColaboradorAEquipaAction());
        menu.addItem(ASSOCIAR_TIPOEQUIPA_A_EQUIPA_OPTION,"Associar tipo de equipa a equipa",new AssociarTipoEquipaAEquipaAction());
        menu.addItem(LISTAR_COLABORADORES_DE_EQUIPA_OPTION,"Listar colaboradores de uma equipa",new ListarColaboradoresDeEquipaAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildTipoEquipaMenu(){
        final Menu menu=new Menu("Tipos de Equipa >");

        menu.addItem(ADICIONAR_TIPOEQUIPA_OPTION,"Adicionar tipo de equipa",new AddTipoEquipaAction());
        menu.addItem(LISTAR_TIPOEQUIPA_OPTION,"Listar tipos de equipa",new ListarTipoEquipaAction());
        menu.addItem(PESQUISAR_TIPOEQUIPA_OPTION,"Pesquisar tipo de equipa por nome",new PesquisarTipoEquipaAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

       return menu;
    }

    private Menu buildCatalogoMenu(){
        final Menu menu=new Menu("Catalogos >");

        menu.addItem(ADICIONAR_CATALOGO_OPTION,"Adicionar catalogo",new AddCatalogoAction());
        menu.addItem(LISTAR_CATALOGO_OPTION,"Listar catalogos",new ListarCatalogoAction());
        menu.addItem(PESQUISAR_CATALOGO_OPTION,"Pesquisar catalogo por titulo",new PesquisarCatalogoAction());
        menu.addItem(ASSOCIAR_CATALOGO_A_EQUIPA_OPTION,"Associar equipa a catalogo",new AssociarEquipaACatalogoAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildServicoMenu(){
        final Menu menu=new Menu("serviços >");

        menu.addItem(ADICIONAR_SERVICO_OPTION,"Adicionar serviço",new AddServicoAction());
        menu.addItem(LISTAR_SERVICO_OPTION,"Listar serviços ativos",new ListarServicoAction());
        menu.addItem(PESQUISAR_SERVICO_OPTION,"Pesquisar serviço por nome",new PesquisarServicoAction());
        menu.addItem(ASSOCIAR_SERVICO_A_CATALOGO_OPTION,"Associar serviço a catalogo",new AssociarServicoACatalogoAction());
        menu.addItem(ACABAR_SERVICO_OPTION,"Acabar serviço",new ContinuarServicoAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

}
