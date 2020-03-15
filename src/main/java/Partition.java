import java.util.ArrayList;
import java.util.List;

public class Partition {
    List<Element> partition = new ArrayList<>();

    public Partition() {
    }

    public Partition(List<Element> partition) {
        this.partition = partition;
    }

    public List<Element> getPartition() {
        return partition;
    }

    public void add(Element e)
    {
        partition.add(e);
    }
}
