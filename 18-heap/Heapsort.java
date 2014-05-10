

public class Heapsort{

	public static void hsort(int[] nums){
		int size = nums.length;
		myHeap H = new myHeap();
		for (int x = 0; x < nums.length; x++){
			H.insert(nums[x]);
		}

		int index = nums.length-1;
		while(H.getNextIndex() > 1){
			nums[index] = H.removeMax();
			index--;
		}
	}

}