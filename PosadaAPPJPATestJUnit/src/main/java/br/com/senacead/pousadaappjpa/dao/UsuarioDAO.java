package br.com.senacead.pousadaappjpa.dao;

import br.com.senacead.pousadaappjpa.estrutura.Criptografia;
import br.com.senacead.pousadaappjpa.estrutura.JPAUtil;
import br.com.senacead.pousadaappjpa.persistencia.Usuario;
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
    
    // Excluir usuário por ID 
    public boolean excluirPorId(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Usuario usuario = em.find(Usuario.class, id);
            if (usuario != null) {
                em.remove(usuario);
                em.getTransaction().commit();
                return true;
            } else {
                em.getTransaction().rollback();
                return false;
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    // Método para Listar usuários (todos ou filtrados por nome/login) 
    public List<Usuario> listar(String filtro) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Usuario> usuarios;
        try {
            em.getTransaction().begin();
            if (filtro == null || filtro.isEmpty()) {
                TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
                usuarios = query.getResultList();
            } else {
                TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.nome LIKE :filtro OR u.login LIKE :filtro", Usuario.class);
                query.setParameter("filtro", "%" + filtro + "%");
                usuarios = query.getResultList();
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            usuarios = null;
        } finally {
            em.close();
        }
        return usuarios;
    }

}
