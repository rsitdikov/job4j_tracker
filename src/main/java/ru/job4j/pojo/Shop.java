package ru.job4j.pojo;

public class Shop {

    public Product[] delete(Product[] products, int index) {
        for (int i = index; i < products.length - 1; i++) {
            products[i] = products[i + 1];
        }
        products[products.length - 1] = null;
        return  products;
    }

    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        products[3] = new Product("Sausage", 15);

        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            //проверяем, что объект не равен null. тк у нас массив не заполнен целиком.
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }

        System.out.println();
        System.out.println("Удаляем значение из ячейки с индексом 1");
        //удаляем значение из ячейки с индексом 1
        products[1] = null;

        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            //проверяем, что объект не равен null. тк у нас массив не заполнен целиком.
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }

        System.out.println();
        System.out.println("Записываем  в ячейку с индексом 1 значение ячейки с индексом 2 и удаляем значение из ячейки с индексом 2");
        //записываем в ячейку с индексом 1 значение ячейки с индексом 2.
        products[1] = products[2];
        //удаляем значение из ячейки с индексом 2.
        products[2] = null;
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            //проверяем, что объект не равен null. так как  у нас массив не заполнен целиком.
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
        System.out.println();
        System.out.println("Для переноса всех ранее неудаленных элементов списка в его начало, вызываем метод 'delete'\n"
                            + "для удаленных продуктов");
        for (int index = 0; index < products.length; index++) {
            if (products[index] == null) {
                products = new Shop().delete(products, index);
            }
        }
        for (Product product: products) {
            if (product != null) {
                System.out.print(product.getName() + " ");
            } else {
                System.out.print(product + " ");
            }
        }
        System.out.println();
        System.out.println("Удаляем элемент с индексом 1");
        products = new Shop().delete(products, 1);
        for (Product product: products) {
            if (product != null) {
                System.out.print(product.getName() + " ");
            } else {
                System.out.print(product + " ");
            }
        }
        System.out.println();
    }
}
