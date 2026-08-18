public class Main {

    public static void main(String[] args) throws Exception {

        teclado = new Scanner(
            System.in,
            Charset.forName("ISO-8859-2")
        );

        nomeArquivoDados = "dadosProdutos.csv";
        produtosCadastrados = lerProdutos(nomeArquivoDados);

        int opcao = -1;

        do {
            opcao = menu();

            switch (opcao) {
                case 1 -> listarTodosOsProdutos();
                case 2 -> localizarProdutos();
                case 3 -> cadastrarProduto();
            }

            pausa();

        } while (opcao != 0);

        salvarProdutos(nomeArquivoDados);
        teclado.close();
    }
}