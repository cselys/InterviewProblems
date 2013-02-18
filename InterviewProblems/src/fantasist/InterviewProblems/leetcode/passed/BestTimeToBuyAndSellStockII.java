package fantasist.InterviewProblems.leetcode.passed;

public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
    	if (prices == null || prices.length < 2)
    		return 0;
        int profit = 0, low = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > low)
                profit += prices[i] - low;
            low = prices[i];
        }
        
        return profit;
    }
    
	public static void main(String[] args) {

		int[] prices = {1, 3, 2, 4, 6, 1, 3};
//		int[] prices = {0, 2};
//		int[] prices = {2, 0};
//		int[] prices = {1, 2, 3};
		
		BestTimeToBuyAndSellStockII b = new BestTimeToBuyAndSellStockII();
		System.out.println(b.maxProfit(prices));
	}

}
