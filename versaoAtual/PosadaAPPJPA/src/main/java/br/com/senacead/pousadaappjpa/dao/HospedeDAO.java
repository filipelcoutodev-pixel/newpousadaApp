package br.com.senacead.pousadaappjpa.dao;

import br.com.senacead.pousadaappjpa.persistencia.Hospede;
import br.com.senacead.pousadaappjpa.estrutura.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class HospedeDAO {

    // Métod para Cadastrar Hóspede
    public boolean cadastrarHospede(Hospede h) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(h);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro ao cadastrar hóspede: " + e.getMessage());
            return false;
        } finally {
            em.close();
        }
    }

    // Métod para Excluir Hóspede
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

    // Métod para Listar Hóspede
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

    //Método para Buscar Hóspedes por ID
    public Hospede buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Hospede hospede = null;
        try {
            hospede = em.find(Hospede.class, id);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return hospede;
    }

    //Método para Atualizar Hóspede
    public void atualizar(Hospede hospede) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(hospede);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Erro ao atualizar hóspede: " + e.getMessage(), e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

}
