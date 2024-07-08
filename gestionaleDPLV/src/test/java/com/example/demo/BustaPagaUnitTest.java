 package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import com.example.demo.controller.BustaPagaController;
import com.example.demo.entity.BustaPaga;
import com.example.demo.repository.BustaPagaRepository;

/**
 * Questo test verifica che il metodo findAll del controller BustaPagaController
 * restituisca correttamente una lista di buste paga.
 *
 * La procedura è la seguente:
 * 1. Si prepara un oggetto BustaPaga con dati di esempio.
 * 2. Si simula il comportamento del repository BustaPagaRepository, in modo che quando
 *    viene chiamato il suo metodo findAll, restituisca la lista contenente l'oggetto
 *    BustaPaga preparato in precedenza.
 * 3. Si chiama il metodo getAll() del controller BustaPagaController, che dovrebbe a sua
 *    volta chiamare il metodo findAll() del repository.
 * 4. Si verifica che la lista restituita dal controller contenga esattamente l'oggetto
 *    BustaPaga preparato in precedenza.
 * 5. Si verifica che il metodo findAll() del repository sia stato effettivamente chiamato
 *    durante l'esecuzione del test.
 *    
 * @version 1.0
 * @author Daniele Pasqualetti, Lorenzo Vaccaro
 */
@SpringBootTest
class BustaPagaUnitTest {
	@Mock
	private BustaPagaRepository bustaPagaRepository;
	@InjectMocks
	private BustaPagaController bustaPagaController;

	@Test
	void findAll_should_return_busta_paga_list() {
		// Given
		BustaPaga bp = new BustaPaga();
		bp.setName("Abderrahim");
		bp.setLastname("Azhrioun");
		bp.setJob("");
		bp.setSalary(1.00);

		// When calling the mocked repository method
		when(bustaPagaRepository.findAll()).thenReturn(List.of(bp));
		Iterable<BustaPaga> bps = this.bustaPagaController.getAll();

		// Then
		assertThat(List.of(bp)).isEqualTo(bps);
		verify(this.bustaPagaRepository).findAll();
	}
}
