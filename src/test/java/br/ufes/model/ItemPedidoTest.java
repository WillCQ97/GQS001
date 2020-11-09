package br.ufes.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ItemPedidoTest {
    
    public ItemPedidoTest() {
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
    public void CT01(){
        ItemPedido itemPedido = new ItemPedido(new Produto("Canetão rosa", 3.6, 10), 5);
        
        assertEquals(5*3.6, itemPedido.getValorItem(), 0.001);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void CT02(){
        var itemPedido = new ItemPedido(new Produto("Nome do Produto", 3.6, 10), 45);
    }
}
