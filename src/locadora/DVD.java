package locadora;

public class DVD extends Product {
    // Declarações de campo de instância
    private int length; // Duração do filme em minutos
    private int ageRating; // Classificação etária
    private String filmStudio; // Estúdio cinematográfico

    // Construtor que permite a definição dos valores iniciais para um DVD
    public DVD(int number, String name, int qty, double price, int length, int rating, String studio) {
        // Especificar os parâmetros necessários para a superclasse
        super(number, name, qty, price);
        this.length = length;
        this.ageRating = rating;
        this.filmStudio = studio;
    }

    // Construtor alternativo que permite inicializar um DVD sem informações extras
    public DVD(int number, String name, int qty, double price) {
        // Especificar os parâmetros necessários para a superclasse
        super(number, name, qty, price);
    }

    // Obter o valor total do inventário para este Produto DVD
    // Inclui uma taxa de reposição de estoque de 5%
    @Override
    public double getInventoryValue() {
        return 1.05 * (super.getPrice() * super.getQtyInStock());
    }

    // Getter e Setter para o campo `length`
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // Getter e Setter para o campo `ageRating`
    public int getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }

    // Getter e Setter para o campo `filmStudio`
    public String getFilmStudio() {
        return filmStudio;
    }

    public void setFilmStudio(String filmStudio) {
        this.filmStudio = filmStudio;
    }

    // Substituir método toString() da classe Product
    // Para permitir a exibição de cada objeto DVD na console
    @Override
    public String toString() {
        return "\n\nNúmero do Item : " + getItemNumber()
                + "\nNome : " + getName()
                + "\nDuração do Filme : " + getLength() + " minutos"
                + "\nClassificação Etária : " + getAgeRating() + " anos"
                + "\nEstúdio Cinematográfico : " + getFilmStudio()
                + "\nQuantidade em estoque : " + getQtyInStock()
                + "\nPreço : R$ " + getPrice()
                + "\nValor do Estoque : R$ " + getInventoryValue()
                + "\nStatus do Produto : " + (getActive() ? "Ativo" : "Descontinuado");
    }
}
