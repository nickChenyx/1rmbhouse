package com.rmbhouse.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by nickChenyx on 2017/4/14.
 */
public class SignInFilter extends OncePerRequestFilter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private String[] shouldNotFilt = new String[]{"index","login"};


    /**
     * 登录拦截，检查session中的值
     * @param httpServletRequest
     * @param httpServletResponse
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        // 相对地址 /index
        String uri = httpServletRequest.getRequestURI();
        if (checkNotFilt(uri)){
            String passToken = (String)httpServletRequest.getSession().getAttribute("passToken");
            if (passToken!=null){
                logger.info("passToken:"+passToken);
            }
             filterChain.doFilter(httpServletRequest,httpServletResponse);

        }else {
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }
    }

    /**
     * 检查路径是否满足可以不做过滤的条件
     * true   可以过滤
     * false  不用过滤
     * @param uri
     * @return
     */
    private boolean checkNotFilt(String uri){
        for (String s : shouldNotFilt){
            if (uri.endsWith(s))
                return false;
        }
        return true;
    }
}
