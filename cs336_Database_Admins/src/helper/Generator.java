package helper;

import java.util.Random;

public class Generator {
	
	public static String generate(Random rng, String input, int length){
		    char[] index = new char[length];
		    for (int i = 0; i < length; i++)
		    {
		        index[i] = input.charAt(rng.nextInt(input.length()));
		    }
		    return new String(index);
	}
}
