package org.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLauch {

	
	//1
public static WebDriver driver;
public static Actions a;
public static Robot r;
public static Alert a1;
public static JavascriptExecutor js;
public static Select s;
public static WebDriverWait W;
public static FluentWait<WebDriver> f;
public static Cell c;
public static Number r1;

	public static void launchChrome() {
	
		WebDriverManager.chromedriver().setup();
	
		driver=new ChromeDriver();
	}
	
	public static void browserClse() {
		driver.close();

	}
	public static void browserQueit() {
		driver.quit();

	}
	//2maximize widow
	public static void winmax() {
		driver.manage().window().maximize();
}
	//3 get url
	public static void loadurl(String url) {
		driver.get(url);
}
	//4get title
	public static void printTitle() {
		String title = driver.getTitle();
       System.out.println(title);
	}
	//5
	public static void fill(WebElement ele,String value) {
		ele.sendKeys(value);
}
	//6
     public static void btnClick(WebElement ele) {
    	 ele.click();
     }
    //7
    	 public static void printcurrenturl() {
			String currentUrl = driver.getCurrentUrl();
          System.out.println(currentUrl);
		}
	//8
    	 public static void dclick(WebElement ele) {
			a=new Actions(driver);
            a.doubleClick(ele).perform();
		}
    	//9
    	public static void rclick(WebElement ele) {
    		a=new Actions(driver);
    		a.contextClick(ele).click();
    	}
    	//10
    	public static void mvElement(WebElement mve) {
    		Actions a = new Actions(driver);
    		a.moveToElement(mve).perform();
    		}
    	//11 select all usi Actios
    	public static void aselectall() {
    		Actions a = new Actions(driver);
    		a.keyDown(Keys.CONTROL).perform();
    		a.sendKeys("a").perform();
    		a.sendKeys(Keys.CONTROL);
    		
    	

		}
    	//12
		public void aCopy() {
			Actions a = new Actions(driver);
			a.keyDown(Keys.CONTROL).perform();
			a.sendKeys("c").perform();
			a.keyUp(Keys.CONTROL);
		}
    	
    	//13
		public void apaste() {
			Actions a = new Actions(driver);
			a.keyDown(Keys.CONTROL).perform();
			a.sendKeys("v").perform();
			a.keyUp(Keys.CONTROL);	

		}
		//14 sed keys usig actios
		public static void aFillvalues(WebElement ele,String value) {
			a=new Actions(driver);
            a.sendKeys(ele, value).perform();
		}
		//15 Drag and Drop
		
		public static void moveElemet(WebElement src,String des) {
			a=new Actions(driver);
		    a.dragAndDrop(src, src);
		}	
		
		//16 enter using Robot
		public static void btnEntert() throws AWTException {
			r=new Robot();
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
		}
		//17.SelectAll using options
		public static void rSelectAll() throws AWTException {
			r=new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_A);
            r.keyRelease(KeyEvent.VK_A);
            r.keyRelease(KeyEvent.VK_SHIFT);
		}
		public static void rCopy1() throws AWTException {
			r=new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_C);
            r.keyRelease(KeyEvent.VK_C);
            r.keyRelease(KeyEvent.VK_SHIFT);
		}
		public static void rPaste() throws AWTException {
			r=new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_V);
            r.keyRelease(KeyEvent.VK_V);
            r.keyRelease(KeyEvent.VK_SHIFT);
		}
            //24 Down Arrow using Robot
            public static void rDown() throws AWTException {
    			r=new Robot();
                r.keyPress(KeyEvent.VK_DOWN);
                r.keyPress(KeyEvent.VK_DOWN);
            }
            
           //25.up arrow using Robot
            public static void rUp() throws AWTException {
    			r=new Robot();
                r.keyPress(KeyEvent.VK_UP);
                r.keyPress(KeyEvent.VK_UP);
            } 
            //26.Accept Alert
            public static void acceptalert() {
				a1=driver.switchTo().alert();
                 a1.accept();
			}
            //27 Dismiss Alert 
            public static void dismissalert() {
            	a1=driver.switchTo().alert();
				a1.dismiss();
            }
			//28.send value to the alert
				public static void promptAlert(String value) {
					a1=driver.switchTo().alert();	
                    a1.sendKeys(value);
                    a1.accept();
				}
				//29.Get text from the Alert
				public static void printTextAlert() {
					String s = a1.getText();
					System.out.println(s);
				}
				//30 Get text
				public static void printtext(WebElement ele) {
				String text = ele.getText();	
				System.out.println(text);
					}
				//31.GetAttribute value for Already in the attributename
				public static void prtAttribute(WebElement ele,String att) {
				String text = ele.getAttribute(att);	
				System.out.println(text);
					
					

				}
				//32 GetAttriute value
	
				public static void prtAttributeValue(WebElement ele) {
					String txt = ele.getAttribute("value");
					System.out.println(txt);
				}
				
				//33.Screenshot
				public static void screenShot(String fileName) throws IOException {
					TakesScreenshot tk = (TakesScreenshot)driver;
					File src = tk.getScreenshotAs(OutputType.FILE);
				    File des = new File("");
				    FileUtils.copyFile(src, des);
					
				}
				
				//34.Sendkeys using JavaScript
				public static void jFillValue(String attributeName, String passkey, WebElement ele) {
					js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].setAttribute('"+attributeName+"','"+passkey+"')", ele);
				}
				
				//35.Get value using JavaScript
				public static void jGetValue(String passkey, WebElement ele) {
					js = (JavascriptExecutor)driver;
					Object o = js.executeScript("arguments[0].setAttribute('"+passkey+"')", ele);
					String s = (String)o;
					System.out.println(s);
				}
				
				//36.ScrollIntoView JavaScript
				public static void jScrollInTop(WebElement ele) {
					js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].scrollIntoView(true)", ele);
				}
				
				//37.ScrollIntoView JavaScript
				public static void jScrollInBottom(WebElement ele) {
					js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].scrollIntoView(false)", ele);
				}
				
				//38.ScrollIntoView JavaScript
				public static void jClick(WebElement ele) {
					js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].click()", ele);
				}
				
				//39.ScrollIntoView JavaScript
				public static void jHighlightElement(String passValue, WebElement ele) {
					js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].setAttribute('style','"+passValue+"')", ele);
				}
				
				//40.SelectedByValue - DropDown
				public static void sValue(String Value, WebElement ele) {
					s = new Select(ele);
					s.selectByValue(Value);
				}
				
				//41.SelectedByVisibleValue - DropDown
				public static void sVisiblevalue(String text, WebElement ele) {
					s = new Select(ele);
					s.deselectByVisibleText(text);
				}
				
				//42.SelectByIndex
				public static void sIndex(WebElement ele, int i) {
					s = new Select(ele);
					s.deselectByIndex(i);;
				}
				
				//43.GetOptions
				public static void allOptions(WebElement ele) {
					s = new Select(ele);
					List<WebElement> li = s.getOptions();
					for (WebElement x : li) {
						String str = x.getText();
						System.out.println(str);
						
					}
				}
				
				//44.GetAllSelectedOptions
				public static void selectedAllOptions(WebElement ele) {
					s = new Select(ele);
					List<WebElement> li = s.getAllSelectedOptions();
					for (WebElement x : li) {
						String str = x.getText();
						System.out.println(str);
						
					}
				}
				
				//45.GetFirstSelectedOptions
				public static void selectedFirstOptions(WebElement ele) {
					s = new Select(ele);
					WebElement x = s.getFirstSelectedOption();
						String str = x.getText();
						System.out.println(str);
				}
				
				//46.DeselectByValue
				public static void rSelectedValue(WebElement ele, String Value) {
					s = new Select(ele);
					s.deselectByValue(Value);
				}
				
				//47.DeSelectByVisibleText
				public static void rSelectedVisibleValue(WebElement ele, String txt) {
					s = new Select(ele);
					s.deselectByVisibleText(txt);
				}
				
				//48.DeSelectByIndex
				public static void rSelectedIndex(WebElement ele, int i) {
					s = new Select(ele);
					s.deselectByIndex(i);
				}
				
				//49.DeSelectAll
				public static void rAll(WebElement ele, int i) {
					s = new Select(ele);
					s.deselectAll();
				}
				
				//50.Frame using id
				public static void frameId(String id) {
					driver.switchTo().frame(id);
				}
				
				//51.Frame using Name
				public static void frameName(String name) {
					driver.switchTo().frame(name);
				}
				
				//52.Frame using WebElement
				public static void frameWebRef(WebElement ele) {
					driver.switchTo().frame(ele);
				}
				
				//53.Frame using Index
				public static void frameIndex(int i) {
					driver.switchTo().frame(i);
				}
				
				//54.Exit from current frame
				public static void curFrame() {
					driver.switchTo().parentFrame();
				}
				
				//55.Exit from all the frame
				public static void allFrame() {
					driver.switchTo().defaultContent();
				}
				
				//56.Switch window using url in WindowsHandling
				public static void windowUrl(String url) {
					driver.switchTo().window(url);
				}
				
				//57.Switch window using title
				public static void windowtitle(String title) {
					driver.switchTo().window(title);
				}
				
				//58.Switch using windows ID(Single)
				public static void singleChildWindowId() {
					String s = driver.getWindowHandle();
					Set<String> sh = driver.getWindowHandles();
					for (String allWindowId : sh) {
						if(!s.equals(allWindowId)) {
							driver.switchTo().window(allWindowId);
						}
					}
				}
				
				//59.Switch using Windows ID(Multiple)
				public static void multipleChildWindowId(int position) {
					String s = driver.getWindowHandle();
					Set<String> sh = driver.getWindowHandles();
					List<String> li = new ArrayList<String>();
					li.addAll(sh);
					String windowId = li.get(position);
					driver.switchTo().window(windowId);
				}
				
				//60.Static wait
				public static void stWait(int w) throws InterruptedException {
					Thread.sleep(w);
				}
				
				//61.Implicit wait
				public static void imtWait(int w) {
					driver.manage().timeouts().implicitlyWait(w, TimeUnit.SECONDS);
				}
				
				//62.WebDriverWait - Element Clickable
				public static void EleClickableWebDriverWait(int seconds, WebElement loc) {
					W = new WebDriverWait(driver, seconds);
					W.until(ExpectedConditions.elementToBeClickable(loc));
				}
				
				//63.WebDriverWait - Alert Present
				public static void aleClickableWebDriverWait(int seconds, WebElement loc) {
				 W = new WebDriverWait(driver,seconds);
					W.until(ExpectedConditions.alertIsPresent());
				}
				
				//64.WebDriverWait - Frame Present
				public static void framePresWebDriverWait(int seconds, WebElement loc) {
					W = new WebDriverWait(driver,seconds);
					W.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(loc));
				}
				
				//65.WebDriverWait - Is Element of Selected
				public static void eleSelectedWebDriverWait(int seconds, WebElement loc) {
					W = new WebDriverWait(driver,seconds);
					W.until(ExpectedConditions.elementToBeSelected(loc));
				}
				
				//66.WebDriverWait - Invisibility of Element Located 
				public static void eleSelectedWebDriverWait(int seconds, String path) {
					W = new WebDriverWait(driver,seconds);
					W.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(path)));
				}
				
				//67.FluentWait - Clickable Element
				public static void clickableElementFluentWait(WebElement loc) {
					f = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(5)).ignoring(Throwable.class);
					f.until(ExpectedConditions.elementToBeClickable(loc));
				}
				
				//68.FluentWait - Frame Available and Switch to it
				public static void frameAvailFluentWait(WebElement loc) {
					f = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(5)).ignoring(Throwable.class);
					f.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(loc));
				}
				
				//69.FluentWait - Visibility of element
				public static void visibilityofEleFluentWait(String path) {
					f = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(5)).ignoring(Throwable.class);
					f.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
				}
				
				
				//70.FluentWait - Invisibility of element
				public static void invisibilityofEleFluentWait(String path) {
					f = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(5)).ignoring(Throwable.class);
					f.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(path)));
				}
				
				//71.FluentWait - Presence of element
				public static void prensenceofEleFluentWait(String path) {
					f = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(5)).ignoring(Throwable.class);
					f.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
				}
				
				//72.Locators - id(click)
				public static void idLocWithFillClick(String name) {
					driver.findElement(By.id(name)).click();
				}
				
				//73.Locators - id(SendKeys)
				public static void idLocWithFillValue(String name, String value) {
					driver.findElement(By.id(name)).sendKeys(value);
				}
				
				//74.Locators - xpath(SendKeys)
				public static void xpathLocWithValue(String tag, String attName, String attvalue, String value) {
						driver.findElement(By.xpath("//"+tag+"[@"+attName+"='"+attvalue+"']")).sendKeys(value);;
				}
				
				//75.Locators - xpath(click)
				public static void xpathLocWithClick(String tag, String attName, String attvalue, String value) {
					driver.findElement(By.xpath("//"+tag+"[@"+attName+"='"+attvalue+"']")).clear();
				}

				
				//76.Get the value from excel using DataDriven
				public static String getData (int rownumber, int cellnumber) throws IOException  {
				
					File f = new File("E:\\eclipse\\sabari\\Frame\\target\\testdata\\testExcel.xlsx");
				FileInputStream fin = new FileInputStream(f);
					Workbook w = new XSSFWorkbook(fin);
					Sheet s = w.getSheet("Project");
					Row row2 = s.getRow(rownumber);
					
					
			
				
						String value ="";
					Cell cell = row2.getCell(cellnumber);
				int CellType =  cell.getCellType();
				
					if(CellType==1) {
						value=cell.getStringCellValue();
					}
				else if(CellType==0)
				{
					if(DateUtil.isCellDateFormatted(cell)) {
				
					Date d =  (Date) cell.getDateCellValue();
							SimpleDateFormat sim = new SimpleDateFormat("dd,MMMM,yyyy");
							value=sim.format(d);
						}else {
						double d = ((org.apache.poi.ss.usermodel.Cell) cell).getNumericCellValue();
						long l = (long)d;
						value = String.valueOf(l);
					}
					
					}
					
					return value;
					
				}
				}







	

					
           
            
                  
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

    	
    	
    	
    	
        
		
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    		

		
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
	

