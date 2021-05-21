/**
 *
 */
package eapli.base.infrastructure.persistence;

import eapli.base.catalogomanagement.repository.CatalogoRepository;
import eapli.base.catalogomanagement.repository.CriteriosEspecificacaoRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;

import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.equipamanagement.repository.EquipaRepository;
import eapli.base.equipamanagement.repository.TipoEquipaRepository;
import eapli.base.formulariomanagement.repository.AtributoRepository;
import eapli.base.formulariomanagement.repository.FormularioRepository;
import eapli.base.nivelcriticidademanagement.repository.NivelCriticidadeRepository;
import eapli.base.pedidomanagement.repository.PedidoRepository;
import eapli.base.pedidomanagement.repository.RascunhoRepository;
import eapli.base.pedidomanagement.repository.HistoricoRepository;
import eapli.base.servicomanagement.repository.ServicoRepository;
import eapli.base.servicomanagement.repository.WorkflowRepository;
import eapli.base.tarefamanagement.domain.TarefaAutomatica;
import eapli.base.tarefamanagement.repository.TarefaAutomaticaRepository;
import eapli.base.tarefamanagement.repository.TarefaManualRepository;
import eapli.base.tarefamanagement.repository.TarefaRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

/**
 * @author Paulo Gandra Sousa
 *
 */
public interface RepositoryFactory {

	/**
	 * factory method to create a transactional context to use in the repositories
	 *
	 * @return
	 */
	TransactionalContext newTransactionalContext();

	/**
	 *
	 * @param autoTx the transactional context to enrol
	 * @return
	 */
	UserRepository users(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	UserRepository users();

	/**
	 *
	 * @param autoTx the transactional context to enroll
	 * @return
	 */
	ClientUserRepository clientUsers(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	ClientUserRepository clientUsers();

	/**
	 *
	 * @param autoTx the transactional context to enroll
	 * @return
	 */
	SignupRequestRepository signupRequests(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	SignupRequestRepository signupRequests();


	ColaboradorRepository colaborador();
	CatalogoRepository catalogo();
	EquipaRepository equipa();
	PedidoRepository pedido();
	ServicoRepository servico();
	NivelCriticidadeRepository nivelCriticidade();
	TarefaRepository tarefa();
	TarefaManualRepository tarefaManual();
	TarefaAutomaticaRepository tarefaAutomatica();
	FormularioRepository formulario();
	CriteriosEspecificacaoRepository criteriosEspecificacao();
	AtributoRepository atributo();
	RascunhoRepository rascunho();
	WorkflowRepository workflow();
	HistoricoRepository historico();
	TipoEquipaRepository tipoEquipa();
}
