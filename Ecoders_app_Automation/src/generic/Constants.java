package generic;

public interface Constants 
{
	String root_directory = System.getProperty("user.dir");	
	
	String geckoKey = "webdriver.gecko.driver";
	String geckoValue =  root_directory+"//executables//geckodriver.exe";

	String chromeKey = "webdriver.chrome.driver";
	String chromeValue = root_directory+"//executables//chromedriver.exe";

	 String ieKey = "webdriver.ie.driver";
	 String ieValue = root_directory+"//executables//IEDriverServer.exe";

	 String operaKey = "webdriver.opera.driver";
	String operaValue = root_directory+"//executables//operadriver.exe";

	String excelSheetPath = root_directory+"//excel_data//project_documents.xlsx";
	String urlOfApplication = "http://localhost:5173/";
	
	String screeshotFolder = root_directory+"//screeshots";

}