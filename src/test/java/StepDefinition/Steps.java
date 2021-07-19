package StepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* TestRunner es el que activa los test de los escenarios */
public class Steps {

    private WebDriver driver;
    /* Declaración de ids del DOM para poder usarlas
       En este caso es por id, name y cssSelector */
    private By searchBoxLocator = By.id("search_query_top");
    private By searchBtnLocator = By.name("submit_search");
    /* Despúes de que se realiza la búsqueda se habilita/aparece/despliega un mensaje,
       el cual activa la clase css heading-counter */
    private By resultTextLocator = By.cssSelector("span.heading-counter");

    /* Cuando se encuentra la línea de @Given(.....) en el feature y escenarios se ejecuta el método.
       Siempre que aparezca el método se va a ejecutar
       El signo de dólar al final significa que se termina la sentencia */
    @Given("Abre el web browser Chrome y direcciona a la aplicacion$")
    public void open_the_web_browser() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/home/ue0100066b/Documentos/Chris/TestingCourse/Extraido/Chrome-Driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @When("Ingreso el nombre del producto a buscar blouse")
    public void ingreso_el_nombre_producto_a_buscar() throws Throwable {
        driver.findElement(searchBoxLocator).sendKeys("blouse");
        driver.findElement(searchBtnLocator).click();
    }

    @When("Ingreso el nombre del producto a buscar shoes$")
    public void ingreso_el_nombre_producto_a_buscar2() throws Throwable {
        driver.findElement(searchBoxLocator).sendKeys("shoes");
        driver.findElement(searchBtnLocator).click();
    }

    @Then("Visualizo resultado de la busqueda$")
    public void visualizo_resultados()throws Throwable {
        /* .getText atrapa el valor */
        String resultText = driver.findElement(resultTextLocator).getText();
        System.out.println("Resultado: " + resultText);
    }

    @And("Cierro el Browser$")
    public void Quit() throws Throwable {
        driver.close();
    }

    @And("Cerrar el test")
    public void close() throws  Throwable {
        System.out.println("Test with Cucumber");
    }
}
