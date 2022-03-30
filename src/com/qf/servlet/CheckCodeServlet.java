package com.qf.servlet;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CheckCodeServlet", value = "/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //验证码宽高，字符个数，干扰线条数
        int width = 120;
        int height = 60;
        int count = 4;
        int line = 10;

        //通过验证码对象创建验证码对象
        ValidateCode code = new ValidateCode(width, height, count, line);
        //获得随机生成验证字符
        String codeString = code.getCode();
        System.out.println("生成的验证码为" + codeString);
        //将生成的验证码存在session中
        request.getSession().setAttribute("CheckCode", codeString);

        //将验证码图片响应给客户端浏览器
        code.write(response.getOutputStream());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
