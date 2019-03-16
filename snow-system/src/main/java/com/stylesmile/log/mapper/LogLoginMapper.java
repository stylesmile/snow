package com.stylesmile.log.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stylesmile.log.entity.LogLogin;
import com.stylesmile.system.entity.SysUser;
import com.stylesmile.system.query.SysUserQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户mapper
 *
 * @author chenye
 * @date 2019/2/26
 */
@Mapper
public interface LogLoginMapper extends BaseMapper<LogLogin> {

}
