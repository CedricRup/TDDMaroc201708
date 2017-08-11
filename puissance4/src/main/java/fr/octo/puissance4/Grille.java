package fr.octo.puissance4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grille {

    public static final int NOMBRE_LIGNE = 6;
    public static final int NOMBRE_COLONNE = 7;
    Map<Integer, List<CouleurPion>> grille = new HashMap<>();

    public Grille() {
        for (int key = 0; key < NOMBRE_COLONNE; key++) {
            List<CouleurPion> colonne = new ArrayList<>();
            for (int i = 0; i < NOMBRE_LIGNE; i++) {
                colonne.add(CouleurPion.Vide);
            }
            this.grille.put(key, colonne);
        }
    }

    public CouleurPion couleurCase(int colonne, int ligne) throws CaseInexistanteException {
        if (ligne >= NOMBRE_LIGNE || ligne < 0 || colonne >= NOMBRE_COLONNE || colonne < 0)
            throw new CaseInexistanteException();
        return grille.get(colonne).get(ligne);
    }

    public void insererPion(int colonne, CouleurPion couleurPion) throws ColonnePleineException {
        verifierColonne(colonne);
        verifierCouleur(couleurPion);
        inserer(colonne, couleurPion);
    }

    private void inserer(int colonne, CouleurPion couleurPion) throws ColonnePleineException {
        List<CouleurPion> colonnePourInserer = grille.get(colonne);
        int index = colonnePourInserer.indexOf(CouleurPion.Vide);
        if (index != -1) {
            colonnePourInserer.set(index, couleurPion);
        } else {
            throw new ColonnePleineException();
        }
    }

    private void verifierCouleur(CouleurPion couleurPion) {
        if (couleurPion == CouleurPion.Vide) {
            throw new IllegalArgumentException();
        }
    }

    private void verifierColonne(int colonne) {
        if (colonne >= NOMBRE_COLONNE || colonne < 0) {
            throw new ColonneInexistanteException();
        }
    }
}
