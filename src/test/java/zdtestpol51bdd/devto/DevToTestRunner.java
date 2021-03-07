package zdtestpol51bdd.devto;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/zdtestpol51bdd.devto"
)
public class DevToTestRunner {
}
