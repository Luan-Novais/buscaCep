package br.com.buscacep.modulos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnectHttpApi {
    private String cep;

    public ConnectHttpApi(String cep) {
        this.cep = cep;
    }

    public String chamaApi() {
        HttpResponse<String> response;
        String endereco = "https://viacep.com.br/ws/" + cep + "/json/";
        System.out.println(endereco);
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response.body();
    };

}
