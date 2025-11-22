package br.com.alura.screenmatch.service;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class OmdbService {

    private static final String API_KEY = "6585022c";
    private static final String BASE_URL = "https://www.omdbapi.com/";
    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    public FilmeOmdbDTO buscarFilme(String titulo) {
        try {
            String url = BASE_URL + "?t=" + titulo.replace(" ", "+") + "&apikey=" + API_KEY;
            
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            FilmeOmdbDTO filme = gson.fromJson(response.body(), FilmeOmdbDTO.class);
            
            if ("False".equals(filme.getResponse())) {
                return null;
            }
            
            return filme;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static class FilmeOmdbDTO {
        private String Title;
        private String Year;
        private String Director;
        private String Genre;
        private String Response;

        public String getTitle() { return Title; }
        public String getYear() { return Year; }
        public String getDirector() { return Director; }
        public String getGenre() { return Genre; }
        public String getResponse() { return Response; }
    }
}
