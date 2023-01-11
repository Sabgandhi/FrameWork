package org.utilities;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.collect.Table.Cell;

public class Adactin extends BrowserLauch {
	public static void main(String[] args) throws IOException, AWTException, InterruptedException {
		
		
		
		
		
		
		launchChrome();	
		winmax();
		loadurl(getData(0, 1));
		printTitle();
		 printcurrenturl();
		
		WebElement user = driver.findElement(By.id("username"));
		fill(user, getData(1, 1));

		WebElement pass = driver.findElement(By.id("password"));
		fill(pass, getData(2, 1));

		WebElement logIn = driver.findElement(By.id("login"));
	
		btnClick(logIn);
		
		WebElement loc = driver.findElement(By.id("location"));
		btnClick(loc);
		 rDown();
		btnEntert();

		WebElement hotel = driver.findElement(By.id("hotels"));
		btnClick(hotel);
		 rDown();
		 btnEntert();

		

		WebElement rType = driver.findElement(By.id("room_type"));
		btnClick(rType);
		 rDown();
		 btnEntert();

		WebElement nos = driver.findElement(By.id("room_nos"));
		btnClick(nos);
		 rDown();
		 btnEntert();

		WebElement checkIn = driver.findElement(By.id("datepick_in"));
		fill(checkIn, "14/11/2022");

		WebElement checkOut = driver.findElement(By.id("datepick_out"));
		fill(checkOut, "19/11/2022");

		WebElement room = driver.findElement(By.id("adult_room"));
		btnClick(room);
		 rDown();
		 btnEntert();

		WebElement child = driver.findElement(By.id("child_room"));
		btnClick(child);
		 rDown();
		 btnEntert();

		WebElement search = driver.findElement(By.id("Submit"));
		btnClick(search);

		WebElement radio = driver.findElement(By.id("radiobutton_0"));
		btnClick(radio);

		WebElement conti = driver.findElement(By.id("continue"));
		btnClick(conti);

		WebElement fname = driver.findElement(By.id("first_name"));
		fill(fname, getData(3, 1));

		WebElement lname = driver.findElement(By.id("last_name"));
		fill(lname, getData(4, 1));

																																																																																																																																																																																																														WebElement add = driver.findElement(By.id("address"));
		fill(add, getData(5, 1));

		WebElement credit = driver.findElement(By.id("cc_num"));
		fill(credit, getData(14, 1));

		WebElement cctype = driver.findElement(By.id("cc_type"));
		btnClick(cctype);
		rDown();
		 rDown();
		 btnEntert();


		WebElement expMonth = driver.findElement(By.id("cc_exp_month"));
		btnClick(expMonth);
		for (int i = 0; i <=11; i++) {
			rDown();
		}
		 btnEntert();

		WebElement expYear = driver.findElement(By.id("cc_exp_year"));
		btnClick(expYear);
		for (int i = 0; i <=11; i++) {
			rDown();
		}
		 btnEntert();
		 
		WebElement cvv = driver.findElement(By.id("cc_cvv"));
		fill(cvv, getData(15, 1));

		WebElement booking = driver.findElement(By.id("book_now"));
		btnClick(booking);
		
		stWait(7000);
		WebElement ordNo = driver.findElement(By.xpath("//input[@name='order_no']"));
		String attribute = ordNo.getAttribute("value");
		System.out.println(attribute);
       File f=new File("E:\\eclipse\\sabari\\Frame\\target\\testdata\\testExcel.xlsx"); 
       
       FileInputStream fin=new FileInputStream(f);
       Workbook w=new XSSFWorkbook(fin);
       Sheet s = w.getSheet("Adactin");
       Row r=s.createRow(11);
org.apache.poi.ss.usermodel.Cell cell = r.createCell(5);
      
       ((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(attribute);
       
       
       FileOutputStream fout=new FileOutputStream(f);
       w.write(fout);
       System.out.println("sucess");
       
       
       
       
       
     
       
		

		
		
	
		
		
		
		
	}

	
	
	
	
	
	
}
