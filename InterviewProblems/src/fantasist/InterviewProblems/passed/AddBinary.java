package fantasist.InterviewProblems.passed;

public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || b == null) {
        	return "0";
        }
        
        char[] str = new char[Math.max(a.length(), b.length()) + 1];
        int idxA = a.length() - 1;
        int idxB = b.length() - 1;
        int i = 0;
        int carry = 0;
        while (idxA >= 0 || idxB >= 0 || carry > 0) {
        	int digit = 0;
        	if (idxA >= 0 && a.charAt(idxA) == '1')
        		digit += 1;
        	if (idxB >= 0 && b.charAt(idxB) == '1')
        		digit += 1;
        	digit += carry;
        	switch(digit) {
        	case 0:
        		str[i] = '0';
        		carry = 0;
        		break;
        	case 1:
        		str[i] = '1';
        		carry = 0;
        		break;
        	case 2:
        		str[i] = '0';
        		carry = 1;
        		break;
        	case 3:
        		str[i] = '1';
        		carry = 1;
        		break;
        	default:
        		break;
        	}
        	idxA--;
        	idxB--;
        	i++;
        }
        
        char[] str2 = new char[i];
        for (int j = 0; j < i; j++) {
        	str2[j] = str[i - j - 1];
        }
        String result = String.copyValueOf(str2);
    	
    	return result;
    }
    
	public static void main(String[] args) {
		String a = "0";
		String b = "0";
		AddBinary ab = new AddBinary();
		System.out.println(ab.addBinary(a, b));
	}

}
