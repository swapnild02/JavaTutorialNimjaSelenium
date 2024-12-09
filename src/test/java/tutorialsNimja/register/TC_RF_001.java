package tutorialsNimja.register;


import java.time.Duration;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_001 {
		

	@Test
	public  void verifyRegisterWithMandatoryField() {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		WebElement clickOnMyAccount=driver.findElement(By.xpath("//ul[@class='list-inline']/child::li/child::a[@title='My Account']"));
		clickOnMyAccount.click();
		WebElement clickOnRegister=driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/child::li/child::a[contains(text(),'Register')]"));
		clickOnRegister.click();
		
		WebElement fill_firstname=driver.findElement(By.xpath("//input[@id='input-firstname']"));
		fill_firstname.sendKeys("swapnil");
		
		WebElement fill_lasttname=driver.findElement(By.xpath("//input[@id='input-lastname']"));
		fill_lasttname.sendKeys("1234");
		WebElement fill_Email=driver.findElement(By.xpath("//input[@id='input-email']"));
		fill_Email.sendKeys(generate_email());
		WebElement fill_tetephone=driver.findElement(By.xpath("//input[@id='input-telephone']"));
		fill_tetephone.sendKeys("8765786548");
		WebElement fill_password=driver.findElement(By.xpath("//input[@id='input-password']"));
		fill_password.sendKeys("1234");
		WebElement fill_confirmpassword=driver.findElement(By.xpath("//input[@id='input-confirm']"));
		fill_confirmpassword.sendKeys("1234");
		WebElement fill_privacyPolocy=driver.findElement(By.xpath("//input[@type='checkbox' and @value='1']"));
		fill_privacyPolocy.click();
		WebElement clickOnContinueButton=driver.findElement(By.xpath("//input[@type='submit' and @value='Continue']"));
		clickOnContinueButton.click();
		WebElement logout_Links=driver.findElement(By.linkText("Logout"));
		String currentURL=driver.getCurrentUrl();
		System.out.print(currentURL);
		boolean isavailable= logout_Links.isDisplayed();
		System.out.println("Isavailable :- "+isavailable);
		Assert.assertTrue(isavailable);
		String expected_text="Your Account Has Been Created!";
		System.out.println("Expected Text is :-"+expected_text);
		WebElement checkText=driver.findElement(By.xpath("//div[@id='content']//h1"));
		System.out.print("Actual Text is :-"+checkText.getText());
		Assert.assertEquals(checkText.getText(), expected_text);
		String properDatailsOne="";
		
		driver.quit();
		

	}
	
	private String generate_email()
	{
		Date date=new Date();
		String stringDate=date.toString();
		String noSpacedate=stringDate.replace(" ","");
		String noSpacecolondate=noSpacedate.replace(":","");
		String finalemail=noSpacecolondate+"@gmail.com";
		return finalemail;
	}

}
