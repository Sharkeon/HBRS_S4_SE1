import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class sequenceTest {

    sequence test1, test2, test3, test4;
    @BeforeEach
    void setup() {
        test1 = new sequence(new String[][]{{ "A" , "C" }, { "C", "D" }, { "B", "C" }});
        test2 = new sequence(new String[][]{{ "A" , "B" }, { "B", "C" }, { "C", "D" }});
        test3 = new sequence(new String[][]{{ "A" , "C" }, { "C", "D" }, { "B", "C" }});
        test4 = new sequence(new String[][]{{ "A" , "B" }, { "B", "C" }});
    }
    
    @Test
    @DisplayName("Korekkte Sequenzen werden akzeptiert")
    void korekkteSequenz_korekkteSequenz_True() {
        assertTrue(test1.korrekteSequenz(new String[]{ "D" , "C", "B", "A" }));
    }
    @Test
    @DisplayName("Sequenzen mit doppeltem Inhalt werden nicht akzeptiert")
    void korekkteSequenz_doppelteSequenz_False() {
        assertFalse(test1.korrekteSequenz(new String[]{ "D" , "D", "B", "A" }));
    }
    
    @Test
    @DisplayName("Leere Sequenzen sind nicht well Sorted")
    void isWellSorted_leereSequenz_False() {
    	assertFalse(test1.isWellSorted(new String[]{}));
    }
    
    @Test
    @DisplayName("Sequenzen mit Buchstaben, die nicht in den Abhängigkeiten auftauchen, werden korrekt behandelt")
    void isWellSorted_falscherBuchstabe_entsprechendDerAbh() {
    	assertTrue(test1.isWellSorted(new String[]{"A","G"}));
    	assertFalse(test1.isWellSorted(new String[]{"G","C"}));
    }
    
    @Test
    @DisplayName("Sequenzen mit Buchstaben, die nicht in den Abhängigkeiten auftauchen, werden korrekt behandelt")
    void isWellSorted_einfacheAbh_entsprechendDerAbh() {
    	assertTrue(test2.isWellSorted(new String[]{"A","B","C","D"}));
    	assertFalse(test3.isWellSorted(new String[]{"G","A","B","C","D"}));
    }
    
    @Test
    @DisplayName("Transitive Abhängigkeiten werden korrekt behandelt")
    void isWellSorted_transitiveAbh_entsprechendDerAbh() {
    	assertFalse(test4.isWellSorted(new String[]{"C","A"}));
    	assertFalse(test4.isWellSorted(new String[]{"B","C"}));
    	assertFalse(test4.isWellSorted(new String[]{"A","C"}));
    	assertTrue(test4.isWellSorted(new String[]{"A","B","C"}));
    }
    
    
    
    @Test
    @DisplayName("Teste verschiedene Szenarien für isWellSorted()")
    void isWellSorted() {
        assertTrue(test1.isWellSorted(new String[]{"A","B","C","D"}));
        assertFalse(test2.isWellSorted(new String[]{"A","C","D"}));
    }
}