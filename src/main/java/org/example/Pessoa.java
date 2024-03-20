package org.example;

public class Pessoa {
    private String nome;
    private String email;

    public Pessoa(String email, String nome) {
        this.email = email;
        this.nome = nome;
    }



    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
