package fr.octo.puissance4;

public class Analyseur {
    public CouleurGagnant gagnant(Grille grille) throws CaseInexistanteException {
        for (int colonneDepart = 0; colonneDepart < Grille.NOMBRE_COLONNE; colonneDepart++) {
            for (int ligneDepart = 0; ligneDepart < 3; ligneDepart++) {
                CouleurGagnant gagnantPourCaseDepart = recupererGagnant(grille, ligneDepart, colonneDepart);
                if (gagnantPourCaseDepart != CouleurGagnant.PasDeGagnant) {
                    return gagnantPourCaseDepart;
                }
            }
        }
        return CouleurGagnant.PasDeGagnant;
    }

    private CouleurGagnant recupererGagnant(Grille grille, int ligneDepart, int colonneDepart) throws CaseInexistanteException {
        CouleurPion couleurPremiereLigne = grille.couleurCase(colonneDepart, ligneDepart);
        CouleurGagnant couleurGagnant = convertirEnCouleurGagnant(couleurPremiereLigne);

        for (int ligne = ligneDepart + 1; ligne < ligneDepart + 4; ligne++) {
            if (couleurPremiereLigne != grille.couleurCase(colonneDepart, ligne)) {
                couleurGagnant = CouleurGagnant.PasDeGagnant;
            }
        }
        return couleurGagnant;
    }

    private CouleurGagnant convertirEnCouleurGagnant(CouleurPion couleurPremiereLigne) {
        switch (couleurPremiereLigne) {
            case Rouge:
                return CouleurGagnant.Rouge;
            case Jaune:
                return CouleurGagnant.Jaune;
            default:
                return CouleurGagnant.PasDeGagnant;
        }
    }
}
