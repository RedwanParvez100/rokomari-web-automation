package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {

    @DataProvider(name = "invalidUserCredentials")
    public static Object invalidCredentials(){

        Object[][] data = {

                {"feciwe6718@anlocc.com", "Pass&Pas", "Your email or password is incorrect!", ""},
                {"feciwe6718@anlocc.co", "Pass&Pas", "Your email or password is incorrect!", ""},
                {"feciwe6718@anlo.com", "1234567Aa", "Your email or password is incorrect!", ""},
                {"", "", "", "Please fill out this field."},
                {"feciwe6718@anlo.com", "", "", "Please fill out this field."}

        };
        return data;
    }


    /*

    @DataProvider(name = "invalidUserCredentialsExp")
    public static Object[][] invalidCredentialstrail() {

        return new Object[][]{
                {"", "", "Please enter a valid email or phone number.", ""},
                {"userexample.com", "", "", "Invalid email! Please enter a valid email or phone number."}
//      {"feciwe6718@anlo.com", "1234567Aa", "Your email or password is incorrect!", ""},
//      {"", "", "", "Please fill out this field."},
//      {"feciwe6718@anlo.com", "", "", "Please fill out this field."}
        };
    }

     */


}
