import org.testng.annotations.DataProvider;

public class DataProviderCredentials {

    @DataProvider(name = "incorrectCredentials")
    public Object[][] provideIncorrectCredentials() {
        return new Object[][]{
                {"Yevhenii.Ustenko@testpro.io", ""},
                {"", "Fantazer120393!"},
                {"Yevhenii@testpro.io", "Fantazer120393!"},
                {"Yevhenii.Ustenko@testpro.io", "Fantazer93!"},
                {"Yevhenii@testpro.io", "Fantazer93!"},

        };
    }
}
