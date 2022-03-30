package com.Listener;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/*
 * 监听访问本网站的当前人数*/
@WebListener
public class CountPeopleListener implements HttpSessionListener {

    public CountPeopleListener() {
    }


    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        System.out.println("来了客户");
        //获得当前网站人数
        Object count = se.getSession().getServletContext().getAttribute("count");
        int num = 0;
        if (count == null) {
            //就是第一个访问本网站的人
            num = 1;
        } else {
            //在原来人数上加一
            num = Integer.valueOf(count.toString()) + 1;
        }
        se.getSession().getServletContext().setAttribute("count", num);
        System.out.println("当前网站访问人数为：" + num);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        System.out.println("走了一个客户");
        //获得当前网站人数
        int num = (int) se.getSession().getServletContext().getAttribute("count");
        se.getSession().getServletContext().setAttribute("count", num - 1);
    }


}
