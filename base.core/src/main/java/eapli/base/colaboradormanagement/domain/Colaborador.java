package eapli.base.colaboradormanagement.domain;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Colaborador implements AggregateRoot<Numero>, Serializable {

    @Id
    private Numero numero;
    private String nomeCurto;
    private String nomeCompleto;
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    private String localResidencia;
    private boolean ativo;
    private boolean serHumano;
    private Passe passe;
    private Email email;
    //private PerfilColaborador perfilColaborador;
    private Funcao funcao;
    private Motivo motivo;
    private Contacto contacto;

    @OneToOne(cascade = CascadeType.ALL)
    private Servico servico;

    @OneToOne(cascade = CascadeType.ALL)
    private Pedido pedido;

    @OneToOne(cascade = CascadeType.ALL)
    private Pedido pedido1;

    @OneToOne(cascade = CascadeType.ALL)
    private Formulario formulario;

    @ManyToOne(cascade = CascadeType.ALL)
    private Equipa equipa;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "colaborador_numero")
    private List<Tarefa> tarefas = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Catalogo catalogo;
    
    protected Colaborador() {
    }

    public Colaborador(int numero, String nomeCurto, String nomeCompleto, Date dataNascimento, String localResidencia, boolean serHumano,
            String passe, String email, String perfilColaborador, String funcao, String motivo, long contacto) {
        this.numero = new Numero(numero);
        this.nomeCurto = nomeCurto;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.localResidencia = localResidencia;
        this.serHumano = serHumano;
        this.ativo = true;
        this.passe = new Passe(passe);
        this.email = new Email(email);
        this.funcao = new Funcao(funcao);
        this.motivo = null;
        this.contacto = new Contacto(contacto);
    }

    @Override
    public String toString() {
        return "Colaborador:\n"
                + "numero= " + numero
                + "\nnomeCurto= " + nomeCurto;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Numero identity() {
        return null;
    }

    public String obterNomeCompleto() {
        return this.nomeCompleto;
    }

    public Numero obterNumero(){
        return numero;
    }

    public void mudarNomeCurto(String nomeCurto) {
        this.nomeCurto = nomeCurto;
    }

    public void mudarNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void mudarLocalResidencia(String localResiencia) {
        this.localResidencia = localResiencia;
    }

    public void mudarPasse(Passe passe) {
        this.passe = passe;
    }

    public void mudarEmail(Email email) {
        this.email = email;
    }

    public void mudarFuncao(Funcao funcao) {
        this.funcao = funcao;
    }
    
    public void mudarContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public void mudarEstado(Boolean bool){
        this.ativo = bool;
    }
}
