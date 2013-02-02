package fantasist.InterviewProblems.leetcode.passed;

import java.util.ArrayList;

public class RestoreIPAddresses {

    ArrayList<String> res;
    int[] buff;
    
    private void splitHelper(String s, int pos, int seg) {
        if (seg == 4 && pos == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                if (i > 0)
                    sb.append(".");
                sb.append(buff[i]);
            }
            res.add(sb.toString());
            return;
        } else if (seg == 4 || pos == s.length())
            return;
        
        char c = s.charAt(pos);
        int possible = buff[seg] * 10 + (int)(c - '0');
        if (possible < 256) {
            int temp = buff[seg];
            buff[seg] = possible;
            if (buff[seg] > 0)
                splitHelper(s, pos + 1, seg);
            splitHelper(s, pos + 1, seg + 1);
            buff[seg] = temp;
        }
    }
    
    public ArrayList<String> restoreIpAddresses(String s) {
        res = new ArrayList<String>();
        buff = new int[4];
        
        splitHelper(s, 0, 0);
        
        return res;
    }
    
    public static void main(String[] args) {
        RestoreIPAddresses r = new RestoreIPAddresses();
        ArrayList<String> list = r.restoreIpAddresses("010010");
        for (String s : list)
            System.out.println(s);
    }

}
