package TestRunner;
/* Indentifica como una clase Runner, que va a accionar algo */
import org.junit.runner.RunWith;

/* Utiliza el framework para que se convierta en un test de Junit
   Entra a trabajar con los archivos feature con los diferentes escenarios */
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
/* Debe estar a la misma altura para dar el path de Features */
@CucumberOptions(features = "Features", glue = {"StepDefinition"})
public class Runner {
}
