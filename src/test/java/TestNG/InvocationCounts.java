package TestNG;

import org.testng.annotations.Test;

public class InvocationCounts {

    @Test(invocationCount = 3)
    public void repeatTest() {
        System.out.println("Test executed");
    }

    @Test
    public void setup() {
        System.out.println("Setup executed");
    }

    @Test(invocationCount = 3, dependsOnMethods = {"setup"})
    public void ReTest()
    {
        System.out.println("Repeated test executed");
    }
}
