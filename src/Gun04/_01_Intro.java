package Gun04;

import org.testng.annotations.*;

public class _01_Intro {


    /*
    @BeforeSuite
        @BeforeTest
            @BeforeGroup
                @BeforeClass
                    @BeforeMethod
                        @Test
                        @Test
                    @BeforeMethod
                @BeforeClass
            @BeforeGroup
        @BeforeTest
    @BeforeSuite
     */


    @BeforeSuite
    void bSuite(){System.out.println("Before Suite");}
    @BeforeTest
    void bTest(){System.out.println("Before Test");}
    @BeforeGroups
    void bGroup(){System.out.println("Before Group");}
    @BeforeClass
    void bClass(){System.out.println("Before Class");}
    @BeforeMethod
    void bMethod(){System.out.println("Before Method");}

    @Test
    void testIntro1_1(){System.out.println("Test Intro 1");}
    @Test
    void testIntro1_2(){System.out.println("Test Intro 2");}




    @AfterSuite
    void aSuite(){System.out.println("After Suite");}
    @AfterTest
    void aTest(){System.out.println("After Test");}
    @AfterGroups
    void aGroup(){System.out.println("After Group");}
    @AfterClass
    void aClass(){System.out.println("After Class");}
    @AfterMethod
    void aMethod(){System.out.println("After Method");}




}
