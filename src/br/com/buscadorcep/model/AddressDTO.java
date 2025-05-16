package br.com.buscadorcep.model;

public class AddressDTO {
    private String logradouro;
    private String estado;
    private String bairro;
    private String uf;

    public String getLogradouro() {
        return this.logradouro;
    }

    public String getEstado() {
        return this.estado;
    }

    public String getUf() {
        return this.uf;
    }

    public String getBairro() {
        return this.bairro;
    }
}
