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
	}

}
