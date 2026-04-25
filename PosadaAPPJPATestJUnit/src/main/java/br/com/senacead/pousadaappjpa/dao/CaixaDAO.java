
package br.com.senacead.pousadaappjpa.dao;

import br.com.senacead.pousadaappjpa.persistencia.Caixa;
import br.com.senacead.pousadaappjpa.estrutura.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;


public class CaixaDAO {

    
 public double somarEntradas() {
    EntityManager ent = JPAUtil.getEntityManager();
    try {
        Double resultado = ent.createQuery("SELECT SUM(h.saldo) FROM Hospede h", Double.class).getSingleResult();
        return resultado != null ? resultado : 0.0;
    } catch (Exception e) {
        e.printStackTrace();
        return 0.0;
    } finally {
        ent.close();
    }
 }
 
public double somarGastos() {
    EntityManager em = JPAUtil.getEntityManager();
    try {
        Double resultado = em.createQuery("SELECT SUM(g.valor) FROM Gastos g", Double.class).getSingleResult();
        return resultado != null ? resultado : 0.0;
    } catch (Exception e) {
        e.printStackTrace();
        return 0.0;
    } finally {
        em.close();
    }
}

    public Caixa calcularCaixa() {
        double entradas = somarEntradas();
        double gastos = somarGastos();
        Caixa caixa = getCaixaAtual();
        // pega o último caixa persistido 
        caixa.setSaldoTotal(entradas - gastos);
        // atualiza saldo consolidado 
        atualizarCaixa(caixa);
        // persiste a atualização
        return caixa;
       
    }

    //Método para atualizar o caixa
    public void atualizarCaixa(Caixa caixa) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(caixa);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Caixa getCaixaAtual() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Caixa> query = em.createQuery("SELECT c FROM Caixa c ORDER BY c.id DESC", Caixa.class);
            query.setMaxResults(1);
            Caixa caixa = query.getResultList().stream().findFirst().orElse(null);
            if (caixa == null) {
                em.getTransaction().begin();
                caixa = new Caixa();
                em.persist(caixa);
                em.getTransaction().commit();
            }
            return caixa;
        } finally {
            em.close();
        }
    }
}
