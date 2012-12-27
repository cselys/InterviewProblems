package fantasist.InterviewProblems.leetcode.passed;

public class BestTimeToBuyAndSellStockIII {

	public int maxProfit(int[] prices) {
		if (prices == null)
			return 0;
		
		// Can be a generic solution to any number of transactions!
		int[] buyAndSells = new int[4];
		for (int i = 0; i < buyAndSells.length; i++)
			buyAndSells[i] = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
			for (int j = buyAndSells.length - 1; j >= 0; j--) {
				if (j % 2 == 1) {
					if  (buyAndSells[j-1] != Integer.MIN_VALUE && prices[i] + buyAndSells[j-1] > buyAndSells[j])
						buyAndSells[j] = prices[i] + buyAndSells[j-1];
				} else {
					if (j == 0) {
						if (-prices[i] > buyAndSells[j])
							buyAndSells[j] = -prices[i];
					} else {
						if (buyAndSells[j-1] != Integer.MIN_VALUE && buyAndSells[j-1] - prices[i] > buyAndSells[j]) {
							buyAndSells[j] = buyAndSells[j-1] - prices[i];
						}
					}
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < buyAndSells.length; i++) {
			if (buyAndSells[i] > max)
				max = buyAndSells[i];
		}
		return max;
    }
    
	public static void main(String[] args) {
		BestTimeToBuyAndSellStockIII b = new BestTimeToBuyAndSellStockIII();
		
		int[] prices = {1, 2};
		System.out.println(b.maxProfit(prices));
	}

}
