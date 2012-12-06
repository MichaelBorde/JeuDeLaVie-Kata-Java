import java.io.IOException;

import com.google.inject.Guice;
import com.google.inject.Injector;

import console.CorpsVersConsole;
import corps.Corps;
import fichier.FichierVersCorps;

public class Programme {

	public static void main(String[] args) throws IOException {
		Corps corps = corpsInitial();
		CorpsVersConsole corpsVersConsole = corpsVersConsole();
		for (int i = 0; i < 10; i++) {
			afficheGeneration(corps, corpsVersConsole, i);
			demandeInterractionUtilisateur();
			corps = corps.suivant();
		}
	}

	private static void afficheGeneration(Corps corps, CorpsVersConsole corpsVersConsole, int i) {
		System.out.println("Génération : " + i);
		corpsVersConsole.ecris(corps);
		System.out.println("Appuyer sur entrée");
	}

	private static void demandeInterractionUtilisateur() throws IOException {
		//noinspection ResultOfMethodCallIgnored
		System.in.read();
	}

	private static CorpsVersConsole corpsVersConsole() {
		return injecteur.getInstance(CorpsVersConsole.class);
	}

	private static Corps corpsInitial() {
		FichierVersCorps fichierVersCorps = new FichierVersCorps("src/main/resources/feu.txt");
		return fichierVersCorps.lisCorps();
	}

	private static Injector injecteur = Guice.createInjector(new ModuleJeu());
}
