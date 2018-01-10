package spellchecker;

import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class SpellCheckerTest {

	@Test
	public void test() {
		SpellChecker a = new SpellChecker(null);
		assertFalse(a.wordIsValid("211313131"));
	}

}
