//  (아홉 개의 수 중 합이 100이 되는 일곱 개의 수를 찾으시오)
// 조합
package hw;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3040 {

	
	static int[] arr;
	static int[] result;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		result = new int[7];
		//visited = new boolean[9];
		for(int i=0; i<9; i++)
		{
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		combinations(0,0,0);
		

	}

	private static void combinations(int index, int k, int sum) {
		// TODO Auto-generated method stub
		
		if(index==7)
		{
			if(sum==100)
			{
				for (int r : result) {
					System.out.println(r);
				}
			}
			return;
		}
		
		
		for(int i=k; i<9; i++)
		{
			result[index] = arr[i];
			combinations(index+1, i+1, sum + arr[i]);
		}
		
	}

}
