package br.ufes.model.testes;

import br.ufes.model.Produto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProdutoTeste {
    
    public ProdutoTeste() {
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
}
