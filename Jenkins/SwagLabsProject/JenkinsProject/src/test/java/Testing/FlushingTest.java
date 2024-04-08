package Testing;

import Utlis.PageFactory;
import org.testng.annotations.AfterClass;

public class FlushingTest {

    @AfterClass
    public void TearDown() throws InterruptedException {
        PageFactory.quit();
    }
}
