package objects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class KeeperScreen extends HtmlElement {

    @FindBy(id = "com.ysparrow.emotionskeeper:id/button1")
    WebElement buttonAngry;
    
    @FindBy(id = "com.ysparrow.emotionskeeper:id/button2")
    WebElement buttonSatisfy;
   
    @FindBy(id = "com.ysparrow.emotionskeeper:id/button3")
    WebElement buttonGood;
    
    @FindBy(id = "com.ysparrow.emotionskeeper:id/button4")
    WebElement buttonHappy;

    @FindBy(id = "com.ysparrow.emotionskeeper:id/textView2")
    WebElement resultText;

    
    public KeeperScreen (WebDriver driver)
    {
	HtmlElementLoader.populatePageObject(this, driver);
    }
    
    @Step
    public void clickButton(Emotions emo) {
	switch (emo) {
	case ANGRY:
	    buttonAngry.click();
	    break;
	case SATISFY:
	    buttonSatisfy.click();
	    break;
	case GOOD:
	    buttonGood.click();
	    break;
	case HAPPY:
	    buttonHappy.click();
	    break;

	}

    }

    @Step
    public void verifyTextResult(Emotions emo) {
	assertEquals(resultText.getText(), "You are " + emo.toString());
    }

}
