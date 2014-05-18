//tried using PriorityQueues as the min and max heaps and the order got constantly messed up while adding
//it does the same using a default comparator

import java.util.PriorityQueue;
import java.util.Comparator;
import java.lang.Integer;
import java.util.Arrays;

public class RunningMedian{
	
	private class MinIntegerComparator implements Comparator<Integer>{
		public int compare(Integer i1, Integer i2){
			return i2.intValue() - i1.intValue();
		}
	}

	private class MaxIntegerComparator implements Comparator<Integer>{
		public int compare(Integer i1, Integer i2){
			return i1.intValue() - i2.intValue();
		}
	}

	private	PriorityQueue<Integer> maxHeap;
	private PriorityQueue<Integer> minHeap;
	private int maxSize;
	private int minSize;

	public RunningMedian(){
		maxHeap = new PriorityQueue<Integer>(11, new MaxIntegerComparator());
		minHeap = new PriorityQueue<Integer>(11, new MinIntegerComparator());
		maxSize = maxHeap.size();
		minSize = minHeap.size();
	}

	private void adjust(){//assuming ordering works properly,which it doesn't
		if (minSize > maxSize){
			minHeap.add(maxHeap.poll());
			minSize--;
			maxSize++;
		} else {
			maxHeap.add(minHeap.poll());
			maxSize--;
			minSize++;
		}
		
	}

	public void add(int i){
		if (Math.abs(minSize - maxSize) > 1){
			adjust();
		} 
		Integer minTop = minHeap.peek();
		Integer maxTop = maxHeap.peek();
		if (minTop == null && maxTop == null){//both null
			minHeap.add(i);
			minSize++;
		} else if(minTop == null){ //one null
			if (i > maxTop.intValue()){ //i > top of maxHeap
				maxHeap.poll();
				maxHeap.add(i);
				minHeap.add(maxTop);
				minSize++;
			} else {//i < top of maxHeap
				minHeap.add(i);
				minSize++;
			}
		} else if (maxTop == null){
			if (i < minTop.intValue()){ //i < top of minHeap
				minHeap.poll();
				minHeap.add(i);
				maxHeap.add(minTop);
				maxSize++;
			} else {//i < top of maxHeap
				maxHeap.add(i);
				maxSize++;
			}
		} else if (i > minTop.intValue()){//neither are empty
			minHeap.add(i);
			minSize++;
		} else {
			maxHeap.add(i);
			maxSize++;
		}


	}

	public int findMedian(){
		return 0;
	}

	public int removeMedian(){
		return 0;
	}

	public String toString(){
		Object[] max = maxHeap.toArray();
		Object[] min = minHeap.toArray();
		String str = Arrays.toString(min) + "\n" + Arrays.toString(max);
		return str;
	}

}