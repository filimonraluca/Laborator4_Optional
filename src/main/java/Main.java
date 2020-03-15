
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String args[]) {

        Main app = new Main();

        Element h0 = new Element("H0", 1);
        Element h1 = new Element("H1", 2);
        Element h2 = new Element("H2", 2);

        Element r0 = new Element("R0");
        Element r1 = new Element("R1");
        Element r2 = new Element("R2");
        Element r3 = new Element("R3");

        h0.setPreferences(Arrays.asList(r3,r0,r1,r2));
        h1.setPreferences(Arrays.asList(r0,r2,r1));
        h2.setPreferences(Arrays.asList(r0,r1,r3));

        r0.setPreferences(Arrays.asList(h0,h1,h2));
        r1.setPreferences(Arrays.asList(h0,h1,h2));
        r2.setPreferences(Arrays.asList(h0,h1));
        r3.setPreferences(Arrays.asList(h0,h2));

        Partition hospitals= new Partition(Arrays.asList(h0,h1,h2));
        Partition residents = new Partition(Arrays.asList(r0,r1,r2,r3));
        Problem problem = new Problem(hospitals, residents);
        Matching solution = problem.getSolution();
        System.out.println(solution);
        System.out.println(solution.isStable());
        System.out.println("-------------------");
        app.testRandomInstance();

    }

    private void testRandomInstance()
    {
        RandomInstances randomInstance = new RandomInstances();
        randomInstance.createInstances();
        Problem test = new Problem(randomInstance.left,randomInstance.right);
        System.out.println(test.getSolution());
    }
}
