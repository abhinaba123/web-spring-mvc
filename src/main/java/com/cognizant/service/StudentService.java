package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.cognizant.model.Student;

@Service
public class StudentService {
	private List<Student> li = new ArrayList<Student>();

	public void insert(HttpServletRequest req) {
		String id = req.getParameter("id");
		String name = req.getParameter("name");

		int id2 = Integer.parseInt(id);

		Student s = new Student(id2, name);

		System.out.println(s);
		li.add(s);
	}

	public void update(HttpServletRequest req) {
		String data = req.getParameter("id");
		String name = req.getParameter("name");
		int id = Integer.parseInt(data);
		Student st = new Student(id, name);

		Student s = null;
		if ((s = getByID(data)) != null) {
			li.remove(s);
		}

		li.add(st);
	}

	public void delete(HttpServletRequest request) {
		String data = request.getParameter("id");

		Student s = null;
		if ((s = getByID(data)) != null) {
			li.remove(s);
		}
	}

	public List<Student> getAll() {

		for (Student s : li) {
			System.out.println(s);
		}

		return li;
	}

	@SuppressWarnings("unlikely-arg-type")
	public Student getByID(String id) {
		for (Student s : li) {
			if (id.equals(s.getId())) {
				return s;
			}
		}
		return null;
	}

}
