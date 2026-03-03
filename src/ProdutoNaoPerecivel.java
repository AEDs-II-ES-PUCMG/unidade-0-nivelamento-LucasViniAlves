public class ProdutoNaoPerecivel extends Produto {
	
	/**
	 * Construtor completo para produto não perecível.
	 * @param desc Descrição do produto (mínimo de 3 caracteres)
	 * @param precoCusto Preço do produto (mínimo 0.01)
	 * @param margemLucro Margem de lucro (mínimo 0.01)
	 */
	public ProdutoNaoPerecivel(String desc, double precoCusto, double margemLucro) {
		super(desc, precoCusto, margemLucro);
	}
	
	/**
	 * Construtor sem margem de lucro - fica considerado o valor padrão de margem de lucro.
	 * @param desc Descrição do produto (mínimo de 3 caracteres)
	 * @param precoCusto Preço do produto (mínimo 0.01)
	 */
	public ProdutoNaoPerecivel(String desc, double precoCusto) {
		super(desc, precoCusto);
	}
	
    /**
    * Gera uma linha de texto a partir dos dados do produto. Preço e margem de lucro vão formatados com 2 casas
    decimais.
    * @return Uma string no formato "1; descrição;preçoDeCusto;margemDeLucro"
    */
    @Override
    public String gerarDadosTexto() {
    /*Você deve implementar aqui a lógica que monta a String com os atributos do objeto ProdutoNaoPerecivel,
    respeitando o formato do arquivo de dados. */
    }

	/**
	 * Retorna o valor de venda do produto não perecível, considerando seu preço de custo e margem de lucro.
	 * @return Valor de venda do produto (double, positivo)
	 */
	@Override
	public double valorDeVenda() {
		return super.valorDeVenda();
	}
}