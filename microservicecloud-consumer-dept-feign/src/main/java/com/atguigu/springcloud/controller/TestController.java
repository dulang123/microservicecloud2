package com.atguigu.springcloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class TestController {
    @RequestMapping(value = "/consumer/dept/test")
    public void test( HttpServletResponse response,
                        HttpServletRequest request) throws ServletException, IOException {
        System.out.println("生成二维码");
     response.sendRedirect("index.jsp");
        System.out.println("#########");
    }
}
