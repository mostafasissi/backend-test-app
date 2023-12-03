package ma.ehtp.project.utils;


import ma.ehtp.project.entities.Product;
import ma.ehtp.project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class CsvDataLoader {

    @Autowired
    private ProductService productService;

    @PostConstruct
    public void loadCsvData() {
        try {
            // Load the CSV file from the resources
            InputStream resource = getClass().getClassLoader().getResourceAsStream("data.csv");
            System.out.println(getClass().getResource("/data.csv"));
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource));

            // Read the first line and skip it as it contains only column names
            String line = reader.readLine();
            if (line != null) {
                // Read each line and add an object to the database
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    String[] data = line.split(":");
                    Product product = new Product();
                    product.setName(data[0]);
                    product.setQuantity(Integer.parseInt(data[1]));
                    product.setPrice(Double.parseDouble(data[2]));
                    productService.addProduct(product);
                }
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
