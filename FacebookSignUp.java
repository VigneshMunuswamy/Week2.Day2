package week2.day2;

	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class FacebookSignUp {

		public static void main(String[] args) throws InterruptedException {

			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();

			driver.get("https://en-gb.facebook.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			WebElement Facebook = driver.findElement(By.linkText("Create New Account"));
			Facebook.click();
			driver.findElement(By.name("firstname")).sendKeys("Test");
			driver.findElement(By.name("lastname")).sendKeys("User");
			driver.findElement(By.name("reg_email__")).sendKeys("8877887@gmail.com");
			driver.findElement(By.id("password_step_input")).sendKeys("Test123#");
			WebElement elem1 = driver.findElement(By.xpath("//select[@id='day' and @name='birthday_day']"));
			Select brday1 = new Select(elem1);
			brday1.selectByValue("26");
			WebElement elem2 = driver.findElement(By.xpath("//select[@id='month' and @name='birthday_month']"));
			Select brmon = new Select(elem2);
			brmon.selectByValue("10");
			WebElement elem3 = driver.findElement(By.xpath("//select[@id='year' and @name='birthday_year']"));
			Select byear = new Select(elem3);
			byear.selectByValue("1997");
			driver.findElement(By.xpath("//input[@value='2' and @name='sex']")).click();
			System.out.println("Completed");
		}
}
