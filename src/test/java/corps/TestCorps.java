package corps;

import static org.fest.assertions.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import outil.Rectangle;

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

	@Test
	public void peutFournirLaBoiteEnglobanteDUnPetitCorps() {
		corps.ajouteCellule(0, 0, true);

		Rectangle boite = corps.boite();

		assertThat(boite).isNotNull();
		assertThat(boite).isEqualTo(new Rectangle(0, 0, 1, 1));
	}

	@Test
	public void peutFournirLaBoiteEnglobanteDUnAvecPlusieursCellules() {
		corps.ajouteCellule(-1, -2, true);
		corps.ajouteCellule(3, 5, true);

		Rectangle boite = corps.boite();

		assertThat(boite).isEqualTo(new Rectangle(-1, -2, 5, 8));
	}

	@Test
	public void laBoiteEnglobanteEstValidePourDesPositionsNegatives() {
		corps.ajouteCellule(-1, -1, true);

		Rectangle boite = corps.boite();

		assertThat(boite).isNotNull();
		assertThat(boite).isEqualTo(new Rectangle(-1, -1, 1, 1));
	}

	@Test
	public void laBoiteEnglobanteDUnCorpsVideEstVide() {
		Rectangle boite = corps.boite();

		assertThat(boite).isNotNull();
		assertThat(boite).isEqualTo(new Rectangle(0, 0, 0, 0));
	}

	private Corps corps;
}
