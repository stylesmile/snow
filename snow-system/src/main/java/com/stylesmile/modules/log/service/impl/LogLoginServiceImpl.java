package com.stylesmile.modules.log.service.impl;

import com.stylesmile.common.service.BaseServiceImpl;
import com.stylesmile.modules.log.entity.LogLogin;
import com.stylesmile.modules.log.mapper.LogLoginMapper;
import com.stylesmile.modules.log.service.LogLoginService;
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
