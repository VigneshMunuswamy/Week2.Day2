package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtons {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/radio.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.id("yes")).click();
		System.out.println("First question is answered");

		boolean option1 = driver.findElement(By.xpath("//input[@name=\"news\" and @value=\"0\"]")).isSelected();
		boolean option2 = driver.findElement(By.xpath("//input[@name=\"news\" and @value=\"1\"]")).isSelected();


		if (option1 == true)
			System.out.println("The First option \"UnChecked\" is selected by default ");
		if (option2 == true)
			System.out.println("The Second option \"Checked\" is selected by default ");
		else
			System.out.println("No option is selected");

		boolean ageRadio1 = driver.findElement(By.xpath("//input[@name=\"age\" and @value=\"0\"]")).isSelected();
		boolean ageRadio2 = driver.findElement(By.xpath("//input[@name=\"age\" and @value=\"1\"]")).isSelected();
		boolean ageRadio3 = driver.findElement(By.xpath("//input[@name=\"age\" and @value=\"2\"]")).isSelected();

		int age = 20;

		if (ageRadio1 == false && ageRadio2 == false && ageRadio3 == false)
		{
			if (age >= 20) {
				driver.findElement(By.xpath("//input[@name=\"age\" and @value=\"0\"]")).click();
				System.out.println("First option is selected");
			}
			if (age >= 21 && age>=40) {
				driver.findElement(By.xpath("//input[@name=\"age\" and @value=\"1\"]")).click();
				System.out.println(" 21 - 40 age option is selected");
			}
			else
				driver.findElement(By.xpath("//input[@name=\"age\" and @value=\"2\"]")).click();
				System.out.println("Above 40 age option is selected");
		}
		else {
			if (ageRadio1 == true)
				System.out.println("1 - 19 age group is already selected");
			if (ageRadio2 == true)
				System.out.println("21 - 40 age group is already selected");
			else
				System.out.println("Above age group is already selected");
		}
			
		driver.close();
	}
	
	
}
