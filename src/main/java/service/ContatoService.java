package service;

import model.Contato;
import java.util.List;
import java.util.Optional;
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


}
