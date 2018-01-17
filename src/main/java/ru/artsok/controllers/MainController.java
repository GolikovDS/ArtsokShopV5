package ru.artsok.controllers;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.artsok.dao.entitys.Order;
import ru.artsok.dao.entitys.Productions;
import ru.artsok.dao.entitys.User;
import ru.artsok.dao.implementes.UserDaoImpl;

import javax.validation.Valid;

@Controller
public class MainController {

    @RequestMapping(value = {"/", "/index", "/menu"}, method = RequestMethod.GET)
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

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String order(@ModelAttribute(name = "order")Order order) {
        return "redirect:/order";
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public ModelAndView orderRedirect(ModelAndView modelAndView) {
        getAuthenticationName(modelAndView);
        modelAndView.setViewName("index");
        modelAndView.addObject("context", "contexts/welcome_page.jsp");
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
                model.addObject("order", new Order.OrderBuilder().name("МГП ").type("16-100Эл хладон127-80кг.").quantity(0).build());
                break;
            case "MIGU":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("resources/images/migu/1.jpg").
                        secondImage("resources/images/migu/2.jpg").thirdImage("resources/images/migu/3.jpg").description("migu-description").build());
                model.addObject("order", new Order.OrderBuilder().name("МИЖУ").type("").quantity(0).build());
                break;
            case "PPKPU":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("resources/images/ppkpu/1.jpg").
                        secondImage("resources/images/ppkpu/2.jpg").thirdImage("resources/images/ppkpu/5.png").description("ppkpu-description").build());
                model.addObject("order", new Order.OrderBuilder().name("ППКПУ 4/16 ").type("").quantity(0).build());
                break;
            case "ASTE":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                model.addObject("order", new Order.OrderBuilder().name("А-СТ ").type("").quantity(0).build());
                break;
            case "AST":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                model.addObject("order", new Order.OrderBuilder().name("А-СТ ").type("").quantity(0).build());
                break;
            case "RAMP":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                model.addObject("order", new Order.OrderBuilder().name("Рампа").type("").quantity(0).build());
                break;
            case "OPORA":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                model.addObject("order", new Order.OrderBuilder().name("Опора").type("").quantity(0).build());
                break;
            case "COLLECTOR":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                model.addObject("order", new Order.OrderBuilder().name("Коллектор").type("").quantity(0).build());
                break;
            case "RVD":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("p").thirdImage("").description("in-work").build());
                model.addObject("order", new Order.OrderBuilder().name("РВД").type("").quantity(0).build());
                break;
            case "TRUBPROV":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                model.addObject("order", new Order.OrderBuilder().name("Трубопровод").type("").quantity(0).build());
                break;
            case "NIPPEL":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                model.addObject("order", new Order.OrderBuilder().name("Нипель").type("").quantity(0).build());
                break;
            case "NASADKI":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("resources/images/nasadki/1.jpg").
                        secondImage("resources/images/nasadki/2.jpg").thirdImage("resources/images/nasadki/3.jpg").description("nasadki-description").build());
                model.addObject("order", new Order.OrderBuilder().name("Насадок").type("").quantity(0).build());
                break;
            case "KLAPAN":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("resources/images/klapan/1.jpg").
                        secondImage("resources/images/klapan/2.jpg").thirdImage("resources/images/null.jpg").description("klapan-description").build());
                model.addObject("order", new Order.OrderBuilder().name("Клапан").type("").quantity(0).build());
                break;
            case "RU":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("resources/images/ru/1.jpg").
                        secondImage("resources/images/ru/2.jpg").thirdImage("resources/images/ru/3.jpg").description("ru-description").build());
                model.addObject("order", new Order.OrderBuilder().name("РУ").type("").quantity(0).build());
                break;
            case "BALLON_PAB":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                model.addObject("order", new Order.OrderBuilder().name("Баллон пабудительный").type("").quantity(0).build());
                break;
            case "SOEDEN":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                model.addObject("order", new Order.OrderBuilder().name("Соеденение резьбовое").type("").quantity(0).build());
                break;
            case "ZAGLUSHKA":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                model.addObject("order", new Order.OrderBuilder().name("Заглушка").type("").quantity(0).build());
                break;
            case "UFOROPR":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                model.addObject("order", new Order.OrderBuilder().name("Устройство для опресовки").type("").quantity(0).build());
                break;
            case "BALLON_FOR_OPR":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                model.addObject("order", new Order.OrderBuilder().name("Баллон для опресcовки и продувки").type("").quantity(0).build());
                break;
            case "TELEGKA":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                model.addObject("order", new Order.OrderBuilder().name("Тележка транспортеровочная ").type("").quantity(0).build());
                break;
            case "ZAPRAVOCNOE":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                break;
            case "PODEMNIK":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("p").thirdImage("").description("in-work").build());
                model.addObject("order", new Order.OrderBuilder().name("Подъемник").type("").quantity(0).build());
                break;
            case "PRISP_FOR_CONTR_PUSK":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                model.addObject("order", new Order.OrderBuilder().name("Приспособления для контроля пуска ").type("").quantity(0).build());
                break;
            case "UKM":
                model.addObject("production", new Productions.ProductionsBuilder().firstImage("").
                        secondImage("").thirdImage("").description("in-work").build());
                model.addObject("order", new Order.OrderBuilder().name("УКМ").type("").quantity(0).build());
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
