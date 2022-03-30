package com.Filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/*
 * 字符编码过滤器
 */
@WebFilter(filterName = "CharsetFilter", value = "/*")
public class CharsetFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        //获得请求的url
        String url = req.getRequestURL().toString();
        //html页面直接放行
        if (!url.contains(".html")) {
            //设置请求和响应的编码
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
        }

        chain.doFilter(request, response);
    }
}
