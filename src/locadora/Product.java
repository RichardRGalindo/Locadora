package locadora;

public class Product {
    // Declarações de campo de instância
    private int itemNumber; // Valor exclusivo para identificação
    private String name; // Nome do produto
    private int qtyInStock; // Quantidade em estoque
    private double price; // Preço do produto
    private boolean active = true; // Status do produto

    // Construtor padrão que inicializa as variáveis de instância
    public Product() {
    }

    // Construtor que permite a definição dos valores iniciais para Produtos
    public Product(int number, String name, int qty, double price) {
        this.itemNumber = number;
        this.name = name;
        this.qtyInStock = qty;
        this.price = price;
    }

    // Adicionar uma quantidade a qtyInStock durante o recebimento de uma remessa
    public void addToInventory(int quantity) {
        if (this.active) {
            this.qtyInStock += quantity;
        } else {
            System.out.println("Não é possível adicionar estoque a uma linha descontinuada!");
        }
    }

    // Subtrair uma quantidade de qtyInStock ao fazer vendas
    public void deductFromInventory(int quantity) {
        this.qtyInStock -= quantity;
    }

    // Retorna o valor atual de itemNumber
    public int getItemNumber() {
        return itemNumber;
    }

    // Atualiza o valor itemNumber
    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    // Retorna o valor atual do nome
    public String getName() {
        return name;
    }

    // Atualiza o valor do nome
    public void setName(String name) {
        this.name = name;
    }

    // Retorna o valor atual de qtyInStock
    public int getQtyInStock() {
        return qtyInStock;
    }

    // Atualiza o valor de qtyInStock
    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }

    // Retorna o valor atual do preço
    public double getPrice() {
        return price;
    }

    // Atualiza o valor do preço
    public void setPrice(double price) {
        this.price = price;
    }

    // Retorna o valor atual de ativo
    public boolean getActive() {
        return active;
    }

    // Atualiza o valor de ativo
    public void setActive(boolean active) {
        this.active = active;
    }

    // Obter o valor total do inventário deste Produto
    public double getInventoryValue() {
        return price * qtyInStock;
    }

    // Substituir método toString() da classe Object
    // Para permitir a exibição de cada objeto na console
    @Override
    public String toString() {
        return "\n\nNúmero do Item : " + this.itemNumber
                + "\nNome : " + this.name
                + "\nQuantidade em estoque: " + this.qtyInStock
                + "\nPreço : R$ " + this.price
                + "\nValor do Estoque : R$ " + getInventoryValue()
                + "\nStatus do Produto : " + (this.active ? "Ativo" : "Descontinuado");
    }
}
