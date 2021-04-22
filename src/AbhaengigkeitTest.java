import org.junit.jupiter.api.*;

class AbhaengigkeitTest {

    Abhaengigkeit sv1;
    Abhaengigkeit sv2;
    String[] Sr1;
    String[] Sr2;
    String[] Sr3;
    String[] Sr4;
    String[] Sr5;

    @BeforeEach
    void setUp() {
        sv1 = new Abhaengigkeit(new String[][]{{"A", "B"}, {"C", "D"}, {"E", "F"}});
        sv2 = new Abhaengigkeit(new String[][]{{"A", "B"}, {"D", "A"}, {"C", "E"}});
        Sr1 = new String[]{"A", "B", "C", "D", "E", "F"};
        Sr2 = new String[]{"F", "C", "B", "D", "E", "A"};
        Sr3 = new String[]{"C", "A", "B", "D", "E"};
        Sr4 = new String[]{"Z", "Y", "A", "B", "C", "G", "E", "F"};
        Sr5 = new String[]{"A", "A", "B", "C", "B", "G", "E", "F"};
    }

    @Test
    @DisplayName("Erlaubter Input ist gueltig")
    public void isWellSorted_ValidInput_IsAccepted() {
        Assertions.assertTrue(sv1.isWellSorted(Sr1));
    }

    @Test
    @DisplayName("Nicht erlaubte Sortierungen sollen ungueltig sein")
    public void isWellSorted_InvalidInput_IsRejected() {
        Assertions.assertFalse(sv1.isWellSorted(Sr2));
    }

    @Test
    @DisplayName("Werden transitive Abhängigkeiten abgedeckt?")
    public void isWellSorted_transDependency() {
        Assertions.assertFalse(sv2.isWellSorted(Sr3));
    }

    @Test
    @DisplayName("Ein Task ohne Abhaengigkeit kann immer ausgefuehrt werden")
    public void isWellSorted_NoDependencyTask() {
        Assertions.assertTrue(sv1.isWellSorted(Sr4));
    }

    @Test
    @DisplayName("Ein Task soll nur einmal abgearbeitet werden")
    public void isWellSorted_CanOnlyDoTaskOnce() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            sv1.isWellSorted(Sr5);
        });
    }
}