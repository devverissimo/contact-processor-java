package service;

import java.util.List;
import model.Contato;

public class RelatorioService {
    public String gerarRelatorio(List<Contato> contatos) {
        StringBuilder sb = new StringBuilder();

        long total = contatos.size();
        long ativos = contatos.stream()
                .filter(Contato::isAtivo)
                .count();
        long inativos = total - ativos;

        sb.append("===== RELATÓRIO DE CONTATOS =====\n");
        sb.append("Total de contatos: ").append(total).append("\n");
        sb.append("Ativos: ").append(ativos).append("\n");
        sb.append("Inativos: ").append(inativos).append("\n");
        sb.append("\n");
        sb.append("Lista de contatos:\n");

        contatos.forEach(contato ->
                sb.append(contato).append("\n")
        );

        return sb.toString();
    }
}

