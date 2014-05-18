

public class RMRunner{
	
	public static void main(String[] args){

		RunningMedian R = new RunningMedian();

		for (int x = 0; x < 100; x++){
			R.add((int)(Math.random() * 100));
		}

		System.out.println(R);

	}
}