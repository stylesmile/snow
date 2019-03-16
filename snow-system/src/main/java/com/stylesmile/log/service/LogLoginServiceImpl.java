package com.stylesmile.log.service;

import com.stylesmile.common.service.BaseServiceImpl;
import com.stylesmile.log.entity.LogLogin;
import com.stylesmile.log.mapper.LogLoginMapper;
import org.springframework.stereotype.Service;

/**
 * 用户管理
 *
 * @author chenye
 * @date 2019/2/26
 */
@Service("logLoginServiceImpl")
public class LogLoginServiceImpl extends BaseServiceImpl<LogLoginMapper, LogLogin> implements LogLoginService {

}
