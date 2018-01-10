package spellchecker;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class WordTest {

@Test
public void test() {
		String a = "A";
		String b = "B";
		int hashcode_a = a.hashCode();
		int hashcode_b = b.hashCode();
		Word a1 = new Word("AB");
		assertEquals(hashcode_a+hashcode_b,a1.hashCode());
	}

}
