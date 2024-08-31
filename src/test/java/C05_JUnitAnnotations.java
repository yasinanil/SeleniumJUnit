import org.junit.*;

public class C05_JUnitAnnotations {

    @Before
    public void setUp(){
        System.out.println("@Before");
    }

    @After
    public void tearDown(){
        System.out.println("@After");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("@BeforeClass");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("@AfterClass");
    }

    @Test
    public void test01(){
        System.out.println("Test 01");
    }

    @Test
    public void test02(){
        System.out.println("Test 02");
    }

    @Test @Ignore("This will run after the fix")
    public void test03(){
        System.out.println("Test 03");
    }

}
