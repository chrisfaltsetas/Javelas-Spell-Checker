package spellchecker;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.junit.Test;


public class DictionaryTest {

@Test
public void test() throws IOException {

		Dictionary dic= new Dictionary("Greek", 73, 974);
		Word a = new Word("Nma");
		dic.addWord(a);
		assertTrue(dic.wordExists(a));
	}

}
