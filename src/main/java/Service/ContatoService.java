package Service;

import model.Contato;
import java.util.List;
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
}
