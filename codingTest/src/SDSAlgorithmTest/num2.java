package SDSAlgorithmTest;
public class num2 {
    	// 출력 및 입력
	public static void main(String[] args) {
		int[][] arr = { { 0, 0, 0, 0, 2 }, { 0, 9, 4, 0, 0 }, { 0, 0, 0, 2, 0 }, { 0, 1, 5, 1, 3 },
				{ 10, 0, 0, 0, 0 } };
		int N = 5;// 행
		int M = 5;// 열
		int K = 3;// 바람 수

		int cnt = 0;
		int[][] arr1=position(arr, K, M, N, cnt);

		int finish = findmax(arr1);
		
		System.out.println(finish);

	}

	// 방향
	public static int[][] position(int[][] arr, int K, int M, int N, int cnt) {
		// 랜덤으로 방향 고르기
		int[][] arr1 = new int[N][M];
		int rand = 0;
		int[] random = new int[K];
		// 랜덤 숫자 뽑기
		for (int i = 0; i < 1; i++) {
			rand = (int) (Math.random() * 4);
			random[i] = rand;
			System.out.println(rand);
		}

		if (K-1>= cnt) {
			int cnt1 = cnt + 1;
			// 움직이기
			for (int h = 0; h < 1; h++) {
				int ran = random[h];
				if (ran == 0) {
					arr = east(N, M, arr);
					System.out.println("ok");
					position(arr, K, M, N, cnt1);
					
				}
				if (ran == 1) {
					arr = west(N, M, arr);
					System.out.println("ok1");

					position(arr, K, M, N, cnt1);
					
				}
				if (ran == 2) {
					arr = south(N, M, arr);
					System.out.println("ok2");
					position(arr, K, M, N, cnt1);
					
				}
				if (ran == 3) {
					arr = north(N, M, arr);
					System.out.println("ok3");

					position(arr, K, M, N, cnt1);
					
				}
			}
		}
		arr1=arr;
		System.out.println(arr1[3][2]);
		return arr1;

	}

	// 동->서(동)
	public static int[][] east(int N, int M, int[][] arr) {
		int[][] arr1 = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int k = 0; k < M; k++) {
				// 끝까지 다달르지 않았을 때
				if (k != M - 1 && k != 0) {
					if (M > k + 1) {
						if (arr[i][k + 1] == 0) {
							// 자리바꿔주기
							arr1[i][k + 1] = arr[i][k];
							arr1[i][k] = 0;
						} else {
							arr1[i][k] = arr[i][k]+arr[i][k + 1];
						}
					}
				} else {
					arr1[i][k] = arr[i][k];
				}
			}
		}
		return arr1;
	}

	// 서->동(서)
	public static int[][] west(int N, int M, int[][] arr) {
		int[][] arr1 = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int k = 0; k < M; k++) {
				// 끝까지 다달르지 않았을 때
				if (k != M - 1 && k != 0) {
					if (k - 1 >= 0) {
						if (arr[i][k - 1] == 0) {
							arr1[i][k - 1] = arr[i][k];
							arr1[i][k] = 0;
						} else {
							arr1[i][k] = arr[i][k]+arr[i][k - 1];
						}
					}
				} else {
					arr1[i][k] = arr[i][k];
				}

			}
		}
		return arr1;
	}

	// 남->북(남)
	public static int[][] south(int N, int M, int[][] arr) {
		int[][] arr1 = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int k = 0; k < M; k++) {
				// 끝까지 다달르지 않았을 때
				if (k != M - 1 && k != 0) {
					if (N > i + 1) {
						if (arr[i + 1][k] == 0) {
							arr1[i + 1][k] = arr[i][k];
							arr1[i][k] = 0;
						} else {
							arr1[i][k] = arr[i][k]+arr[i + 1][k];
						}
					}
				} else {
					arr1[i][k] = arr[i][k];

				}
			}
		}
		return arr1;

	}

	// 북->남(북)
	public static int[][] north(int N, int M, int[][] arr) {
		int[][] arr1 = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int k = 0; k < M; k++) {
				if (k != M - 1 && k != 0) {
					if (i - 1 >= 0) {
						if (arr[i - 1][k] == 0) {
							arr1[i - 1][k] = arr[i][k];
							arr1[i][k] = 0;
						} else {
							arr1[i][k] = arr[i][k]+arr[i - 1][k];
						}
					}
				} else {
					arr1[i][k] = arr[i][k];
				}

			}
		}
		return arr1;
	}
	
	public static int findmax(int[][] arr1) {
	//다 끝난 다음
	int max = 0;
	int[][] test = new int[arr1.length][arr1[0].length];
	for(int j=0;j<arr1.length;j++) {
		for(int p=0;p<arr1[0].length;p++) {
			if(max<test[j][p]) {
				System.out.println(test[j][p]);
				max=test[j][p];
			}
		}
	}
	return max;
	}
}
