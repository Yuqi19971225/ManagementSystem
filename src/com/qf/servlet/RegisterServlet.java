package com.qf.servlet;

import com.qf.entity.User;
import com.qf.service.UserService;
import com.qf.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决post请求乱码
        request.setCharacterEncoding("utf-8");

        //servlet只做三件事
        //1.接受用户请求数据
        //创建对象接受请求数据
        User user = new User();
        user.setUsername(request.getParameter("uname"));
        user.setPassword(request.getParameter("upassword"));
        user.setAge(Integer.valueOf(request.getParameter("uage")));
        user.setGender(request.getParameter("usex"));
        user.setCity(request.getParameter("ucity"));
        user.setBirthday(request.getParameter("ubirthday"));

        String[] hobbies = request.getParameterValues("uhobby");
        if (hobbies != null) {
            //将爱好数组转为字符串
            user.setHobby(Arrays.toString(hobbies));
        }
        System.out.println("接受用户信息为" + user);

        //2.调用业务层
        UserService userService = new UserServiceImpl();
        int res = userService.register(user);
        //3.响应结果
        //设置响应对象及编码方式
        response.setContentType("text/html;charset=utf-8");
        if (res > 0) {
            response.getWriter().write("注册成功");
//            //5秒后跳转，跳转后的页面无法获得上一个页面数据
//            response.setHeader("refresh","5;url=login.jsp");

            //转发
            request.getRequestDispatcher("login.jsp").forward(request,response);

//            //重定向
//            response.sendRedirect("login.jsp");
        } else {
            response.getWriter().write("注册失败");
//            //5秒后跳转
//            response.setHeader("refresh","5;url=register.html");
            //转发
            request.getRequestDispatcher("register.html").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
