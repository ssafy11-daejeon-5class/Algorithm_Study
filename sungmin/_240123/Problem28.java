package codingTestPack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Pair
{
	private int x,y;
	public Pair(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}

public class Problem28 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("count.txt"));
		Scanner sc = new Scanner(System.in);
		Pair []map = new Pair[51360];
		int count=0;
		for(int i=1;i<=300;i++)
		{
			int x=1;
			int y=i;
			//x는 1부터 증가
			//y는 i부터 감소
			for(int j=0;j<=i-1;j++)
			{
				++count;
				map[count]=new Pair(x,y);
				x++;
				y--;
			}
		}
		int T=sc.nextInt();
		for(int test_case=1;test_case<=T;test_case++)
		{
			int p=sc.nextInt();
			int q=sc.nextInt();
			int nx = map[p].getX() + map[q].getX();
			int ny = map[p].getY() + map[q].getY();
			
			for(int i=1;i<45000;i++)
			{
				if(map[i].getX() == nx && map[i].getY()== ny)
				{
					System.out.println("#"+test_case +" " +i);
					break;
				}
			}
		}
		
	}
}
