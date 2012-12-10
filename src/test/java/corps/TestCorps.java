package corps;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;

import outil.Point;

public class TestCorps {

	@Test
	public void unCorpsEstInfini() {
		Corps corps = new Corps(new Point(-12, 20000));

		assertThat(corps.cellule(new Point(-12, 20000)).estVivante()).isTrue();
		assertThat(corps.cellule(new Point(0, 12)).estVivante()).isFalse();
	}


	@Test
	public void leCorpsPeutEvoluer() {
		Corps corps = new Corps(new Point(10, 12), new Point(11, 11), new Point(12, 10));

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
		Corps corps = new Corps(new Point(0, 0), new Point(1, 0), new Point(2, 0));

		Corps suivant = corps.suivant();

		assertThat(suivant.cellule(new Point(1, -1)).estVivante()).isTrue();
		assertThat(suivant.cellule(new Point(1, 0)).estVivante()).isTrue();
		assertThat(suivant.cellule(new Point(1, 1)).estVivante()).isTrue();
	}
}
