package com.jasmine.idempotent.service;

import javax.servlet.http.HttpServletRequest;

/**
 * token service
 *
 * @author guangchang
 * @create 2019-07-31 00:07
 **/
public interface TokenService {
    /**
     * 创建token
     * @return
     */
    String createToken();


    /**
     * 拦截器检查token
     * @param request
     */
    void checkToken(HttpServletRequest request);

    /**
     * 测试幂等结果
     * @return
     */
    String testIdempotent();
}

