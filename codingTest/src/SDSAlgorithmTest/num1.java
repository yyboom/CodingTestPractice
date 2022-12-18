package SDSAlgorithmTest;
public class num1 {
	static int finalse = 0;
	// 배열 하나 줄이는 것
	public static int[] minus(int[] arr) {
		int[] newresult = new int[arr.length - 1];
		for (int i = 0; i < newresult.length; i++) {
			newresult[i] = arr[i + 1];
		}
		return newresult;

	}
	
	public static int add(int a) {
		
		return 0;
	}

	// 순열
	public static void permutation(int[] newresult, int[] out, boolean[] visited, int depth, int r, int var,
			int[] arr) {
		boolean a = false;
		int[] finalse1 = new int[1];
		int answer = 0;
		int cnt = 0;
		int count = 1;

		for (int i = 1; i < arr.length; i++) {
			count = count * i;
		}

		if (depth == r) {

			a = true;
			if (a == true) {
				int[][] newNumlist = new int[count][newresult.length + 2];
				for (int i1 = 0; i1 < out.length; i1++) {
					for (int k = 0; k < newresult.length; k++) {
						int[] newlist = new int[newresult.length + 2];
						newlist[0] = var;
						newNumlist[i1][0] = newlist[0];
						newlist[k + 1] = out[k];
						newNumlist[i1][k + 1] = newlist[k + 1];
						newlist[newlist.length - 1] = var;
						newNumlist[i1][newlist.length - 1] = newlist[newlist.length - 1];
					}
				}

				int total = 0;
				int u = 0;
				int selectnum[][] = new int[newNumlist.length][newNumlist[0].length - 1];
				for (int o = 0; o < newNumlist.length; o++) {
					for (int h = 0; h < newNumlist[0].length - 1; h++) {
						total = newNumlist[o][h] + newNumlist[o][h + 1];

					}

					for (long k = 1; k < 400; k++) {

						if (total / k == k && total % k == 0) {
							answer = answer + 1;
						}
					}

				}

			}
			if(finalse1[0]<answer) {
				finalse1[0]=answer;
				finalse=answer;
			}

			
		} else

		{
			for (int i = 0; i < newresult.length; i++) {
				if (!visited[i]) {
					visited[i] = true;
					out[depth] = newresult[i];
					permutation(newresult, out, visited, depth + 1, r, var, arr);
					visited[i] = false;
				}
				a = false;
			}

		}
	}

	public static void main(String[] args) {
		int n=1;
		int[] arr = { 1, 3, 6, 8 };
		minus(arr);
		int r = minus(arr).length;
		permutation(minus(arr), new int[r], new boolean[minus(arr).length], 0, r, arr[0], arr);
		System.out.println(finalse);

	}

}