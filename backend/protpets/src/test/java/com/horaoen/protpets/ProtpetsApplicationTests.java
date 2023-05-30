package com.horaoen.protpets;

import cn.hutool.json.JSONUtil;
import com.horaoen.protpets.infrastructure.response.UnifiedResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProtpetsApplicationTests {
    @Autowired
    private MockMvc mvc;
    
    @Test
    @WithMockUser(roles = "ADMIN")
    void contextLoads() throws Exception {
        mvc.perform(get("/account/test"))
                .andExpect(status().isOk())
                .andExpect(content().json(JSONUtil.parse(UnifiedResponse.success("test")).toString()));
    }

}
