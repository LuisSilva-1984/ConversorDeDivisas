import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class CurrencyService {
    private static final String API_KEY = "1eff64127c6d7507f75df4e0";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";

    // Método para obtener la tasa de cambio desde la API
    public double getExchangeRate(String fromCurrency, String toCurrency) throws Exception {
        String urlStr = API_URL + API_KEY + "/pair/" + fromCurrency + "/" + toCurrency;
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        connection.disconnect();

        JSONObject jsonResponse = new JSONObject(content.toString());
        return jsonResponse.getDouble("conversion_rate");
    }
}
