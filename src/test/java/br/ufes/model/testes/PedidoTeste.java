package br.ufes.model.testes;

import br.ufes.model.Cliente;
import br.ufes.model.Pedido;
import br.ufes.model.Produto;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PedidoTeste {

    public PedidoTeste() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void CT01() {
        Produto canetaAzul = new Produto("Caneta Azul", 1.5, 100);
        Produto canetaVermelha = new Produto("Caneta Vermelha", 1.6, 50);
        int qtdAzul = 3;
        int qtdVerm = 2;

        Pedido pedido = new Pedido(
                new Cliente("Fulano da Silva", "123.456.789-01"),
                canetaAzul,
                qtdAzul, LocalDate.now());

        pedido.addItem(canetaVermelha, qtdVerm);

        double valorTotalEsperado = canetaAzul.getValorUnitario()
                * qtdAzul + canetaVermelha.getValorUnitario() * qtdVerm;

        Assert.assertEquals(valorTotalEsperado, pedido.getValor(), 0.001);

    }

    @Test
    public void CT02() {
        Produto canetaAzul = new Produto("Caneta Azul", 1.5, 100);
        Produto canetaVermelha = new Produto("Caneta Vermelha", 1.6, 50);
        int qtdAzul = 3;
        int qtdVerm = 2;

        Pedido pedido = new Pedido(
                new Cliente("Fulano da Silva", "123.456.789-01"),
                canetaAzul,
                qtdAzul, LocalDate.now());

        pedido.addItem(canetaVermelha, qtdVerm);

        double valorTotalPedido = canetaAzul.getValorUnitario()
                * qtdAzul + canetaVermelha.getValorUnitario() * qtdVerm;

        double valorDescontoEsperado = valorTotalPedido * 0.05;

        Assert.assertEquals(valorDescontoEsperado, pedido.getValorDesconto(), 0.001);
    }
    
    @Test
    public void CT03() {
        Pedido pedido = new Pedido(new Cliente("Fulano", "123.456.789-09"), 
                new Produto("Canetão Rosa", 3.6, 50), 5, LocalDate.now());
        
        double valorTotalPedido = 3.6 * 5;
        double valorAPagarEsperado = valorTotalPedido - valorTotalPedido * 0.05;
        
        Assert.assertEquals(valorAPagarEsperado, pedido.getValorAPagar(), 0.001);
    }
}
