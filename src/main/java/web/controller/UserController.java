package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired()
    public UserController(UserService userService) {
        this.userService = userService;
    }


   // @GetMapping("/")
//    @RequestMapping(value ="/", method = RequestMethod.GET)
//    public ModelAndView allUsers() {
//        List<User> list = userService.allUsers();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("users");
//        modelAndView.addObject("userList", list);
//        return modelAndView;
//    }

     @GetMapping("/")
    public String allUsers(Model model) {
         model.addAttribute("userList", userService.allUsers());
         return "users";
    }


//   // @GetMapping("/edit/{id}")
//    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
//    public ModelAndView editPage(@PathVariable("id") int id) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("editPage");
//        modelAndView.addObject("user", userService.getById(id));
//        return modelAndView;
//    }
    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable("id") int id, Model model) {
         model.addAttribute("user",userService.getById(id));
         return "editPage";
    }


//    @PostMapping("/edit")
//    //@RequestMapping(value = "/edit", method = RequestMethod.POST)
//    public ModelAndView editUser(@ModelAttribute("user") User user) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("redirect:/");
//        userService.edit(user);
//        return modelAndView;
//    }



    @PostMapping("/edit")
    //@RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("user") User user) {
         userService.edit(user);
         return "redirect:/";
    }
//@PatchMapping("/{id}")
////@RequestMapping(value = "/edit", method = RequestMethod.POST)
//public String editUser(@ModelAttribute("user") User user,  @PathVariable("id") int id) {
//    userService.edit(user);
//    return "redirect:/";
//}















//    @RequestMapping(value = "/add", method = RequestMethod.GET)
//    public ModelAndView addPage() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("new");
//        modelAndView.addObject("user", new User());
//        return modelAndView;
//    }

    @GetMapping("/add")
    public String addPage(Model model) {
         model.addAttribute("user", new User());
         return "new";
    }

//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public ModelAndView addFilm(@ModelAttribute("user") User user) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("redirect:/");
//        userService.add(user);
//        return modelAndView;
//    }

    @PostMapping("/add")
    public String addFilm(@ModelAttribute("user") User user) {
         userService.add(user);
         return "redirect:/";
    }



//    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
//    public ModelAndView deleteUser(@PathVariable("id") int id) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("redirect:/");
//        userService.delete(userService.getById(id));
//        return modelAndView;
//    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(userService.getById(id));
        return "redirect:/";
    }


}

