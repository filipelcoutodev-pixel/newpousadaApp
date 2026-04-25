package br.com.senacead.pousadaappjpa.estrutura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    //Nome da unidade de persistência
    private static final String PERSISTENCE_UNIT = "pousadaappjpa";

    private static EntityManager em;
    private static EntityManagerFactory fabrica;

    //cria a entidade se estiver nula e a retorna
 public static EntityManager getEntityManager() {
    if(fabrica == null || !fabrica.isOpen())
        fabrica = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    
    return fabrica.createEntityManager(); // sem usar 'em' estático
}

    //fecha o EntityManager e o factory
    public static void closeEntityManager() {
        if (em != null && em.isOpen()) {
            em.close();
        }
        if (fabrica != null && fabrica.isOpen()) {
            fabrica.close();
        }
    }
}
