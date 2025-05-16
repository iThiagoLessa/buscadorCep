package br.com.buscadorcep.model;

// import com.google.gson.Gson;

public class Address {

    private final String state;
    private final String uf;
    private final String street;
    private final String neighborhood;


    public Address(String street, String state, String neighborhood, String uf) {
        this.street = street;
        this.state = state;
        this.neighborhood = neighborhood;
        this.uf = uf;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {


        return "(Logradouro: " + this.street + " - " + this.neighborhood + ", " + this.state + " - " + this.uf + ")";

        // deixando esse bloco aqui
        // para indicar que tb posso mandar um tostring em forma de json usando essa lib

        //Gson gson = new Gson();
        //return gson.toJson(this);
    }
}
