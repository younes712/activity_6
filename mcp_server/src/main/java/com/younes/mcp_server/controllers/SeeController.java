package com.younes.mcp_server.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeeController {

    @GetMapping("/see")
    public String seeEndpoint() {
        return "MCP Server is working!";
    }
}
