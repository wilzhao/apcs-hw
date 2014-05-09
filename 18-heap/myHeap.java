

public class myHeap{

	private int[] values;
	private int nextIndex;

	public myHeap(){
		values = new int[10];
		nextIndex = 1;
	}

	private void grow(){
		int[] temp = new int[values.length*2];
		for (int i  = 0; i < values.length; i++){
			temp[i] = values[i];
		}
		values = temp;
	}

	public int getNextIndex(){
		return nextIndex;
	}

	public void insert(int n){
		if (nextIndex >= values.length){
			grow();
		}
		values[nextIndex] = n;
		int index = nextIndex;
		while (n > values[index/2] && index != 1 ){
			int temp = values[index/2];
			values[index/2] = n;
			values[index] = temp;
			index /= 2;
		}
		nextIndex++;

	}

	public void removeMax(){
		values[1] = values[nextIndex - 1];
		if (nextIndex == 2){
			values[1] = 0;
			nextIndex = 1;
		}
		int index = 1;
		while (index * 2 < values.length && (values[index] < values[index*2] || values[index] < values[index*2 + 1])){
			if (values[index] < values[index*2]){
				int temp = values[index*2];
				values[index*2] = values[index];
				values[index] = temp;
				index = index*2;
			} else {
				int temp = values[index*2-1];
				values[index*2-1] = values[index];
				values[index] = temp;
				index = index*2 - 1;
			}

		}
		
		nextIndex--;
	}


	public String toString(){
		String str = "";
		for (int x = 1; x < nextIndex;x++){
			str += "" + x + ": " + values[x] + "\n";
		}
		return str;
	}

}