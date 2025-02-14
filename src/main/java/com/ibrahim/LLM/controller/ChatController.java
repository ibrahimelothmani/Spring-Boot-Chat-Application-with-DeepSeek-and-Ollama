package com.ibrahim.LLM.controller;

import com.ibrahim.LLM.service.DeepSeekService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;

@Controller
public class ChatController {

    private final DeepSeekService deepSeekService;

    public ChatController(DeepSeekService deepSeekService) {
        this.deepSeekService = deepSeekService;
    }

    // Show the chat form
    @GetMapping("/")
    public String showChat() {
        return "chat";
    }

    // Receive Response from DeepSeek
    @PostMapping("/api/chat")
    @ResponseBody
    public Flux<String> chatStream(@RequestParam String prompt) {
        return deepSeekService.getStreamingResponse(prompt)
                .map(chunk -> chunk.replaceAll("<think>", "")
                        .replaceAll("</think>", ""));
    }
}