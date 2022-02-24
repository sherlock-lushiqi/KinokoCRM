package com.lushiqi.kinokocrm.filter;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if(loginUser != null){
            return true;//放行
        }
//        session.setAttribute("msg","请先登陆");
        // response.sendRedirect("/loginPage");
        request.setAttribute("msg","请先登陆");
        request.getRequestDispatcher("/login").forward(request,response);
        //拦截
        return false;
    }
}
