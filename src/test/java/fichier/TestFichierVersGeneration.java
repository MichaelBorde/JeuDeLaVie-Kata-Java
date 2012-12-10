package fichier;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;

import modeleDuDomaine.Generation;
import outil.Point;

public class TestFichierVersGeneration {

	@Test
	public void peutLireUnFichierPourCreerUnCorps() {
		FichierVersGeneration fichierVersGeneration = new FichierVersGeneration("src/test/resources/generation.txt");

		Generation generation = fichierVersGeneration.lisGeneration();

		assertThat(generation.celluleA(new Point(0, 0)).estVivante()).isFalse();
		assertThat(generation.celluleA(new Point(1, 1)).estVivante()).isTrue();
	}
}
