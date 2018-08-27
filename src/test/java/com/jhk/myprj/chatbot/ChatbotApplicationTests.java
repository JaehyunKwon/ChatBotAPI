package com.jhk.myprj.chatbot;

import com.jhk.chatbot.ChatbotApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ChatbotApplication.class)
public class ChatbotApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println("Hello!! World!!!");
    }

}
