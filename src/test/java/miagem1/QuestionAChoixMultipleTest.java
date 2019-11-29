package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QuestionAChoixMultipleTest {

    private QuestionAChoixMultiple QACM;
    private List<Integer> listeReponses = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        QACM = new QuestionAChoixMultiple("un enonce", listeReponses);
        this.listeReponses.add(2);
    }

    @Test
    public void testgetEnonce() {
        assertEquals("un enonce", QACM.getEnonce());
    }

    @Test
    public void testgetScoreForIndice() {
        // when : un étudiant fourni les bonnes réponses
        int indiceEtudiant = 2;
        // and : on demande le calcul du score
        Float resScore=QACM.getScoreForIndice(indiceEtudiant);
        // then : le score obtenu correspond bien aux score possibles
        assertEquals(new Float(100f), resScore);

        // when : un étudiant fourni une mauvaise réponse
        indiceEtudiant = 10;
        resScore = 0f;
        // and : on demande le calcul du score
        resScore=QACM.getScoreForIndice(indiceEtudiant);
        // then : le score obtenu correspond bien aux score possibles
        assertEquals(new Float(0f), resScore);

    }
}
