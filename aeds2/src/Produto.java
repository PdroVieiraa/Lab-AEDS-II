
public abstract class Produto {

    /** Margem de lucro padrão adotada pela loja: 20% */
    private static final double MARGEM_PADRAO = 0.2;

    /** Descrição do produto (mínimo 3 caracteres) */
    private String descricao;

    /** Preço de custo do produto para a loja (mínimo 0.01) */
    private double precoCusto;

    /** Margem de lucro sobre o preço de custo (mínimo 0.01) */
    private double margemLucro;

    /**
     * Construtor completo. Causa exceção em caso de valores inválidos.
     * @param descricao Descrição do produto (mínimo 3 caracteres)
     * @param precoCusto Preço de compra do produto (mínimo 0.01)
     * @param margemLucro Margem de lucro para a venda (mínimo 0.01)
     * @throws IllegalArgumentException em caso dos limites acima serem desrespeitados.
     */
    public Produto(String descricao, double precoCusto, double margemLucro) {
        if (descricao == null || descricao.trim().length() < 3)
            throw new IllegalArgumentException("Descrição deve ter, no mínimo, 3 caracteres.");
        if (precoCusto < 0.01)
            throw new IllegalArgumentException("Preço de custo deve ser, no mínimo, 0.01.");
        if (margemLucro < 0.01)
            throw new IllegalArgumentException("Margem de lucro deve ser, no mínimo, 0.01.");

        this.descricao = descricao;
        this.precoCusto = precoCusto;
        this.margemLucro = margemLucro;
    }

    /**
     * Construtor com margem de lucro padrão (20%). Causa exceção em caso de valores inválidos.
     * @param descricao Descrição do produto (mínimo 3 caracteres)
     * @param precoCusto Preço de compra do produto (mínimo 0.01)
     * @throws IllegalArgumentException em caso dos limites acima serem desrespeitados.
     */
    public Produto(String descricao, double precoCusto) {
        this(descricao, precoCusto, MARGEM_PADRAO);
    }

    /**
     * Retorna o valor de venda do produto, considerando seu preço de custo e margem de lucro.
     * @return Valor de venda do produto (double, positivo)
     */
    public abstract double valorDeVenda();

    /**
     * Descrição em string do produto, contendo sua descrição e o valor de venda.
     * @return String no formato "[DESCRIÇÃO]: R$ [VALOR DE VENDA]"
     */
    
    @Override
    public String toString() {
        return String.format("%s: R$ %,.2f", descricao, valorDeVenda());
    }
}
