package fichier;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.google.common.io.Files;

import modeleDuDomaine.Generation;
import outil.Point;

public class FichierVersGeneration {

	public FichierVersGeneration(String chemin) {
		this.chemin = chemin;
	}

	public Generation lisGeneration() {
		List<Point> points = new ArrayList<Point>();
		List<String> lignes = lignes();
		for (int j = 0; j < lignes.size(); j++) {
			String ligne = lignes.get(j);
			for (int i = 0; i < ligne.length(); i++) {
				if (celluleVivante(ligne, i)) {
					points.add(new Point(i, j));
				}
			}
		}
		return new Generation(points);
	}

	private boolean celluleVivante(String ligne, int i) {
		return ligne.charAt(i) == 'x';
	}

	private List<String> lignes() {
		try {
			return Files.readLines(new File(chemin), Charset.defaultCharset());

		} catch (Exception e) {
			throw new IllegalArgumentException("Chemin invalide : " + chemin, e);
		}
	}

	private final String chemin;
}
