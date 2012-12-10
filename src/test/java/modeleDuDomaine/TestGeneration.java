package modeleDuDomaine;

import static org.fest.assertions.Assertions.*;

import java.util.Set;

import org.junit.Test;

import outil.Point;

public class TestGeneration {

	@Test
	public void unCorpsEstInfini() {
		Generation generation = new Generation(new Point(-12, 20000));

		assertThat(generation.positionsVivantes()).containsOnly(new Point(-12, 20000));
	}

	@Test
	public void leCorpsPeutEvoluer() {
		Generation generation = new Generation(new Point(10, 12), new Point(11, 11), new Point(12, 10));

		Generation suivant = generation.creeSuivante();

		Set<Point> positionsVivantes = suivant.positionsVivantes();
		assertThat(positionsVivantes).containsOnly(new Point(11, 11));
	}

	@Test
	public void uneCelluleMortePeutRevenirALaVie() {
		Generation generation = new Generation(new Point(0, 0), new Point(1, 0), new Point(2, 0));

		Generation suivant = generation.creeSuivante();

		Set<Point> positionsVivantes = suivant.positionsVivantes();
		assertThat(positionsVivantes).containsOnly(new Point(1, -1), new Point(1, 0), new Point(1, 1));
	}
}
