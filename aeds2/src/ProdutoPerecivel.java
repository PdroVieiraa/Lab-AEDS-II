import java.time.LocalDate;

public class ProdutoPerecivel extends Produto{
    
    private double DESCONTO = 0.25;
    private int PRAZO_DESCONTO = 7;
    LocalDate dataDeValidade;

    public ProdutoPerecivel (String desc, double precoCusto,double margemLucro){
        super(desc, precoCusto, margemLucro);
    }

    @Override
    public double valorDeVenda (){

    }


    public String toString(){}

}
