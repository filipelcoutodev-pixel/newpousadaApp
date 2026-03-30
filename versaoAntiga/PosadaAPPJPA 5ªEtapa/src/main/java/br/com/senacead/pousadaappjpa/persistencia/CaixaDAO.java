
package br.com.senacead.pousadaappjpa.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;


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
        return new Caixa(entradas, gastos);
    }
}
