import java.util.ArrayList;

public class MergesortComparable{

    public ArrayList<Comparable> mergesort(ArrayList<Comparable> comps){
	if (comps.size() >= 2){
	    comps = split(comps);  
	}
	return comps;
	
    }

    private ArrayList<Comparable> merge(ArrayList<Comparable> a, ArrayList<Comparable> b){
	if (a.size() >= 2) a = split(a);	
	if (b.size() >= 2) b = split(b);
	
	int aindex = 0, bindex = 0;
	ArrayList<Comparable> result = new ArrayList<Comparable>();

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

    private ArrayList<Comparable> split(ArrayList<Comparable> comps){
	int half1 = comps.size()/2;
	int half2 = comps.size() - half1;
	ArrayList<Comparable> firsthalf = new ArrayList<Comparable>();
	ArrayList<Comparable> secondhalf = new ArrayList<Comparable>();
	
	for (int x = 0; x < half1;x++) firsthalf.add(comps.get(x));
	for (int x = 0; x < half2;x++) secondhalf.add(comps.get(x+half1));
	return merge(firsthalf,secondhalf);
    }

}
