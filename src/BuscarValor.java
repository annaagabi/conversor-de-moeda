import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscarValor {
    public static double converter(String moedaOrigem, String moedaDestino, double valor) {
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/ef736cce930efef26d5311bb/latest/" + moedaOrigem);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            DadosApi apiResponse = new Gson().fromJson(response.body(), DadosApi.class);

            if (!"success".equals(apiResponse.getResult())) {
                throw new RuntimeException("Falha na API: " + apiResponse.getResult());
            }

            Double taxaDestino = apiResponse.getConversion_rates().get(moedaDestino.toUpperCase());

            if (taxaDestino == null) {
                throw new RuntimeException("Moeda de destino inválida: " + moedaDestino);
            }

            // Realizar a conversão
            return valor * taxaDestino;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar o valor da moeda: " + moedaOrigem, e);
        }
    }
}
