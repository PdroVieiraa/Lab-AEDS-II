import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Locale;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Teste simples para a classe Produto (Tarefa 0).
 * Observação: ao concluir a Tarefa 1 (refatoração com herança e polimorfismo),
 * este teste deixará de compilar caso Produto se torne abstrata. Nesse momento,
 * substitua-o pelos testes das subclasses, disponíveis na pasta "testes-tarefa1".
 */
public class ProdutoTest {

    static Produto produto;

    @BeforeAll
    static public void prepare() {
        Locale.setDefault(new Locale("pt", "BR"));
        produto = new Produto("Produto teste", 100, 0.1);
    }

    @Test
    public void calculaPrecoCorretamente() {
        assertEquals(110.0, produto.valorDeVenda(), 0.01);
    }

    @Test
    public void calculaPrecoComMargemPadrao() {
        Produto padrao = new Produto("Produto padrão", 100);
        assertEquals(120.0, padrao.valorDeVenda(), 0.01);
    }

    @Test
    public void stringComDescricaoEValor() {
        String desc = produto.toString();
        assertTrue(desc.contains("Produto teste") && desc.contains("R$") && desc.contains("110,00"));
    }

    @Test
    public void naoCriaProdutoComDescricaoCurta() {
        assertThrows(IllegalArgumentException.class, () -> new Produto("ab", 5, 0.5));
    }

    @Test
    public void naoCriaProdutoComPrecoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Produto("teste", -5, 0.5));
    }

    @Test
    public void naoCriaProdutoComMargemNegativa() {
        assertThrows(IllegalArgumentException.class, () -> new Produto("teste", 5, -1));
    }
}
