package br.com.buscacep.metodos;

import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {
    public void criaLista(String json) throws IOException {
        FileWriter fileWriter = new FileWriter("endereco.json");
        fileWriter.write(json);
        fileWriter.close();
    }
}
