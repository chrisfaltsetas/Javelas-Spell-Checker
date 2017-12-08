
public abstract class WordEdit {

	public static int jHashCode(String word) {
		int jhash = 0;
		if (word != null) {
			if (word.length() > 0) {
				for (int i = 0; i < word.length(); i++) {
					jhash += word.substring(i, i+1).hashCode();
				}
			}
		}
		return jhash;
	}
	
}
