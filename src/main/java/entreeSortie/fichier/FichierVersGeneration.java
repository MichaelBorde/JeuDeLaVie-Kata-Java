package entreeSortie.fichier;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.io.Files;

import entreeSortie.RepresentationCellule;
import modeleDuDomaine.Generation;
import outil.Point;

public class FichierVersGeneration {

	public FichierVersGeneration(String chemin) {
		this.chemin = chemin;
	}

	public Generation lisGeneration() {
		List<Point> points = Lists.newArrayList();
		List<String> lignes = lisLignes();
		for (int y = 0; y < lignes.size(); y++) {
			points.addAll(creePointsSurLaLigne(lignes.get(y), y));
		}
		return new Generation(points);
	}

	private List<Point> creePointsSurLaLigne(String ligne, int j) {
		List<Point> resultat = Lists.newArrayList();
		for (int i = 0; i < ligne.length(); i++) {
			resultat.addAll(creeCelluleVivanteOuCollectionVide(new Point(i, j), ligne.charAt(i)));
		}
		return resultat;
	}

	private List<Point> creeCelluleVivanteOuCollectionVide(Point point, char representation) {
		if (celluleVivante(representation)) {
			return Lists.newArrayList(point);
		}
		return Lists.newArrayList();
	}

	private boolean celluleVivante(char representation) {
		return String.valueOf(representation).equals(RepresentationCellule.VIVANTE);
	}

	private List<String> lisLignes() {
		try {
			return Files.readLines(new File(chemin), Charset.defaultCharset());
		} catch (Exception e) {
			throw new IllegalArgumentException("Chemin invalide : " + chemin, e);
		}
	}

	private final String chemin;
}
