package controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Student;
import service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/list")
	public String getAllStudents(Map<String, List<Student>> map) {
		List<Student> students = studentService.findAllStudents();
		map.put("students", students);
		return "studentlist";

	}

	@GetMapping("/showform")
	public String showFormForSave(Model model) {
		Student student = new Student();
		model.addAttribute(student);
		return "studentform";
	}

	@GetMapping("/update/{id}")
	public String showFormForSave(Model model, @PathVariable int id) {
		Student student = this.studentService.findStudentById(id);
		model.addAttribute(student);
		return "studentform";
	}

	@PostMapping("/save")
	public String saveOrUpdate(Student student) {
		Student savedStudent = null;
		if (student.getId() != 0) {
			savedStudent = studentService.findStudentById(student.getId());
			savedStudent.setCountry(student.getCountry());
			savedStudent.setDepartment(student.getDepartment());
			savedStudent.setName(student.getName());
		} else {
			savedStudent = new Student(student.getName(), student.getDepartment(), student.getCountry());
		}
		this.studentService.saveorUpdate(savedStudent);
		return "redirect:/students/list";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		this.studentService.delete(id);
		return "redirect:/students/list";
	}
}
