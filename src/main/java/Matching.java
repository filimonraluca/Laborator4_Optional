import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Matching {
    Map<Element, List<Element>> lr = new HashMap<>();
    Map<Element, List<Element>> rl = new HashMap<>();

    public void add(Element l, Element r) {
        if (!lr.containsKey(l)) {
            lr.put(l, new ArrayList<>());
        }
        lr.get(l).add(r);
        if (!rl.containsKey(r)) {
            rl.put(r, new ArrayList<>());
        }
        rl.get(r).add(l);
    }

    public Matching(Partition residents, Partition hospitals) {
        for (Element resident : residents.getPartition()) {
            for (Element hospital : resident.getPreferences()) {
                if (hospital.getCapacity() > 0) {
                    add(resident, hospital);
                    hospital.minusCapacity();
                    resident.minusCapacity();
                    if (resident.getCapacity() <= 0) {
                        break;
                    }
                }
            }
        }
    }

    boolean isStable(Element left, Element right) {
        for (Element preferredOverRight : left.getPreferencesBefore(right)) {
            List<Element> matchedWith = rl.get(preferredOverRight);
            for (Element prevMatch : matchedWith) {
                if (preferredOverRight.prefersFirstBetter(left, prevMatch)) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isStable() {
        for (Element h : lr.keySet()) {
            for (Element r : lr.get(h))
                if (!isStable(h, r)) {
                    return false;
                }
        }
        return true;
    }

    public Map<Element, List<Element>> getMatching() {
        return lr;
    }

    @Override
    public String toString() {
        return "Matching{" +
                "matching=" + lr +
                '}';
    }
}
