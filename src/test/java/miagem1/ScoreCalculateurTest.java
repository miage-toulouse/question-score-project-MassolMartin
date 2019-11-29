package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ScoreCalculateurTest {

    private ScoreCalculateur scoreC;
    private QuestionAChoixMultiple questionAChoixMultiple;

    @Before
    public void setUp() throws Exception {
        scoreC = new ScoreCalculateur();
        questionAChoixMultiple = new QuestionAChoixMultiple("q1",new ArrayList<Integer>(Arrays.asList(2,3,5)));
    }

    @Test
    public void calculeScore() {
        // when : l'étudiant ne donne aucune bonne réponse
        ArrayList<Integer> listeReponses = new ArrayList<>(Arrays.asList(1,4));
        // Then : on teste le calcul du score
        Float score = scoreC.calculeScore(listeReponses,questionAChoixMultiple);
        assertEquals(0f,score,0.01f);

        // When : l'étudiant donne 2 bonnes réponses
        ArrayList<Integer> listeReponses2 = new ArrayList<>(Arrays.asList(2,3));
        // Then : on teste le calcul du score
        Float score2 = scoreC.calculeScore(listeReponses2,questionAChoixMultiple);
        assertEquals( 2*100/3f,score2,0.01f);

        // When : l'étudiant donne toutes les bonnes réponses
        ArrayList<Integer> listeReponses3 = new ArrayList<>(Arrays.asList(2,3,5));
        // Then : on teste le calcul du score
        Float score3 = scoreC.calculeScore(listeReponses3,questionAChoixMultiple);
        assertEquals( 100f,score3,0.01f);
    }
}