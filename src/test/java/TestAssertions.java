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
        person.add("attr", "value");
        assertEquals(person.get("attr")[0], "value");
    }

    @Test
    public void testTwitterHandler() {
        TwitterHandler twitterHandler = TwitterHandler.getHandler();
        assertEquals(twitterHandler.getUsername("https://twitter.com/name123/with_replies"),
                "name123");

        assertTrue(twitterHandler.isProfileUrl("http://twitter.com/name123"));
        assertFalse(twitterHandler.isProfileUrl("http://twitter.com/name123/tweets"));
        assertFalse(twitterHandler.isProfileUrl("http://twitter.com/"));
    }
}
