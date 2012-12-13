package modeleDuDomaine;

import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import outil.Fonction;

public class TestCellule {

	@Before
	public void avant() throws Exception {
		mock = mock(Fonction.class);
	}

	@Test
	public void uneCelluleVivanteAvecMoinsDe2VoisinesVivantesMeurt() {
		Cellule cellule = Cellule.creeVivante();
		Cellule suivante = cellule.evolue(creeCellulesVivantes(1));

		suivante.prendsPartALEvolution(mock);

		verify(mock, never()).appelle();
	}

	@Test
	public void uneCelluleVivanteAvec2VoisinesVivantesResteVivante() {
		Cellule cellule = Cellule.creeVivante();
		Cellule suivante = cellule.evolue(creeCellulesVivantes(2));

		suivante.prendsPartALEvolution(mock);

		verify(mock).appelle();
	}

	@Test
	public void uneCelluleVivanteAvecPlusDe3VoisinesVivantesMeurt() {
		Cellule cellule = Cellule.creeVivante();
		Cellule suivante = cellule.evolue(creeCellulesVivantes(4));

		suivante.prendsPartALEvolution(mock);

		verify(mock, never()).appelle();
	}

	@Test
	public void uneCelluleMorteAvec2VoisinesVivanteResteMorte() {
		Cellule cellule = Cellule.creeMorte();
		Cellule suivante = cellule.evolue(creeCellulesVivantes(2));

		suivante.prendsPartALEvolution(mock);

		verify(mock, never()).appelle();
	}

	@Test
	public void uneCelluleMorteAvec3VoisinesVivantesRevit() {
		Cellule cellule = Cellule.creeMorte();
		Cellule suivante = cellule.evolue(creeCellulesVivantes(3));

		suivante.prendsPartALEvolution(mock);

		verify(mock).appelle();
	}

	private List<Cellule> creeCellulesVivantes(int nombre) {
		List<Cellule> resultat = Lists.newArrayList();
		for (int i = 0; i < nombre; i++) {
			resultat.add(Cellule.creeVivante());
		}
		return resultat;
	}

	private Fonction mock;
}
