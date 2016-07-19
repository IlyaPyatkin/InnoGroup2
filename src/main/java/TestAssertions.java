import org.junit.Test;
import static org.junit.Assert.*;

public class TestAssertions {
    @Test
    public void testAWebHandler() {
        assertEquals(AWebHandler.getDomainName("twitter.com/user/uesr"), "twitter.com");
    }

    public void testPerson() {
        Person person = new Person();
        person.attr("attr", "value");
        assertEquals(person.attr("attr"), "value");
    }
}
