package eapli.base.servicomanagement.application;

import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.repository.FormularioRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repository.ServicoRepository;

public class AssociarFormularioAServicoController {

    private final ServicoRepository servicoRepository= PersistenceContext.repositories().servico();
    private final FormularioRepository formularioRepository= PersistenceContext.repositories().formulario();

    public Servico associarFormularioAServicoComNome(String nomeFormulario,String codServico){

        Formulario f=verificarFormulario(nomeFormulario);
        Servico s=verificarServico(codServico);

        if(f==null)
            throw new IllegalArgumentException("Formulario inválido com nome: "+nomeFormulario);

        if(s==null)
            throw new IllegalArgumentException("Serviço inválido com codigo: "+codServico);

        s.associarFormulario(f);

        return servicoRepository.save(s);

    }

    public Servico associarFormularioAServicoComIdF(int idF,int idS){

        Servico s=verificarIdS(idS);
        Formulario f=verificaIdF(idF);

        if(f==null)
            throw new IllegalArgumentException("Formulario inválido com id: "+idF);

        if(s==null)
            throw new IllegalArgumentException("Serviço inválido com id: "+idS);

        s.associarFormulario(f);

        return servicoRepository.save(s);

    }

    public Formulario verificaIdF(int id){
        Iterable<Formulario> formularios=formularioRepository.findAll();

        for(Formulario f : formularios){
            if(f.obterId()==id)
                return f;
        }

        return null;
    }

    public Formulario verificarFormulario(String nomeFormulario){

        Iterable<Formulario> formularios=formularioRepository.findAll();

        for(Formulario f : formularios){
            if(f.compareTo(nomeFormulario)==0)
                return f;
        }

        return null;
    }

    public Servico verificarIdS(int id){
        Iterable<Servico> servicos=servicoRepository.findAll();

        for(Servico s : servicos){
            if(s.obterId()==id)
                return s;
        }
        return null;
    }

    public Servico verificarServico(String codServico){

        Iterable<Servico> servicos=servicoRepository.findAll();

        for(Servico s : servicos){
            if(s.compareTo(codServico)==0)
                return s;
        }

        return null;
    }

}