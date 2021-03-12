package UI.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "UI/stepDefinitions"
        ,tags = "@demo" ,dryRun = false)


public class SauceDemoRunner {

}
