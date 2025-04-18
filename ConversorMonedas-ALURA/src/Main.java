import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.MalformedInputException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcion = 0;

        System.out.println("*****************************************");
        System.out.println("\nCONVERSOR DE MONEDAS");
        System.out.println("\n*****************************************");

        String menu = """
                *** Escriba el numero de la opcion deseada***
                1- Peso ARG ==> USD
                2- USD ==> Peso ARG
                3- Peso Chileno ==> USD
                4- Peso Colombiano ==> USD
                5- USD ==> Peso Colombiano
                6- USD ==> Peso Chileno
                9- Salir
                """;

        Scanner teclado = new Scanner(System.in);
        while (opcion != 9) {
            System.out.println(menu);
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingresa la cantidad de pesos ARG a convertir");
                    double usdAr = teclado.nextDouble();
                    if (usdAr < 0) {
                        System.out.println("valor invalido");
                    } else {
                        String direccion = "https://v6.exchangerate-api.com/v6/85b1a5e71de7f60e8dfee675/latest/ARS";
                        try {
                            HttpClient client = HttpClient.newHttpClient();
                            HttpRequest request = HttpRequest.newBuilder()
                                    .uri(URI.create(direccion))
                                    .build();
                            HttpResponse<String> response = client
                                    .send(request, HttpResponse.BodyHandlers.ofString());
                            String json = response.body();
                            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
                            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
                            double moneda = conversionRates.get("USD").getAsDouble();
                            System.out.println("\n-----------------------------------------");
                            System.out.println("\nPESO ARGENTINO => USD: " + (moneda * usdAr) + " Dolares.");
                            System.out.println("\n-----------------------------------------");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                        case 2:
                            System.out.println("Ingresa la cantidad de USD a convertir");
                            double arUsd = teclado.nextDouble();
                            if (arUsd < 0) {
                                System.out.println("valor invalido");
                            } else {
                                String direccion = "https://v6.exchangerate-api.com/v6/85b1a5e71de7f60e8dfee675/latest/USD";
                                try {
                                    HttpClient client = HttpClient.newHttpClient();
                                    HttpRequest request = HttpRequest.newBuilder()
                                            .uri(URI.create(direccion))
                                            .build();
                                    HttpResponse<String> response = client
                                            .send(request, HttpResponse.BodyHandlers.ofString());
                                    String json = response.body();
                                    JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
                                    JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
                                    double moneda = conversionRates.get("ARS").getAsDouble();
                                    System.out.println("\n-----------------------------------------");
                                    System.out.println("\nUSD => PESO ARGENTINO: " + (moneda * arUsd) + " Pesos.");
                                    System.out.println("\n-----------------------------------------");
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            }

                            break;
                        case 3:
                    System.out.println("Ingresa la cantidad de pesos COL a convertir");
                    double usdCl = teclado.nextDouble();
                    if (usdCl < 0) {
                        System.out.println("valor invalido");
                    } else {
                        String direccion = "https://v6.exchangerate-api.com/v6/85b1a5e71de7f60e8dfee675/latest/CLP";
                        try {
                            HttpClient client = HttpClient.newHttpClient();
                            HttpRequest request = HttpRequest.newBuilder()
                                    .uri(URI.create(direccion))
                                    .build();
                            HttpResponse<String> response = client
                                    .send(request, HttpResponse.BodyHandlers.ofString());
                            String json = response.body();
                            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
                            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
                            double moneda = conversionRates.get("USD").getAsDouble();
                            System.out.println("\n-----------------------------------------");
                            System.out.println("\nPESO CHILENO => USD: " + (moneda * usdCl) + " Dolares");
                            System.out.println("\n-----------------------------------------");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Ingresa la cantidad de pesos CL a convertir");
                    double usdCol = teclado.nextDouble();
                    if (usdCol < 0) {
                        System.out.println("valor invalido");
                    } else {
                        String direccion = "https://v6.exchangerate-api.com/v6/85b1a5e71de7f60e8dfee675/latest/COP";
                        try {
                            HttpClient client = HttpClient.newHttpClient();
                            HttpRequest request = HttpRequest.newBuilder()
                                    .uri(URI.create(direccion))
                                    .build();
                            HttpResponse<String> response = client
                                    .send(request, HttpResponse.BodyHandlers.ofString());
                            String json = response.body();
                            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
                            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
                            double moneda = conversionRates.get("USD").getAsDouble();
                            System.out.println("\n-----------------------------------------");
                            System.out.println("\nPESO COLOMBIANO => USD: " + (moneda * usdCol) + " Dolares.");
                            System.out.println("\n-----------------------------------------");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Ingresa la cantidad de USD a convertir");
                    double colUsd = teclado.nextDouble();
                    if (colUsd < 0) {
                        System.out.println("valor invalido");
                    } else {
                        String direccion = "https://v6.exchangerate-api.com/v6/85b1a5e71de7f60e8dfee675/latest/USD";
                        try {
                            HttpClient client = HttpClient.newHttpClient();
                            HttpRequest request = HttpRequest.newBuilder()
                                    .uri(URI.create(direccion))
                                    .build();
                            HttpResponse<String> response = client
                                    .send(request, HttpResponse.BodyHandlers.ofString());
                            String json = response.body();
                            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
                            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
                            double moneda = conversionRates.get("COP").getAsDouble();
                            System.out.println("\n-----------------------------------------");
                            System.out.println("\nUSD => PESO COLOMBIANO: " + (moneda * colUsd) + " Pesos.");
                            System.out.println("\n-----------------------------------------");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    break;
                case 6:
                    System.out.println("Ingresa la cantidad de USD a convertir");
                    double clUsd = teclado.nextDouble();
                    if (clUsd < 0) {
                        System.out.println("valor invalido");
                    } else {
                        String direccion = "https://v6.exchangerate-api.com/v6/85b1a5e71de7f60e8dfee675/latest/USD";
                        try {
                            HttpClient client = HttpClient.newHttpClient();
                            HttpRequest request = HttpRequest.newBuilder()
                                    .uri(URI.create(direccion))
                                    .build();
                            HttpResponse<String> response = client
                                    .send(request, HttpResponse.BodyHandlers.ofString());
                            String json = response.body();
                            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
                            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
                            double moneda = conversionRates.get("CLP").getAsDouble();
                            System.out.println("\n-----------------------------------------");
                            System.out.println("\nUSD => PESO CHILENO: " + (moneda * clUsd) + " Pesos.");
                            System.out.println("\n-----------------------------------------");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    break;

                        case 9:
                            System.out.println("Saliendo... Gracias por utilizar nuestra app");
                            break;
                        default:
                            System.out.println("Opcion no valida");
                    }
            }


        }
    }

