package ru.artsok.controllers;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.artsok.dao.entitys.Productions;
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

    @RequestMapping(value = "/redirect_production", method = RequestMethod.GET)
    public ModelAndView addDescriptionProductionRedirect(ModelAndView model, @RequestParam("productName") String s) {
        getAuthenticationName(model);
        model.addObject("productName", s);
        switch (s) {
            case "MGP":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("resources/images/mgp/1.bmp").
                        secondImage("resources/images/mgp/2.bmp").thirdImage("resources/images/mgp/3.bmp").description("mgp-description").build());
                break;
            case "MIGU":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("resources/images/migu/1.jpg").
                        secondImage("resources/images/migu/2.jpg").thirdImage("resources/images/migu/3.jpg").description("in-work").build());
                break;
            case "PPKPU":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("resources/images/ppkpu/1.jpg").
                        secondImage("resources/images/ppkpu/2.jpg").thirdImage("resources/images/ppkpu/5.png").description("in-work").build());
                break;
            case "ASTE":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                break;
            case "AST":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                break;
            case "RAMP":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                break;
            case "OPORA":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                break;
            case "COLLECTOR":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                break;
            case "RVD":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("p").thirdImage("").description("in-work").build());
                break;
            case "TRUBPROV":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                break;
            case "NIPPEL":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                break;
            case "NASADKI":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                break;
            case "KLAPAN":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                break;
            case "RU":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                break;
            case "BALLON_PAB":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                break;
            case "SOEDEN":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                break;
            case "ZAGLUSHKA":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                break;
            case "UFOROPR":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                break;
            case "BALLON_FOR_OPR":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                break;
            case "TELEGKA":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                break;
            case "ZAPRAVOCNOE":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                break;
            case "PODEMNIK":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("p").thirdImage("").description("in-work").build());
                break;
            case "PRISP_FOR_CONTR_PUSK":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                break;
            case "UKM":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                break;

            default:
                break;
        }
        model.setViewName("index");
        model.addObject("context", "contexts/description_production.jsp");
        return model;
    }


    public ModelAndView getAuthenticationName(ModelAndView modelAndView) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            modelAndView.addObject("username", authentication.getName());
        }
        return modelAndView;
    }


}
