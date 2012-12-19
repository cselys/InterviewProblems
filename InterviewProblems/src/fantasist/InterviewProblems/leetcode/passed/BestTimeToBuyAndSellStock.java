package fantasist.InterviewProblems.leetcode.passed;

public class BestTimeToBuyAndSellStock {

	public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
        	return 0;
        
		int max = 0;
		int left = 0;
    	
		for (int i = 1; i < prices.length; i++) {
			int diff = prices[i] - prices[left];
			if (diff > max)
				max = diff;
			
			if (prices[i] < prices[left])
				left = i;
		}
		
    	return max;
    }
	
	public static void main(String[] args) {

		int[] i = {1, 2, 5, 3, 6};
		BestTimeToBuyAndSellStock b = new BestTimeToBuyAndSellStock();
		
		System.out.println(b.maxProfit(i));
	}

}
