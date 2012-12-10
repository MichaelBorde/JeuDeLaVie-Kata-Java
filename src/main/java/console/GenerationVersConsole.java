package console;

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
		for (int j = 0; j < taille; j++) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < taille; i++) {
				builder.append(vivantes.contains(new Point(i, j)) ? "x" : ".");
			}
			console.ecris(builder.toString());
		}
	}

	private final Console console;
}
