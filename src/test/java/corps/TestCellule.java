package corps;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;

public class TestCellule {

	@Test
	public void uneCelluleVivanteAvecMoinsDe2VoisinesVivantesMeurt() {
		Cellule cellule = Cellule.vivante();

		Cellule suivante = cellule.evolue(1);

		assertThat(suivante.estVivante()).isFalse();
	}

	@Test
	public void uneCelluleVivanteAvec2VoisinesVivantesResteVivante() {
		Cellule cellule = Cellule.vivante();

		Cellule suivante = cellule.evolue(2);

		assertThat(suivante.estVivante()).isTrue();
	}

	@Test
	public void uneCelluleVivanteAvecPlusDe3VoisinesVivantesMeurt() {
		Cellule cellule = Cellule.vivante();

		Cellule suivante = cellule.evolue(4);

		assertThat(suivante.estVivante()).isFalse();
	}

	@Test
	public void uneCelluleMorteAvec2VoisinesVivanteResteMorte() {
		Cellule cellule = Cellule.morte();

		Cellule suivante = cellule.evolue(2);

		assertThat(suivante.estVivante()).isFalse();
	}

	@Test
	public void uneCelluleMorteAvec3VoisinesVivantesRevit() {
		Cellule cellule = Cellule.morte();

		Cellule suivante = cellule.evolue(3);

		assertThat(suivante.estVivante()).isTrue();
	}
}
