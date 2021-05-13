import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Application {

	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<Student>();
		ArrayList<Mentor> mentors = new ArrayList<Mentor>();
		
		ArrayList<String> student1Lessons = new ArrayList<String>();
		student1Lessons.add("math");
		student1Lessons.add("literature");
		Student student1 = new Student(1, "Károly", 26, student1Lessons, 1);
		
		ArrayList<String> student2Lessons = new ArrayList<String>();
		student2Lessons.add("math");
		student2Lessons.add("IT");
		student2Lessons.add("biology");
		student2Lessons.add("music");
		Student student2 = new Student(2, "Balázs", 24, student2Lessons, 1);
		
		ArrayList<String> student3Lessons = new ArrayList<String>();
		student3Lessons.add("IT");
		student3Lessons.add("physics");
		student3Lessons.add("music");
		Student student3 = new Student(3, "Kata", 28, student3Lessons, 2);
		
		students.add(student1);
		students.add(student2);
		students.add(student3);
		
		Mentor mentor1 = new Mentor(1, "Tamás");
		Mentor mentor2 = new Mentor(2, "Zsolt");
		
		mentors.add(mentor1);
		mentors.add(mentor2);
		
		System.out.println("minden diákot irjunk ki");
		System.out.println(students.toString());
		
		System.out.println("28 évnél fiatalabbak");
		List<Student> q2 = students.stream().filter(s -> s.age < 28).collect(Collectors.toList());
		System.out.println(q2.toString());
		
		System.out.println("//azon diákok, akiknek lesz \"music\" órájuk");
		List<Student> q3 = students
				.stream()
				.filter(s -> s.lessons.contains("music"))
				.collect(Collectors.toList());
		System.out.println(q3.toString());
		
		System.out.println("legfiatalabb diák");
        Comparator<Student> minComparator = new Comparator<Student>() {
            
            @Override
            public int compare(Student s1, Student s2) {
                return s1.age > s2.age ? 1 : -1;
            }
        };
 
        Optional<Student> q4 = students.stream()
                                .min(minComparator);
        
		System.out.println(q4.toString());
		
		System.out.println("hány diáknak lesz \"math\" órája");
		
		long q5 = students.stream().filter(s -> s.lessons.contains("math")).count();
		
		System.out.println(q5);
		
		System.out.println("azok a diákok, akiknek Tamás a mentora");
		
		List<Student> q6 = students.stream()
	            .filter(s -> mentors.stream()
	                         .anyMatch(m -> s.mentor == m.id && m.name == "Tamás"))
	            .collect(Collectors.toList());
		
		System.out.println(q6.toString());
	}

}
