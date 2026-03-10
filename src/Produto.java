import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Produto {
	
	private static final double MARGEM_PADRAO = 0.2;
	protected String descricao;
	protected double precoCusto;
	protected double margemLucro;
	
	/**
     * Inicializador privado. Os valores default, em caso de erro, são:
     * "Produto sem descrição", R$ 0.00, 0.0  
     * @param desc Descrição do produto (mínimo de 3 caracteres)
     * @param precoCusto Preço do produto (mínimo 0.01)
     * @param margemLucro Margem de lucro (mínimo 0.01)
     */
	private void init(String desc, double precoCusto, double margemLucro) {
		
		if ((desc.length() >= 3) && (precoCusto > 0.0) && (margemLucro > 0.0)) {
			descricao = desc;
			this.precoCusto = precoCusto;
			this.margemLucro = margemLucro;
		} else {
			throw new IllegalArgumentException("Valores inválidos para os dados do produto.");
		}
	}
	
	/**
     * Construtor completo. Os valores default, em caso de erro, são:
     * "Produto sem descrição", R$ 0.00, 0.0  
     * @param desc Descrição do produto (mínimo de 3 caracteres)
     * @param precoCusto Preço do produto (mínimo 0.01)
     * @param margemLucro Margem de lucro (mínimo 0.01)
     */
	protected Produto(String desc, double precoCusto, double margemLucro) {
		init(desc, precoCusto, margemLucro);
	}
	
	/**
     * Construtor sem margem de lucro - fica considerado o valor padrão de margem de lucro.
     * Os valores default, em caso de erro, são:
     * "Produto sem descrição", R$ 0.00 
     * @param desc Descrição do produto (mínimo de 3 caracteres)
     * @param precoCusto Preço do produto (mínimo 0.01)
     */
	protected Produto(String desc, double precoCusto) {
		init(desc, precoCusto, MARGEM_PADRAO);
	}

	 /**
     * Retorna o valor de venda do produto, considerando seu preço de custo e margem de lucro.
     * @return Valor de venda do produto (double, positivo)
     */
	public double valorVenda() {
		return (precoCusto * (1.0 + margemLucro));
	}

    public static Produto criarDoTexto(String linha) {
        String[] partes = linha.split(";");
        int tipo = Integer.parseInt(partes[0]);
        String descricao = partes[1];
        double precoDeCusto = Double.parseDouble(partes[2]);
        double margemDeLucro = Double.parseDouble(partes[3]);

        if (tipo == 1) {
            return new ProdutoNaoPerecivel(descricao, precoDeCusto, margemDeLucro);
        } else if (tipo == 2) {
            LocalDate validade = LocalDate.parse(partes[4], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return new ProdutoPerecivel(descricao, precoDeCusto, margemDeLucro, validade);
        }

        throw new IllegalArgumentException("Tipo de produto inválido.");
    }

	public String getDescricao() {
		return descricao;
	}

    /**
     * Gera uma linah de texto a partir dos dados do produto
     * @return Uma string no formato "tipo; descrição;preçoDeCusto;margemDeLucro;[dataDeValidade]"
     */
    public abstract String gerarDadosTexto();

	/**
     * Descrição, em string, do produto, contendo sua descrição e o valor de venda.
     *  @return String com o formato:
     * [NOME]: R$ [VALOR DE VENDA]
     */
    @Override
	public String toString() {
    	
    	NumberFormat moeda = NumberFormat.getCurrencyInstance();
    	
		return String.format("NOME: " + descricao + ": " + moeda.format(valorVenda()));
	}

    @Override
    public boolean equals(Object obj) {
        Produto outro = (Produto) obj;
        return this.descricao.toLowerCase().equals(outro.descricao.toLowerCase());
    }
}