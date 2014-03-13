import java.util.ArrayList;

public class Quicksort{

    

    public Integer[] qsort(Integer[] L){
	if (L.length <= 1){
	    return L;
	}
	int pivot = (int)(Math.random()*L.length);
	Integer pivotvalue = L[pivot];
	ArrayList<Integer> Llow = new ArrayList<Integer>();
	ArrayList<Integer> Lhigh = new ArrayList<Integer>();
	for (int x = 0; x < L.length;x++){
	    if (x != pivot){
		if (L[x] > L[pivot]){
		    Lhigh.add(L[x]);
		} else {
		    Llow.add(L[x]);
		}
	    }
	}
	Integer[] first = qsort(Llow.toArray(new Integer[Llow.size()]));
	Integer[] second = qsort(Lhigh.toArray(new Integer[Lhigh.size()]));
	int y = 0;
	for (y = 0; y < first.length;y++){
	    L[y] = first[y];
	}
	L[y] = pivotvalue;
	for (y = 0; y <second.length;y++){
	    L[y+first.length+1] = second[y];
	}
	return L;
    }

}

