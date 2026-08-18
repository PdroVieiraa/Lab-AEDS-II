import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoPerecivel extends Produto {

    // Desconto de 25% aplicado aos produtos próximos do vencimento
    private static final double DESCONTO = 0.25;

    // Quantidade de dias para considerar o produto próximo do vencimento
    private static final int PRAZO_DESCONTO = 7;

    // Data de validade do produto
    private LocalDate dataDeValidade;


    public ProdutoPerecivel(String desc, double precoCusto, LocalDate dataDeValidade) {
        super(desc, precoCusto);

        // Não permite cadastrar um produto que já esteja vencido
        if (dataDeValidade.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException(
                "A data de validade não pode ser anterior à data atual."
            );
        }

        this.dataDeValidade = dataDeValidade;
    }


    @Override
    public double valorDeVenda() {

        LocalDate hoje = LocalDate.now();

        // Verifica novamente a validade no momento da venda,
        // pois o produto pode ter vencido depois de ter sido cadastrado
        if (dataDeValidade.isBefore(hoje)) {
            throw new IllegalStateException(
                "Não é possível vender um produto vencido."
            );
        }

        // Utiliza o cálculo normal de venda definido na classe Produto
        double valor = super.valorDeVenda();

        // Se o produto vence em até 7 dias, aplica desconto de 25%
        if (!dataDeValidade.isAfter(hoje.plusDays(PRAZO_DESCONTO))) {
            valor = valor * (1 - DESCONTO);
        }

        return valor;
    }


    @Override
    public String toString() {

        // Acrescenta a data de validade às informações do produto
        return super.toString()
                + "\nData de validade: "
                + dataDeValidade;
    }


     // AULA 2

    /** 
     * Gera uma linha de texto a partir dos dados do produto. Preço e margem de lucro vão formatados com 2 casas decimais. 
     * Data de validade vai no formato dd/mm/aaaa 
     * @return Uma string no formato "2; descrição;preçoDeCusto;margemDeLucro;dataDeValidade" 
     */ 
    @Override 
    public String gerarDadosTexto() { 

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return String.format(
            "2;%s;%.2f;%.2f;%s",
            descricao,
            precoCusto,
            margemLucro,
            dataDeValidade.format(formato)
        );
    } 
}