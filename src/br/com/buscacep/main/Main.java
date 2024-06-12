package br.com.buscacep.main;

import br.com.buscacep.metodos.CepApiClient;
import br.com.buscacep.metodos.CreateFile;
import br.com.buscacep.modelos.address;
import br.com.buscacep.modelos.Refine;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            run();
        } catch (IOException | InterruptedException e) {
            System.out.println("Ocorreu um erro: ");
            System.out.println(e.getMessage());
        }


    }

    public static void run() throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        CepApiClient cepApiClient = new CepApiClient();
        CreateFile createFile = new CreateFile();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println("Bem-vindo ao Busca Cep" + "\n---------------------");
        List<address> addresses = new ArrayList<>();
        String endereco = "";
        while (!endereco.trim().equalsIgnoreCase("sair")) {
            System.out.println("digite o cep:");
            endereco = (scanner.nextLine());
            if (endereco.trim().equalsIgnoreCase("sair")) {
                scanner.close();
                break;
            }
            cepApiClient.Consome(endereco);
            String response = cepApiClient.getJson();


            Refine refina = gson.fromJson(response, Refine.class);
            address newAddress = new address(refina);
            addresses.add(newAddress);
            System.out.println(newAddress + "\n---------------------\n");


        }

        String json = gson.toJson(addresses);
        createFile.criaLista(json);
    }

}
