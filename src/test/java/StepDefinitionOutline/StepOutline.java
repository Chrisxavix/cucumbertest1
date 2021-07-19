package StepDefinitionOutline;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepOutline {
    private WebDriver driver;

    private By searchBoxLocator = By.id("search_query_top");
    private By searchBtnLocator = By.name("submit_search");
    private By resultTextLocator = By.cssSelector("span.heading-counter");

    @Given("Abre el web browser Chrome y direcciona a la aplicacion$")
    public void open_the_web_browser() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/home/ue0100066b/Documentos/Chris/TestingCourse/Extraido/Chrome-Driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    /* Definir una expresión regular
       "([^"]*)" significa que va a recibir un string como parámetro
       Agregar solo un espacio antes de la expresión */
    @When("Ingreso el nombre del producto a buscar \"([^\"]*)\"$")
    /* Recibe el parámetro de tipo String */
    public void nombre_del_producto_a_buscar(String DataEntradaFeauture)throws Throwable {
        driver.findElement(searchBoxLocator).sendKeys(DataEntradaFeauture);
        driver.findElement(searchBtnLocator).click();
    }

    @Then("Visualizo resultado de la busqueda$")
    public void visualizo_resultados() throws Throwable {
        String resultText = driver.findElement(resultTextLocator).getText();
        System.out.println("Resultado: " + resultText);
    }

    @And("Cierro el Browser$")
    public void Quit() throws Throwable {
        driver.close();
    }

}
