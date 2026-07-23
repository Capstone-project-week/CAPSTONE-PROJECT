package com.example.demo.service;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class N8nService {







    private static final String N8N_WEBHOOK_URL = "https://sakethallada.app.n8n.cloud/webhook/Storyorchestrator";

    public String generateText(String prompt) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("chatInput", prompt);

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

            
            String rawResponse = restTemplate.postForObject(N8N_WEBHOOK_URL, entity, String.class);
            
            if (rawResponse == null || rawResponse.trim().isEmpty()) {
                return "N8n Agent triggered successfully but returned an empty response. You might need to check your workflow configuration.";
            }

            if (rawResponse.trim().startsWith("{")) {
                String extracted = extractJsonField(rawResponse);
                if (extracted != null) {
                    return extracted;
                }
            }

          
            if (rawResponse.startsWith("\"") && rawResponse.endsWith("\"")) {
                rawResponse = rawResponse.substring(1, rawResponse.length() - 1);
            }
            
            return rawResponse;
            
        } catch (Exception e) {
            e.printStackTrace();
            return "Error calling n8n Agent: " + e.getMessage();
        }
    }

    private String extractJsonField(String rawResponse) {
        try {
            org.springframework.boot.json.JsonParser parser = org.springframework.boot.json.JsonParserFactory.getJsonParser();
            Map<String, Object> jsonMap = parser.parseMap(rawResponse);
            
            if (jsonMap.containsKey("output")) {
                return String.valueOf(jsonMap.get("output"));
            } else if (jsonMap.containsKey("text")) {
                return String.valueOf(jsonMap.get("text"));
            }
        } catch (Exception e) {
            // Ignored: fallback to returning raw string
        }
        return null;
    }
}
