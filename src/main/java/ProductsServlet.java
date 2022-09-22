import java.io.*;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "productServlet", urlPatterns = "/products")
public class ProductsServlet extends HttpServlet{
    private ArrayList<Product> products;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        createProducts();
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>Products</h1>");
        writer.println("<table>");
        writer.println("<tr><th>id</th><th>title</th><th>cost</th>");
        for (Product product:products){
            writer.println("<tr><th>" + product.getId() +
                    "</th><th>" + product.getTitle() +
                    "</th><th>" + product.getCost() + "</th></tr>");
        }
        writer.close();
    }

    private void createProducts() {
        products = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            products.add(new Product(i,"product" + i, 100 * i));
        }
    }
}
