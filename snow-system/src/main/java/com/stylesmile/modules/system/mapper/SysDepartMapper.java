package com.stylesmile.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stylesmile.modules.system.entity.SysDepart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author chenye
 * @date 2018/11/18
 */
@Mapper
public interface SysDepartMapper  extends BaseMapper<SysDepart> {
    /**
     * 查询全部部门
     *
     * @return list
     */
    List<SysDepart> getDepartList();

    /**
     * 更新部门
     *
     * @param sysDepart 部门
     * @return Boolean
     */
    Boolean updateDepart(SysDepart sysDepart);

    /**
     * 删除
     *
     * @param id 主键
     * @return Boolean
     */
    Boolean deleteDepart(int id);
}
