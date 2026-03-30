package br.com.senacead.pousadaappjpa.estrutura;

import br.com.senacead.pousadaappjpa.persistencia.Hospede;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

public class Relatorio {

    //Atributos que definem o caminho dos arquivos de Relatório
    private static final String CAMINHO_TXT = "C:\\RelatoriosPousada\\RelatorioCompleto.txt";
    private static final String CAMINHO2_TXT = "C:\\RelatoriosPousada\\RelatorioResumido.txt";
   
    //Método que gera Relatório Completo  
    public void escrevaRelatorioCompleto(List<Hospede> listaHospedes, double totalEntradas, double totalGastos, String dataReferencia) {
        double saldoFinal = totalEntradas - totalGastos;

        File arquivo = new File(CAMINHO_TXT);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, false))) {

            writer.write("===== RELATÓRIO DA POUSADA =====");
            writer.newLine();
            writer.write("Data: " + dataReferencia);
            writer.newLine();
            writer.write("Total de Hóspedes: " + listaHospedes.size());
            writer.newLine();
            writer.newLine();

            if (listaHospedes == null || listaHospedes.isEmpty()) {
                writer.write("Nenhum hóspede registrado no momento.");
                writer.newLine();
            } else {
                writer.write("=== DADOS DOS HÓSPEDES ===");
                writer.newLine();
                for (Hospede h : listaHospedes) {
                    writer.write("ID: " + h.getId());
                    writer.newLine();
                    writer.write("Nome: " + h.getNome());
                    writer.newLine();
                    writer.write("CPF: " + h.getCpf());
                    writer.newLine();
                    writer.write("Idade: " + h.getIdade());
                    writer.newLine();
                    writer.write("Contato: " + h.getContato());
                    writer.newLine();
                    writer.write("Diárias: " + h.getNumeroDeDias());
                    writer.newLine();
                    writer.write("Quarto: " + h.getIdentificacaoQuarto());
                    writer.newLine();
                    writer.write("Saldo: R$ " + String.format("%.2f", h.getSaldo()));
                    writer.newLine();
                    writer.write("------------------------------");
                    writer.newLine();
                }
            }

            writer.newLine();
            writer.write("=== FINANCEIRO ===");
            writer.newLine();
            writer.write("Total de Entradas: R$ " + String.format("%.2f", totalEntradas));
            writer.newLine();
            writer.write("Total de Gastos: R$ " + String.format("%.2f", totalGastos));
            writer.newLine();
            writer.write("Saldo Final: R$ " + String.format("%.2f", saldoFinal));
            writer.newLine();

            writer.flush(); // garante que tudo foi escrito
            JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso!");

            //Abre o relatório automaticamente
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(arquivo);
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao gerar relatório: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    //Método que gera Relatório Resumido
    public void escrevaRelatorioResumido(List<Hospede> listaHospedes, double totalEntradas, double totalGastos, String dataReferencia) {
        double saldoFinal = totalEntradas - totalGastos;

        File arquivo = new File(CAMINHO2_TXT);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, false))) {

            writer.write("===== RELATÓRIO RESUMIDO DA POUSADA =====");
            writer.newLine();
            writer.write("Data: " + dataReferencia);
            writer.newLine();
            writer.write("Total de Hóspedes: " + listaHospedes.size());
            writer.newLine();
            writer.newLine();

            if (listaHospedes == null || listaHospedes.isEmpty()) {
                writer.write("Nenhum hóspede registrado no momento.");
                writer.newLine();
            }

            writer.newLine();
            writer.write("=== FINANCEIRO ===");
            writer.newLine();
            writer.write("Total de Entradas: R$ " + String.format("%.2f", totalEntradas));
            writer.newLine();
            writer.write("Total de Gastos: R$ " + String.format("%.2f", totalGastos));
            writer.newLine();
            writer.write("Saldo Final: R$ " + String.format("%.2f", saldoFinal));
            writer.newLine();

            writer.flush(); // garante que tudo foi escrito
            JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso!");

            //Abre o relatório automaticamente
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(arquivo);
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao gerar relatório: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
