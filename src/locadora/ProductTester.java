package locadora;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductTester {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int maxSize, menuChoice;

        maxSize = getNumProducts(in);
        if (maxSize == 0) {
            System.out.println("Não há produtos!");
        } else {
            Product[] products = new Product[maxSize];
            addToInventory(products, in);
            do {
                menuChoice = getMenuOption(in);
                executeMenuChoice(menuChoice, products, in);
            } while (menuChoice != 0);
        }
        in.close();
    }

    static void executeMenuChoice(int choice, Product[] products, Scanner in) {
        switch (choice) {
            case 1 -> {
                System.out.println("Exibir Lista de Produtos");
                displayInventory(products);
            }
            case 2 -> {
                System.out.println("Adicionar Estoque");
                addInventory(products, in);
            }
            case 3 -> {
                System.out.println("Deduzir Estoque");
                deductInventory(products, in);
            }
            case 4 -> {
                System.out.println("Descontinuar Estoque");
                discontinueInventory(products, in);
            }
            case 0 -> System.out.println("Saindo do programa...");
            default -> System.out.println("Opção inválida.");
        }
    }

    static void discontinueInventory(Product[] products, Scanner in) {
        int productChoice = getProductNumber(products, in);
        products[productChoice].setActive(false);
        System.out.println("Produto descontinuado com sucesso.");
    }

    static void deductInventory(Product[] products, Scanner in) {
        int productChoice = getProductNumber(products, in);
        int updateValue;

        do {
            try {
                System.out.print("Quantos produtos deseja deduzir? ");
                updateValue = in.nextInt();
                if (updateValue < 0) {
                    System.out.println("Insira apenas valores positivos para deduzir do estoque.");
                } else if (updateValue > products[productChoice].getQtyInStock()) {
                    System.out.println("Estoque insuficiente. Restam apenas " + products[productChoice].getQtyInStock() + " unidades.");
                } else {
                    products[productChoice].deductFromInventory(updateValue);
                    System.out.println("Estoque deduzido com sucesso.");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Insira um número válido.");
                in.nextLine();
            }
        } while (true);
    }

    static void addInventory(Product[] products, Scanner in) {
        int productChoice = getProductNumber(products, in);
        int updateValue;

        do {
            try {
                System.out.print("Quantos produtos deseja adicionar? ");
                updateValue = in.nextInt();
                if (updateValue < 0) {
                    System.out.println("Insira apenas valores positivos.");
                } else {
                    products[productChoice].addToInventory(updateValue);
                    System.out.println("Estoque atualizado com sucesso.");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Insira um número válido.");
                in.nextLine();
            }
        } while (true);
    }

    static int getProductNumber(Product[] products, Scanner in) {
        int productChoice = -1;
        displayInventory(products);

        do {
            try {
                System.out.print("Insira o número do item do produto: ");
                productChoice = in.nextInt();
                if (productChoice < 0 || productChoice >= products.length) {
                    System.out.println("Número inválido. Escolha entre 0 e " + (products.length - 1) + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Insira um número válido.");
                in.nextLine();
            }
        } while (productChoice < 0 || productChoice >= products.length);
        return productChoice;
    }

    static int getMenuOption(Scanner in) {
        int menuOption = -1;

        do {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Exibir Inventário");
                System.out.println("2. Adicionar Estoque");
                System.out.println("3. Deduzir Estoque");
                System.out.println("4. Descontinuar Produto");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                menuOption = in.nextInt();
                if (menuOption < 0 || menuOption > 4) {
                    System.out.println("Escolha inválida! Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Insira um número válido.");
                in.nextLine();
            }
        } while (menuOption < 0 || menuOption > 4);
        return menuOption;
    }

    static int getNumProducts(Scanner in) {
        int maxSize = -1;

        do {
            try {
                System.out.print("Insira o número de produtos que deseja adicionar (0 para nenhum): ");
                maxSize = in.nextInt();
                if (maxSize < 0) {
                    System.out.println("Valor inválido. Insira um número positivo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Insira um número válido.");
                in.nextLine();
            }
        } while (maxSize < 0);
        return maxSize;
    }

    static void addToInventory(Product[] products, Scanner in) {
        for (int i = 0; i < products.length; i++) {
            int stockChoice;

            do {
                try {
                    System.out.println("\n1: CD\n2: DVD");
                    System.out.print("Escolha o tipo de produto: ");
                    stockChoice = in.nextInt();
                    if (stockChoice < 1 || stockChoice > 2) {
                        System.out.println("Escolha inválida! Apenas 1 ou 2 são permitidos.");
                    } else {
                        if (stockChoice == 1) {
                            addCDToInventory(products, in, i);
                        } else {
                            addDVDToInventory(products, in, i);
                        }
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida! Insira um número válido.");
                    in.nextLine();
                }
            } while (true);
        }
    }

    static void addCDToInventory(Product[] products, Scanner in, int i) {
        in.nextLine();
        System.out.print("Nome do CD: ");
        String name = in.nextLine();
        System.out.print("Artista: ");
        String artist = in.nextLine();
        System.out.print("Selo de Gravação: ");
        String label = in.nextLine();
        System.out.print("Número de músicas: ");
        int numSongs = in.nextInt();
        System.out.print("Quantidade em estoque: ");
        int qty = in.nextInt();
        System.out.print("Preço: ");
        double price = in.nextDouble();
        System.out.print("Número do item: ");
        int number = in.nextInt();

        products[i] = new CD(number, name, qty, price, artist, numSongs, label);
    }

    static void addDVDToInventory(Product[] products, Scanner in, int i) {
        in.nextLine();
        System.out.print("Nome do DVD: ");
        String name = in.nextLine();
        System.out.print("Estúdio cinematográfico: ");
        String studio = in.nextLine();
        System.out.print("Classificação etária: ");
        int rating = in.nextInt();
        System.out.print("Duração (em minutos): ");
        int length = in.nextInt();
        System.out.print("Quantidade em estoque: ");
        int qty = in.nextInt();
        System.out.print("Preço: ");
        double price = in.nextDouble();
        System.out.print("Número do item: ");
        int number = in.nextInt();

        products[i] = new DVD(number, name, qty, price, length, rating, studio);
    }

    static void displayInventory(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                System.out.println(i + ": " + products[i]);
            }
        }
    }
}
