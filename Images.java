package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Images {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String mainUrl = driver.getCurrentUrl();
		
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/div/div/img")).click();
		System.out.println(driver.getTitle());
		driver.get(mainUrl);
		
		  boolean secondImg = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/img")).isEnabled();
		    if (secondImg==true)
		    	System.out.println("Image is broken");
		    else
		    	System.out.println("Image is not broken");

		    driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/div/div/img")).click();
		   System.out.println(driver.getTitle()); 
		   driver.close();
		
}
}