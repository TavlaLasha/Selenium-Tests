import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class executed");
    }

    @Test(dataProvider = "dataMethod")
    public void testMethod(String param) {
        System.out.println("The parameter value is: " + param);
    }

    @DataProvider
    public Object[][] dataMethod() {
        return new Object[][] { { "one" }, { "two" } };
    }


    @DataProvider (name = "data-provider2")
    public Object[][] dpMethod (){
        return new Object[][] {{2, 3 , 5}, {5, 7, 9}};
    }

    @Test (dataProvider = "data-provider2")
    public void Sum (int a, int b, int c) {
        int sum = a + b + c;
        System.out.println("Sum is: " + sum);
    }
}
