<Query Kind="Statements" />

var students = new [] {
	new {id = 1, name = "Károly", age = 26, lessons = new [] {"math", "literature"}, mentor = 1},
	new {id = 2, name = "Balázs", age = 24, lessons = new  [] {"math", "IT", "biology", "music"}, mentor = 1},
	new {id = 3, name = "Kata", age = 28, lessons = new [] {"IT", "physics", "music"}, mentor = 2}
};

var mentors = new [] {
	new {id = 1, name = "Tamás"},
	new {id = 2, name = "Zsolt"}
};

//minden diákot irjunk ki
var q1 = students.Select(s => new { s });
q1.Dump();

//28 évnél fiatalabbak
var q2 = students.Where(s => s.age < 28).Select(s => s.name);
q2.Dump();

//azon diákok, akiknek lesz "music" órájuk
var q3 = students.Where(s => s.lessons.Contains("music")).Select(s => s.name);
q3.Dump();

//legfiatalabb diák
var minAge = students.Min(s => s.age);
var q4 = students
			.Where(s => s.age == minAge)
			.Select( s => new {
				name = s.name, age = s.age
			});
q4.Dump();

//hány diáknak lesz "math" órája
var q5 = students.Where(s => s.lessons.Contains("math")).Count();
q5.Dump();

//azok a diákok, akiknek Tamás a mentora
var q6 = students
			.Join(mentors, s => s.mentor, m => m.id, (s, m) => new {s, m})
			.Where(sm => sm.m.name == "Tamás")
			.Select(sm => new {student = sm.s.name, mentor = sm.m.name});
q6.Dump();