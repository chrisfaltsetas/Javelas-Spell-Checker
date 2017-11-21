public class WordDistance {
	
	public static int getMinimumDistance(String word1, String word2) {
				
		int length1 = word1.length();
		int length2 = word2.length();
		
		int[][] distanceMap = new int[length2 + 1][length1 + 1];
		
		for (int i = 0; i <= length2; i++) {
			distanceMap[i][0] = i;
		}
		
		for (int i = 0; i <= length1; i++) {
			distanceMap[0][i] = i;
		}
		
		for (int i = 0; i < length2; i++) {
			char char2 = word2.charAt(i);
			for (int j = 0; j < length1; j++) {
				char char1 = word1.charAt(j);
				
				int topleft = distanceMap[i][j];
				int top = distanceMap[i][j + 1];
				int left = distanceMap[i + 1][j];
				
				distanceMap[i + 1][j + 1] = Math.min(topleft, Math.min(top, left));

				if (char1 != char2)
					distanceMap[i + 1][j + 1] ++;
			}//end for
		}//end for
		
		//Test
		printDistanceMap(distanceMap, word1, word2);
		
		return distanceMap[length2][length1];
		
	}//end method getMinimumDistance
	
	/*
	public static int distanceOptimal(String word1, String word2) {
		
		if (word1.length() < word2.length()) {
			String temp = word1;
			word1 = word2;
			word2 = temp;
		}
		
		int length1 = word1.length();
		int length2 = word2.length();
		
		int[][] distanceMap = new int[length2 + 1][length1 + 1];
		
		for (int i = 0; i <= length2; i++) {
			distanceMap[i][0] = i;
		}
		
		for (int i = 0; i <= length1; i++) {
			distanceMap[0][i] = i;
		}
		
		for (int j = 0; j < length1; j++) {
			char char1 = word1.charAt(j);
			for (int i = 0; i < ((j+1) < length2 ? (j+1) : length2); i++) {
				char char2 = word2.charAt(i);
				
				int topleft = distanceMap[i][j];
				int top = distanceMap[i][j + 1];
				int left = distanceMap[i + 1][j];
				
				distanceMap[i + 1][j + 1] = Math.min(topleft, Math.min(top, left));

				if (char1 != char2)
					distanceMap[i + 1][j + 1] ++;		
				//printDistanceMap(distanceMap, word1, word2);
			}
		}
		
		
		//Test
		printDistanceMap(distanceMap, word1, word2);
		
		return distanceMap[length2][length1];
		
	}//end method distanceOptimal
	*/
		
	
	//Test method
	public static void printDistanceMap(int[][] distanceMap, String word1, String word2) {
		
		word1 = word1.toUpperCase();
		word2 = word2.toUpperCase();
				
		System.out.print("    ");
		for (int i = 0; i < word1.length(); i++)
			System.out.print(word1.charAt(i) + " ");
		System.out.println();
		
		for (int i = 0; i < distanceMap.length; i++) {
			if (i != 0)
				System.out.print(word2.charAt(i - 1) + " ");
			else
				System.out.print("  ");
			for (int j = 0; j < distanceMap[0].length; j++) {
				System.out.print(distanceMap[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
}//end class
