package corps;

import static org.fest.assertions.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import outil.Point;

public class TestCorps {

	@Before
	public void avant() {
		corps = new Corps();
	}

	@Test
	public void unCorpsEstInfini() {
		corps.ajouteCellule(new Point(-12, 20000), true);

		assertThat(corps.cellule(new Point(-12, 20000)).estVivante()).isTrue();
		assertThat(corps.cellule(new Point(0, 12)).estVivante()).isFalse();
	}


	@Test
	public void leCorpsPeutEvoluer() {
		corps.ajouteCellule(new Point(10, 12), true);
		corps.ajouteCellule(new Point(11, 11), true);
		corps.ajouteCellule(new Point(12, 10), true);

		Corps suivant = corps.suivant();

		assertThat(suivant.cellule(new Point(10, 10)).estVivante()).isFalse();
		assertThat(suivant.cellule(new Point(10, 11)).estVivante()).isFalse();
		assertThat(suivant.cellule(new Point(10, 12)).estVivante()).isFalse();
		assertThat(suivant.cellule(new Point(11, 10)).estVivante()).isFalse();
		assertThat(suivant.cellule(new Point(11, 11)).estVivante()).isTrue();
		assertThat(suivant.cellule(new Point(11, 12)).estVivante()).isFalse();
		assertThat(suivant.cellule(new Point(10, 10)).estVivante()).isFalse();
		assertThat(suivant.cellule(new Point(10, 11)).estVivante()).isFalse();
		assertThat(suivant.cellule(new Point(10, 12)).estVivante()).isFalse();
	}

	@Test
	public void uneCelluleMortePeutRevenirALaVie() {
		corps.ajouteCellule(new Point(0, 0), true);
		corps.ajouteCellule(new Point(1, 0), true);
		corps.ajouteCellule(new Point(2, 0), true);

		Corps suivant = corps.suivant();

		assertThat(suivant.cellule(new Point(1, -1)).estVivante()).isTrue();
		assertThat(suivant.cellule(new Point(1, 0)).estVivante()).isTrue();
		assertThat(suivant.cellule(new Point(1, 1)).estVivante()).isTrue();
	}

	private Corps corps;
}
