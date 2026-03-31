package service;

import exception.EmailInvalidoException;
import model.Contato;

import java.util.*;
import java.util.stream.Collectors;

public class ContatoService {

    // ── listarAtivos ──────────────────────────────────────────────────────────
    public List<Contato> listarAtivos(List<Contato> contatos) {
        return contatos.stream()
                .filter(Contato::isAtivo)
                .collect(Collectors.toList());
    }

    // ── listarPorCidade ───────────────────────────────────────────────────────
    public List<Contato> listarPorCidade(List<Contato> contatos, String cidade) {
        return contatos.stream()
                .filter(c -> c.getCidade() != null)
                .filter(c -> c.getCidade().equalsIgnoreCase(cidade))
                .collect(Collectors.toList());
    }

    // ── listarComIdadeAcimaDe ─────────────────────────────────────────────────
    public List<Contato> listarComIdadeAcimaDe(List<Contato> contatos, int minimo) {
        return contatos.stream()
                .filter(c -> c.getIdade() != null)
                .filter(c -> c.getIdade() > minimo)
                .collect(Collectors.toList());
    }

    // ── listarNomesOrdenados ──────────────────────────────────────────────────
    public List<String> listarNomesOrdenados(List<Contato> contatos) {
        return contatos.stream()
                .map(Contato::getNome)
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
    }

    public Optional<Contato> buscarPorEmail(List<Contato> contatos, String email) {
        return contatos.stream()
                .filter(contato -> contato.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    public Optional<Contato> buscarPorNome(List<Contato> contatos, String nome){
        return  contatos.stream()
                .filter(contato -> contato.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }

    public void validarEmail(String email) {
        if (!email.contains("@")) {
            throw new EmailInvalidoException(email);
        }
    }
    public long contarAtivos(List<Contato> contatos){
        return contatos.stream()
                .filter(Contato::isAtivo)
                .count();
    }
    public OptionalDouble mediaDeIdade(List<Contato> contatos){
        return contatos.stream()
                .map(Contato :: getIdade)
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .average();
    }
    public Map<String, List<Contato>> agruparPorCidade(List<Contato> contatos){
        return  contatos.stream()
                .collect(Collectors.groupingBy(Contato::getCidade));
    }
    public List<String> emailAtivos(List<Contato> contatos){
        return contatos.stream()
                .filter(Contato::isAtivo)
                .map(Contato::getEmail)
                .filter(Objects::nonNull)
                .distinct()
                .toList();
    }










}
