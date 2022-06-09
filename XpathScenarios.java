package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathScenarios {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//a[contains(@class,'decorative')]")).click();

		driver.findElement(By.xpath("//a[contains(@class,'CRM/SFA'")).click();
		driver.findElement(By.xpath("//a[contains(@class,'Leads']")).click();

		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Vignesh");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("M");
	


	}
}
