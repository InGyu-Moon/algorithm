import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer token;

	static int n, m;
	static int[] arr;
	static int[] selected;
	static boolean[] visited;

	public static void sol(int depth) {
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				output.append(selected[i]).append(" ");
			}
			output.append("\n");
			return;
		}
		int temp = -1;
		for (int i = 0; i < n; i++) {
			if (temp == arr[i])
				continue;
			temp = arr[i];
			selected[depth] = arr[i];
			sol(depth + 1);
		}
	}

	public static void init() throws Exception {
		token = new StringTokenizer(input.readLine());
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		arr = new int[n];
		selected = new int[m];
		visited = new boolean[n];
		token = new StringTokenizer(input.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
		Arrays.sort(arr);
	}

	public static void main(String[] args) throws Exception {
		init();
		sol(0);
		System.out.println(output);
	}
}