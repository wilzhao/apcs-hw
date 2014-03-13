

public class Mergesort{

    public int[] mergesort(int[] nums){
	if (nums.length >= 2){
	    nums = split(nums);  
	}
	return nums;
    }

    private int[] merge(int[] a, int[] b){
	if (a.length >= 2) a = split(a);	
	if (b.length >= 2) b = split(b);
	
	int aindex = 0, bindex = 0;
	int[] result = new int[a.length + b.length];

	while (aindex < a.length && bindex < b.length){
	    if (a[aindex] < b[bindex]){
		result[aindex+bindex] = a[aindex];
		aindex++;
	    } else {
		result[aindex+bindex] = b[bindex];
		bindex++;
	    }
	}
	while (bindex < b.length){
	    result[aindex+bindex] = b[bindex];
	    bindex++;
	}
	while (aindex < a.length){
	    result[aindex+bindex] = a[aindex];
	    aindex++;
	}

	return result;
    }

    private int[] split(int[] nums){
	int half1 = nums.length/2;
	int half2 = nums.length - half1;
	int[] firsthalf = new int[half1];
	int[] secondhalf = new int[half2];
	
	for (int x = 0; x < half1;x++) firsthalf[x] = nums[x];
	for (int x = 0; x < half2;x++) secondhalf[x] = nums[x+half1];
	return merge(firsthalf,secondhalf);
    }

}
