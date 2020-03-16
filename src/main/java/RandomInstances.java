import java.util.Random;

public class RandomInstances {
    Partition left;
    Partition right;

    public RandomInstances() {
        left = new Partition();
        right = new Partition();
    }

    /**
     * Metoda createInstances adauga elemente in partitiile
     * left si right ale obiectului curent.
     */

    public void createInstances()
    {
        Random rand = new Random();

        int numberOfElements = rand.nextInt(10);
            for(int i = 0; i <= numberOfElements; i++)
            {
                Element element = new Element();
                element.randomElement();
               if (rand.nextInt(100)%2==0){
                    left.add(element);
                }
                else {
                    right.add(element);
                }

            }
            addPreferences();
    }

    /**
     * Metoda addPreferances adauga elemente in listele de
     * preferinte a elementelor din partitiile left si right.
     */

    private void addPreferences()
    {
        Random rand = new Random();
        for (Element leftElement:left.getPartition())
        {
            leftElement.preferences.add(right.getPartition().get(rand.nextInt(right.getPartition().size())));
        }
        for (Element rightElement:right.getPartition())
        {
            rightElement.preferences.add(left.getPartition().get(rand.nextInt(left.getPartition().size())));
        }
    }

    @Override
    public String toString() {
        return "RandomInstances{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
