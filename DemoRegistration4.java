package org.utilities;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.collect.ImmutableCollection;

public class DemoRegistration4 extends BrowserLauch {
	
	public static void main(String[] args) throws AWTException, IOException {
		
		launchChrome();
		winmax();
		loadurl("https://demoqa.com/automation-practice-form");
		printTitle();
		 printcurrenturl();
		 WebElement fName = driver.findElement(By.id("firstName"));
		 fill(fName, getData(0, 1));

		 WebElement lName = driver.findElement(By.id("lastName"));
		 fill(lName, getData(0, 2));

		 WebElement eMail = driver.findElement(By.id("userEmail"));
		 fill(eMail, getData(1, 1));

		 WebElement gender = driver.findElement(By.xpath("//label[text()='Male']"));
		 btnClick(gender);

		 WebElement mobNum = driver.findElement(By.id("userNumber"));
		 fill(mobNum, getData(3, 1));

		 WebElement dob = driver.findElement(By.id("dateOfBirthInput"));

		 btnEntert();
		 rDown();
		 rDown();

		 WebElement sub = driver.findElement(By.xpath("//input[@id='subjectsInput']"));
		 fill(sub, getData(5, 1));

		 WebElement hobby = driver.findElement(By.xpath("//label[text()='Sports']"));
		 jClick(hobby);
		 WebElement address = driver.findElement(By.id("currentAddress"));

		 btnEntert();
		 

		 WebElement state = driver.findElement(By.xpath("//div[text()='Select State']"));
		 jGetValue("value", state);
		 WebElement stat = driver.findElement(By.xpath("//div[text()='Haryana']"));
		 mvElement(stat);
		 jGetValue("value", state);


		 WebElement city = driver.findElement(By.xpath("//div[text()='Select City']"));
		 jGetValue("value",city );

		 WebElement cite = driver.findElement(By.xpath("//div[text()='Panipat']"));
		 mvElement(cite);
		 jGetValue("value",cite );
		 btnEntert();
		  
	}

		
		
	}
	
	
	
	
	
	
	


