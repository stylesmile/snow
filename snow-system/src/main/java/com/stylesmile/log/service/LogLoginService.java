package com.stylesmile.log.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stylesmile.common.service.BaseService;
import com.stylesmile.log.entity.LogLogin;
import com.stylesmile.system.entity.SysRole;
import com.stylesmile.system.entity.SysUserRole;
import com.stylesmile.system.query.SysRoleQuery;

import javax.servlet.http.HttpSession;

/**
 * 用户管理
 *
 * @author chenye
 * @date 2019/2/26
 */
public interface LogLoginService extends BaseService<LogLogin> {

}
