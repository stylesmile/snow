package com.Stylesmile.system.query;

import com.Stylesmile.system.entity.SysUser;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

/**
 * @author chenye
 * @date 2018/12/10
 */
@Data
public class SysRoleQuery extends Page<SysUser> {

    private int id;
    private String name;
    private String code;
    private String sort;

}
