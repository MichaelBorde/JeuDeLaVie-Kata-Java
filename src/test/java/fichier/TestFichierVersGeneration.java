package fichier;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;

import modeleDuDomaine.Generation;
import outil.Point;

public class TestFichierVersGeneration {

	@Test
	public void peutLireUnFichierPourCreerUnGeneration() {
		FichierVersGeneration fichierVersGeneration = new FichierVersGeneration("src/test/resources/generation.txt");

		Generation generation = fichierVersGeneration.lisGeneration();

		assertThat(generation.positionsVivantes()).containsOnly(new Point(1, 1));
	}
}
