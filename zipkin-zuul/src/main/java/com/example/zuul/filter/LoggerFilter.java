package com.example.zuul.filter;

import brave.Span;
import brave.Tracer;
import brave.propagation.TraceContext;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import com.netflix.zuul.http.ZuulServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @Author：盛年华
 * @Date：2018/8/13 9:35
 * @Description:
 */
@Component
public class LoggerFilter extends ZuulFilter {

    @Autowired
    Tracer tracer;

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 900;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        Span span=this.tracer.currentSpan();
        span.tag("operator","forezp");
        System.out.println(span.context().traceIdString());
        return null;
    }
}
