package test.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import test.streams.pojo.Student;

public class StreamExample {

	public static void main(String[] args) {

		String[] arr = {"A", "AA", "BA", "ABA"};

		List<Student> students = new ArrayList<>();
		for (String str : arr) {
			Student s = new Student();
			s.setName(str);
			students.add(s);
		}

		// Traditional way
		List<String> names = new ArrayList<>();
		for (Student student : students) {
			if (student.getName().startsWith("A")) {
				names.add(student.getName());
			}
		}
		System.out.println("Traditional way");
		System.out.println(names);

		// Using Lambda Expression
		List<String> names1 = students.stream().map(Student::getName).filter(name -> name.startsWith("A")).collect(Collectors.toList());

		System.out.println("Using Lambda Expression");
		System.out.println(names1);

		List<String> names2 = students.stream().map(Student::getName).filter(name -> name.startsWith("A")).collect(Collectors.toList());
	}

}
