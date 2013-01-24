package fantasist.InterviewProblems.other;

public class CoinsInALine {

	public int maxProfit(int[] coins) {
		if (coins == null || coins.length == 0)
			return 0;
		
		int len = coins.length;
		int[][] dp = new int[len][len];
		for (int dist = 0; dist < len; dist++) {
			for (int start = 0; start + dist < len; start++) {
				int end = start + dist;
				if (dist == 0)
					dp[start][end] = coins[start];
				else if (dist == 1)
					dp[start][end] = Math.max(coins[start], coins[end]);
				else
					dp[start][end] = Math.max(
							coins[start] + Math.min(dp[start+2][end], dp[start+1][end-1]),
							coins[end] + Math.min(dp[start][end-2], dp[start+1][end-1]));
			}
		}
		
		return dp[0][len-1];
	}
	
	public static void main(String[] args) {
		int[] coins = {3, 2, 2, 3, 1, 2};
		
		CoinsInALine c = new CoinsInALine();
		System.out.println(c.maxProfit(coins));
	}
}
