package br.com.senacead.pousadaappjpa.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class UsuarioDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("pousadaappjpa");

    public void cadastrar(Usuario u) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            u.setSenha(Criptografia.md5(u.getSenha()));
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public Usuario buscarPorLoginESenha(String loginDigitado, String senhaDigitada) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            String senhaCriptografada = Criptografia.md5(senhaDigitada);
            System.out.println("MD5 gerado: " + senhaCriptografada); // teste no console

            TypedQuery<Usuario> query = em.createQuery(
                    "SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha", Usuario.class);
            query.setParameter("login", loginDigitado);
            query.setParameter("senha", senhaCriptografada);

            List<Usuario> resultado = query.getResultList();
            System.out.println("Login digitado: " + loginDigitado);
            System.out.println("Senha MD5: " + senhaCriptografada);
            System.out.println("Resultado da query: " + resultado.size());
            return resultado.isEmpty() ? null : resultado.get(0);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

}
