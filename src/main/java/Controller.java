import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Controller {
    public static void Menu(){
        Scanner sc = new Scanner(System.in);

        int choice;
        do{
            System.out.println("\n\n----------------------------------------------------");
            System.out.println("1. Print all item");
            System.out.println("2. Print price greater than 100000");
            System.out.println("3. Sort by Quantity Sold");
            System.out.println("4. Bestseller");
            System.out.println("5. Print from category");
            System.out.println("6. Search name");
            System.out.println("0. Exit");
            System.out.println("Your choice?");
            choice = sc.nextInt();
            switch (choice){
                case 0:
                    break;
                case 1:
                    printList();
                    break;
                case 2:
                    sortByPrice();
                    break;
                case 3:
                    sortByQuantitySold();
                    break;
                case 4:
                    bestSeller();
                    break;
                case 5:
                    printByCategory();
                    break;
                default:
                    System.out.println("Please enter 0-5");
                    break;
            }
        }while (choice != 0);
    }

    public static void printList(){
        ProductRepository rp = new ProductRepository();
        ArrayList<Product> list = rp.getData();
        print(list);
    }

    public static void sortByPrice(){
        ProductRepository rp = new ProductRepository();
        ArrayList<Product> list = rp.getData();
        ArrayList<Product> list2 = new ArrayList<>();

        for(Product p : list){
            if(p.getPrice() >= 100000){
                list2.add(p);
            }
        }

        Collections.sort(list2, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o2.getPrice() - o1.getPrice();
            }
        });
        print(list2);
    }

    public static void sortByQuantitySold(){
        ProductRepository rp = new ProductRepository();
        ArrayList<Product> list = rp.getData();

        Collections.sort(list, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o2.getQuantitySold() - o1.getQuantitySold();
            }
        });
        print(list);
    }

    public static void bestSeller(){
        ProductRepository rp = new ProductRepository();
        ArrayList<Product> list = rp.getData();
        Collections.sort(list, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o2.getQuantitySold() - o1.getQuantitySold();
            }
        });
        Product bestSeller = new Product();
        bestSeller = list.get(0);
        System.out.println(bestSeller);
    }

    public static void printByCategory(){
        ProductRepository rp = new ProductRepository();
        ArrayList<Product> list = rp.getData();

        ArrayList<Product> listHouseWare = new ArrayList<>();
        ArrayList<Product> listFashion = new ArrayList<>();
        ArrayList<Product> listCosmetic = new ArrayList<>();
        ArrayList<Product> listFood = new ArrayList<>();

        for(Product p : list){
            if(p.getCategory() == Category.FOOD){
                listFood.add(p);
            }else if(p.getCategory() == Category.COSMETICS){
                listCosmetic.add(p);
            }else if(p.getCategory() == Category.FASHION){
                listFashion.add(p);
            }else if(p.getCategory() == Category.HOUSEWARE){
                listHouseWare.add(p);
            }
        }

        print(listHouseWare);
        print(listFashion);
        print(listCosmetic);
        print(listFood);
    }

    public static void print(ArrayList<Product> list){
        for(Product p: list){
            System.out.println(p.toString());
        }
    }
}
