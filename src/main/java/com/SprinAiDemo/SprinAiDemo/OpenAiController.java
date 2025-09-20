package com.SprinAiDemo.SprinAiDemo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenAiController {

    private ChatClient chatModel;

    public OpenAiController(OpenAiChatModel model){
        chatModel = ChatClient.create(model);
    }

    @GetMapping("/api/{message}")
    public String getAns(@PathVariable String message){
        return chatModel
                .prompt(message)
                .call()
                .content();
    }
}
