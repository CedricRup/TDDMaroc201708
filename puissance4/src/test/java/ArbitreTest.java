import fr.octo.puissance4.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArbitreTest {

    private Analyseur analyseur;
    private Grille grille;
    private Arbitre arbitre;

    @Before
    public void init() {
        analyseur = mock(Analyseur.class);
        grille = new Grille();
        arbitre = new Arbitre(grille, analyseur);
    }

    @Test
    public void au_debut_jaune_doit_jouer() {
        assertEquals(CouleurPion.Jaune, arbitre.aQuiLeTour());
    }

    @Test
    public void quand_jaune_a_joue_rouge_doit_jouer() throws ColonnePleineException {
        arbitre.accepterCoup(0);
        assertEquals(CouleurPion.Rouge, arbitre.aQuiLeTour());
    }

    @Test
    public void quand_rouge_a_joue_jaune_doit_jouer() throws ColonnePleineException {
        arbitre.accepterCoup(0);
        arbitre.accepterCoup(0);
        assertEquals(CouleurPion.Jaune, arbitre.aQuiLeTour());
    }

    @Test
    public void quand_jaune_joue_on_insere_un_pion() throws CaseInexistanteException, ColonnePleineException {
        arbitre.accepterCoup(0);
        assertEquals(CouleurPion.Jaune, grille.couleurCase(0, 0));
    }


    @Test
    public void quand_le_coup_non_valide_le_meme_joueur_doit_rejouer() throws CaseInexistanteException, ColonnePleineException {
        arbitre.accepterCoup(-1);
        assertEquals(CouleurPion.Jaune, arbitre.aQuiLeTour());
    }

    @Test
    public void quand_le_partie_est_nulle_arbitre_dit_qu_elle_est_nulle() throws CaseInexistanteException {
        when(analyseur.gagnant(any())).thenReturn(CouleurGagnant.MatchNul);

        assertEquals(CouleurGagnant.MatchNul, arbitre.etatDuJeu());
    }

    @Test
    public void quand_un_joueur_gagne_arbitre_dit_qu_il_gagne() throws CaseInexistanteException {
        when(analyseur.gagnant(any())).thenReturn(CouleurGagnant.Rouge);

        assertEquals(CouleurGagnant.Rouge, arbitre.etatDuJeu());
    }


}
