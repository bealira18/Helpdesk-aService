package eapli.base.colaboradormanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Contacto;
import eapli.base.colaboradormanagement.domain.Email;
import eapli.base.colaboradormanagement.domain.Funcao;
import eapli.base.colaboradormanagement.domain.Passe;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class EditarColaboradorController {

    private final ColaboradorRepository colaboradorRepository = PersistenceContext.repositories().colaborador();

    public Colaborador procurarColaboradorNomeCompleto(String nome){
        return colaboradorRepository.procurarPorNomeCompleto(nome);
    }

    public void mudarNomeCurto(String nomeCompleto, String nomeCurto) {

        Colaborador colaborador = procurarColaboradorNomeCompleto(nomeCompleto);

        if (colaborador == null) {
            throw new IllegalArgumentException("Este colaborador tem um nome inválido: " + nomeCompleto);
        } else {
            colaborador.mudarNomeCurto(nomeCurto);
        }

        colaboradorRepository.save(colaborador);
    }

    public void mudarNomeCompleto(String nomeAtual, String nomeNovo) {

        Colaborador colaborador = procurarColaboradorNomeCompleto(nomeAtual);

        if (colaborador == null) {
            throw new IllegalArgumentException("Este colaborador tem um nome inválido: " + nomeAtual);
        } else {
            colaborador.mudarNomeCompleto(nomeNovo);
        }

        colaboradorRepository.save(colaborador);
    }

    public void mudarLocalResidencia(String nomeCompleto, String novaResidencia) {

        Colaborador colaborador = procurarColaboradorNomeCompleto(nomeCompleto);

        if (colaborador == null) {
            throw new IllegalArgumentException("Este colaborador tem um nome inválido: " + nomeCompleto);
        } else {
            colaborador.mudarLocalResidencia(novaResidencia);
        }

        colaboradorRepository.save(colaborador);
    }

    public void mudarPasse(String nomeCompleto, String novaPasse) {

        Colaborador colaborador = procurarColaboradorNomeCompleto(nomeCompleto);

        if (colaborador == null) {
            throw new IllegalArgumentException("Este colaborador tem um nome inválido: " + nomeCompleto);
        } else {
            colaborador.mudarPasse(new Passe(novaPasse));
        }

        colaboradorRepository.save(colaborador);
    }

    public void mudarEmail(String nomeCompleto, String novoEmail) {

        Colaborador colaborador = procurarColaboradorNomeCompleto(nomeCompleto);

        if (colaborador == null) {
            throw new IllegalArgumentException("Este colaborador tem um nome inválido: " + nomeCompleto);
        } else {
            colaborador.mudarEmail(new Email(novoEmail));
        }

        colaboradorRepository.save(colaborador);
    }

    public void mudarFuncao(String nomeCompleto, String novaFuncao) {

        Colaborador colaborador = procurarColaboradorNomeCompleto(nomeCompleto);

        if (colaborador == null) {
            throw new IllegalArgumentException("Este colaborador tem um nome inválido: " + nomeCompleto);
        } else {
            colaborador.mudarFuncao(new Funcao(novaFuncao));
        }

        colaboradorRepository.save(colaborador);
    }

    public void mudarContacto(String nomeCompleto, String novoContacto) {

        Colaborador colaborador = procurarColaboradorNomeCompleto(nomeCompleto);

        if (colaborador == null) {
            throw new IllegalArgumentException("Este colaborador tem um nome inválido: " + nomeCompleto);
        } else {
            colaborador.mudarContacto(new Contacto(novoContacto));
        }

        colaboradorRepository.save(colaborador);
    }

}
