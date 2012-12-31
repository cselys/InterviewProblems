package fantasist.InterviewProblems.leetcode.passed;

public class ContainerWithMostWater {
    
	public int maxArea(int[] height) {
		if (height == null || height.length < 2)
			return 0;
		
		int max = 0;
		int left = 0, right = height.length - 1;
		while (left < right) {
			int area = Math.min(height[left], height[right]) * (right - left);
			if (max < area)
				max = area;
			if (height[left] <= height[right]) {
				int temp = height[left];
				while (left < right && height[left] <= temp)
					left++;
			} else if (height[left] > height[right]) {
				int temp = height[right];
				while (left < right && height[right] <= temp)
					right--;
			} else {
				int temp = height[left];
				while (left < right && height[left] <= temp)
					left++;
				if (left == right)
					break;
				temp = height[right];
				while (left < right && height[right] <= temp)
					right--;
			}
		}
		
		return max;
    }
	
	public static void main(String[] args) {
	}

}
