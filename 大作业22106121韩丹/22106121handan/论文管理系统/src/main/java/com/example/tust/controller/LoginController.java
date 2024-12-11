package com.example.tust.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.tust.entity.Users;
import com.example.tust.service.UsersService;
import com.example.tust.utils.RandomValidateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Controller
public class LoginController {

    @Autowired
    private UsersService usersService;

    // 登录   默认请求方式是get
    // @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("captcha") String captcha
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public JSONObject login(@RequestBody HashMap<String, String> czmap, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String vode = (String) session.getAttribute(RandomValidateCode.RANDOMCODEKEY);
        Map<String, String> map = new HashMap<String, String>();

        if (vode.toLowerCase().equals(czmap.get("captcha").toLowerCase())) {
            Users user = usersService.findUserByUAndP(czmap.get("username"), czmap.get("password"));
            if (user != null) {
                session.setAttribute("user", user);
                session.setAttribute("username", user.getUsername());
                session.setAttribute("userId", user.getUserId());
                session.setAttribute("role", user.getRole());
                map.put("msg", "正确！");
                map.put("count", "1");
            } else {
                map.put("msg", "用户名和密码不正确!");
            }
        } else {
            map.put("msg", "验证码不正确!");
        }
        return JSON.parseObject(JSON.toJSONString(map));
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.removeAttribute("username");
        session.removeAttribute("userId");
        session.removeAttribute("role");
        return "/page/login";
    }

    @RequestMapping(value = "/getVCode", produces = "application/json; charset=utf-8")
    public void getVCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置相应类型,告诉浏览器输出的内容为图片
        response.setContentType("image/jpeg");
        //设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        RandomValidateCode randomValidateCode = new RandomValidateCode();
        try {
            randomValidateCode.getRandcode(request, response);//输出图片方法
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
