package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenCart {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.opencart.com/index.php?route=account/register");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("Vignesh2610");
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Vignesh");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("M");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("Vignesh2610@gmail.com");
		WebElement ddele = driver.findElement(By.xpath("//select[@id='input-country']"));
		Select dd = new Select(ddele);
		dd.selectByIndex(98);
		Thread.sleep(3000);
		dd.selectByVisibleText("India");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("V@2610#co");
		
		System.out.println("The reCAPTCHA text is "+driver.findElement(By.xpath("//strong")).getText());
		
	}

}
