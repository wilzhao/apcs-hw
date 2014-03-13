

public class BinarySearchint{

    public int rbsearch(int n, int[] L){
	return rbhelper(n,0,L.length-1,L);
    }

    public int rbhelper(int n, int Li,int Hi,int[] L){//Lower index, Higher index
	int avg = (Li+Hi)/2;
	if (Li == avg || Li == Hi){
	    if (n == L[Li]){
		return Li;
	    } else if (n == L[Hi]){
		return Hi;
	    } else {
		return -1;
	    }
	}
	if (n < L[avg]){
	    return rbhelper(n,Li,avg,L);
	} else if (n > L[avg]){
	    return rbhelper(n,avg,Hi,L);
	} else {
	    return avg;
	}
    }

    public int ibsearch(int n, int[] L){
	int lower = 0;
	int upper = L.length - 1;
	int avg = (lower+upper/2);
	while (avg != lower && lower != upper){
	    if (n == L[avg]){
		return avg;
	    } else if (n > L[avg]){
		lower = avg;
	    } else {
		upper = avg;
	    }
	    avg = lower + upper/2;
	}
	if (n == L[lower]){
	    return lower;
	}
	if (n== L[upper]){
	    return upper;
	}
	return -1;
    }

}
