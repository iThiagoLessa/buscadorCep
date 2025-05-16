package br.com.buscadorcep.app;

import br.com.buscadorcep.model.Address;
import br.com.buscadorcep.service.GetAddressService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Address> list = new ArrayList<>();
        String cep = "";

        while (!cep.equalsIgnoreCase("sair")) {
            Scanner leitura = new Scanner(System.in);
            System.out.println("Digite o cep");
            cep = leitura.nextLine();

            // caso n tenha lista terei um erro aqui de exceção aqui
            if (cep.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                GetAddressService service = new GetAddressService(cep.replaceAll("\\D", ""));
                Address address = service.getCep();

                System.out.println("checa ai: " + address);

                if(address != null) {
                    list.add(address);
                }

                service.saveToFile(list, "cepsBuscados.json");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


        // organizando por ordem alfabetica
        list.sort(Comparator.comparing(Address::getStreet));
        System.out.println("lista ai: " + list);

    }
}
