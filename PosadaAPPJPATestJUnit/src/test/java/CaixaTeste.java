/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import br.com.senacead.pousadaappjpa.persistencia.Caixa;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author FilipeLuizCouto
 */
public class CaixaTeste {
    
    public CaixaTeste() {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testConstrutorCalculaSaldo() {
        Caixa caixa = new Caixa(1000.0, 400.0);
        double esperado = 600.0;
        double resultado = caixa.getSaldoTotal();

        // Print para evidência
        System.out.println("Teste 1 - Esperado: " + esperado + " | Resultado: " + resultado);

        assertEquals(esperado, resultado, 0.001);
    }

    @Test
    public void testSaldoNegativo() {
        Caixa caixa = new Caixa(200.0, 500.0);
        double esperado = -300.0;
        double resultado = caixa.getSaldoTotal();

        // Print para evidência
        System.out.println("Teste 2 - Esperado: " + esperado + " | Resultado: " + resultado);

        assertEquals(esperado, resultado, 0.001);
    }
}
