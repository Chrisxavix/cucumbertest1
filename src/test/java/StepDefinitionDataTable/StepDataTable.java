package StepDefinitionDataTable;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class StepDataTable {
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

    @When("Ingreso el nombre del producto a buscar:$")
    /* Recibe una tabla */
    public void nombre_del_producto_buscar_table(DataTable tabla) throws Throwable {
        /* Lista del tipo String
           asLists Devuelve una matriz en lugar de una Lista */
        List<List<String>> rows = tabla.asLists(String.class);
        System.out.println("Rows: " + rows);
        System.out.println("Row size: " + rows.size());
        /* (1: indice, rows.size(): lo que contenga el dataTable */
        List<List<String>> rowsWithHead = rows.subList(1, rows.size());
        for (List<String> row : rowsWithHead) {
            driver.findElement(searchBoxLocator).clear();
            driver.findElement(searchBoxLocator).sendKeys(row.get(0));
            driver.findElement(searchBtnLocator).click();
        }
    }

    @Then("Visualizo resultado de la busqueda$")
    public void visualizo_resultados()throws Throwable {
        String resultText = driver.findElement(resultTextLocator).getText();
        System.out.println("Resultado: " + resultText);
    }

    @And("Cierro el Browser$")
    public void Quit() throws Throwable {
        driver.close();
    }
}
