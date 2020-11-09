package br.ufes.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProdutoTest {
    
    public ProdutoTest() {
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
        Produto produto = new Produto("Canetão", 3.5, 10);
        
        Assert.assertEquals(false, produto.estoqueDisponivel(50));
    }
    
    @Test
    public void CT02() {
        Produto produto = new Produto("Canetão rosa", 3.6, 10);
        Assert.assertEquals(produto.getValorUltimaCompra(), produto.getValorUnitario(), 0.001);
    }
    
    @Test
    public void CT03() {
        double valorInicial = 3.6;
        Produto produto = new Produto("Canetão rosa", valorInicial, 10);
        produto.setValorUnitario(3.2);
        
        Assert.assertEquals(produto.getValorUltimaCompra(), valorInicial, 0.001);
    }
    
    @Test(expected = NullPointerException.class)
    public void CT04(){
        var produto = new Produto("Nome do Produto", 3.69, 10);
        
        produto.setNome(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void CT05(){
        var produto = new Produto("Nome do Produto", 3.69, 20);
        
        produto.setValorUnitario(-2.69);
    }
}
