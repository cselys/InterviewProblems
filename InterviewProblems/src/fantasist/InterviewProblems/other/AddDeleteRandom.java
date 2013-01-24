package fantasist.InterviewProblems.other;

import java.util.HashMap;
import java.util.Random;

public class AddDeleteRandom {

	private HashMap<Integer, Integer> map;
	private int[] arr;
	private int size;
	private Random random;
	
	public AddDeleteRandom(int maxSize) {
		arr = new int[maxSize];
		map = new HashMap<Integer, Integer>();
		size = 0;
		random = new Random();
		System.out.println("Initialized");
	}
	
	public boolean add(int num) {
		if (size == arr.length) {
			System.out.println("[ERROR] Cannot add " + num + " because the storage is full");
			return false;
		}
		if (map.containsKey(num)) {
			System.out.println("[ERROR] Cannot add " + num + " because the number already exists");
			return false;
		}
		arr[size] = num;
		map.put(num, size);
		
		System.out.println("Added: (" + num + ", " + size + "), new size: " + (size+1));
		
		size++;
		
		return true;
	}
	
	public boolean delete(int num) {
		Integer index = map.get(num);
		if (index == null)
			return false;
		
		System.out.println("Removed: (" + num + ", " + index + "), new element: ("
				+ arr[size-1] + ", " + (size-1) + "), new size: " + (size-1));
		arr[index] = arr[size-1];
		map.remove(arr[index]);
		map.put(arr[index], index);
		size--;
		
		return true;
	}
	
	public Integer getRandom() {
		if (size == 0)
			return null;
		
		int randomIndex = random.nextInt(size);
		return arr[randomIndex];
	}
	
	public static void main(String[] args) {
		AddDeleteRandom adr = new AddDeleteRandom(4);
		adr.add(1);
		adr.add(2);
		adr.add(3);
		adr.add(4);
		adr.add(3);
		adr.delete(4);
		adr.add(5);
		adr.add(1);
		adr.add(6);
		
		int rounds = 10;
		while (rounds-- > 0) {
			System.out.println("Get random: " + adr.getRandom());
		}
	}

}
