package Utils;

import java.io.IOException;
import PageObjects.PageObjectManager;

public class TextContext {
	
	public String searchedproductToIncrement;
	public String productname;
	
	public TestBase testbase;
	public CommonUtils utils;
	public PageObjectManager pageobjects;
	
	public TextContext() throws IOException
	{
		testbase = new TestBase();
		pageobjects = new PageObjectManager(testbase.WebDriverManager());
		utils = new CommonUtils(testbase.WebDriverManager());
		
	}

}
