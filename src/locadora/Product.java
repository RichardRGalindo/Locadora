
package locadora;

public class Product {
//Declarações de campo de instância
private int itemNumber; //valor exclusivo para identificação
private String name; //nome do produto
private int qtyInStock; //quantidade em estoque
private double price; //preço do produto
private boolean active = true; //status do produto
//construtor padrão que inicializa as variáveis de instância
//os valores numéricos são 0 (zero) e os valores de String são "" (nulo)
public Product()
{
}//encerrar construtor
//construtor que permite a definição dos valores iniciais para Produtos
public Product(int number, String name, int qty, double price)
{
this.itemNumber = number;
this.name = name;
this.qtyInStock = qty;
this.price = price;
}//encerrar construtor
//adicionar uma quantidade a qtyInStock durante o recebimento de uma remessa
public void addToInventory(int quantity)
{
if(this.active)
this.qtyInStock += quantity;
else
System.out.println("Não é possível adicionar estoque a uma linha descontinuada!");
//endif
}//encerrar método addToInventory
//subtrair uma quantidade de qtyInStock ao fazer vendas
public void deductFromInventory(int quantity)
{
this.qtyInStock -= quantity;
}//encerrar método deductFromInventory
//retorna o valor atual de itemNumber
public int getItemNumber() {
return itemNumber;
}//encerrar método getItemNumber
//atualiza o valor itemNumber
public void setItemNumber(int itemNumber) {
this.itemNumber = itemNumber;
}//encerrar método setItemNumber
//retorna o valor atual do nome
public String getName() {
return name;
}//encerrar método getName
///atualiza o valor do nome
public void setName(String name) {
this.name = name;
}//encerrar método setName
//retorna o valor atual de qtyInStock
public int getQtyInStock() {
return qtyInStock;
}//encerrar método getQtyInStock
//atualiza o valor de qtyInStock
public void setQtyInStock(int qtyInStock) {
this.qtyInStock = qtyInStock;
}//encerrar método setQtyInStock
//retorna o valor atual do preço
public double getPrice() {
return price;
}//encerrar método getPrice
//atualiza o valor do preço
public void setPrice(double price) {
this.price = price;
}//encerrar método setPrice
//retorna o valor atual de ativo
public boolean getActive() {
return active;
}//encerrar método getActive
//atualiza o valor de ativo
public void setActive(boolean active) {
this.active = active;
}//encerrar método setActive
//obter o valor total do inventário deste Produto
public double getInventoryValue()
{
return price * qtyInStock;
}/encerrar método getInventoryValue
//substituir Método toString() da classe Objeto
//para permitir a exibição de cada objeto na console
public String toString()
{
return "\n\nNúmero do Item : " + this.itemNumber
+ "\nNome : " + this.name
+ "\nQuantidade em estoque: " + this.qtyInStock
+ "\nPreço : " + this.price
+ Valor do Estoque : " + getInventoryValue()
+ "\nStatus do Produto : " + (this.active?"Ativo":"Descontinuado");
}//encerrar método toString
}//encerrar classe Produto