/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senacead.pousadaappjpa.service;

import br.com.senacead.pousadaappjpa.dao.CaixaDAO;
import br.com.senacead.pousadaappjpa.dao.GastosDAO;
import br.com.senacead.pousadaappjpa.dao.HospedeDAO;
import br.com.senacead.pousadaappjpa.dao.UsuarioDAO;
import br.com.senacead.pousadaappjpa.persistencia.Caixa;
import br.com.senacead.pousadaappjpa.persistencia.Gastos;
import br.com.senacead.pousadaappjpa.persistencia.Hospede;
import br.com.senacead.pousadaappjpa.persistencia.Usuario;
import java.util.List;

/**
 *
 * @author FilipeLuizCouto
 */
public class FuncService {

    // Inicializa os DAOs
    private HospedeDAO hospedeDAO = new HospedeDAO();
    private final GastosDAO gastoDAO = new GastosDAO();
    private final CaixaDAO caixaDAO = new CaixaDAO();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    //* Métodos para Hóspedes *//
    // Método para Cadastrar Hóspede
    public boolean cadastrarHospede(Hospede hospede) {
        return hospedeDAO.cadastrarHospede(hospede);
    }

    // Métod para listar Hóspede
    public List<Hospede> listarHospedes(String nome) {
        return hospedeDAO.listar(nome);
    }

    // Método para Buscar Hóspede por Id
    public Hospede buscarPorId(Long id) {
        return hospedeDAO.buscarPorId(id);
    }

    // Método para Atualizar Hóspede
    public void atualizarHospede(Hospede hospede) {
        hospedeDAO.atualizar(hospede);
    }

    // Método para Excluir Hóspede
    public boolean excluirHospede(int id) {
        return hospedeDAO.excluirHospedePorId(id);
    }

    //* Métados para Gastos *//
    // Método para cadastrar gasto 
    public boolean cadastrarGasto(Gastos gasto) {
        gastoDAO.cadastrarGasto(gasto);
        return true;
    }

    // Método para Listar gastos 
    public List<Gastos> listarGastos() {
        return gastoDAO.listar();
    }

    // Método para Excluir gasto
    public boolean excluirGasto(int id) {
        Gastos gasto = gastoDAO.buscarPorId(id);

        if (gasto != null) {
            gastoDAO.excluir(gasto);

            // Estorno no caixa
            Caixa caixa = caixaDAO.getCaixaAtual();
            caixa.setSaldoTotal(caixa.getSaldoTotal() + gasto.getValor());
            caixaDAO.atualizarCaixa(caixa);
            return true;
        }
        return false;
    }

    //* Métodos para Caixa *//
    // Método para Registrar entradas
    public void registrarEntrada(double valor) {
        Caixa caixa = caixaDAO.getCaixaAtual();

        caixa.setSaldoTotal(caixa.getSaldoTotal() + valor);
        caixaDAO.atualizarCaixa(caixa);
    }

    // Método Registrar saída 
    public void registrarSaida(double valor) {
        Caixa caixa = caixaDAO.getCaixaAtual();

        caixa.setSaldoTotal(caixa.getSaldoTotal() - valor);
        caixaDAO.atualizarCaixa(caixa);
    }

    // Método para Consultar saldo atual
    public double getSaldoAtual() {
        Caixa caixa = caixaDAO.getCaixaAtual();
        return caixa.getSaldoTotal();
    }

    //* Método para Login *//
    // Método para Autenticação de login 
    public Usuario autenticar(String login, String senha) {
        if (login == null || login.isEmpty() || senha == null || senha.isEmpty()) {
            throw new IllegalArgumentException("Login e senha devem ser informados.");
        }

        return usuarioDAO.buscarPorLoginESenha(login, senha);
    }

    //* Métodos para Usuario *//
    // Método para Cadastro de novo usuário 
    public void cadastrarUsuario(Usuario usuario) {
        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome do usuário é obrigatório.");
        }
        if (usuario.getLogin() == null || usuario.getLogin().isEmpty()) {
            throw new IllegalArgumentException("Login é obrigatório.");
        }
        if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
            throw new IllegalArgumentException("Senha é obrigatória.");
        }
        if (usuario.getSenha().length() < 6) {
            throw new IllegalArgumentException("A senha deve ter no mínimo 6 caracteres.");
        }
        usuarioDAO.cadastrar(usuario);
    }

    // Método para Exclusão de usuário por ID 
    public void excluirUsuario(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido para exclusão.");
        }
        boolean sucesso = usuarioDAO.excluirPorId(id);
        if (!sucesso) {
            throw new IllegalArgumentException("Usuário não encontrado ou erro ao excluir.");
        }
    }

    // Método para Listar usuários 
    public List<Usuario> listarUsuarios(String filtro) {
        return usuarioDAO.listar(filtro);
    }
}
