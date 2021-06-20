/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.nivelcriticidademanagement.application.DefinirNivelCriticidadeController;
import eapli.framework.actions.Action;

public class NivelCriticidadeBootstrapper implements Action {

    DefinirNivelCriticidadeController controller = new DefinirNivelCriticidadeController();

    @Override
    public boolean execute() {

        controller.definirNivelCriticidade("Primeiro objetivo", 15, 35, 5, "Elevada");
        controller.definirNivelCriticidade("Segundo objetivo", 10, 20, 3, "Média");

        return true;
    }
    
}
