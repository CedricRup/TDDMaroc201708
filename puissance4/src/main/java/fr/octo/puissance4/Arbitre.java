package fr.octo.puissance4;

public class Arbitre {


    private CouleurPion couleurActuelle;
    private Grille grille;
    private Analyseur analyseur;

    public Arbitre(Grille grille, Analyseur analyseur) {
        this.grille = grille;
        this.analyseur = analyseur;
        couleurActuelle = CouleurPion.Jaune;
    }

    public CouleurPion aQuiLeTour() {
        return couleurActuelle;
    }

    public void accepterCoup(int colonne) {
        try {
            grille.insererPion(colonne, couleurActuelle);
            changerJoueur();
        } catch (ColonneInexistanteException | ColonnePleineException e) {
        }
    }

    private void changerJoueur() {
        if (CouleurPion.Jaune.equals(couleurActuelle)) {
            couleurActuelle = CouleurPion.Rouge;
        } else {
            couleurActuelle = CouleurPion.Jaune;
        }
    }

    public CouleurGagnant etatDuJeu() throws CaseInexistanteException {
        return analyseur.gagnant(this.grille);
    }
}
