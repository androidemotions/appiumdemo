package tests;

import objects.Emotions;
import objects.KeeperScreen;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import framework.DriverSetup;

public class KeeperTest extends DriverSetup {

    KeeperScreen keep;

    @BeforeClass
    public void startTest() {
	keep = new KeeperScreen(setUp("ANDROID"));
    }

    @Test(dataProvider = "emotions")
    @Features("Buttons")
    @Stories("Click buttons")
    public void testGreenResults(Emotions emo) {
	keep.clickButton(emo);
	keep.verifyTextResult(emo);
    }

    @AfterClass
    public void finishTest() {
	shutDown();
    }

    @DataProvider(name = "emotions")
    public Object[][] emotionsData() {
	
	return new Object[][] { {Emotions.ANGRY}, {Emotions.SATISFY}, {Emotions.GOOD}, {Emotions.HAPPY} };
    }

}
