package ru.artsok.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.artsok.dao.entitys.Productions;
import ru.artsok.dao.entitys.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public ModelAndView getAuthenticationName(ModelAndView modelAndView) {
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
    public ModelAndView productionRedirect() {
        ModelAndView modelAndView = new ModelAndView();
        List<Productions> productionses = new ArrayList<>();
        getAuthenticationName(modelAndView);
        modelAndView.setViewName("index");
        modelAndView.addObject("context", "contexts/productions.jsp");
        productionses = new ArrayList<>(Arrays.asList(
                new Productions.ProductionsBuilder().mainImage("/resources/images/production_menu/mgp.jpg").mainText("Модули газового пожаротушени")
                        .buttonName("MGP").build(),
                new Productions.ProductionsBuilder().mainImage("/resources/images/production_menu/migu.jpg").mainText("Модули изотермические для жидкой двуокиси углерода")
                        .buttonName("MIGU").build(),
                new Productions("/resources/images/production_menu/aist.jpg", "Прибор приемно-контрольный пожарный и управления ППКПУ-4/16 «АИСТ", "PPKPU", "", "", "", "", ""),
                new Productions("/resources/images/production_menu/stoika_el.jpg", "СТОЙКИ С ВЕСОВЫМИ УСТРОЙСТВАМИ ДЛЯ МОДУЛЕЙ", "ASTE", "", "", "", "", "</tr><tr>"),

                new Productions("/resources/images/production_menu/stoika_mex.jpg", "СТОЙКА С МЕХАНИЧЕСКИМ ВЕСОВЫМ УСТРОЙСТВОМ", "AST", "", "", "", "", ""),
                new Productions("/resources/images/production_menu/rampa.jpg", "РАМПЫ ДЛЯ МГП", "RAMP", "", "", "", "", ""),
                new Productions("/resources/images/production_menu/opora.jpg", "Опоры стеновые", "OPORA", "", "", "", "", ""),
                new Productions("/resources/images/production_menu/kollector.jpg", "Коллектора", "COLLECTOR", "", "", "", "", "</tr><tr>"),

                new Productions("/resources/images/production_menu/rvd.jpg", "РУКАВА ВЫСОКОГО ДАВЛЕНИЯ", "RVD", "", "", "", "", ""),
                new Productions("/resources/images/production_menu/truboprovod.jpg", "ТРУБОПРОВОД ДЛЯ ПНЕВМОПУСКА", "TRUBPROV", "", "", "", "", ""),
                new Productions("/resources/images/production_menu/nipel.jpg", "НИППЕЛИ И ПЕРЕХОДНИКИ", "NIPPEL", "", "", "", "", ""),
                new Productions("/resources/images/production_menu/nasadok.jpg", "НАСАДКИ", "NASADKI", "", "", "", "", "</tr><tr>"),

                new Productions("/resources/images/production_menu/klapan.jpg", "ОБРАТНЫЕ КЛАПАНЫ ГЕРМЕТИЧНЫЕ", "KLAPAN", "", "", "", "", ""),
                new Productions("/resources/images/production_menu/ru.jpg", "РАСПРЕДЕЛИТЕЛЬНЫЕ УСТРОЙСТВА", "RU", "", "", "", "", ""),
                new Productions.ProductionsBuilder().mainImage("/resources/images/production_menu/pobud_ballon.jpg").mainText("Баллон побудительный")
                        .buttonName("BALLON_PAB").build(),
                new Productions("/resources/images/production_menu/soedenenie.jpg", "СОЕДИНЕНИЯ РЕЗЬБОВЫЕ", "SOEDEN", "", "", "", "", "</tr><tr>"),

                new Productions("/resources/images/production_menu/zaglushka.jpg", "ЗАГЛУШКИ ИСПЫТАТЕЛЬНЫЕ", "ZAGLUSHKA", "", "", "", "", ""),
                new Productions("/resources/images/production_menu/opresov.jpg", "УСТРОЙСТВО ДЛЯ ОПРЕССОВКИ И ПРОДУВКИ", "UFOROPR", "", "", "", "", ""),
                new Productions("/resources/images/production_menu/ballon_opress.jpg", "БАЛЛОН ДЛЯ ОПРЕССОВКИ И ПРОДУВКИ", "BALLON_FOR_OPR", "", "", "", "", ""),
                new Productions("/resources/images/production_menu/telega.jpg", "ТЕЛЕЖКА ТРАНСПОРТНАЯ", "TELEGKA", "", "", "", "", "</tr><tr>"),

                new Productions("/resources/images/production_menu/zaprav.jpg", "УСТРОЙСТВО ЗАПРАВОЧНОЕ", "ZAPRAVOCNOE", "", "", "", "", ""),
                new Productions("/resources/images/production_menu/podemnic.jpg", "ПОДЪЕМНИК ДЛЯ МГП", "PODEMNIK", "", "", "", "", ""),
                new Productions("/resources/images/production_menu/control_pusc.jpg", "ПРИСПОСОБЛЕНИЕ ДЛЯ КОНТРОЛЯ ПУСКОВОГО УСТРОЙСТВА МГП", "PRISP_FOR_CONTR_PUSK", "", "", "", "", ""),
                new Productions.ProductionsBuilder().mainImage("/resources/images/production_menu/ukm.jpg").mainText("Устройство контролля массы")
                        .buttonName("UKM").build()
        ));
        modelAndView.addObject("production", productionses);

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

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        String name = null;

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                name = file.getOriginalFilename();
                return "You successfully uploaded file=" + name;
            } catch (IOException e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        }
        return "NULL";
    }

}
