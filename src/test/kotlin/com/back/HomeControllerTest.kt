package com.back

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class HomeControllerTest {
    @Autowired
    private lateinit var mvc: MockMvc

    @Test
    @DisplayName("GET /buckets")
    fun t1() {
        mvc.get("/buckets")
            .andDo { print() }
            .andExpect { status { isOk() } }
    }
}