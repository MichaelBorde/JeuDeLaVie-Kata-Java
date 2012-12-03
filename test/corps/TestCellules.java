package corps;

import static org.fest.assertions.Assertions.*;

import java.util.List;

import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class TestCellules {

	@Test
	public void peutFournirLesVoisinesDUneCellule() {
		Cellules cellules = new Cellules();
		cellules.ajoute(10, 10, Cellule.vivante());
		cellules.ajoute(10, 11, Cellule.vivante());

		List<Cellule> resultat = cellules.voisines(10, 10);

		assertThat(resultat.size()).isEqualTo(8);
		assertThat(vivantes(resultat)).hasSize(1);
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
