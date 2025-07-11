package com.younes.mcpclient.controllers;

import com.younes.mcpclient.agents.AIAgent;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class AIRestController {
    private AIAgent agent;

    public AIRestController(AIAgent agent) {
        this.agent=agent;
    }
    @GetMapping("/chat")
    public String chat(String query) {
        return agent.askLLM(query);
    }

}
