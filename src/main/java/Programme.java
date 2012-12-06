import java.io.IOException;

import com.google.inject.Guice;
import com.google.inject.Injector;

import console.Console;
import console.CorpsVersConsole;
import corps.Corps;
import fichier.FichierVersCorps;

public class Programme {

	public static void main(String[] args) throws IOException, InterruptedException {
		Corps corps = corpsInitial();
		CorpsVersConsole corpsVersConsole = corpsVersConsole();
		for (int i = 0; i < 30; i++) {
			afficheGeneration(corps, corpsVersConsole, i);
			Thread.sleep(1000);
			corps = corps.suivant();
		}
	}

	private static void afficheGeneration(Corps corps, CorpsVersConsole corpsVersConsole, int i) {
		console().ecris("Génération : " + i);
		corpsVersConsole.ecris(corps, 20);
	}

	private static CorpsVersConsole corpsVersConsole() {
		return injecteur.getInstance(CorpsVersConsole.class);
	}

	private static Console console() {
		return injecteur.getInstance(Console.class);
	}

	private static Corps corpsInitial() {
		FichierVersCorps fichierVersCorps = new FichierVersCorps("src/main/resources/feu.txt");
		return fichierVersCorps.lisCorps();
	}

	private static Injector injecteur = Guice.createInjector(new ModuleJeu());
}
