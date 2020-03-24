package com.cognizant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.model.Student;
import com.cognizant.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService ss;

	public void setSs(StudentService ss) {
		this.ss = ss;
	}

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insertPage() {
		return "INSERT";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest req) {
		ss.insert(req);
		req.setAttribute("msg", "Record Successfully Inserted");
		return "INSERT";

	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String updatePage() {
		return "UPDATE";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(HttpServletRequest req) {
		ss.update(req);
		req.setAttribute("msg", "Record Updated Inserted");
		return "UPDATE";

	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deletePage() {
		return "DELETE";
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(HttpServletRequest req) {
		ss.delete(req);
		req.setAttribute("msg", "Record Deleted Inserted");
		return "DELETE";

	}

	@RequestMapping(value = "show", method = RequestMethod.POST)
	public String show(HttpServletRequest req) {
		List<Student> list = ss.getAll();
		req.setAttribute("list", list);
		return "SHOW";

	}

}
