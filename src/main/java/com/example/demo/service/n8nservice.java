package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class n8nservice {

    @Value("${n8n.webhook.url:https://srisaketh.app.n8n.cloud/webhook/Storyorchestrator}")
    private String n8nWebhookUrl;

    public String generateText(String prompt) {

        try {
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("storyId", "1");
            requestBody.put("playerId", "player001");
            requestBody.put("userPrompt", prompt);

            HttpEntity<Map<String, Object>> entity =
                    new HttpEntity<>(requestBody, headers);

            String response = restTemplate.postForObject(
                    n8nWebhookUrl,
                    entity,
                    String.class
            );

            return response;

        } catch (Exception e) {
            e.printStackTrace();
            return "Error calling n8n webhook: " + e.getMessage();
        }
    }
}