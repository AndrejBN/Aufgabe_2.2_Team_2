public class Abhaengigkeit implements AbhaengigkeitIF {
    String[][] dependencies;
    Abhaengigkeit(String[][] str){
        this.dependencies = str;
    }
    @Override
    public boolean isWellSorted(String[] sequence) {
        for (int i = 0; i < sequence.length; ++i) {
            for (String[] dependency : dependencies) {
                if (dependency[1].equals(sequence[i])) {
                    boolean isDone = false;
                    for (int j = 0; j < i; ++j) {
                        if (sequence[i].equals(sequence[j])) {
                            throw new IllegalArgumentException("Aufgaben dürfen nur einmal abgearbeitet werden.");
                        }
                        if (sequence[j].equals(dependency[0])) {
                            isDone = true;
                        }
                    }
                    if (!isDone) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}