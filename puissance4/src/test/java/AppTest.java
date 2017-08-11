import fr.octo.puissance4.*;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class AppTest {


    private Arbitre arbitre;
    private IEcran ecran;
    private App app;
    private IClavier clavier;

    @Before
    public void init() {
        arbitre = mock(Arbitre.class);
        ecran = mock(IEcran.class);
        clavier = mock(IClavier.class);
        app = new App(ecran, arbitre, clavier);
        when(clavier.lire()).thenReturn("0");
    }

    @Test
    public void afficher_jaune_quand_jaune_doit_jouer() {
        when(arbitre.aQuiLeTour()).thenReturn(CouleurPion.Jaune);

        app.demarrer();
        verify(ecran).ecrireJoueurCourrant("Jaune");
    }

    @Test
    public void afficher_rouge_quand_rouge_doit_jouer() {
        when(arbitre.aQuiLeTour()).thenReturn(CouleurPion.Rouge);
        app.demarrer();
        verify(ecran).ecrireJoueurCourrant("Rouge");
    }

    @Test
    public void inserer_un_pion_dans_la_colonne_0_quand_le_joueur_saisit_0() {
        when(clavier.lire()).thenReturn("0");
        app.demarrer();
        verify(arbitre).accepterCoup(0);
    }

    @Test
    public void inserer_un_pion_dans_la_colonne_1_quand_le_joueur_saisit_1() {
        when(clavier.lire()).thenReturn("1");
        app.demarrer();
        verify(arbitre).accepterCoup(1);
    }
}
