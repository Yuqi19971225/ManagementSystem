package com.servlet;

import com.entity.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
@MultipartConfig
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决post请求乱码
//        request.setCharacterEncoding("utf-8");

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


        //接受文件表单元素
        Part p1 = request.getPart("myFile1");
        Part p2 = request.getPart("myFile2");
        Part p3 = request.getPart("myFile3");

        //获得上传路径
        String path = this.getServletContext().getRealPath("upload");
        System.out.println(path);
        //获得上传文件名
        String fileName1 = fileUpload(response, p1, path);
        String fileName2 = fileUpload(response, p2, path);
        String fileName3 = fileUpload(response, p3, path);
        //将上传后的文件名存在对象中
        user.setImg1(fileName1);
        user.setImg2(fileName2);
        user.setImg3(fileName3);


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
            request.getRequestDispatcher("login.jsp").forward(request, response);

//            //重定向
//            response.sendRedirect("login.jsp");
        } else {
            response.getWriter().write("注册失败");
//            //5秒后跳转
//            response.setHeader("refresh","5;url=register.html");
            //转发
            request.getRequestDispatcher("register.html").forward(request, response);
        }
    }


    //文件上传的方法
    private String fileUpload(HttpServletResponse response, Part p, String path) throws IOException {

        //获得上传头部信息
        String headMess = p.getHeader("content-disposition");
        //获得上传原文件名
        String fileName = headMess.substring(headMess.lastIndexOf("=") + 2, headMess.length() - 1);
        System.out.println(fileName);
        //判断上传文件大小
        if (p.getSize() > 30 * 1024) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("你的文件超过30KB，无法上传");
        } else {
            if (fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".gif")) {
                //防止重名
//                fileName = UUID.randomUUID() + "_" + fileName;
                //实现文件上传到指定文件夹
                p.write(path + File.separator + fileName);
                //响应
                return fileName;
            } else {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("你的文件格式有误，无法上传");
            }
        }
        return null;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
