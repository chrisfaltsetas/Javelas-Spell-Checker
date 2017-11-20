import java.io.IOException;

public class TestMain {

	public static void main(String[] args) {
		System.out.println("Distance is: " + WordDistance.distanceOptimal("cayry", "caral"));
		System.out.println("");
		System.out.println("");
		System.out.println("Distance is: " + WordDistance.getMinimumDistance("cayry", "caral"));		
		System.out.println("");
		System.out.println("");
		System.out.println("Distance is: " + WordDistance.distanceOptimal("sitting", "kitten"));
		System.out.println("");
		System.out.println("");
		System.out.println("Distance is: " + WordDistance.getMinimumDistance("sitting", "kitten"));	
		
				
		HashMapsExample.HashMapsTest();
		
		String path = "C:/Users/CHRIS/Desktop/LAB/Java/Javelas/src/Greek.txt";//Needs to be changed
		String encoding = "UTF8";
		while(true) {
			try {
				SpellChecker.run(path, encoding);
			} catch (IOException ioException) {
				System.out.println (ioException.toString());
				System.out.println("Could not find file: " + path);
			}
		}
	}

}
