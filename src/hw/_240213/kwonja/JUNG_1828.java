package hw._240213.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class JUNG_1828 {
/*
 * 냉장고
 */
	
	//그리디로 풀었는데 왜 맞았는지 모르겠다...
	//최대 보관온도 기준으로 정렬하고 그 다음 음식이 냉장고에 들어올수 있으면 패스
	//냉장고의 최대 보관온도에 올수 없으면 새로운 냉장고 생성
	public static class CompareClass implements Comparator<Pair>
	{
		@Override
		public int compare(Pair o1, Pair o2) {
			//내림차순정렬
			if(o1.getY()==o2.getY())
			{
				return o1.getX()-o2.getX();
			}
			return o1.getY()-o2.getY();
		}
		
	}
	static Pair[] refri;
	public static void main(String[] args) throws IOException {
//		System.setIn(JUNG_1828.class.getResourceAsStream(".txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		refri = new Pair[n];
		
		for(int i=0;i<n;i++)
		{
			st = new StringTokenizer(br.readLine());
			refri[i]=new Pair(Integer.parseInt(st.nextToken())	,Integer.parseInt(st.nextToken()));		
		}
		Arrays.sort(refri,new CompareClass());
		int cnt=1;
		int newrefri=refri[0].getY();
		for(int i=1;i<n;i++)
		{
			//같은 냉장고에 대입
			if(refri[i].getX()<=newrefri)continue;
			newrefri = refri[i].getY();
			cnt++; //냉장고 추가
			
		}
		System.out.println(cnt);
		
		
	}
	
	

}
