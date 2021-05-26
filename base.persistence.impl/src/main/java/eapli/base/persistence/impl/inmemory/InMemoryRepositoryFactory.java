package eapli.base.persistence.impl.inmemory;

import eapli.base.catalogomanagement.repository.CriteriosEspecificacaoRepository;
import eapli.base.catalogomanagement.repository.CatalogoRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.equipamanagement.repository.EquipaRepository;
import eapli.base.equipamanagement.repository.TipoEquipaRepository;
import eapli.base.formulariomanagement.repository.FormularioRepository;
import eapli.base.formulariomanagement.repository.AtributoRepository;
import eapli.base.formulariomanagement.repository.RespostasFormularioRepository;
import eapli.base.infrastructure.bootstrapers.BaseBootstrapper;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.nivelcriticidademanagement.repository.NivelCriticidadeRepository;
import eapli.base.pedidomanagement.repository.PedidoRepository;
import eapli.base.pedidomanagement.repository.RascunhoRepository;
import eapli.base.pedidomanagement.repository.HistoricoRepository;
import eapli.base.servicomanagement.repository.ServicoRepository;
import eapli.base.servicomanagement.repository.WorkflowRepository;
import eapli.base.tarefamanagement.repository.InfoTarefaRepository;
import eapli.base.tarefamanagement.repository.TarefaAutomaticaRepository;
import eapli.base.tarefamanagement.repository.TarefaManualRepository;
import eapli.base.tarefamanagement.repository.TarefaRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.InMemoryUserRepository;

/**
 *
 * Created by nuno on 20/03/16.
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

	static {
		// only needed because of the in memory persistence
		new BaseBootstrapper().execute();
	}

	@Override
	public UserRepository users(final TransactionalContext tx) {
		return new InMemoryUserRepository();
	}

	@Override
	public UserRepository users() {
		return users(null);
	}


	@Override
	public ClientUserRepository clientUsers(final TransactionalContext tx) {

		return new InMemoryClientUserRepository();
	}

	@Override
	public ClientUserRepository clientUsers() {
		return clientUsers(null);
	}

	@Override
	public SignupRequestRepository signupRequests() {
		return signupRequests(null);
	}

	@Override
	public ColaboradorRepository colaborador() {
		return new InMemoryColaboradorRepository();
	}

	@Override
	public CatalogoRepository catalogo() {
		return new InMemoryCatalogoRepository();
	}

	@Override
	public EquipaRepository equipa() {
		return new InMemoryEquipaRepository();
	}

	@Override
	public PedidoRepository pedido() {
		return new InMemoryPedidoRepository();
	}

	@Override
	public ServicoRepository servico() {
		return new InMemoryServicoRepository();
	}
        
	@Override
	public NivelCriticidadeRepository nivelCriticidade() {
		return new InMemoryNivelCriticidadeRepository();
	}
        
	@Override
	public TarefaRepository tarefa() {
		return new InMemoryTarefaRepository();
	}

	@Override
	public TarefaManualRepository tarefaManual() {
		return new InMemoryTarefaManualRepository();
	}

	@Override
	public TarefaAutomaticaRepository tarefaAutomatica() {
		return new InMemoryTarefaAutomaticaRepository();
	}

	@Override
	public InfoTarefaRepository infoTarefa() {
		return new InMemoryInfoTarefaRepository();
	}

	@Override
	public FormularioRepository formulario() {
		return new InMemoryFormularioRepository();
	}

	@Override
	public RespostasFormularioRepository respostasFormulario(){
		return new InMemoryRespostasFormularioRepository();
	}

	@Override
	public CriteriosEspecificacaoRepository criteriosEspecificacao() {
		return new InMemoryCriteriosEspecificacaoRepository();
	}

	@Override
	public AtributoRepository atributo() {
		return new InMemoryAtributoRepository();
	}

	@Override
	public RascunhoRepository rascunho() {
		return new InMemoryRascunhoRepository();
	}

	@Override
	public HistoricoRepository historico() {
		return new InMemoryHistoricoRepository();
	}

	@Override
	public WorkflowRepository workflow() {
		return new InMemoryWorkflowRepository();
	}

	@Override
	public TipoEquipaRepository tipoEquipa() {
		return new InMemoryTipoEquipaRepository();
	}

	@Override
	public SignupRequestRepository signupRequests(final TransactionalContext tx) {
		return new InMemorySignupRequestRepository();
	}


	@Override
	public TransactionalContext newTransactionalContext() {
		// in memory does not support transactions...
		return null;
	}

}
