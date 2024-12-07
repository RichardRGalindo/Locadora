
package locadora;

public class DVD extends Product {
//Declarações de campo de instância
private int length;
private int ageRating;
private String filmStudio;
//construtor que permite a definição dos valores iniciais para um DVD
public DVD(int number, String name, int qty, double price, int length, int rating, String
studio)
{
//especificar os parâmetros necessários para a superclasse
super(number, name, qty, price);
this.length = length;
this.ageRating = rating;
this.filmStudio = studio;
}//encerrar construtor
//construtor que permite a definição dos valores iniciais para um DVD
public DVD(int number, String name, int qty, double price)
{
//especificar os parâmetros necessários para a superclasse
super(number, name, qty, price);
}//encerrar construtor
//obter o valor total do inventário para este Produto DVD
//que inclui uma taxa de reposição de estoque de 5%
public double getInventoryValue()
{
return (1.05 * (super.getPrice() * super.getQtyInStock()));
}/encerrar método getInventoryValue
public int getLength() {
return length;
}//encerrar método getLength
public void setLength(int length) {
this.length = length;
}//encerrar método setLength
public int getAgeRating() {
return ageRating;
}//encerrar método getAgeRating
public void setAgeRating(int ageRating) {
this.ageRating = ageRating;
}//encerrar método setAgeRating
public String getFilmStudio() {
return filmStudio;
}//encerrar método getFilmStudio
public void setFilmStudio(String filmStudio) {

Copyright © 2022, Oracle e/ou suas empresas afiliadas. Oracle, Java e MySQL são marcas comerciais registradas da Oracle Corporation e/ou de suas empresas afiliadas. Outros nomes podem ser
marcas comerciais de seus respectivos proprietários.

14

this.filmStudio = filmStudio;
}//encerrar método setFilmStudio
//substituir Método toString() da classe Produto
//para permitir a exibição de cada objeto DVD na console
public String toString()
{
return "\n\nNúmero do Item : " + getItemNumber()
+ "\nNome : " + getName()
+ "\nDuração do Filme : " + getLength()
+ "\nClassificação Etária : " + getAgeRating()
+ "\nEstúdio Cinematográfico : " + getFilmStudio()
+ "\nQuantidade em estoque: " + getQtyInStock()
+ "\nPreço : " + getPrice()
+ Valor do Estoque : " + getInventoryValue()
+ "\nStatus do Produto : " + (getActive()?"Ativo":"Descontinuado");
}//encerrar método toString
}//encerrar classe DVD