
package br.com.senacead.pousadaappjpa;

import br.com.senacead.pousadaappjpa.dao.GastosDAO;
import br.com.senacead.pousadaappjpa.dao.HospedeDAO;
import br.com.senacead.pousadaappjpa.dao.UsuarioDAO;
import br.com.senacead.pousadaappjpa.gui.Login;
import br.com.senacead.pousadaappjpa.persistencia.Gastos;
import br.com.senacead.pousadaappjpa.persistencia.Hospede;
import br.com.senacead.pousadaappjpa.persistencia.Usuario;


public class PousadaAPPJPA {

    public static void main(String[] args) {
        
        // Teste de Hospede
        Hospede hospede = new Hospede();
        hospede.setNome("Pedro");
        hospede.setCpf("000.000.000-01");
        hospede.setIdade(23);
        hospede.setContato("24-999784563");
        hospede.setNumeroDeDias(3);
        hospede.setIdentificacaoQuarto("Quarto 1");
        hospede.setSaldo(360.00);

        HospedeDAO hospedeDAO = new HospedeDAO();
        hospedeDAO.cadastrarHospede(hospede);

        System.out.println("Hospede salvo: " + hospede.getNome());

        // Teste de Gastos
        Gastos gasto = new Gastos();
        gasto.setData("30/03/2026");
        gasto.setDescricao("Pães");
        gasto.setValor(120.00);

        GastosDAO gastosDAO = new GastosDAO();
        gastosDAO.cadastrarGasto(gasto);

        System.out.println("Gasto salvo: " + gasto.getDescricao());

        Login login = new Login();
        login.setVisible(true);
    }
}
