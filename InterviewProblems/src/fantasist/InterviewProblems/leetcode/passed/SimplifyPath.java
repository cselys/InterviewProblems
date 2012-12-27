package fantasist.InterviewProblems.leetcode.passed;

import java.util.LinkedList;

public class SimplifyPath {

    public String simplifyPath(String path) {
    	if (path == null)
    		return "/";
        LinkedList<String> list = new LinkedList<String>();
        int len = path.length();
        if (len < 2)
        	return "/";
        
        for (int i = 0; i < len; i++) {
        	if (path.charAt(i) == '/')
        		continue;
        	else if (path.charAt(i) == '.') {
        		if (i+1 < len && path.charAt(i+1) == '.') {
        			if (!list.isEmpty())
        				list.removeLast();
        			i++;
        		}
        	} else {
        		int start = i;
        		while (++i < len && path.charAt(i) != '/') {}
        		list.add(path.substring(start, i));
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        if (list.isEmpty())
        	return "/";
        for (String str : list)
        	sb.append("/" + str);
    	
    	return sb.toString();
    }
    
	public static void main(String[] args) {
		SimplifyPath s = new SimplifyPath();
		System.out.println(s.simplifyPath("/home/"));
		System.out.println(s.simplifyPath("/a/./b/../../c/"));
		System.out.println(s.simplifyPath("/./home/../"));
	}

}
