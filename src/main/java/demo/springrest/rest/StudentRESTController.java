package demo.springrest.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.springrest.entity.Student;
import demo.springrest.exception.StudentNotFoundException;

@RestController
@RequestMapping("/api")
public class StudentRESTController {
	
	private List<Student> students;
	
	// define @PostConstruct to load student data.. execute only once after bean creation 
	@PostConstruct
	public void loadData() {
		
		students = new ArrayList<Student>();
		
		students.add(new Student("Debi", "Mishra"));
		students.add(new Student("Debi", "Prasad"));
		students.add(new Student("Vicky", "Mishra"));
		students.add(new Student("Rog", "Debi"));
	}

	// define end-point for a "/students" - return list of students
	@GetMapping("/students")
	public List<Student> getStudents(){
		return students;
	}
	
	// define end-point for "/students/{studentId}" - return student index in ArrayList
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId)
	{
		// just index it into the list 
		
		// check the studentId against the list.size()
		if((studentId >= students.size()) || (studentId<0))
			throw new StudentNotFoundException("Student Not Found with id "+studentId);
		
		return students.get(studentId);
	}
	
}












