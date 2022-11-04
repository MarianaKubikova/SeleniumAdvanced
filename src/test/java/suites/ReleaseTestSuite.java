package suites;

import categories.ReleaseTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.ScrollToTest;

@RunWith(Categories.class)
@Categories.IncludeCategory(ReleaseTest.class)
@Suite.SuiteClasses({
    ScrollToTest.class
})
public class ReleaseTestSuite {
}
