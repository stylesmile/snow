package com.stylesmile.modules.system.controller;

import com.stylesmile.modules.system.entity.SysMenu;
import com.stylesmile.modules.system.service.SysMenuService;
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
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SysMenuController.class)
class SysMenuControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SysMenuService mockSysMenuService;

    @Test
    void testIndex() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/index.html")
                        .accept(MediaType.TEXT_HTML))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testList() throws Exception {
        // Setup
        // Configure SysMenuService.getList(...).
        final SysMenu sysMenu = new SysMenu();
        sysMenu.setId(0);
        sysMenu.setParentId(0);
        sysMenu.setName("name");
        sysMenu.setCode("code");
        sysMenu.setUrl("url");
        sysMenu.setType("type");
        sysMenu.setSort(0);
        final List<SysMenu> sysMenus = Arrays.asList(sysMenu);
        when(mockSysMenuService.getList()).thenReturn(sysMenus);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/list.json")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testList_SysMenuServiceReturnsNoItems() throws Exception {
        // Setup
        when(mockSysMenuService.getList()).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/list.json")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }

    @Test
    void testAdd1() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/add.html")
                        .param("parentId", "parentId")
                        .accept(MediaType.TEXT_HTML))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testAdd2() throws Exception {
        // Setup
        when(mockSysMenuService.save(any(SysMenu.class))).thenReturn(false);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/add.json")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testEdit1() throws Exception {
        // Setup
        // Configure SysMenuService.getById(...).
        final SysMenu sysMenu = new SysMenu();
        sysMenu.setId(0);
        sysMenu.setParentId(0);
        sysMenu.setName("name");
        sysMenu.setCode("code");
        sysMenu.setUrl("url");
        sysMenu.setType("type");
        sysMenu.setSort(0);
        when(mockSysMenuService.getById(0L)).thenReturn(sysMenu);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/edit.html")
                        .param("id", "0")
                        .accept(MediaType.TEXT_HTML))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testEdit2() throws Exception {
        // Setup
        when(mockSysMenuService.updateById(any(SysMenu.class))).thenReturn(false);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/edit.json")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testDelete() throws Exception {
        // Setup
        when(mockSysMenuService.deleteMenu("id")).thenReturn(false);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/delete.json")
                        .param("id", "id")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }
}
