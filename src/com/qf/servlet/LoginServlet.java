package com.qf.servlet;

import com.qf.entity.User;
import com.qf.service.UserService;
import com.qf.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1.接收数据
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        System.out.println("用户登录信息" + user);
        //调用业务处理并得到结果
        UserService userService = new UserServiceImpl();
        User res = userService.login(user);
        //3.响应
        if (res != null) {
            //登录成功，进首页
            request.setAttribute("loginUser", res);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            //登录失败，重新登录
            request.setAttribute("miss", "用户名或密码错误，登录失败！");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
