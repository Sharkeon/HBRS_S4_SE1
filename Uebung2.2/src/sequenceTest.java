import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class sequenceTest {

    sequence test1, test2, test3;
    @BeforeEach
    void setup() {
        test1 = new sequence(new String[][]{{ "A" , "C" }, { "C", "D" }, { "B", "C" }});
        test2 = new sequence(new String[][]{{ "A" , "B" }, { "B", "C" }, { "C", "D" }});
        test3 = new sequence(new String[][]{{ "A" , "C" }, { "C", "D" }, { "B", "C" }});
    }
    @Description("Teste verschiedene Szenarien für korekkteSequenz()")
    @org.junit.jupiter.api.Test
    void korekkteSequenz() {
        assertTrue(test1.korekkteSequenz(new String[]{ "D" , "C", "B", "A" }));
        assertFalse(test1.korekkteSequenz(new String[]{ "D" , "D", "B", "A" }));
    }
    @Description("Teste verschiedene Szenarien für isWellSorted()")
    @org.junit.jupiter.api.Test
    void isWellSorted() {
        assertTrue(test1.isWellSorted(new String[]{"A","B","C","D"}));
        assertFalse(test2.isWellSorted(new String[]{"A","C","D"}));
    }
}