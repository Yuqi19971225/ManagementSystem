package com.servlet;

import com.entity.User;
import com.service.AdminService;
import com.service.UserService;
import com.service.impl.AdminServiceImpl;
import com.service.impl.UserServiceImpl;
import com.vo.LoginVo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
        //1.接收数据
//        User user = new User();
        //将实体类改为接受模板
        LoginVo user = new LoginVo();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setRole(request.getParameter("role"));
//        System.out.println("用户登录信息" + user);

        //接受记住我，多选框如果没有value属性，那么没有选中得到的结果为null,选中得到的是on
        String rememberMe = request.getParameter("rememberMe");
//        System.out.println("记住我：" + rememberMe);

        //接受验证码
        String cCode = request.getParameter("checkCode").toLowerCase();
        String checkCode = (String) request.getSession().getAttribute("CheckCode");

        if (checkCode.equals(cCode)) {  //验证成功
            //声明变量存结果
            boolean result = false;
            //2.调用业务处理并得到结果

            if ("student".equals(user.getRole())) { //普通用户
                UserService userService = new UserServiceImpl();
                result = userService.login(user);
            } else {//管理员
                AdminService adminService = new AdminServiceImpl();
                result = adminService.login(user);
            }

            //3.响应
            if (result) {
                //登录成功，进首页
                //记住我功能
                if ("on".equals(rememberMe)) {
                    //创建cookie对象存用户名密码
                    Cookie cookie1 = new Cookie("username", user.getUsername());
                    Cookie cookie2 = new Cookie("password", user.getPassword());
                    //设置cookie有效期
                    cookie1.setMaxAge(31536000);
                    cookie2.setMaxAge(31536000);
                    //用响应对象将cookie对象通过浏览器存在客户端
                    response.addCookie(cookie1);
                    response.addCookie(cookie2);
                }
                //将数据存在session对象中
                request.getSession().setAttribute("loginUser",user);
                request.setAttribute("loginUser", user);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                //登录失败，重新登录
                request.setAttribute("miss", "用户名或密码错误，登录失败！");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            //验证失败，重新登录
            request.setAttribute("miss", "验证码错误，登录失败！");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
