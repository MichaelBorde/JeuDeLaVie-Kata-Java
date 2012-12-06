package fichier;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;

import corps.Corps;
import outil.Point;

public class TestFichierVersCorps {

	@Test
	public void peutLireUnFichierPourCreerUnCorps() {
		FichierVersCorps fichierVersCorps = new FichierVersCorps("src/test/resources/corps.txt");

		Corps corps = fichierVersCorps.lisCorps();

		assertThat(corps.cellule(new Point(0, 0)).estVivante()).isFalse();
		assertThat(corps.cellule(new Point(1, 1)).estVivante()).isTrue();
	}
}
