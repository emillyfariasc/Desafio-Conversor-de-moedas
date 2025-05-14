package pacotesjava;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.Map;
import pacotesjava.ApiMoeda;
import pacotesjava.TipoDaResposta;


public class ConversorDeMoedas {

    private static final String CHAVE_API = "918474773fa8b046b3580ada";
    
    public static double obter_taxa_de_conversao(TipoDaResposta dados, String moedaDestino) throws IllegalArgumentException{
        Map<String, Double> taxas = dados.conversion_rates;

        if (!taxas.containsKey(moedaDestino)) {
            throw new IllegalArgumentException("Moeda de destino inválida ou não encontrada.");
        }

        return taxas.get(moedaDestino);
    }

    public static double converter(double valorInicial, String moedaOrigem, String moedaDestino) throws IOException, IllegalArgumentException {
        String url = "https://v6.exchangerate-api.com/v6/" + CHAVE_API + "/latest/" + moedaOrigem;

        // Faz a requisição para a API e obtém a resposta JSON como String
        ApiMoeda minhaApi = new ApiMoeda();
        String respostaJson = minhaApi.buscar(url);

        // Converte o JSON para um objeto Java (usando Gson)
        Gson gson = new Gson();
        var minhaJson = gson.fromJson(respostaJson, TipoDaResposta.class);


        // Pega o mapa de taxas de conversão
        double taxaDeConversao = obter_taxa_de_conversao(minhaJson, moedaDestino);
        
        return valorInicial * taxaDeConversao;
    }
}
