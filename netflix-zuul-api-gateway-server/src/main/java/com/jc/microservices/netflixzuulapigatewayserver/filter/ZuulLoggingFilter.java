package com.jc.microservices.netflixzuulapigatewayserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Override
    public String filterType() {

        return "pre";
    }

    @Override
    public int filterOrder() {

        return 0;
    }

    @Override
    public boolean shouldFilter() {

        return true;
    }

    @Override
    public Object run() throws ZuulException {

        HttpServletRequest httpServletRequest = RequestContext.getCurrentContext().getRequest();
        LOG.info("Request -> {} . Request URI -> {}", httpServletRequest, httpServletRequest.getRequestURI());
        return null;
    }
}
