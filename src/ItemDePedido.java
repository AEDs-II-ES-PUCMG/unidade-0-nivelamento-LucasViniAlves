public class ItemDePedido {

    // Atributos encapsulados
    private Produto produto;
    private int quantidade;
    private double precoVenda;

    /**
     * Construtor da classe ItemDePedido.
     * O precoVenda deve ser capturado do produto no momento da criação do item,
     * garantindo que alterações futuras no preço do produto não afetem este pedido.
     */
    public ItemDePedido(Produto[] produto, int quantidade, double precoVenda) {
        produto = new Produto;
        quantidade = 0;
        precoVenda = 0;
    }

    public double calcularSubtotal() {
        
        double total = 0;
        total += produto.valorVenda();
        return total;

    }

    /**
     * Compara a igualdade entre dois itens de pedido.
     * A regra de negócio define que dois itens são iguais se possuírem o mesmo Produto.
     */
    @Override
    public boolean equals(Object obj) {
        
        ItemDePedido outro = (ItemDePedido) obj;       
        return this.produto.equals(outro.produto);
    }
}
