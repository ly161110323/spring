package com.ly.controller;

import com.ly.entity.MsgReturn;
import com.ly.entity.User;
import com.ly.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserFeign userFeign;

    @PostMapping("/login")
    @ResponseBody
    public MsgReturn login(String account, String pwd, HttpSession session) {
        User user = userFeign.getUser(account);
        if (user == null)
        {
            return new MsgReturn(-1, "用户名不存在", 0, null);
        }
        else if (!pwd.equals(user.getPwd()))
        {
            return new MsgReturn(-1, "密码错误", 0, null);
        }
        else {
            user.setPwd("");
            session.setAttribute("user", user);
            return new MsgReturn(0, "登录成功", 0, null);
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }

    @GetMapping("/findAll")
    @ResponseBody
    public MsgReturn findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int count = userFeign.getUsersCount();
        if (count == 0)
        {
            return new MsgReturn(-1, "no data", count, null);
        }
        return new MsgReturn(0, "success", count, userFeign.findAllUsers(page, limit));
    }

    @RequestMapping("/redirect/{target}")
    public String redirect(@PathVariable("target") String target){
        return target;
    }

    @GetMapping("/deleteById")
    @ResponseBody
    public MsgReturn deleteUser(@RequestParam("userId") int userId) {
        userFeign.deleteUser(userId);
        return new MsgReturn(0, "success", 0, null);
    }
}
