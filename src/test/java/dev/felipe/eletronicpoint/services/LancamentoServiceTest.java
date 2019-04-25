package dev.felipe.eletronicpoint.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import dev.felipe.eletronicpoint.entities.Lancamento;
import dev.felipe.eletronicpoint.repositories.LancamentoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class LancamentoServiceTest {

	@MockBean
	private LancamentoRepository LancamentoRepository;

	@Autowired
	private LancamentoService LancamentoService;

	@Before
	public void setUp() throws Exception {

		BDDMockito
				.given(this.LancamentoRepository.findByFuncionarioId(Mockito.anyLong(), Mockito.any(PageRequest.class)))
				.willReturn(new PageImpl<Lancamento>(new ArrayList<Lancamento>()));
		BDDMockito.given(this.LancamentoRepository.findByFuncionarioId(Mockito.anyLong()))
				.willReturn(new ArrayList<Lancamento>());
		BDDMockito.given(this.LancamentoRepository.findById(Mockito.anyLong()))
				.willReturn(Optional.ofNullable(new Lancamento()));
		BDDMockito.given(this.LancamentoRepository.save(Mockito.any(Lancamento.class))).willReturn(new Lancamento());
		//doNothing().when(LancamentoRepository).delete(Mockito.any(Lancamento.class));
	}

	@Test
	public void testBuscarLancamentoPorFuncionarioId() {
		Page<Lancamento> lancamento = LancamentoService.buscarPorFuncionarioId(1L, new PageRequest(0, 10));
		assertNotNull(lancamento);
	}

	@Test
	public void testBuscarLancamentoPorId() {
		Optional<Lancamento> lancamento = LancamentoService.buscarPorId(1L);
		assertTrue(lancamento.isPresent());
	}

	@Test
	public void testPersistir() {
		Lancamento lancamento = LancamentoService.persistir(new Lancamento());
		assertNotNull(lancamento);
	}
//
//	@Test
//	public void testRemoverLancamentoPorId() {
//		this.LancamentoService.remover(1L);
//		verify(this.LancamentoService, times(1)).remover(1L);
//	}

}
