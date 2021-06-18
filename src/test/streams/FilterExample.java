package test.streams;

import java.util.Arrays;
import java.util.List;

public class FilterExample {
	
	public static void main(String args[]) {
		// TODO Auto-generated method stub
		
		List<String> l = Arrays.asList("Sam", "George", "Tom", "John");
		
		for (String s : l) {
			if (!s.equals("Sam")) {
				System.out.println(s);
			}
		}
		
		l.stream().filter(s-> s.equals("Sam")).forEach(s-> System.out.println(s));
		l.stream().filter(FilterExample::isNotSam).forEach(System.out::println);
		//l.stream()
	}
	
	private static boolean isNotSam(String s) {
		return !"Sam".equals(s);
	}

}
