package locadora;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductTester {

    public static void main(String[] args) {
//criar um objeto Scanner para entrada do teclado
        Scanner in = new Scanner(System.in);
        int maxSize, menuChoice;
        maxSize = getNumProducts(in);
        if (maxSize == 0) {
//Exibir uma mensagem de que não há produto se zero for inserido
            System.out.println("Não há produtos!");
        } else {
            Product[] products = new Product[maxSize];
            addToInventory(products, in);
            do {
                menuChoice = getMenuOption(in);
                executeMenuChoice(menuChoice, products, in);
            } while (menuChoice != 0);
        }//endif
    }//encerrar método principal

    static void executeMenuChoice(int choice, Product[] products, Scanner in) {
        switch (choice) {
            case 1:
                System.out.println("Exibir Lista de Produtos");

                displayInventory(products);
                break;
            case 2:
                System.out.println("Adicionar Estoque");
                addInventory(products, in);
                break;
            case 3:
                System.out.println("Deduzir Estoque");
                deductInventory(products, in);
                break;
            case 4:
                System.out.println("Descontinuar Estoque");
                discontinueInventory(products, in);
                break;
        }//encerrar switch
    }//encerrar método executeMenuChoice

    static void discontinueInventory(Product[] products, Scanner in) {
        int productChoice;
        productChoice = getProductNumber(products, in);

        products[productChoice].setActive(false);
    }//encerrar método deductInventory

    static void deductInventory(Product[] products, Scanner in) {
        int productChoice;
        int updateValue = -1;
        productChoice = getProductNumber(products, in);
        do {
            try {
                System.out.print("Quantos produtos deseja deduzir? ");
                updateValue = in.nextInt();
                if (updateValue < 0) {
                    System.out.println("Insira apenas valores positivos para deduzir do estoque");
                }

//endif
                if (updateValue > products[productChoice].getQtyInStock()) {
                    System.out.println("Não há estoque suficiente para remover essa quantidade;restam" + products[productChoice].getQtyInStock() + "somente!");

}catch (InputMismatchException e) {
                System.out.println("Tipo incorreto de dados inserido!");
                in.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                in.nextLine();
            }
        } while (updateValue < 0 || updateValue > products[productChoice].getQtyInStock());

        products[productChoice].deductFromInventory(updateValue);
    }//encerrar método deductInventory

    static void addInventory(Product[] products, Scanner in) {
        int productChoice;
        int updateValue = -1;
        productChoice = getProductNumber(products, in);
        do {
            try {

                System.out.print("Quantos produtos deseja adicionar?");
                updateValue = in.nextInt();
                if (updateValue < 0) {
                    System.out.println(
                }"Insira apenas valores positivos para adicionar ao

estoque
             ");

//endif
}catch (InputMismatchException e) {
                System.out.println("Tipo incorreto de dados inserido!");
                in.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                in.nextLine();
            }
        } while (updateValue < 0);

        products[productChoice].addToInventory(updateValue);
    }//encerrar método addInventory

    static int getProductNumber(Product[] products, Scanner in) {
        int productChoice = -1;
//exibir o conteúdo do array de produtos
        for (int i = 0; i < products.length; i++) {
            System.out.println(i + " : " + products[i].getName());
        }
//endor
        do {
            try {

                System.out.print("Insira o número do item do produto que deseja atualizar: ");
                productChoice = in.nextInt();
                if (productChoice < 0 || productChoice > products.length - 1) {
                    System.out.println("Insira somente valores entre 0 e "
                            + (products.length - 1));
                }
//endif

            } catch (InputMismatchException e) {
                System.out.println("Tipo incorreto de dados inserido!");
                in.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                in.nextLine();
            }
        } while (productChoice < 0 || productChoice > products.length - 1);
        return productChoice;
    }//encerrar método getProductNumber

    static int getMenuOption(Scanner in) {
        int menuOption = -1;
//exibir menu até que uma entrada válida seja fornecida
        do {
            try {
                System.out.println(
                "\n\n1. Exibir Inventário\n2. Adicionar Estoque\n3.

Deduzir Estoque\n
                "

+ "4. Descontinuar Produto\n0. Sair");
System.out.print("Insira uma opção de menu: ");
                menuOption = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Tipo incorreto de dados inserido!");
                in.nextLine();
            } catch (Exception e) {

                System.out.println(e);
                in.nextLine();
            }
        } while (menuOption < 0 || menuOption > 4);
//retornar a entrada válida do usuário
        return menuOption;
    }//encerrar método getMenuOption

    static int getNumProducts(Scanner in) {
        int maxSize = -1;
//solicitar que o usuário insira um número >= zero
        do {
            try {
//exibir prompt para o usuário
                System.out.println("Insira o número de produtos que gostaria de

adicionar.
                ");

System.out.print("Insira 0 (zero) se não quiser adicionar produtos: ");
//supor que o usuário informe um valor válido
                maxSize = in.nextInt();
                if (maxSize < 0) {
                    System.out.println("Valor Incorreto inserido");
                }
//endif
            } catch (InputMismatchException e) {
                System.out.println("Tipo incorreto de dados inserido!");
                in.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                in.nextLine();
            }
        } while (maxSize < 0);
//retorna o valor válido inserido pelo usuário
        return maxSize;
    }//encerrar método getNUmProducts

    static void addToInventory(Product[] products, Scanner in) {
//criar variáveis locais
        int stockChoice = -1;
        for (int i = 0; i < products.length; i++) {

//exibir menu até que uma entrada válida seja fornecida
            do {
                try {
//pedir ao usuário para inserir as informações sobre o produto
                    System.out.println("\n1: CD\n2: DVD");
                    System.out.print("Insira o tipo de produto: ");
                    stockChoice = in.nextInt();
                    if (stockChoice < 1 || stockChoice > 2) {
                        System.out.println("Somente os números 1 ou 2 são permitidos!");
                    }
//endif
                } catch (InputMismatchException e) {
                    System.out.println("Tipo incorreto de dados inserido!");
                    in.nextLine();
                } catch (Exception e) {
                    System.out.println(e);

                    in.nextLine();
                }
            } while (stockChoice < 1 || stockChoice > 2);
            if (stockChoice == 1) {
                addCDToInventory(products, in, i);
            } else {
                addDVDToInventory(products, in, i);
            }
//endif
        }//endfor
    }//encerrar método addToInventory

    static void addCDToInventory(Product[] products, Scanner in, int i) {
//criar variáveis locais
        int tempNumber;
        String tempName;
        int tempQty;
        double tempPrice;
        String tempArtist;
        int tempNumSongs;
        String tempLabel;
//limpar o buffer de entrada
        in.nextLine();

//pedir ao usuário para inserir as informações sobre o produto
        System.out.print("\n\nInsira o nome do CD: ");
        tempName = in.nextLine();
        System.out.print("Insira o nome do artista:");
        tempArtist = in.nextLine();
        System.out.print("Insira o nome do selo de gravação: ");
        tempLabel = in.nextLine();
        System.out.print("Insira o número de músicas:");
        tempNumSongs = in.nextInt();
        System.out.print("Insira a quantidade em estoque para este produto: ");
        tempQty = in.nextInt();
        System.out.print("Insira o preço para este produto: ");
        tempPrice = in.nextDouble();
        System.out.print("Insira o número do item: ");
        tempNumber = in.nextInt();
//criar um objeto Produto CD e armazená-lo no array de produtos
        products[i] = new CD(tempNumber, tempName, tempQty, tempPrice, tempArtist,
                tempNumSongs, tempLabel);
    }//encerrar método addCDToInventory

    static void addDVDToInventory(Product[] products, Scanner in, int indexValue) {
//criar variáveis locais
        int tempNumber;
        String tempName;
        int tempQty;
        double tempPrice;
        int tempLength;
        int tempRating;
        String tempStudio;
//limpar o buffer de entrada
        in.nextLine();

//pedir ao usuário para inserir as informações sobre o produto
        System.out.print("\n\nInsira o nome do DVD: ");
        tempName = in.nextLine();
        System.out.print("Insira o nome do estúdio cinematográfico: ");

        tempStudio = in.nextLine();
        System.out.print("Insira a classificação etária: ");
        tempRating = in.nextInt();
        System.out.print("Insira a duração em minutos: ");
        tempLength = in.nextInt();
        System.out.print("Insira a quantidade em estoque para este produto: ");
        tempQty = in.nextInt();
        System.out.print("Insira o preço para este produto: ");
        tempPrice = in.nextDouble();
        System.out.print("Insira o número do item: ");
        tempNumber = in.nextInt();
//criar um objeto Produto DVD e armazená-lo no array de produtos
        products[indexValue] = new DVD(tempNumber, tempName, tempQty, tempPrice, tempLength,
                tempRating, tempStudio);
    }//encerrar método addDVDToInventory

    static void displayInventory(Product[] products) {
//exibir o conteúdo do array de produtos
        for (Product product : products) {
            System.out.println(product);
        }
//endor
    }//encerrar método displayInventory
}//encerrar classe ProductTester
