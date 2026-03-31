package org.example;

import exception.ContatoNaoEncontradoException;
import exception.EmailInvalidoException;
import model.Contato;
import service.ContatoService;
import service.RelatorioService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

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


        ContatoService service = new ContatoService();
        //email
        Optional<Contato> resultadoEmail = service.buscarPorEmail(contatos, "maria@gmail.com");
        resultadoEmail.ifPresent(contato -> System.out.println("Entrontrado: " + contato.getEmail()));
        Contato contato = service.buscarPorEmail(contatos, "naoexiste@gmail.com")
                .orElse(null);

        System.out.println(contato); // null — mas você escolheu isso explicitamente

        try {
            Contato emailNaoEncontrado = service.buscarPorEmail(contatos, "naoexiste@gmail.com")
                    .orElseThrow(() -> new ContatoNaoEncontradoException("Email não encontrado"));
        } catch (ContatoNaoEncontradoException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }


        //nome
        Optional<Contato> resultadoNome = service.buscarPorNome(contatos, "Maria");
        resultadoNome.ifPresent(nome -> System.out.println("Nome: " + nome.getNome()));
        contato = service.buscarPorNome(contatos, "naoexsite")
                .orElse(null);

        System.out.println(contato); // null — mas você escolheu isso explicitamente

        try {
            Contato nomeNaoEncontrado = service.buscarPorNome(contatos, "naoexiste")
                    .orElseThrow(() -> new ContatoNaoEncontradoException("Nome não encontrado"));
        } catch (ContatoNaoEncontradoException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }

        // ── validarEmail ──────────────────────────────────────────────────────────
        System.out.println("\n--- validarEmail ---");

// email válido — não lança nada
        service.validarEmail("maria@gmail.com");
        System.out.println("maria@gmail.com → válido!");

// email inválido — lança EmailInvalidoException
        try {
            service.validarEmail("anaemail.com");
        } catch (EmailInvalidoException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }
        RelatorioService relatorioService = new RelatorioService();

        String relatorio = relatorioService.gerarRelatorio(contatos);

        System.out.println(relatorio);
}
}
