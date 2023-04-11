package com.stylesmile.modules.system.controller;

import com.stylesmile.common.util.Result;
import com.stylesmile.modules.system.entity.SysUser;
import com.stylesmile.modules.system.service.SysMenuService;
import com.stylesmile.modules.system.service.SysUserService;
import com.stylesmile.modules.system.vo.LoginVo;
import com.stylesmile.modules.system.vo.tree.MenuTree;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@WebMvcTest(IndexController.class)
class IndexControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SysUserService mockSysUserService;
    @MockBean
    private SysMenuService mockSysMenuService;

    @Test
    void testLogin1() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/login.html")
                        .accept(MediaType.TEXT_HTML))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testLogin2() throws Exception {
        // Setup
        when(mockSysUserService.getSysUserByNameAndPassword(eq(new LoginVo()), any(HttpSession.class)))
                .thenReturn(Result.fail("value"));

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/login.json")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testLogin2_SysUserServiceReturnsNoItem() throws Exception {
        // Setup
        when(mockSysUserService.getSysUserByNameAndPassword(eq(new LoginVo()), any(HttpSession.class)))
                .thenReturn(Result.fail());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/login.json")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("");
    }

    @Test
    void testLogin2_SysUserServiceReturnsFailure() throws Exception {
        // Setup
        when(mockSysUserService.getSysUserByNameAndPassword(eq(new LoginVo()), any(HttpSession.class)))
                .thenReturn(Result.fail());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/login.json")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testLogOut() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/logOut.do")
                        .accept(MediaType.TEXT_HTML))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testIndex() throws Exception {
        // Setup
        when(mockSysMenuService.getMenuListByUserId(any(HttpServletRequest.class))).thenReturn(new MenuTree());
        when(mockSysUserService.getSessionUser(any(HttpServletRequest.class)))
                .thenReturn(new SysUser("username", "password"));

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/index.html")
                        .accept(MediaType.TEXT_HTML))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }
}
