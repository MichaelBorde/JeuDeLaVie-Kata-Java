package modeleDuDomaine;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;

import outil.Point;

public class TestGeneration {

	@Test
	public void unCorpsEstInfini() {
		Generation generation = new Generation(new Point(-12, 20000));

		assertThat(generation.donneCellule(new Point(-12, 20000)).estVivante()).isTrue();
		assertThat(generation.donneCellule(new Point(0, 12)).estVivante()).isFalse();
	}


	@Test
	public void leCorpsPeutEvoluer() {
		Generation generation = new Generation(new Point(10, 12), new Point(11, 11), new Point(12, 10));

		Generation suivant = generation.creeSuivante();

		assertThat(suivant.donneCellule(new Point(10, 10)).estVivante()).isFalse();
		assertThat(suivant.donneCellule(new Point(10, 11)).estVivante()).isFalse();
		assertThat(suivant.donneCellule(new Point(10, 12)).estVivante()).isFalse();
		assertThat(suivant.donneCellule(new Point(11, 10)).estVivante()).isFalse();
		assertThat(suivant.donneCellule(new Point(11, 11)).estVivante()).isTrue();
		assertThat(suivant.donneCellule(new Point(11, 12)).estVivante()).isFalse();
		assertThat(suivant.donneCellule(new Point(10, 10)).estVivante()).isFalse();
		assertThat(suivant.donneCellule(new Point(10, 11)).estVivante()).isFalse();
		assertThat(suivant.donneCellule(new Point(10, 12)).estVivante()).isFalse();
	}

	@Test
	public void uneCelluleMortePeutRevenirALaVie() {
		Generation generation = new Generation(new Point(0, 0), new Point(1, 0), new Point(2, 0));

		Generation suivant = generation.creeSuivante();

		assertThat(suivant.donneCellule(new Point(1, -1)).estVivante()).isTrue();
		assertThat(suivant.donneCellule(new Point(1, 0)).estVivante()).isTrue();
		assertThat(suivant.donneCellule(new Point(1, 1)).estVivante()).isTrue();
	}
}
