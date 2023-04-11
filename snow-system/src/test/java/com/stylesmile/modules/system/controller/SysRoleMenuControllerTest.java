package com.stylesmile.modules.system.controller;

import com.stylesmile.modules.system.service.SysRoleMenuService;
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

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SysRoleMenuController.class)
class SysRoleMenuControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SysRoleMenuService mockSysRoleMenuService;

    @Test
    void testUserRole() throws Exception {
        // Setup
        when(mockSysRoleMenuService.getRoleMenuList(0)).thenReturn(Arrays.asList(0));

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/roleMenu.html")
                        .param("roleId", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testUserRole_SysRoleMenuServiceReturnsNoItems() throws Exception {
        // Setup
        when(mockSysRoleMenuService.getRoleMenuList(0)).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/roleMenu.html")
                        .param("roleId", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testRoleMenu() throws Exception {
        // Setup
        when(mockSysRoleMenuService.getRoleMenuList(0)).thenReturn(Arrays.asList(0));

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/roleMenu.json")
                        .param("roleId", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testRoleMenu_SysRoleMenuServiceReturnsNoItems() throws Exception {
        // Setup
        when(mockSysRoleMenuService.getRoleMenuList(0)).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/roleMenu.json")
                        .param("roleId", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }

    @Test
    void testUserRoleAdd() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/userRoleAdd.html")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testSaveRoleMenu() throws Exception {
        // Setup
        when(mockSysRoleMenuService.addRoleMenu(0, "menuIds")).thenReturn(false);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/saveRoleMenu.json")
                        .param("roleId", "0")
                        .param("menuIds", "menuIds")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testDeleteRoleMenu() throws Exception {
        // Setup
        when(mockSysRoleMenuService.removeByIds(Arrays.asList("value"))).thenReturn(false);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/deleteRoleMenu.json")
                        .param("ids", "ids")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }
}
