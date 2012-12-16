import java.io.IOException;

import com.google.inject.Guice;
import com.google.inject.Injector;

import entreeSortie.console.Console;
import entreeSortie.console.GenerationVersConsole;
import entreeSortie.fichier.FichierVersGeneration;
import modeleDuDomaine.Generation;

public class Programme {

	public static void main(String[] args) throws IOException, InterruptedException {

		Generation generation = lisGraine();
		GenerationVersConsole generationVersConsole = creeGenerationVersConsole();
		for (int i = 0; i < 30; i++) {
			afficheGeneration(generation, generationVersConsole, i);
			Thread.sleep(1000);
			generation = generation.creeSuivante();
		}
	}

	private static void afficheGeneration(Generation generation, GenerationVersConsole generationVersConsole, int i) {
		creeConsole().ecris("Génération : " + i);
		generationVersConsole.ecris(generation, 20);
	}

	private static GenerationVersConsole creeGenerationVersConsole() {
		return injecteur.getInstance(GenerationVersConsole.class);
	}

	private static Console creeConsole() {
		return injecteur.getInstance(Console.class);
	}

	private static Generation lisGraine() {
		FichierVersGeneration fichierVersGeneration = new FichierVersGeneration("src/main/resources/planeur.txt");
		return fichierVersGeneration.lisGeneration();
	}

	private static final Injector injecteur = Guice.createInjector(new ModuleJeu());
}
