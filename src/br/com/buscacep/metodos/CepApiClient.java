package br.com.buscacep.metodos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CepApiClient {

    private String json;

    public String getJson() {
        return json;
    }


    public void Consome(String endereco) throws IOException, InterruptedException {
        String url = "https://viacep.com.br/ws/" + endereco + "/json/";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());


        this.json = response.body();
    }


}
