public class Abhaengigkeit implements AbhaengigkeitIF {
    String[][] abh;
    Abhaengigkeit(String[][] str){
        this.abh = str;
    }
    @Override
    public boolean isWellSorted(String[] sequence) {
        return false;
    }
}
