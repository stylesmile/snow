package com.stylesmile.modules.system.service;

import com.stylesmile.common.service.BaseService;
import com.stylesmile.modules.system.entity.SysDepart;

import java.util.List;

/**
 * 部门管理
 *
 * @author chenye
 * @date 2019/1/8 21:23
 */
public interface SysDepartService extends BaseService<SysDepart> {

    /**
     * 查询部门列表
     *
     * @return List<SysDepart>
     */
    List<SysDepart> getList(String source);

    /**
     * 修改部门
     *
     * @param sysDepart 部门信息
     * @return Boolean
     */
    Boolean updateDepart(SysDepart sysDepart);

    /**
     * 删除部门
     *
     * @param id 主键
     * @return Boolean
     */
    Boolean deleteDepart(int id);

    /**
     * 清除部门缓存
     */
    void clearDepartListCache();

    /**
     * 通过id 获取部门信息
     *
     * @param id 主键
     * @return SysDepart
     */
    SysDepart getDeptById(Integer id);

    /**
     * 清理单个部门缓存
     */
    void clearDept(Integer id);

}
