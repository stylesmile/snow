package com.stylesmile.modules.system.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stylesmile.modules.system.entity.SysUser;
import lombok.Data;

/**
 * @author chenye
 * @date 2018/12/10
 */
@Data
public class SysMenuQuery extends Page<SysUser> {

    private int id;
    private String name;
    private String code;
    private String sort;

}
