package fichier;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

import com.google.common.io.Files;

import corps.Corps;

public class FichierVersCorps {

	public FichierVersCorps(String chemin) {
		this.chemin = chemin;
	}

	public Corps lisCorps() {
		Corps corps = new Corps();
		List<String> lignes = lignes();
		for (int j = 0; j < lignes.size(); j++) {
			String ligne = lignes.get(j);
			for (int i = 0; i < ligne.length(); i++) {
				corps.ajouteCellule(i, j, ligne.charAt(i) == 'x');
			}
		}
		return corps;
	}

	private List<String> lignes() {
		try {
			return Files.readLines(new File(chemin), Charset.defaultCharset());

		} catch (Exception e) {
			throw new IllegalArgumentException("Chemin invalide : " + chemin, e);
		}
	}

	private String chemin;
}
