package locadora;

public class CD extends Product {
    // Declarações de campo de instância
    private String artist;
    private int numberOfSongs;
    private String label;

    // Construtor que permite a definição dos valores iniciais para um CD
    public CD(int number, String name, int qty, double price, String artist, int numSongs, String label) {
        // Especificar os parâmetros necessários para a superclasse
        super(number, name, qty, price);
        this.artist = artist;
        this.numberOfSongs = numSongs;
        this.label = label;
    }

    // Getter e Setter para o campo `artist`
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    // Getter e Setter para o campo `numberOfSongs`
    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    public void setNumberOfSongs(int numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }

    // Getter e Setter para o campo `label`
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    // Substituir método toString() da classe Product
    // Para permitir a exibição de cada objeto CD no console
    @Override
    public String toString() {
        return "\n\nNúmero do Item : " + getItemNumber()
                + "\nNome : " + getName()
                + "\nArtista : " + getArtist()
                + "\nMúsicas do Álbum : " + getNumberOfSongs()
                + "\nSelo de Gravação : " + getLabel()
                + "\nQuantidade em Estoque : " + getQtyInStock()
                + "\nPreço : R$ " + getPrice()
                + "\nValor do Estoque : R$ " + getInventoryValue()
                + "\nStatus do Produto : " + (getActive() ? "Ativo" : "Descontinuado");
    }
}
