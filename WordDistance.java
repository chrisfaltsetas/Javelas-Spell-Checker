package Javelas;

public class WordDistance {
	
	public static int getMinimumDistance(String word1, String word2) {
		
		int length1 = word1.length();
		int length2 = word2.length();
		
		int[][] distanceMap = new int[length1 + 1][length2 + 1];
		
		for (int i = 0; i <= length1; i++) {
			distanceMap[i][0] = i;
		}
		
		for (int i = 0; i <= length2; i++) {
			distanceMap[0][i] = i;
		}
		
		for (int i = 0; i < length1; i++) {
			char char1 = word1.charAt(i);
			for (int j = 0; j < length2; j++) {
				char char2 = word2.charAt(j);
				
				if (char1 == char2) {
					distanceMap[i + 1][j + 1] = distanceMap[i][j];
				} else {
					int topleft = distanceMap[i][j];
					int top = distanceMap[i][j + 1];
					int left = distanceMap[i + 1][j];
					
					int min = topleft;
					if (top < min)
						min = top;
					if (left < min)
						min = left;
					min = min + 1;
					distanceMap[i + 1][j + 1] = min;
				}//end else
			}//end for
		}//end for
			
		return distanceMap[length1][length2];
		
	}//end method getMinimumDistance
		
	
	
	
	
	
}
