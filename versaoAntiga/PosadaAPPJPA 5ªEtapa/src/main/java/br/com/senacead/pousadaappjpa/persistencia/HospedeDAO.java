package br.com.senacead.pousadaappjpa.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import javax.swing.JOptionPane;

public class HospedeDAO {

    public boolean cadastrarHospede(Hospede h) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(h);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar hóspede: " + e.getMessage());
            System.out.println("Erro ao cadastrar hóspede: " + e.getMessage());
            return false;
        } finally {
            em.close(); //garante que o EntityManager usado seja fechado corretamente
        }
    }

    public boolean excluirHospedePorId(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Hospede hospede = em.find(Hospede.class, id);
            if (hospede != null) {
                em.getTransaction().begin();
                em.remove(hospede);
                em.getTransaction().commit();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return false;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public List<Hospede> listar(String nome) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Hospede> hospedes = null;

        try {
            String textoQuery;
            Query consulta;

            if (nome == null || nome.trim().isEmpty()) {
                textoQuery = "SELECT h FROM Hospede h";
                consulta = em.createQuery(textoQuery);
            } else {
                textoQuery = "SELECT h FROM Hospede h WHERE LOWER(h.nome) LIKE :nome";
                consulta = em.createQuery(textoQuery);
                consulta.setParameter("nome", "%" + nome.toLowerCase() + "%");
            }

            hospedes = consulta.getResultList();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }

        return hospedes;
    }

}
