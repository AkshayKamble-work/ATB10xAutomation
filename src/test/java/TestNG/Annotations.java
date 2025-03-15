package TestNG;

import org.testng.annotations.*;

public class Annotations {
@BeforeSuite
    public void Setup()
    {
        System.out.println("Before Suite --> Set up ");
    }

    @BeforeTest
    public void URl()
    {
        System.out.println("Before Test --> URl");
    }
    @BeforeClass
    public void LaunchBrowser()
    {
        System.out.println("Before class --> Browser Launch");

    }
    @BeforeMethod
    public void LoginApplication()
    {
        System.out.println("Before Method --> login into application");
    }
    @Test
    public void MyTest()
    {
        System.out.println("My Test Method ---> Test Method");
    }


    @AfterMethod
    public void logoutApplication()
    {
        System.out.println("After method --> logout application");
    }
    @AfterClass
    public void closeBrowser()
    {
        System.out.println("After Class -->Application is closed");
    }

    @AfterTest
    public void deletecockies()

    {
        System.out.println("After Test --> Delete Alll cocokies  ");
    }

}
