package modeleDuDomaine;

import static org.fest.assertions.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

public class TestCellule {

	@Test
	public void uneCelluleVivanteAvecMoinsDe2VoisinesVivantesMeurt() {
		Cellule cellule = Cellule.creeVivante();
		Cellule suivante = cellule.evolue(creeCellulesVivantes(1));

		List<Cellule> vivantes = suivante.ajouteToiAuxVivantes(new ArrayList<Cellule>());

		assertThat(vivantes).hasSize(0);
	}

	@Test
	public void uneCelluleVivanteAvec2VoisinesVivantesResteVivante() {
		Cellule cellule = Cellule.creeVivante();
		Cellule suivante = cellule.evolue(creeCellulesVivantes(2));

		List<Cellule> vivantes = suivante.ajouteToiAuxVivantes(new ArrayList<Cellule>());

		assertThat(vivantes).contains(suivante);
	}

	@Test
	public void uneCelluleVivanteAvecPlusDe3VoisinesVivantesMeurt() {
		Cellule cellule = Cellule.creeVivante();
		Cellule suivante = cellule.evolue(creeCellulesVivantes(3));

		List<Cellule> vivantes = suivante.ajouteToiAuxVivantes(new ArrayList<Cellule>());

		assertThat(vivantes).contains(suivante);
	}

	@Test
	public void uneCelluleMorteAvec2VoisinesVivanteResteMorte() {
		Cellule cellule = Cellule.creeMorte();
		Cellule suivante = cellule.evolue(creeCellulesVivantes(2));

		List<Cellule> vivantes = suivante.ajouteToiAuxVivantes(new ArrayList<Cellule>());

		assertThat(vivantes).hasSize(0);
	}

	@Test
	public void uneCelluleMorteAvec3VoisinesVivantesRevit() {
		Cellule cellule = Cellule.creeMorte();
		Cellule suivante = cellule.evolue(creeCellulesVivantes(3));

		List<Cellule> vivantes = suivante.ajouteToiAuxVivantes(new ArrayList<Cellule>());

		assertThat(vivantes).contains(suivante);
	}

	private List<Cellule> creeCellulesVivantes(int nombre) {
		List<Cellule> resultat = Lists.newArrayList();
		for (int i = 0; i < nombre; i++) {
			resultat.add(Cellule.creeVivante());
		}
		return resultat;
	}
}
