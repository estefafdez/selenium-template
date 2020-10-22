package constant;

import org.openqa.selenium.By;

public class HomeConst {
	
	/*--------------------------------------------------------------------*
	|      POPUP ELEMENTS                                            
	*---------------------------------------------------------------------*/
	public static final By popupCloseButton = By.id("at-cv-lightbox-header");
	
	/*--------------------------------------------------------------------*
	|      HEADER ELEMENTS                                            
	*---------------------------------------------------------------------*/
	public static final By seleniumEasyLogo = By.xpath("//div[@id='site-name' and contains(., 'Selenium Easy')]");
	public static final By crossBrowserTestingLogo = By.xpath("//img[@class='cbt']");
	
	/*--------------------------------------------------------------------*
	|      NAV BAR OPTIONS ELEMENTS                                            
	*---------------------------------------------------------------------*/
	public static final By navBarInputFormsLink = By.xpath("//a[@class='dropdown-toggle' and contains(., 'Input Forms')]");
	
	/** SubMenu inside Input Forms **/
	public static final By navBarSimpleFormDemoLink = By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Simple Form Demo')]");
	
	// TODO: Añadir el resto de elementos en todas las categorias y submenus
	
	public static final By navBarDatePickersLink = By.xpath("//a[@class='dropdown-toggle' and contains(., 'Date pickers')]");
	
	public static final By navBarTableLink = By.xpath("//a[@class='dropdown-toggle' and contains(., 'Table')]");
	
	public static final By navBarDemoHomeLink = By.xpath("//div[@class='navbar-brand navbar-brand-centered' and contains(., 'Demo Home')]");
	
	public static final By navBarProgressBarsLink = By.xpath("//a[@class='dropdown-toggle' and contains(., 'Progress Bars')]");
	
	public static final By navBarAlertsAndModalsLink = By.xpath("//a[@class='dropdown-toggle' and contains(., 'Alerts & Modals')]");
	
	public static final By navBarListBoxLink = By.xpath("//a[@class='dropdown-toggle' and contains(., 'List Box')]");
	
	public static final By navBarOthersLink = By.xpath("//a[@class='dropdown-toggle' and contains(., 'Others')]");
		
	/*--------------------------------------------------------------------*
	|      MENU LIST OPTIONS ELEMENTS                                            
	*---------------------------------------------------------------------*/
	public static final By menuAllExamplesOption = By.xpath("//li[@class='tree-branch']/a[contains(text(),'All Examples')]");
	public static final By menuInputFormsOption = By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]");
	public static final By menuDatePickersOption = By.xpath("//li[@class='tree-branch']/a[contains(text(),'Date pickers')]");
	public static final By menuTableOption = By.xpath("//li[@class='tree-branch']/a[contains(text(),'Table')]");
	public static final By menuProgressBarsSlidersOption = By.xpath("//li[@class='tree-branch']/a[contains(text(),'Progress Bars & Sliders')]");
	public static final By menuAlertsAndModalsOption = By.xpath("//li[@class='tree-branch']/a[contains(text(),'Alerts & Modals')]");;
	public static final By menuListBoxOption = By.xpath("//li[@class='tree-branch']/a[contains(text(),'List Box')]");;
	public static final By menuOthersOption = By.xpath("//li[@class='tree-branch']/a[contains(text(),'Others')]");;
	
	/*--------------------------------------------------------------------*
	|      FOOTER ELEMENTS                                            
	*---------------------------------------------------------------------*/ 
	public static final By footerTutorialsMenuTitle = By.xpath("//h4[contains(., 'Tutorials Menu')]");
	public static final By footerPopularPostsMenuTitle = By.xpath("//h4[contains(., 'Popular Posts')]");

}
