package suites;

import categories.SmokeTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.BlurTest;
import tests.InceptionTest;

@RunWith(Categories.class)
@Categories.IncludeCategory(SmokeTest.class)
@Suite.SuiteClasses({
    BlurTest.class,
    InceptionTest.class
})
public class SmokeTestSuite {

}