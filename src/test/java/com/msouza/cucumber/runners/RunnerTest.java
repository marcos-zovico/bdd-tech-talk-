package com.msouza.cucumber.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/alugar_filme.feature",
		glue = {"com.msouza.cucumber.steps"},
		plugin = {"pretty", "html:build/report-html", "json:build/report.json"},
		snippets = SnippetType.CAMELCASE
		)
public class RunnerTest {
}
