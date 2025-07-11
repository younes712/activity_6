package com.younes.mcpclient.agents;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AIAgent {
    private ChatClient chatClient;

    public AIAgent(ChatClient.Builder chatClient, ToolCallbackProvider toolCallbackProvider) {
        this.chatClient = chatClient
                .defaultSystem("Answer the user question using provided tools callback")
                .defaultToolCallbacks(toolCallbackProvider)
                .defaultAdvisors(MessageChatMemoryAdvisor
                        .builder( MessageWindowChatMemory.builder().build()).build())
                .build();
    }
    public String askLLM(String question) {
        return chatClient.prompt()
                .user(question).call().content();
    }
}
