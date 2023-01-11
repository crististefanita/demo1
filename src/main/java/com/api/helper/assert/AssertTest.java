package api.methods;

import lombok.extern.log4j.Log4j;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;


@Log4j
public class AssertTest {
    public static <T> void assertHard(String reason, T actual, Matcher<? super T> matcher) {
        Description description = new StringDescription();
        description.appendText(reason).appendText("\nExpected: ").appendDescriptionOf(matcher).appendText("\n  found: ");
        matcher.describeMismatch(actual, description);
        log.info(description);

        if (!matcher.matches(actual)) {
            throw new AssertionError(description.toString());
        }
    }

}
