package org.example;

import exception.ContatoNaoEncontradoException;
import exception.EmailInvalidoException;
import model.Contato;
import service.ContatoService;
import service.RelatorioService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {

        List<Contato> contatos = new ArrayList<>();

        contatos.add(new Contato("Maria", 20, "maria@gmail.com", "62999990001", true, "Goiânia"));
        contatos.add(new Contato("João", null, "joao@gmail.com", null, true, "Anápolis"));
        contatos.add(new Contato("Ana", 25, "anaemail.com", "62999990002", false, "Brasília"));
        contatos.add(new Contato("Carlos", 30, "carlos@gmail.com", "62999990003", true, "Goiânia"));
        contatos.add(new Contato("Fernanda", null, "fernanda@gmail.com", null, false, "Aparecida de Goiânia"));
        contatos.add(new Contato("Lucas", 19, "lucas@gmail.com", "62999990004", true, "Trindade"));
        contatos.add(new Contato("Patrícia", 27, "patricia@gmail.com", null, false, "Senador Canedo"));
        contatos.add(new Contato("Bruno", 22, "bruno@gmail.com", "62999990005", true, "Rio Verde"));

        ContatoService service = new ContatoService();
        RelatorioService relatorioService = new RelatorioService();

        System.out.println("\n--- Buscar por email ---");
        Optional<Contato> resultadoEmail = service.buscarPorEmail(contatos, "maria@gmail.com");
        resultadoEmail.ifPresent(c -> System.out.println("Encontrado: " + c.getEmail()));

        Contato contatoEmail = service.buscarPorEmail(contatos, "naoexiste@gmail.com")
                .orElse(null);
        System.out.println("Resultado com orElse: " + contatoEmail);

        try {
            service.buscarPorEmail(contatos, "naoexiste@gmail.com")
                    .orElseThrow(() -> new ContatoNaoEncontradoException("Email não encontrado"));
        } catch (ContatoNaoEncontradoException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }

        System.out.println("\n--- Buscar por nome ---");
        Optional<Contato> resultadoNome = service.buscarPorNome(contatos, "Maria");
        resultadoNome.ifPresent(c -> System.out.println("Nome: " + c.getNome()));

        Contato contatoNome = service.buscarPorNome(contatos, "naoexiste")
                .orElse(null);
        System.out.println("Resultado com orElse: " + contatoNome);

        try {
            service.buscarPorNome(contatos, "naoexiste")
                    .orElseThrow(() -> new ContatoNaoEncontradoException("Nome não encontrado"));
        } catch (ContatoNaoEncontradoException e) {
            System.out.println( e.getMessage());
        }

        System.out.println("\n--- Validar email ---");
        service.validarEmail("maria@gmail.com");
        System.out.println("maria@gmail.com → válido!");

        try {
            service.validarEmail("anaemail.com");
        } catch (EmailInvalidoException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }

        System.out.println("\n--- Relatório ---");
        String relatorio = relatorioService.gerarRelatorio(contatos);
        System.out.println(relatorio);

        System.out.println("\n--- Estatísticas ---");
        long ativos = service.contarAtivos(contatos);
        System.out.println("Quantidade de ativos: " + ativos);

        OptionalDouble media = service.mediaDeIdade(contatos);
        System.out.println("Média de idade: " + media.orElse(0.0));

        Map<String, List<Contato>> agrupados = service.agruparPorCidade(contatos);
        System.out.println("Agrupados por cidade: " + agrupados);

        List<String> emailsAtivos = service.emailAtivos(contatos);
        System.out.println("Emails dos ativos: " + emailsAtivos);
    }
}