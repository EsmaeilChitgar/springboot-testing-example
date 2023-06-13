package com.example.controllers.firend;

import com.example.controllers.FriendController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(SpringExtension.class)
@WebMvcTest(FriendController.class)
class FriendControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void hello3(){
        assertEquals(1, 7-6);
    }

    @Test
    void hello() throws Exception {
        RequestBuilder request = get("/hello");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Hello, friend", result.getResponse().getContentAsString());
    }

    @Test
    public void testHelloWithName() throws Exception {
        mvc.perform(get("/hello?name=Dan"))
                .andExpect(content().string("Hello, Dan"));
    }
}

