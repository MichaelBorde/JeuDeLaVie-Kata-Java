package entreeSortie.console;

import static entreeSortie.RepresentationCellule.*;

import java.util.Set;

import com.google.inject.Inject;

import modeleDuDomaine.Generation;
import outil.Point;

public class GenerationVersConsole {

	@Inject
	public GenerationVersConsole(Console console) {
		this.console = console;
	}

	public void ecris(Generation generation, int taille) {
		Set<Point> vivantes = generation.positionsVivantes();
		for (int y = 0; y < taille; y++) {
			console.ecris(ligne(vivantes, y, taille));
		}
	}

	private String ligne(Set<Point> vivantes, int y, int taille) {
		StringBuilder builder = new StringBuilder();
		for (int x = 0; x < taille; x++) {
			builder.append(representationCellule(vivantes, new Point(x, y)));
		}
		return builder.toString();
	}

	private String representationCellule(Set<Point> vivantes, Point position) {
		return vivantes.contains(position) ? VIVANTE : MORTE;
	}

	private final Console console;
}
