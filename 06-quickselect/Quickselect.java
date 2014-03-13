

public class Quickselect{

    public int quickselect(int[] a, int k, int low, int high){

	if (low >= high){
	    return a[low];
	} 
	int pivot = (int) (Math.random()*(high - low) + low);//never picks high

	int[] b = new int[a.length];
	int left = low;
	int right = high;
	for (int i = low; i <= high;i++){
	    if (i != pivot){
		if (a[i] > a[pivot]){
		    b[right] = a[i];
		    right--;
		} else {
		    b[left] = a[i];
		    left++;
		}
	    }
	}
	//a[k] should go at the current right or left index
	if (k == left){//picked the right one as pivot
	    return a[pivot];
	}
	if (k > left){
	    return quickselect(b,k,left+1,high); 
	}
	return quickselect(b,k,low,right-1);
	
    }

    public int quickselect(int[] a, int k){
	return quickselect(a,k,0,a.length-1);
    }

}
