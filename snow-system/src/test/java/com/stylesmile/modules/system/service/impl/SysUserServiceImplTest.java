package com.stylesmile.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stylesmile.common.util.Result;
import com.stylesmile.modules.system.entity.SysUser;
import com.stylesmile.modules.system.vo.LoginVo;
import com.stylesmile.modules.system.vo.query.SysUserQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.assertj.core.api.Assertions.assertThat;

class SysUserServiceImplTest {

    private SysUserServiceImpl sysUserServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        sysUserServiceImplUnderTest = new SysUserServiceImpl();
    }

    @Test
    void testGetSessionUser() {
        // Setup
        final HttpServletRequest httpServletRequest = new MockHttpServletRequest();

        // Run the test
        final SysUser result = sysUserServiceImplUnderTest.getSessionUser(httpServletRequest);

        // Verify the results
    }

    @Test
    void testGetSysUserByNameAndPassword() {
        // Setup
        final LoginVo loginVo = new LoginVo();
        loginVo.setUsername("username");
        loginVo.setPassword("password");

        final HttpSession session = null;

        // Run the test
        final Result<String> result = sysUserServiceImplUnderTest.getSysUserByNameAndPassword(loginVo, session);

        // Verify the results
    }

    @Test
    void testGetUserList() {
        // Setup
        final SysUserQuery sysUserQuery = new SysUserQuery();
        sysUserQuery.setUsername("username");
        sysUserQuery.setNickname("nickname");
        sysUserQuery.setPhone("phone");
        sysUserQuery.setEmail("email");
        sysUserQuery.setDepartId("departId");

        // Run the test
        final Page<SysUser> result = sysUserServiceImplUnderTest.getUserList(sysUserQuery);

        // Verify the results
    }

    @Test
    void testUpdateUser() {
        // Setup
        final SysUser user = new SysUser("username", "password");

        // Run the test
        final Boolean result = sysUserServiceImplUnderTest.updateUser(user);

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testDeleteUser() {
        // Setup
        // Run the test
        final Boolean result = sysUserServiceImplUnderTest.deleteUser(0);

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testQueryPermission() {
        // Setup
        // Run the test
        final Integer result = sysUserServiceImplUnderTest.queryPermission("url", 0);

        // Verify the results
        assertThat(result).isEqualTo(0);
    }

    @Test
    void testClearUserListCache() {
        // Setup
        // Run the test
        sysUserServiceImplUnderTest.clearUserListCache();

        // Verify the results
    }

    @Test
    void testGetUserByIdCache() {
        assertThat(sysUserServiceImplUnderTest.getUserByIdCache(0)).isNull();
    }

    @Test
    void testClearUserCache() {
        // Setup
        // Run the test
        sysUserServiceImplUnderTest.clearUserCache(0);

        // Verify the results
    }

    @Test
    void testMain() {
        // Setup
        // Run the test
        SysUserServiceImpl.main(new String[]{"args"});

        // Verify the results
    }
}
