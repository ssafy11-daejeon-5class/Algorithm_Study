package hw._240213.hyeona;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


// 최소힙? 

class Temperature implements Comparable<Temperature>{
	int low;
	int high;
	
	public Temperature(int low, int high) {
		super();
		this.low = low;
		this.high = high;
	}
	

	@Override
	public int compareTo(Temperature o) {
		// TODO Auto-generated method stub
		
		return this.high != o.high ? this.high - o.high : this.low - o.low;

	}
	
}

public class Jung_1828 {

	
	static Temperature[] refrigerator;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		
		refrigerator = new Temperature[N];
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			refrigerator[i] = new Temperature(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		
		Arrays.sort(refrigerator);
		int Ans=1;
		
		List<Temperature> list = new ArrayList<>();
		
		list.add(refrigerator[0]);
		
		for(int i=1; i<N; i++)
		{
			if(list.get(list.size()-1).high >= refrigerator[i].low) continue;
			else 
			{
				list.add(refrigerator[i]);
				Ans++;
			}
			
		}
		System.out.println(Ans);
		// System.out.println(refrigerator[0].low);
		// System.out.println(refrigerator[1].low);
		

	}

}
