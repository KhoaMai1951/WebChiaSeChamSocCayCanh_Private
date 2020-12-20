package com.myclass.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;

import com.myclass.entity.User;
import com.myclass.service.CategoryService;
import com.myclass.service.CommentService;
import com.myclass.service.PostService;
import com.myclass.service.RoleService;
import com.myclass.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {
	@Autowired
	CategoryService categoryService;

	@Autowired
	RoleService roleService;

	@Autowired
	PostService postService;

	@Autowired
	CommentService commentService;

	@Autowired
	UserService userService;

	// ================================INIT BINDER=================================
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	// =================================USER POST===================================
	// posts management page
	@GetMapping(path = "/posts")
	String posts(Model model) {
		model.addAttribute("posts", postService.findAllByUser());

		return "admin-page/v1/posts/index";
	}

	// soft delete
	@GetMapping(path = "/posts/soft-delete")
	String softDelete(@RequestParam String id) {
		this.postService.softDelete(id);
		return "redirect:/admin/user/posts";
	}

	// show deleted posts page
	@GetMapping(path = "/posts/deleted")
	String restorePostsPage(Model model) {

		model.addAttribute("posts", postService.findAllPostsDeleted());
		return "admin-page/v1/posts/deleted";
	}

	// restore deleted news
	@GetMapping(path = "/posts/restore")
	String restore(@RequestParam String id) {
		this.postService.restore(id);
		return "redirect:/admin/user/posts/deleted";
	}

	// delete
	@GetMapping(path = "/posts/delete")
	String delete(@RequestParam String id) {
		this.postService.deleteById(id);
		return "redirect:/admin/user/posts";
	}

	// =================================USER LIST===================================
	// user list page
	@GetMapping(path = "/list")
	String users(Model model) {
		model.addAttribute("users", userService.findAll());

		return "admin-page/v1/users/index";
	}

	// add user page
	@GetMapping(path = "/add")
	String add(Model model, HttpServletRequest request) {
		// check inform message
		if (request.getParameterMap().containsKey("success"))
			model.addAttribute("success", true);
		if (request.getParameterMap().containsKey("fail"))
			model.addAttribute("fail", true);

		model.addAttribute("user", new User());
		model.addAttribute("roles", this.roleService.findAll());
		return "admin-page/v1/users/add";
	}

	// add user
	@PostMapping(path = "/add")
	ModelAndView addUser(
			@ModelAttribute @Valid User user, 	// this is the bean
			BindingResult bindingResult, 		// your BindingResult needs to be placed immediately after the bean
			Model model,
			HttpServletRequest request, 
			RedirectAttributes redirectAttributes) throws IOException {

		if (bindingResult.hasErrors()) {
			System.out.println("BINDING RESULT ERROR");
			return new ModelAndView("admin-page/v1/users/add");
		}
//		int roleId = Integer.parseInt((String) request.getParameter("roleId"));
//		if(this.userService.save(user, roleId) == true)
//		{
//			redirectAttributes.addAttribute("success", true);
//		}
//		else redirectAttributes.addAttribute("fail", true);  
//		//return "redirect:/admin/user/add";
		return new ModelAndView("redirect:/admin/user/add");

	}
}
