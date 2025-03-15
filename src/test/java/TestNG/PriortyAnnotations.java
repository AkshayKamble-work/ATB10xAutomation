package TestNG;

import org.testng.annotations.Test;

public class PriortyAnnotations {

    @Test(priority = 2)
    public void testB() {
        System.out.println("Test B executed");
    }

    @Test(priority = 1)
    public void testA() {
        System.out.println("Test A executed");
    }

    @Test(priority = 3)
    public void testC() {
        System.out.println("Test C executed");
    }

    @Test (priority = -1)
    public void NegativeTest()
    {
        System.out.println("I negevtive am Test i execute first ");
    }
}
