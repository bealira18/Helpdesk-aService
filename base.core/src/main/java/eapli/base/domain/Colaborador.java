package eapli.base.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

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
    private PerfilColaborador perfilColaborador;
    private Funcao funcao;
    private Motivo motivo;
    private Contacto contacto;

    protected Colaborador(){}

    public Colaborador(int numero,String nomeCurto,String nomeCompleto,Date dataNascimento,String localResidencia,boolean serHumano,
                       String passe,String email,String perfilColaborador,String funcao,String motivo,long contacto){
        this.numero=new Numero(numero);
        this.nomeCurto=nomeCurto;
        this.nomeCompleto=nomeCompleto;
        this.dataNascimento=dataNascimento;
        this.localResidencia=localResidencia;
        this.serHumano=serHumano;
        this.ativo=true;
        this.passe=new Passe(passe);
        this.email=new Email(email);
        this.perfilColaborador=new PerfilColaborador(perfilColaborador);
        this.funcao=new Funcao(funcao);
        this.motivo=new Motivo(motivo);
        this.contacto=new Contacto(contacto);
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Numero identity() {
        return null;
    }
}
