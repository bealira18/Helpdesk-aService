package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.catalogomanagement.repository.CatalogoRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.equipamanagement.repository.EquipaRepository;
import eapli.base.formulariomanagement.repository.FormularioRepository;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.nivelcriticidademanagement.repository.NivelCriticidadeRepository;
import eapli.base.pedidomanagement.repository.PedidoRepository;
import eapli.base.servicomanagement.repository.ServicoRepository;
import eapli.base.tarefamanagement.repository.TarefaRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.JpaAutoTxUserRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 *
 * Created by nuno on 21/03/16.
 */
public class JpaRepositoryFactory implements RepositoryFactory {

	@Override
	public UserRepository users(final TransactionalContext autoTx) {
		return new JpaAutoTxUserRepository(autoTx);
	}

	@Override
	public UserRepository users() {
		return new JpaAutoTxUserRepository(Application.settings().getPersistenceUnitName(),
				Application.settings().getExtendedPersistenceProperties());
	}


	@Override
	public JpaClientUserRepository clientUsers(final TransactionalContext autoTx) {
		return new JpaClientUserRepository(autoTx);
	}

	@Override
	public JpaClientUserRepository clientUsers() {
		return new JpaClientUserRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public SignupRequestRepository signupRequests(final TransactionalContext autoTx) {
		return new JpaSignupRequestRepository(autoTx);
	}

	@Override
	public SignupRequestRepository signupRequests() {
		return new JpaSignupRequestRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public ColaboradorRepository colaborador() {
		return new JpaColaboradorRepository();
	}

	@Override
	public CatalogoRepository catalogo() {
		return new JpaCatalogoRepository();
	}

	@Override
	public EquipaRepository equipa() {
		return new JpaEquipaRepository();
	}

	@Override
	public PedidoRepository pedido() {
		return new JpaPedidoRepository();
	}

	@Override
	public ServicoRepository servico() {
		return new JpaServicoRepository();
	}
        
        @Override
	public NivelCriticidadeRepository nivelCriticidade() {
		return new JpaNivelCriticidadeRepository();
	}
        
        @Override
	public TarefaRepository tarefa() {
		return new JpaTarefaRepository();
	}
        
         @Override
	public FormularioRepository formulario() {
		return new JpaFormularioRepository();
	}

	@Override
	public TransactionalContext newTransactionalContext() {
		return JpaAutoTxRepository.buildTransactionalContext(Application.settings().getPersistenceUnitName(),
				Application.settings().getExtendedPersistenceProperties());
	}


}
