import java.util.Random;
import java.util.Arrays;

public class Quicksortpartition1{
    private Random rd = new Random();

    private int med(int a, int b, int c){
	if (a <= b){
	    if (c >= b){
		return b;
	    } else if (c <= a){
		return a;
	    } else {
		return c;
	    }
	} else if (c > a){
	    return a;
	} else if (c < b){
	    return b;
	} else {
	    return c;
	}
    }

    public int partition(int[] a, int l, int r){
	int pind = med(l,r,(l+r)/2);
  	int pivot = a[pind];
	
	int temp = a[r];
	a[r] = pivot;
	a[pind] = temp;

	int wall = l;
	for (int x = l; x < r; x++){
	    if (a[x] < pivot){
		temp = a[x];
		a[x] = a[wall];
		a[wall] = temp;
		wall++;
	    } else {
		
	    } 
	}
	temp = a[r];
	a[r] = a[wall];
	a[wall] = temp;

	int rwall = wall;
	for (int y = wall;y < r;y++){
	    if (a[y] == pivot){
		temp = a[y];
		a[y] = a[rwall];
		a[rwall] = temp;
		rwall++;
	    }
	}
	return (wall+rwall)/2;
    }
    
    public void quicksort(int[] a, int l, int r){
	if (r - l < 1){
	    return;
	} else {
	    int pind = partition(a,l,r);
	    if (pind - 1 > l){
		quicksort(a,l,pind-1);
	    }
	    if (pind + 1 < r){
		quicksort(a,pind+1,r);
	    }
	}
    }
    
    public void quicksort(int[] a){
	quicksort(a,0,a.length-1);
    }

}
