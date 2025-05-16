package br.com.buscadorcep.service;

import br.com.buscadorcep.model.Address;
import br.com.buscadorcep.model.AddressDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class GetAddressService {
    private final String cep;


    public GetAddressService(String cep) {
        this.cep = cep;
    }

    // metodo que busca o endereço a partir do cep
    public Address getCep() {
        try {
            // URL correta para o serviço ViaCEP
            String url = "https://viacep.com.br/ws/" + this.cep + "/json/";

            // Client da requisição
            HttpClient client = HttpClient.newHttpClient();

            // request da requisição
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            AddressDTO dto = gson.fromJson(response.body(), AddressDTO.class);


            return new Address(dto.getLogradouro(), dto.getEstado(), dto.getBairro(), dto.getUf());
        } catch (Exception e) {
            throw new RuntimeException("Endereço inválido");
        }

    }

    // metodo para salvar em um arquivo no formato json
    public void saveToFile(List<Address> addresses, String path) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();


        try (FileWriter writer = new FileWriter(path)) {
            // aqui ele vai salvar a lista toda que tenho
            String json = gson.toJson(addresses);
            writer.write(json);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
