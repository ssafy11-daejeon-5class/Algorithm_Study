package study._240123.jeonghyeon;

import java.util.Scanner;

public class SWEA1493 {

	public static void main(String[] args) {
		
		/*
		 0 0 1 0 1 2 0 1 2 3 0 1 2 3 4 << 1부터 15까지 수들의 x좌표에서 1 뺀 값들
		 0 1 0 2 1 0 3 2 1 0 4 3 2 1 0 << 1부터 15까지 수들의 y좌표에서 1 뺀 값들
		 0 1 1 2 2 2 3 3 3 3 4 4 4 4 4 << 두 좌표의 합
		 1   3     6       10       15     21    28 ...
		 1 = 1*2/2  
		 3 = 2*3/2  
		 6 = 3*4/2  
		 10 = 4*5/2  
		 15 = 5*6/2  ...
		 
		 
		 입력받은 수가 저 중에 어떤 범위에 들어가는지를 먼저 구해야 함
		 그러려면 저 n*(n+1)/2 계산을 이용해서 추적할 수 있을 거 같음
		 
		 만약 입력받은 수에 2를 곱하고 루트를 한 값이 4.xx다 라고 하면
		 그 수는 8 이상 12 이하일 것이라고 추측할 수 있음. 
		 위의 표에서 입력수가 7~10까지는 x,y좌표 합이 3이고 11~15는 4임. 
		 그래서 입력수에서 계산했을 때 4.xx면 x,y좌표합은 3 아니면 4다.
		 그 둘중에 어떤 범위인지를 if문으로 딱 판별하고 좌표를 구해보면 된다.
		 
		 만약 xy좌표합이 4인데 여기서 xy 좌표를 구하려면
		 입력수가 뭐 12라고 해보자
		 우리는 xy좌표합이 4인 수들이 11부터 15까지라는 것을 알고있음 (4*5/2 초과 5*6/2 미만인 범위)
		 4*5/2로 기준을 잡아보자
		 12는 4*5/2(=10)보다 2만큼 크고
		 좌표는 (1, 3)이다.
		 10을 초과한 수 인 11의 x좌표가 0이고 이후로 1씩 커지므로
		 12의 x좌표를 산출하는 식은 2(=12-10) - 1 이라고 볼 수 있음
		 y는 xy합(=4)에서 x값을 빼면 됨.
		 이걸 일반화해서 코드로 만들자
		 
		 */
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();		
		for(int t = 1; t <= T; t++) {

			// 두 수와 정답수 각각 수, x좌표, y좌표 세가지 값을 가져야 함
			int[][] nums = new int[2][3];
			nums[0][0] = sc.nextInt();
			nums[1][0] = sc.nextInt();
			int[] answer = new int[3];
			
			for (int i = 0; i < nums.length; i++) {
				// 입력받은 수에 2를 곱하고 루트를 해봄
				int calculatedNum = (int) Math.sqrt(nums[i][0]*2);
				//System.out.println(calculatedNum);
				
				// 계산한 수를 이용해 x,y 좌표합을 구함
				int xPlusY;
				if (nums[i][0] > calculatedNum*(calculatedNum+1)/2) {
					xPlusY = calculatedNum;
				}
				else {
					xPlusY = calculatedNum - 1;
				}
				
				// x,y 좌표합을 이용해 x, y 각각의 값을 구함
				nums[i][1] = nums[i][0] - xPlusY*(xPlusY+1)/2 -1;
				nums[i][2] = xPlusY - nums[i][1];
			}

			// 정답 좌표 구하기
			// 문제에서는 xy좌표가 1부터 시작하는데 난 0으로 해버려서 +1 해서 보정을 해줌
			answer[1] = nums[0][1] + nums[1][1] + 1;
			answer[2] = nums[0][2] + nums[1][2] + 1;
			
			// 좌표에서 수를 구하는 건 아까 계산의 역순으로 하면 됨
			int xPlusY = answer[1] + answer[2];
			answer[0] = xPlusY * (xPlusY+1) / 2 + answer[1] + 1;
			System.out.println("#" + t + " " + answer[0]);
			
		}
	}
}
