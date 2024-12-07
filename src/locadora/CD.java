
package locadora;

public class CD extends Product {
//Declarações de campo de instância
private String artist;
private int numberOfSongs;
private String label;
//construtor que permite a definição dos valores iniciais para um CD
public CD(int number, String name, int qty, double price, String artist, int numSongs, String
label)
{
//especificar os parâmetros necessários para a superclasse
super(number, name, qty, price);
this.artist = artist;
this.numberOfSongs = numSongs;
this.label = label;
}//encerrar construtor
public String getArtist() {
return artist;
}//encerrar método getArtist
public void setArtist(String artist) {
this.artist = artist;
}//encerrar método setArtist
public int getNumberOfSongs() {
return numberOfSongs;
}//encerrar método getNumberOfSongs
public void setNumberOfSongs(int numberOfSongs) {
this.numberOfSongs = numberOfSongs;
}//encerrar método setNumberOfSongs

Copyright © 2022, Oracle e/ou suas empresas afiliadas. Oracle, Java e MySQL são marcas comerciais registradas da Oracle Corporation e/ou de suas empresas afiliadas. Outros nomes podem ser
marcas comerciais de seus respectivos proprietários.

15

public String getLabel() {
return label;
}//encerrar método getLabel
public void setLabel(String label) {
this.label = label;
}//encerrar método setLabel
//substituir Método toString() da classe Produto
//para permitir a exibição de cada objeto CD na console
public String toString()
{
return "\n\nNúmero do Item : " + getItemNumber()
+ "\nNome : " + getName()
+ "\nArtista : " + getArtist()
+ "\nMúsicas do Álbum :" + getNumberOfSongs()
+ "\nSelo de Gravação : " + getLabel()
+ "\nQuantidade em estoque: " + getQtyInStock()
+ "\nPreço : " + getPrice()
+ Valor do Estoque : " + getInventoryValue()
+ "\nStatus do Produto : " + (getActive()?"Ativo":"Descontinuado");
}//encerrar método toString
}//encerrar classe CD