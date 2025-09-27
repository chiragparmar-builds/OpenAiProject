package com.SprinAiDemo.SprinAiDemo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class OpenAiController {

    private ChatClient chatModel;
    private String result = null;

    public OpenAiController(OpenAiChatModel model){
        chatModel = ChatClient.create(model);
    }


    @GetMapping("/apo")
    public Map<String, String> getMessage() {
        return Map.of("message", "Hello from Spring Boot!");
    }

    @PostMapping("/post/api/")
    public String getAnssdf(){
        System.out.println("hello");
        result = chatModel
                .prompt("message")
                .call()
                .content();
        System.out.println(result);
        return result;
    }

    @GetMapping("/get/api")
    public String getAns(){
        return result;
    }
}
