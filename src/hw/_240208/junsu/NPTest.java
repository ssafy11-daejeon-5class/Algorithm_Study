package hw._240208.junsu;

import java.util.Arrays;
import java.util.Scanner;

public class NPTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		// step 0 : Sort!
		Arrays.sort(input);
		
		do {
			// 순열 이용한 처리 로직은 여기!
			System.out.println(Arrays.toString(input));
		} while(np(input));
	}

	// 순열의 뒷쪽부터 작은 변화를 준다.
	public static boolean np(int[] p) { // 현순열의 사전순 다음 순열 생성
		final int N = p.length;
		// step 1 : 교환 위치 찾기
		int i = N - 1;
		while (i > 0 && p[i - 1] >= p[i])
			i--;
		if (i == 0)
			return false;

		// step 2 : 교환위치(i-1)에 넣을 값 뒤쪽부터 찾기 (큰 값 중 최솟값)
		int j = N - 1;
		while (p[i - 1] >= p[j])
			--j;

		// step 3 : i-1값과 찾은 위치 j값 교환
		swap(p, i - 1, j);

		// step 4 : 꼭대기 위치부터 맨뒤까지 오름차순 정렬
		int k = N - 1;
		while (i < k)
			swap(p, i++, k--);
		return true;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
