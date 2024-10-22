package utilities;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
	
	@DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
            {"manish.test1@gmail.com", "Test_1234"},
            {"manish.test2@gmail.com", "Test_1234"}            
        };
    }

}
