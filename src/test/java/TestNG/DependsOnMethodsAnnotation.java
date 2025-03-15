package TestNG;

import org.testng.annotations.Test;

public class DependsOnMethodsAnnotation {

    @Test
    public void login() {
        System.out.println("Login Test Executed");
    }

    @Test(dependsOnMethods = {"login"})
    public void dashboard() {
        System.out.println("Dashboard Test Executed");
    }

    @Test
    public void stepOne() {
        System.out.println("Step 1 executed");
    }

    @Test
    public void stepTwo() {
        System.out.println("Step 2 executed");
    }

    @Test(dependsOnMethods = {"stepOne", "stepTwo"})
    public void finalStep() {
        System.out.println("Final Step executed");
    }
}
