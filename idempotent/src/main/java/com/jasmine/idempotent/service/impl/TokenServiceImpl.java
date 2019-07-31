package com.jasmine.idempotent.service.impl;

import com.jasmine.idempotent.exception.ServiceException;
import com.jasmine.idempotent.manager.ResponseCode;
import com.jasmine.idempotent.service.TokenService;
import com.jasmine.idempotent.util.JedisUtil;
import com.jasmine.idempotent.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * token impl
 *
 * @author guangchang
 * @create 2019-07-31 00:08
 **/
@Service
@Slf4j
public class TokenServiceImpl implements TokenService {
    private static final String TOKEN_NAME = "token";

    @Autowired
    private JedisUtil jedisUtil;

    @Override
    public String createToken() {
        String str = RandomUtil.UUID32();
        StrBuilder token = new StrBuilder();
        token.append("token:").append(str);

        jedisUtil.set(token.toString(), token.toString(), 600);

        return token.toString();
    }

    /**
     * 检查请求中token信息 咩有就抛异常
     * @param request
     */
    @Override
    public void checkToken(HttpServletRequest request) {
        log.info("检查token");
        String token = request.getHeader(TOKEN_NAME);
        System.err.println(token);
        if (StringUtils.isBlank(token)) {
            /**
             * header中不存在token
             */
            token = request.getParameter(TOKEN_NAME);
            if (StringUtils.isBlank(token)) {
                /**
                 * parameter中也不存在token
                 */
                throw new ServiceException(ResponseCode.ILLEGAL_ARGUMENT.getMsg());
            }
        }

        if (!jedisUtil.exists(token)) {
            throw new ServiceException(ResponseCode.REPETITIVE_OPERATION.getMsg());
        }

        Long del = jedisUtil.del(token);
        if (del <= 0) {
            throw new ServiceException(ResponseCode.REPETITIVE_OPERATION.getMsg());
        }
    }



    @Override
    public String testIdempotent() {
        return ("testIdempotent: success");
    }

}