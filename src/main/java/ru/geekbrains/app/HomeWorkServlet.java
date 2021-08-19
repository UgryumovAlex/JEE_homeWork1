package ru.geekbrains.app;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Задание
 * 1. Установить сервер приложений TomCat или Wildfly (либо любой другой по выбору);
 * 2. Создать и запустить новый проект по инструкции из данной методички;
 * 3. Создайте класс Product с полями (id, title, cost);
 * 4. Реализуйте сервлет выводящий на страницу список из 10 продуктов (создаете продукты в момент обработки запроса).
 *
 * */


public class HomeWorkServlet extends HttpServlet {
    private List<Product> productList;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        productList = new ArrayList<>();
        productList.add(new Product(100, "apple", 10));
        productList.add(new Product(101, "melon", 100));
        productList.add(new Product(102, "orange", 15));
        productList.add(new Product(103, "lemon", 25));
        productList.add(new Product(104, "peach", 20));
        productList.add(new Product(105, "pear", 20));
        productList.add(new Product(106, "grape", 50));
        productList.add(new Product(107, "guava", 90));
        productList.add(new Product(108, "pine-apple", 150));
        productList.add(new Product(109, "water-melon", 80));

        StringBuilder sb = new StringBuilder();
        for (Product p : productList) {
            sb.append("<li>");
            sb.append("Product id : " + p.getId() + "; title : " + p.getTitle() + "; cost : " + p.getCost());
            sb.append("</li>");
        }
        resp.getWriter().printf("<html><body><ul>" + sb.toString() + "</ul></body></html>");
    }

}
