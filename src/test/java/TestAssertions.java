import org.junit.Test;
import static org.junit.Assert.*;

public class TestAssertions {
    @Test
    public void testAWebHandler() {
        assertEquals(AWebHandler.getDomainName("twitter.com/user/uesr"), "twitter.com");
    }

    @Test
    public void testPerson() {
        Person person = new Person();
        person.attr("attr", "value");
        assertEquals(person.attr("attr"), "value");
    }

    @Test
    public void testTwitterHandler() {
        TwitterHandler twitterHandler = TwitterHandler.getHandler();
        assertEquals(twitterHandler.getUsername("https://twitter.com/name123/with_replies"),
                "name123");
    }
}
