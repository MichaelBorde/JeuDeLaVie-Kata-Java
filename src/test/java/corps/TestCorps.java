package corps;

import static org.fest.assertions.Assertions.*;

import org.junit.Before;
import org.junit.Test;

public class TestCorps {

	@Before
	public void avant() {
		corps = new Corps();
	}

	@Test
	public void unCorpsEstInfini() {
		corps.ajouteCellule(-12, 20000, true);

		int i = -12;
		assertThat(corps.cellule(i, 20000).estVivante()).isTrue();
		assertThat(corps.cellule(0, 12).estVivante()).isFalse();
	}


	@Test
	public void leCorpsPeutEvoluer() {
		corps.ajouteCellule(10, 12, true);
		corps.ajouteCellule(11, 11, true);
		corps.ajouteCellule(12, 10, true);

		Corps suivant = corps.suivant();

		assertThat(suivant.cellule(10, 10).estVivante()).isFalse();
		assertThat(suivant.cellule(10, 11).estVivante()).isFalse();
		assertThat(suivant.cellule(10, 12).estVivante()).isFalse();
		assertThat(suivant.cellule(11, 10).estVivante()).isFalse();
		assertThat(suivant.cellule(11, 11).estVivante()).isTrue();
		assertThat(suivant.cellule(11, 12).estVivante()).isFalse();
		assertThat(suivant.cellule(10, 10).estVivante()).isFalse();
		assertThat(suivant.cellule(10, 11).estVivante()).isFalse();
		assertThat(suivant.cellule(10, 12).estVivante()).isFalse();
	}

	private Corps corps;
}
