import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class AbhaengigkeitIFTest {

    String[] A;
    String[] B;
    String[] C;

    @BeforeEach
    void setUp() {
        A = new String[]{"A","B","C","D"};
        B = new String[]{"C", "B", "D", "A"};
        C = new String[]{"D", "D", "D"};
    }


    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Einfache Tests zu Beginn.")
    void isWellSorted() {
        Assertions.assertTrue(isWellSorted(A));
        Assertions.assertFalse(isWellSorted(B));
        Assertions.assertFalse(isWellSorted(C));
    }
}