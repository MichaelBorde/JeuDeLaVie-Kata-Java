package modeleDuDomaine;

import java.util.List;

import com.google.common.collect.Lists;

import outil.Fonction;

public enum EtatCellule {
	VIVANTE {
		@Override
		public List<Cellule> ajouteToiAuxVivantes(Cellule cellule, List<Cellule> vivantes) {
			List<Cellule> cellules = Lists.newArrayList(vivantes);
			cellules.add(cellule);
			return cellules;
		}

		@Override
		public void prendsPartALEvolution(Fonction siVivante) {
			siVivante.appelle();
		}

		@Override
		protected boolean capableDeSurvivre(int voisinesVivantes) {
			return voisinesVivantes >= 2 && voisinesVivantes <= 3;
		}
	},
	MORTE {
		@Override
		public List<Cellule> ajouteToiAuxVivantes(Cellule cellule, List<Cellule> vivantes) {
			return Lists.newArrayList(vivantes);
		}

		@Override
		public void prendsPartALEvolution(Fonction siVivante) {
		}

		@Override
		protected boolean capableDeSurvivre(int voisinesVivantes) {
			return voisinesVivantes == 3;
		}
	};

	public abstract void prendsPartALEvolution(Fonction siVivante);

	public Cellule creeCelluleEvoluee(int nombreVoisinesVivantes) {
		if (capableDeSurvivre(nombreVoisinesVivantes)) {
			return Cellule.creeVivante();
		}
		return Cellule.creeMorte();
	}

	protected abstract boolean capableDeSurvivre(int voisinesVivantes);

	public abstract List<Cellule> ajouteToiAuxVivantes(Cellule cellule, List<Cellule> vivantes);
}
