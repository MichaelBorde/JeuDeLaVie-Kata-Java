package fichier;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;

import corps.Corps;

public class TestFichierVersCorps {

	@Test
	public void peutLireUnFichierPourCreerUnCorps() {
		FichierVersCorps fichierVersCorps = new FichierVersCorps("test/ressource/corps.txt");

		Corps corps = fichierVersCorps.lisCorps();

		assertThat(corps.cellule(0, 0).estVivante()).isFalse();
		assertThat(corps.cellule(1, 1).estVivante()).isTrue();
	}
}
