import org.junit.jupiter.api.Test;

public class registerTest extends pageObjects.registerPageObjects {

    @Test
    public void FirstTest(){
        openWebsite();
        goToRegisterForm();
        fillRegisterForm("Dan","Smith",
                getRandomString()+"@gmail.com","Qwerty123$");
        checkRegisterSuccess();
    }

}
