package pacotesjava;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiMoeda {

    public static String buscar(String endereco) throws IOException {
        URL url = new URL (endereco);
        // System.out.println(endereco);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        conexao.setRequestMethod("GET");

        int status = conexao.getResponseCode();
        if (status != 200) {
            throw new IOException("Erro na requisição: Código HTTP " + status);
        } else {
            BufferedReader leitor = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            StringBuilder resposta = new StringBuilder();
            String linha;
            while ((linha = leitor.readLine()) != null) {
                resposta.append(linha);
            }
            leitor.close();
            return resposta.toString();
        }
    }
}

