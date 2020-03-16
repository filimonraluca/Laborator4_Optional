import java.util.Random;

public class Problem {
    Partition partition1;
    Partition partition2;

    public Problem(Partition partition1, Partition partition2) {
        this.partition1 = partition1;
        this.partition2 = partition2;
    }

    /**
     * Metoda getSolution determina un maching
     * intre cele 2 partitii folosind constructorul
     * clasei Maching.
     */

    public Matching getSolution()
    {
        Matching solution = new Matching(partition1,partition2);
        return solution;
    }

}
