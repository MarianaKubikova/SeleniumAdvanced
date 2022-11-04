package suites;

import categories.RegressionTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.WaitForItTest;

@RunWith(Categories.class)
@Categories.IncludeCategory(RegressionTest.class)
@Suite.SuiteClasses({
    WaitForItTest.class
})
public class RegressionTestSuite {
}
