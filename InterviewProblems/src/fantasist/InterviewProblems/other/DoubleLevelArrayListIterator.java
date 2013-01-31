package fantasist.InterviewProblems.other;

import java.util.ArrayList;
import java.util.Iterator;

public class DoubleLevelArrayListIterator {

    private Iterator<ArrayList<Integer>> itLvl1;
    private Iterator<Integer> itLvl2;
    
    public DoubleLevelArrayListIterator(ArrayList<ArrayList<Integer>> a) {
        itLvl1 = a.iterator();
        itLvl2 = null;
    }
    
    public boolean hasNext() {
        if (itLvl2 != null && itLvl2.hasNext()) {
            return true;
        } else {
            while ((itLvl2 == null || !itLvl2.hasNext()) && itLvl1.hasNext()) {
                itLvl2 = itLvl1.next().iterator();
            }

            return itLvl2 != null && itLvl2.hasNext();
        }
    }
    
    public Integer next() {
        if (itLvl2 != null && itLvl2.hasNext()) {
            return itLvl2.next();
        } else {
            while ((itLvl2 == null || !itLvl2.hasNext()) && itLvl1.hasNext()) {
                itLvl2 = itLvl1.next().iterator();
            }
            
            if (itLvl2 != null && itLvl2.hasNext())
                return itLvl2.next();
            else
                return null;
        }
    }
    
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        for (int i = 1; i <= 5; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int j = 1; j <= i; j++) {
                temp.add(i * j);
            }
            a.add(temp);
        }
        DoubleLevelArrayListIterator it = new DoubleLevelArrayListIterator(a);
        
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
