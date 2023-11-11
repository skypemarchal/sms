package com.dabm.sms.client;

import com.dabm.sms.client.request.NrsSmsRequest;
import com.dabm.sms.exception.client.NrsClientException;
import com.dabm.sms.util.Base64Encoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class NrsClient {

    @Value("${nrs.api.baseurl}")
    private String baseUrl;

    @Value("${nrs.api.endpoints.sendSms}")
    private String sendSmsEndpoint;
    @Value("${nrs.api.credentials.username}")
    private String username;
    @Value("${nrs.api.credentials.password}")
    private String password;

    private final WebClient webClient;

    public NrsClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://dashboard.360nrs.com/api/rest").build();
    }

    public Mono<Void> sendMessage(NrsSmsRequest request) {
        String token = Base64Encoder.encodeStringToBase64(username + ":" + password);
        return webClient
                .post()
                .uri(sendSmsEndpoint)
                .bodyValue(request)
                .header("Authorization", "Basic " + token)
                .retrieve()
                .onStatus(HttpStatusCode::isError, clientResponse ->
                        Mono.error(new NrsClientException(clientResponse.toString())))
                .toBodilessEntity().then();

    }
}
