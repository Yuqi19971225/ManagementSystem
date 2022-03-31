package com.servlet;

import com.dbutils.PageUtils;
import com.entity.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectUsersByPageServlet", value = "/SelectUsersByPageServlet")
public class SelectUsersByPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受请求
        PageUtils pageUtils = new PageUtils();
        pageUtils.setCurPage(Integer.valueOf(request.getParameter("cur")));
        //2.调用业务
        UserService userService = new UserServiceImpl();
        List<User> users = userService.selectUserByPage(pageUtils);

        //3.响应
        //将数据存在请求对象带到下一个页面
        request.setAttribute("userList", users);
        request.setAttribute("page", pageUtils);
        request.getRequestDispatcher("UsersList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
