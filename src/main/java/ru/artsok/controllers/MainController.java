package ru.artsok.controllers;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.artsok.dao.entitys.User;
import ru.artsok.dao.implementes.UserDaoImpl;

import javax.validation.Valid;

@Controller

public class MainController {

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView main(ModelAndView modelAndView) {

        modelAndView.setViewName("index");
        if (modelAndView.getModel().get("context") == null)
            modelAndView.addObject("context", "contexts/about_as.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/registration")
    public ModelAndView registration(@Valid User user, BindingResult result) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView modelAndView = new ModelAndView();
        new UserDaoImpl().appendNewUser(user);
        if (authentication != null) {
            modelAndView.addObject("username", authentication.getName());
        }

        modelAndView.setViewName("index");
        modelAndView.addObject("context", "contexts/account.jsp");

        return modelAndView;
    }
}
