package com.ibrahim.LLM.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class DeepSeekService {

    private final ChatClient chatClient;

    public DeepSeekService(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    public String getResponse(String prompt) {
        return chatClient.prompt()
                .user(prompt) // Send the user's input to DeepSeek
                .call()       // Call the Ollama server
                .content();   // Extract the response
    }

    public Flux<String> getStreamingResponse(String prompt) {
        return chatClient.prompt()
                .user(prompt)
                .stream()
                .content();
    }
}
