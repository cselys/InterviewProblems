package fantasist.InterviewProblems.leetcode.passed;

public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
    	if (prices == null || prices.length < 2)
    		return 0;
        int profit = 0;
        int start = 0, end;
        for(end = 1; end < prices.length; end++) {
        	if (prices[end] < prices[end - 1]) {
        		int newProfit = prices[end - 1] - prices[start];
        		if (end - 1 > start && newProfit > 0)
        			profit += newProfit;
        		start = end;
        	}
        }
        int lastProfit = prices[end - 1] - prices[start];
        if (end - 1 > start && lastProfit > 0)
        	profit += lastProfit;
        
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
