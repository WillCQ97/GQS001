package br.ufes.model;

import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PedidoTest {

    public PedidoTest() {
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

    @Test(expected = NullPointerException.class)
    public void CT04() {
        var pedido = new Pedido(null, new Produto("Novo Produto", 3.6, 12), 25, LocalDate.now());
    }

    @Test(expected = IllegalArgumentException.class)
    public void CT05() {
        var produto = new Produto("Canetão Rosa", 3.6, 50);
        var pedido = new Pedido(new Cliente("Fulano", "123.456.789-09"), produto, 5, LocalDate.now());

        pedido.addItem(produto, 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void CT06() {
        var produto = new Produto("Canetão Rosa", 3.6, 50);
        var pedido = new Pedido(new Cliente("Fulano", "123.456.789-09"), produto, 0, LocalDate.now());
    }

    @Test(expected = IllegalArgumentException.class)
    public void CT07() {
        var pedido = new Pedido(new Cliente("Cliente", "000.000.000-00"),
                new Produto("Produto", 2.63, 20), 1, LocalDate.now());
        
        pedido.removerItem("Produto não adicionado");
    }
}
