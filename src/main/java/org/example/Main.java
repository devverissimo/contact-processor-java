package org.example;

import model.Contato;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {
        List<Contato> contatos = new ArrayList<>();

        contatos.add(new Contato("Maria", 20, "maria@gmail.com", "62999990001", true, "Goiânia"));
        contatos.add(new Contato("João", null, "joao@gmail.com", null, true, "Anápolis"));
        contatos.add(new Contato("Ana", 25, "anaemail.com", "62999990002", false, "Brasília")); // email inválido
        contatos.add(new Contato("Carlos", 30, "carlos@gmail.com", "62999990003", true, "Goiânia"));
        contatos.add(new Contato("Fernanda", null, "fernanda@gmail.com", null, false, "Aparecida de Goiânia"));
        contatos.add(new Contato("Lucas", 19, "lucas@gmail.com", "62999990004", true, "Trindade"));
        contatos.add(new Contato("Patrícia", 27, "patricia@gmail.com", null, false, "Senador Canedo"));
        contatos.add(new Contato("Bruno", 22, "bruno@gmail.com", "62999990005", true, "Rio Verde"));

        for (Contato contato : contatos) {
            System.out.println(contato);
        }
    }


}
