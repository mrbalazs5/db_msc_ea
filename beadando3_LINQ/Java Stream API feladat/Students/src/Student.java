import java.util.List;

public class Student {
	public int id;
	public String name;
	public int age;
	public List<String> lessons;
	public int mentor;
	
	public Student(int id, String name, int age, List<String> lessons, int mentor) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.lessons = lessons;
		this.mentor = mentor;
	}
	
	@Override
	public String toString() {
		return "Id:" + id + ", Name: " + name + ", Age: " + age + ", Lessons: " + lessons + ", Mentor: " + mentor + "\n";
	}
}
