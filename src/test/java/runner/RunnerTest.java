package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags = { "@Amazon" }, monochrome = true, glue = {
		"Testcases" }, features = "src\\test\\resources\\Feature")
public class RunnerTest {

}
