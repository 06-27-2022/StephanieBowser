import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class test {

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		ArrayList<String> temp = new ArrayList<String>();
        int N = in.nextInt();
        boolean[] wordpossible = new boolean[N];
        
        for ( int i = 0; i<N; i ++) {
        	wordpossible[i]= true;
        }
        
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < N; i++) {
            temp.add(in.nextLine());
        }
        String LETTERS = in.nextLine();
    	
    	for (int i = 0; i < N; i++) {
    		int wordlength = temp.get(i).length();
    		String[] tempArray2 = new String[wordlength];
            for (int k = 0; k <wordlength;k++) {
            	tempArray2[k]= "" + temp.get(i).charAt(k);
            }
            String tempLETTERS = new String(LETTERS);

    		for (int j = 0; j < wordlength;j++) {
    			
        		if (wordlength > 7 || !tempLETTERS.contains(tempArray2[j])) {
        			wordpossible[i]=false;
        		}else {
        			tempLETTERS = tempLETTERS.replaceFirst(tempArray2[j], "");
        		}

    		}
    	}

        int[] pointarray= {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
        
        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < N; i++) {
        	if (wordpossible[i]) {
        		words.add(temp.get(i));
        	}
        }
        
        
        
        int[] totals = new int[words.size()];
        for (int i = 0; i < totals.length; i++) {
        	char[] tempChararray = words.get(i).toCharArray();
        	for (char c : tempChararray) {
        		int ascii = c - 97;
        		totals[i] += pointarray[ascii];
        	}
        }
        int highestvalue = 0;
        String winner = "";
        
        for (int i = 0; i < totals.length; i++) {
        	if (highestvalue < totals[i]) {
        		highestvalue = totals[i];
        		winner = words.get(i);
        	}
        }
        System.out.println(winner);
        in.close();
        
        
	}
}
