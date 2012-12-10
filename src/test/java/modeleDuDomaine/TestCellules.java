package modeleDuDomaine;

import static org.fest.assertions.Assertions.*;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

import outil.Point;

public class TestCellules {

	@Test
	public void peutFournirLesVoisinesDUneCellule() {
		Cellules cellules = new Cellules();
		cellules.ajoute(new Point(10, 10), Cellule.creeVivante());
		cellules.ajoute(new Point(10, 11), Cellule.creeVivante());

		List<Cellule> resultat = cellules.voisinesAutour(new Point(10, 10));

		assertThat(resultat.size()).isEqualTo(8);
		assertThat(vivantes(resultat)).hasSize(1);
	}

	@Test
	public void peutFournirLesPositionsVivantes() {
		Cellules cellules = new Cellules();
		cellules.ajoute(new Point(0, 0), Cellule.creeVivante());
		cellules.ajoute(new Point(0, 1), Cellule.creeVivante());
		cellules.ajoute(new Point(0, 2), Cellule.creeMorte());

		Set<Point> resultat = cellules.positionsVivantes();

		assertThat(resultat).hasSize(2);
		assertThat(resultat).contains(new Point(0, 0));
		assertThat(resultat).contains(new Point(0, 1));
	}

	private Iterable<Cellule> vivantes(List<Cellule> resultat) {
		return Iterables.filter(resultat, new Predicate<Cellule>() {
			@Override
			public boolean apply(Cellule cellule) {
				return cellule.estVivante();
			}
		});
	}
}
