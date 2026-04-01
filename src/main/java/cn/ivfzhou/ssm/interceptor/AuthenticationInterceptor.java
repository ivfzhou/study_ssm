package cn.ivfzhou.ssm.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.ivfzhou.ssm.constant.SsmConstant;
import cn.ivfzhou.ssm.entity.User;

/**
 * 基于Session的认证拦截器（已被Shiro替代，当前未启用）。
 * <p>通过检查Session中是否存在用户信息来判断用户是否已登录，
 * 未登录则重定向到登录页面。该拦截器已在 springmvc.xml 中注释。</p>
 *
 * @author ivfzhou
 * @see cn.ivfzhou.ssm.realm.CustomRealm
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    /**
     * 在请求处理之前执行，检查用户登录状态。
     *
     * @param request  当前HTTP请求
     * @param response 当前HTTP响应
     * @param handler  处理器对象
     * @return true表示放行，false表示拦截
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("处理1");
        // 手动判断路径.
        // String uri = request.getRequestURI();
        // if(uri.contains("/user/")){
        //     return true;
        // }
        // 1. 通过request获取session.
        HttpSession session = request.getSession();
        // 2. 通过session获取登录后的用户信息.
        User user = (User) session.getAttribute(SsmConstant.USER_INFO);
        // 3.1 如果用户信息为null -> 重定向到登录页面.
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/user/login-ui");
            return false;
        } else {
            // 3.2 如果用户信息不为null -> 放行.
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("处理2");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("处理3");
    }

}
