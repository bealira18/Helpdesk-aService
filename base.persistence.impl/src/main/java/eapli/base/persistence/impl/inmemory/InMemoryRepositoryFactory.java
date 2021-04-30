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
import eapli.base.infrastructure.bootstrapers.BaseBootstrapper;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.nivelcriticidademanagement.repository.NivelCriticidadeRepository;
import eapli.base.pedidomanagement.repository.PedidoRepository;
import eapli.base.pedidomanagement.repository.RascunhoRepository;
import eapli.base.pedidomanagement.repository.HistoricoRepository;
import eapli.base.servicomanagement.repository.ServicoRepository;
import eapli.base.servicomanagement.repository.WorkflowRepository;
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
		return null;
	}

	@Override
	public CatalogoRepository catalogo() {
		return null;
	}

	@Override
	public EquipaRepository equipa() {
		return null;
	}

	@Override
	public PedidoRepository pedido() {
		return null;
	}

	@Override
	public ServicoRepository servico() {
		return null;
	}
        
        @Override
	public NivelCriticidadeRepository nivelCriticidade() {
		return null;
	}
        
        @Override
	public TarefaRepository tarefa() {
		return null;
	}
        
        @Override
	public FormularioRepository formulario() {
		return null;
	}

	@Override
	public CriteriosEspecificacaoRepository criteriosEspecificacao() {
		return null;
	}

	@Override
	public AtributoRepository atributo() {
		return null;
	}

	@Override
	public RascunhoRepository rascunho() {
		return null;
	}

	@Override
	public HistoricoRepository historico() {
		return null;
	}

	@Override
	public WorkflowRepository workflow() {
		return null;
	}

	@Override
	public TipoEquipaRepository tipoEquipa() {
		return null;
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
