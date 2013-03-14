package fantasist.InterviewProblems.other;


public class RPConservation {

	public int maxRP(int[] actions) {
		if (actions == null || actions.length == 0)
			return 0;
		int positive = 0, negative = 0;
		for (int i = 0; i < actions.length; i++) {
			int temp = negative;
			if (positive + actions[i] > negative)
				negative = positive + actions[i];
			if (temp - actions[i] > positive)
				positive = temp - actions[i];
		}
		
		return Math.max(negative, positive);
	}
	
	public static void main(String[] args) {
//		int[] actions = {1};
//		int[] actions = {1, 2};
		int[] actions = {2, 3, 4, 2, 1, 3, 2};
		RPConservation r = new RPConservation();
		System.out.println(r.maxRP(actions));
	}

}
