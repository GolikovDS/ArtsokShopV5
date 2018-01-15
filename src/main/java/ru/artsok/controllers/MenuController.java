package ru.artsok.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.artsok.dao.entitys.User;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @RequestMapping(params = "about", method = RequestMethod.POST)
    public String aboutAs() {
        return "redirect:/menu/about";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public ModelAndView redirectAboutAs() {
        ModelAndView modelAndView = new ModelAndView();
        getAuthenticationName(modelAndView);
        modelAndView.setViewName("index");
        modelAndView.addObject("context", "contexts/about_as.jsp");
        return modelAndView;
    }

    @RequestMapping(params = "basket", method = RequestMethod.POST)
    public String basket() {
        return "redirect:/menu/basket";
    }

    @RequestMapping(value = "/basket", method = RequestMethod.GET)
    public ModelAndView redirectBasket() {
        ModelAndView modelAndView = new ModelAndView();
        getAuthenticationName(modelAndView);
        modelAndView.setViewName("index");
        modelAndView.addObject("context", "contexts/basket.jsp");
        return modelAndView;
    }

    @RequestMapping(params = "login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "error", required = false) String error) {

        return "redirect:/menu/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView redirectLogin() {
        ModelAndView modelAndView = new ModelAndView();
        getAuthenticationName(modelAndView);
        modelAndView.setViewName("index");
        modelAndView.addObject("context", "contexts/lk_login.jsp");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public ModelAndView loginPost(@RequestParam(value = "error", required = false) String err) {
//        ModelAndView modelAndView = new ModelAndView();
//        getAuthenticationName(modelAndView);
//        modelAndView.setViewName("index");
//        modelAndView.addObject("context", "contexts/lk_login.jsp");
//        modelAndView.addObject("user", new User());
//
//        if (err != null) {
//            modelAndView.addObject("error", "error name or password");
//        }
//        return modelAndView;
//    }

    @RequestMapping(params = "contacts", method = RequestMethod.POST)
    public String menuContacts() {
        return "redirect:menu/menuContacts";
    }

    @RequestMapping(value = "/menuContacts", method = RequestMethod.GET)
    public ModelAndView menuContactsRedirect() {

        ModelAndView modelAndView = new ModelAndView();
        getAuthenticationName(modelAndView);
        modelAndView.setViewName("index");
        modelAndView.addObject("context", "contexts/contacts.jsp");
        return modelAndView;
    }

    public ModelAndView getAuthenticationName(ModelAndView modelAndView){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            modelAndView.addObject("username", authentication.getName());
        }
        return modelAndView;
    }
    @RequestMapping(params = "kat", method = RequestMethod.POST)
    public String production() {
        return "redirect:menu/kat";
    }
    @RequestMapping(value = "/kat", method = RequestMethod.GET)
    public ModelAndView productionRedirect(){
        ModelAndView modelAndView = new ModelAndView();
        getAuthenticationName(modelAndView);
        modelAndView.setViewName("index");
        modelAndView.addObject("context", "contexts/productions.jsp");

        return modelAndView;
    }

    @RequestMapping(params = "admin", method = RequestMethod.POST)
    public String admin() {
        return "redirect:menu/admin";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminRedirect() {
        ModelAndView modelAndView = new ModelAndView();
        getAuthenticationName(modelAndView);
        modelAndView.setViewName("index");
        modelAndView.addObject("context", "contexts/admin_panel.jsp");

        return modelAndView;
    }

    @RequestMapping(params = "welcome_page", method = RequestMethod.POST)
    public String welcome() {
        return "redirect:menu/admin";
    }

    @RequestMapping(value = "/welcome_page", method = RequestMethod.GET)
    public ModelAndView welcomeRedirect(ModelAndView modelAndView) {
//        ModelAndView modelAndView = new ModelAndView();
        getAuthenticationName(modelAndView);
        modelAndView.setViewName("index");
        modelAndView.addObject("context", "contexts/welcome_page.jsp");
        return modelAndView;
    }

    @RequestMapping(params = "add_production", method = RequestMethod.POST)
    public String addProduction() {
        return "redirect:menu/add_production";
    }

    @RequestMapping(value = "/add_production", method = RequestMethod.GET)
    public String addSpitterFromForm(BindingResult bindingResult, @RequestParam(value = "image", required = false) // Прием файла
            MultipartFile image) {
        return "contexts/welcome_page.jsp";
    }


    @RequestMapping(value = "/kat", method = RequestMethod.POST)
    public String addDescriptionProduction(Model model, @RequestParam("mgp") String s) {
        model.addAttribute("productName", s);
        return "redirect:/redirect_production";
    }



}
