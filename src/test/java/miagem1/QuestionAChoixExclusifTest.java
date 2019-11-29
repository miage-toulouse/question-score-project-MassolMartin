package miagem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionAChoixExclusifTest {

    private QuestionAChoixExclusif uneQuestion;
    @Before
    public void setUp() throws Exception {
        QuestionAChoixExclusif QACE = new QuestionAChoixExclusif("Un énoncé",2);
        uneQuestion = QACE;

    }

    @Test
    public void testgetEnonce() {
        //when : on demande l'énoncé à la question
        String enonce = uneQuestion.getEnonce();
        //then : l'énoncé est non null
        assertNotNull(enonce);
        // and : l'énoncé est bien celui fourni dans la cnstruction
        assertEquals(enonce,"Un énoncé");

    }

    @Test
    public void testGetScoreForIndice() {
        //when : un étudiant fourni la bonne réponse correspondant à la bonne réponse
        int indiceEtudiant = 2;
        // and : on demande le calcul du score
        Float resScore = uneQuestion.getScoreForIndice(indiceEtudiant);
        //then : le score obtenu est de 100
        assertEquals(new Float(100f), resScore);
        // when : un étudiant fourni l'indice correspondant à une mauvaise réponse
        indiceEtudiant = 3;
        // and : on demande le calcul du score
        resScore = uneQuestion.getScoreForIndice(indiceEtudiant);
        //then : le score obtenu est de 0
        assertEquals(new Float(0f), resScore);
    }
}