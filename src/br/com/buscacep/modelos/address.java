package br.com.buscacep.modelos;

public class address {

    private final String cep;
    private final String logradouro;
    private final String bairro;
    private final String localidade;
    private final String uf;
    private final int ddd;

    public address(Refine refina) {
        this.cep = refina.cep();
        this.logradouro = refina.logradouro();
        this.bairro = refina.bairro();
        this.localidade = refina.localidade();
        this.uf = refina.uf();
        this.ddd = refina.ddd();
    }

    @Override
    public String toString() {
        return "---------------------" + "\nCEP PESQUISADO: " + cep + "\nLogradouro: " + logradouro + "\nBairro: " + bairro + "\nLocalidade: " + localidade + "\nUF: " + uf + "\nDDD: " + ddd;
    }

}
