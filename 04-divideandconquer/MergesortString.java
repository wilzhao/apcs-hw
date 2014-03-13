import java.util.ArrayList;

public class MergesortString{

    public ArrayList<String> mergesort(ArrayList<String> strings){
	if (strings.size() >= 2){
	    strings = split(strings);  
	}
	return strings;
	
    }

    private ArrayList<String> merge(ArrayList<String> a, ArrayList<String> b){
	if (a.size() >= 2) a = split(a);	
	if (b.size() >= 2) b = split(b);
	
	int aindex = 0, bindex = 0;
	ArrayList<String> result = new ArrayList<String>();

	while (aindex < a.size() && bindex < b.size()){
	    if (a.get(aindex).compareTo(b.get(bindex)) < 0){
		result.add(a.get(aindex));
		aindex++;
	    } else {
		result.add(b.get(bindex));
		bindex++;
	    }
	}
	while (bindex < b.size()){
	    result.add(b.get(bindex));
	    bindex++;
	}
	while (aindex < a.size()){
	    result.add(a.get(aindex));
	    aindex++;
	}

	return result;
    }

    private ArrayList<String> split(ArrayList<String> strings){
	int half1 = strings.size()/2;
	int half2 = strings.size() - half1;
	ArrayList<String> firsthalf = new ArrayList<String>();
	ArrayList<String> secondhalf = new ArrayList<String>();
	
	for (int x = 0; x < half1;x++) firsthalf.add(strings.get(x));
	for (int x = 0; x < half2;x++) secondhalf.add(strings.get(x+half1));
	return merge(firsthalf,secondhalf);
    }

}
