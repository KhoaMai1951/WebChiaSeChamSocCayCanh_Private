package com.myclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myclass.service.CommentService;

@Controller
@RequestMapping("/admin/comment")
public class AdminCommentController {

	@Autowired
	CommentService commentService;

	// comment management page
	@GetMapping(path = "/list")
	String comments(Model model) {
		model.addAttribute("comments", commentService.findAll());

		return "admin-page/v1/comment/index";
	}

	// soft-delete comment
	@GetMapping(path = "/soft-delete")
	String softDelete(@RequestParam String id) {
		this.commentService.softDelete(Integer.parseInt(id));
		return "redirect:/admin/comment/list";
	}

	// deleted comment page
	@GetMapping(path = "/deleted")
	String deleted(Model model) {
		model.addAttribute("comments", commentService.findAllDeleted());

		return "admin-page/v1/comment/deleted";
	}

	// restore comment
	@GetMapping(path = "/restore")
	String restore(@RequestParam String id) {
		this.commentService.restore(Integer.parseInt(id));
		return "redirect:/admin/comment/deleted";
	}
}
