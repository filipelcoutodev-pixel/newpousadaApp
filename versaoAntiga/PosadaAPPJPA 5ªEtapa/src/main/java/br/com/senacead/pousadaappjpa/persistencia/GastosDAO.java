package br.com.senacead.pousadaappjpa.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;
import javax.swing.JOptionPane;

public class GastosDAO {

    // Método Cadastrar Gasto
    public boolean cadastrarGasto(Gastos gastos) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(gastos);
            em.getTransaction().commit();
            return true; // Cadastro bem-sucedido
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro ao cadastrar gasto: " + e.getMessage());
            e.printStackTrace(); // útil para debug
            return false; // Falha no cadastro
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

   

    //Método excluir por IDDigitado
    public void excluirPorIDDigitado(int id) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            TypedQuery<Gastos> query = em.createQuery(
                    "SELECT g FROM Gastos g WHERE g.id = :id", Gastos.class);
            query.setParameter("id", id);
            List<Gastos> resultados = query.getResultList();

            if (resultados.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum gasto encontrado com essa Descrição");
            } else {
                for (Gastos g : resultados) {
                    em.remove(g);
                }
                em.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Gasto excluído com sucesso.");
            }

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            JOptionPane.showMessageDialog(null,
                    "Erro ao excluir gasto " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            em.close();
        }
    }

    //Método Listar Gasto por Descrição
    public List<Gastos> listar(String descricao) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Gastos> listaGastos = null;

        try {
            String textoQuery;
            Query consulta;

            if (descricao == null || descricao.trim().isEmpty()) {
                textoQuery = "SELECT g FROM Gastos g";
                consulta = em.createQuery(textoQuery);
            } else {
                textoQuery = "SELECT g FROM Gastos g WHERE LOWER(g.descricao) LIKE :descricao";
                consulta = em.createQuery(textoQuery);
                consulta.setParameter("descricao", "%" + descricao.toLowerCase() + "%");
            }

            listaGastos = consulta.getResultList();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }

        return listaGastos;
    }

}
