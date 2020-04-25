package com.stylesmile.modules.system.vo.tree;

import com.stylesmile.modules.system.entity.SysMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author StyleSmile
 * @date 2019/02/12
 */
public class MenuTree {
    private Integer id;
    private Integer parentId;
    private String name;
    private String url;
    private List<MenuTree> children = new ArrayList<>();
    private MenuTree parent = null;

    public static MenuTree listToTree(List<SysMenu> sysMenuList) {
        //菜单树，根节点id为0
        MenuTree menuTree = new MenuTree(0);
        //构建树节点
        buildMenuTree(menuTree, sysMenuList);
        return menuTree;
    }

    /**
     * 构建树节点
     *
     * @param parent      父节点
     * @param sysMenuList list数据
     */
    private static void buildMenuTree(MenuTree parent, List<SysMenu> sysMenuList) {
        Integer pid = parent.getId();
        //添加到子节点的待删除数据
        List<SysMenu> dels = new ArrayList<>();
        //找到子节点，放进children
        for (SysMenu sysMenu : sysMenuList) {
            if (pid.intValue() == sysMenu.getParentId().intValue()) {
                MenuTree menuTree = new MenuTree(sysMenu);
                parent.children.add(menuTree);
                dels.add(sysMenu);
            }
        }
        //删除添加到子节点的数据
        sysMenuList.remove(dels);
        //把子节点的子节点 ，放进子节点
        //递归
        for (MenuTree menuTree : parent.getChildren()) {
            buildMenuTree(menuTree, sysMenuList);
        }
    }

    private MenuTree(Integer id) {
        this.id = id;
    }

    private MenuTree(SysMenu sysMenu) {
        this.id = sysMenu.getId();
        this.parentId = sysMenu.getParentId();
        this.name = sysMenu.getName();
        this.url = sysMenu.getUrl();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<MenuTree> getChildren() {
        return children;
    }

    public void setChildren(List<MenuTree> children) {
        this.children = children;
    }

    public MenuTree getParent() {
        return parent;
    }

    public void setParent(MenuTree parent) {
        this.parent = parent;
    }

    public MenuTree() {
    }
}
