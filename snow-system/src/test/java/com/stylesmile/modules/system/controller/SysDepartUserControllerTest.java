package com.stylesmile.modules.system.controller;

import com.stylesmile.modules.system.entity.SysDepart;
import com.stylesmile.modules.system.service.SysDepartService;
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
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SysDepartUserController.class)
class SysDepartUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SysDepartService mockSysDepartService;

    @Test
    void testIndex() throws Exception {
        // Setup
        // Configure SysDepartService.getList(...).
        final List<SysDepart> sysDeparts = Arrays.asList(new SysDepart(0, 0, "name", "code", "sort"));
        when(mockSysDepartService.getList("")).thenReturn(sysDeparts);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/index.html")
                        .accept(MediaType.TEXT_HTML))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testIndex_SysDepartServiceReturnsNoItems() throws Exception {
        // Setup
        when(mockSysDepartService.getList("")).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/index.html")
                        .accept(MediaType.TEXT_HTML))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }
}
