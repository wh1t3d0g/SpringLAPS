package sg.edu.iss.lapsdemo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import sg.edu.iss.lapsdemo.model.User;
import sg.edu.iss.lapsdemo.service.UserService;
import sg.edu.iss.lapsdemo.service.UserServiceImpl;

@Controller
@SessionAttributes("display")
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService uservice; 
	
	@Autowired
	public void setUserService(UserServiceImpl userviceImpl) {
		this.uservice=userviceImpl;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		
	}
	
	@GetMapping(value="/login")
	public String login(@ModelAttribute("user") User user) {
		user=new User();
		return "login";
	}
	
	@GetMapping(value="/validate")
	public String validate(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
			Model model, HttpSession session) {
//		if(bindingResult.hasErrors()||user==null) {
//			return "login";
//		} 
//			User registeredUser=uservice.findUserByName(user.getUserName());
//			if(!registeredUser.getPassword().equals(user.getPassword())) {
//				return "login";
//			}
//			session.setAttribute("display",user.getUserName());
			return "success";			
	}
	
	@GetMapping("/logout")
	public String logout(@ModelAttribute("user") User user, Model model, HttpSession session) {
		session.setAttribute("display",null);
		return "forward:/user/login";
	}	
}
