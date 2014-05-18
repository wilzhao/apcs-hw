import java.util.HashMap;
import java.util.TreeMap;
import java.util.Arrays;

public class SpeedTest{

	public static String[] makeRandom(int x, int length){
		int strlength = length;
		String[] temp = new String[x];
		String strtemp = "";
		for (int i = 0;i<x; i++){
			for (int j = 0; j < strlength;j++){
				strtemp += "" +  (char)(Math.random()*(int)('z' - 'a') + (int)'a');
			}
			temp[i] = strtemp;
			strtemp = "";
		}
		return temp;
	}

	public static void main(String[] args) {
		
		HashMap<String,String> H = new HashMap<String,String>();
		TreeMap<String,String> T = new TreeMap<String,String>();

		int numKeys = 1000000;
		String[] keys = makeRandom(numKeys,10);
		String[] mapped = makeRandom(numKeys,10);

		long startTime = System.nanoTime();
		for (int x = 0; x < numKeys;x++){
			H.put(keys[x],mapped[x]);
		}
		long endTime = System.nanoTime();
		double difference = (endTime - startTime)/(1000000000.0);	
		System.out.println("Hashmap: " + difference + " seconds");

		startTime = System.nanoTime();
		for (int x = 0; x < numKeys;x++){
			T.put(keys[x],mapped[x]);
		}
		endTime = System.nanoTime();
		difference = (endTime - startTime)/(1000000000.0);	
		System.out.println("Treemap: " + difference + " seconds");

		//String[] strs = makeRandom(10,5);
		//System.out.println(Arrays.toString(strs));
	}

}