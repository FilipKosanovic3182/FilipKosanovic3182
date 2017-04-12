/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.filipkosanovic3182;

import com.it355.filip.dao.BrandDao;
import com.it355.filip.dao.DisplayDao;
import com.it355.filip.dao.PicturesDao;
import com.it355.filip.dao.StrapDao;
import com.it355.filip.dao.UsersDao;
import com.it355.filip.dao.WatchDao;
import com.it355.filip.model.*;
import com.it355.filip.service.BrandService;
import com.it355.filip.service.DisplayService;
import com.it355.filip.service.PicturesService;
import com.it355.filip.service.StrapService;
import com.it355.filip.service.UsersService;
import com.it355.filip.service.WatchService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Filip Wolve
 */
@Controller
public class MainController {

    private BrandService brandService;
    private DisplayService displayService;
    private PicturesService picturesService;
    private StrapService strapService;
    private UsersService usersService;
    private WatchService watchService;

    @Autowired(required = true)
    @Qualifier(value = "brandService")
    public void setBrandService(BrandService bs) {
        this.brandService = bs;
    }
    @Qualifier(value = "displayService")
    public void setDisplayService(DisplayService ds) {
        this.displayService = ds;
    }
    @Qualifier(value = "picturesService")
    public void setPicturesService(PicturesService ps) {
        this.picturesService = ps;
    }
    @Qualifier(value = "strapService")
    public void setStrapService(StrapService ss) {
        this.strapService = ss;
    }
    @Qualifier(value = "usersService")
    public void setUsersService(UsersService us) {
        this.usersService = us;
    }
    @Qualifier(value = "watchService")
    public void setWatchService(WatchService ws) {
        this.watchService = ws;
    }

    /*@Autowired
    private BrandDao brandDao;

    @Autowired
    private DisplayDao displayDao;

    @Autowired
    private PicturesDao picturesDao;

    @Autowired
    private StrapDao strapDao;

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private WatchDao watchDao;*/

    /*@RequestMapping( value ="/dodajRezervaciju", method = RequestMethod.GET)
    public ModelAndView formRezervacijaAdd(ModelAndView model){
        model.addObject("rezervacija", new Rezervacija());
        model.setViewName("form_dodavanje_rez_Controller");
        return model;
        //return new ModelAndView("form_dodavanje_soba", "command", new Soba());
    }*/
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView defaultPage() {
        ModelAndView model = new ModelAndView();
        //model.addObject("stranica", "index.jsp");
        model.addObject("message", "Ovo je strana kojoj svi mogu da pristupe!");
        model.setViewName("index");
        return model;
    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("message", "Ovo je strana za admine!");
        model.setViewName("admin");
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Losi login podaci!");
        }
        if (logout != null) {
            model.addObject("msg", "Izlogovani ste.");
        }
        model.setViewName("login");
        return model;
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            System.out.println(userDetail);
            model.addObject("username", userDetail.getUsername());
        }
        model.setViewName("403");
        return model;
    }

    @RequestMapping(value = "/criterium/{kriterijum}", method = RequestMethod.GET)
    public ModelAndView pretraziPo(@PathVariable String kriterijum) {
        ModelAndView model = new ModelAndView();
        System.out.println(kriterijum + "KED DADSA");
        if (kriterijum.equals("brendovi")) {
            List<Brand> brendovi = this.brandService.getAllBrands();
            System.out.println(brendovi);
            model.addObject("objekti", brendovi);
            model.setViewName("prikazPoPotraznji");
            System.out.println("DAA");
        } else if (kriterijum.equals("narukvice")) {
            List<Strap> narukvice = this.strapService.getAllStraps();
            model.addObject("objekti", narukvice);
            model.setViewName("prikazPoPotraznji");
        } else if (kriterijum.equals("staklo")) {
            List<Display> stakla = this.displayService.getAllDisplays();
            model.addObject("objekti", stakla);
            model.setViewName("prikazPoPotraznji");
        } else if (kriterijum.equals("akcija")) {
            List<Watch> satovi = this.watchService.getWatchesOnOffer();
            model.addObject("objekti", satovi);
            model.setViewName("prikazPoPotraznji");
        } else {
            model.setViewName("403");
        }
        return model;
    }
}
