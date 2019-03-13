package com.jxy.controller;

import com.jxy.entity.Role;
//import com.jxy.repository.MyRoleRe;
//import com.jxy.service.RoleServiceRe;
import com.jxy.repository.MyRoleRe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: ybl
 * @Date: 2018/12/14 0014 11:07
 * @Description:
 */
@Controller
@RequestMapping("/")
public class HomeController {
  //  @Autowired
    //private RoleServiceRe roleServiceRe;
    @Autowired
    MyRoleRe myRoleRe;

    @RequestMapping(method = RequestMethod.GET)
    public String home(HttpServletRequest request, Model model) {
        Map<String, Object> user = new HashMap<>();
        user.put("userName", "jxy");
        model.addAttribute("user", user);
        return "homePage";
    }

    @RequestMapping("login")
    public String loginGet(HttpServletRequest request) {
        Role role=new Role();
        role.setRoleName("home");
        role.setUserId(1);
        role.setCreateTime(new Date());
        role.setRemark("xoiadsa");
        role.setUserName("sdsd");
        myRoleRe.save(role);
        return "login";
    }

}
