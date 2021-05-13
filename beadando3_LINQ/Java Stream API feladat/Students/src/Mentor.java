public class Mentor {
	public int id;
	public String name;
	
	public Mentor(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Id:" + id + ", Name: " + name + "\n";
	}
}
