import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Matching {
    Map<Element, List<Element>> lr = new HashMap<>();
    Map<Element, List<Element>> rl = new HashMap<>();


    /**
     * Metoda adauga cele doua elemente (l, r)
     * la map-urile simetrice
     */

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

    /**
     * Constructorul realizeaza un maching intre cele doua partitii
     * Elementelor din stanga li se asociaza un element din dreapta in
     * ordinea preferintelor si tinand cont de capacitatea elementelor.
     */

    public Matching(Partition left, Partition right) {
        for (Element leftElement : left.getPartition()) {
            for (Element rightElement : leftElement.getPreferences()) {
                if (rightElement.getCapacity() > 0) {
                    add(leftElement, rightElement);
                    rightElement.minusCapacity();
                    leftElement.minusCapacity();
                    if (leftElement.getCapacity() <= 0) {
                        break;
                    }
                }
            }
        }
    }

    /**
     *  Metoda verifica daca cele 2 elemente left, right formeaza o pereche stabila
     */

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

    /**
     * Metoda trece prin toate elementele map-ului si se verifica
     * daca perechea (l,r) este stabila.
     */

    boolean isStable() {
        for (Element l : lr.keySet()) {
            for (Element r : lr.get(l))
                if (!isStable(l, r)) {
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
