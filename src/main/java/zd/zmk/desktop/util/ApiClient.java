package zd.zmk.desktop.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import zd.zmk.entities.VendingMachine;
import zd.zmk.entities.Product;
import zd.zmk.entities.Sale;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiClient {

    private static final String BASE_URL = "http://localhost:8080/api";
    private ObjectMapper objectMapper;

    public ApiClient() {
        this.objectMapper = new ObjectMapper();
    }

    // Vending Machine methods
    public ObservableList<VendingMachine> getAllVendingMachines() {
        try {
            URL url = new URL(BASE_URL + "/vending-machines");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                response.append(output);
            }

            // Parse the response to extract the content from the Page object
            JsonNode rootNode = objectMapper.readTree(response.toString());
            JsonNode contentNode = rootNode.get("content");

            ObservableList<VendingMachine> vendingMachines = FXCollections.observableArrayList();

            if (contentNode.isArray()) {
                for (final JsonNode machineNode : contentNode) {
                    VendingMachine machine = objectMapper.treeToValue(machineNode, VendingMachine.class);
                    vendingMachines.add(machine);
                }
            }

            conn.disconnect();

            return vendingMachines;
        } catch (Exception e) {
            e.printStackTrace();
            return FXCollections.observableArrayList();
        }
    }

    public VendingMachine getVendingMachineById(int id) {
        try {
            URL url = new URL(BASE_URL + "/vending-machines/" + id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                response.append(output);
            }

            VendingMachine machine = objectMapper.readValue(response.toString(), VendingMachine.class);
            conn.disconnect();

            return machine;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public VendingMachine createVendingMachine(VendingMachine machine) {
        try {
            URL url = new URL(BASE_URL + "/vending-machines");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            String jsonInputString = objectMapper.writeValueAsString(machine);

            try(OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            if (conn.getResponseCode() != 201) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                response.append(output);
            }

            VendingMachine createdMachine = objectMapper.readValue(response.toString(), VendingMachine.class);
            conn.disconnect();

            return createdMachine;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Product methods
    public ObservableList<Product> getAllProducts() {
        try {
            URL url = new URL(BASE_URL + "/products");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                response.append(output);
            }

            // Parse the response to extract the content from the Page object
            JsonNode rootNode = objectMapper.readTree(response.toString());
            JsonNode contentNode = rootNode.get("content");

            ObservableList<Product> products = FXCollections.observableArrayList();

            if (contentNode.isArray()) {
                for (final JsonNode productNode : contentNode) {
                    Product product = objectMapper.treeToValue(productNode, Product.class);
                    products.add(product);
                }
            }

            conn.disconnect();

            return products;
        } catch (Exception e) {
            e.printStackTrace();
            return FXCollections.observableArrayList();
        }
    }

    // Sale methods
    public ObservableList<Sale> getAllSales() {
        try {
            URL url = new URL(BASE_URL + "/sales");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                response.append(output);
            }

            // Parse the response to extract the content from the Page object
            JsonNode rootNode = objectMapper.readTree(response.toString());
            JsonNode contentNode = rootNode.get("content");

            ObservableList<Sale> sales = FXCollections.observableArrayList();

            if (contentNode.isArray()) {
                for (final JsonNode saleNode : contentNode) {
                    Sale sale = objectMapper.treeToValue(saleNode, Sale.class);
                    sales.add(sale);
                }
            }

            conn.disconnect();

            return sales;
        } catch (Exception e) {
            e.printStackTrace();
            return FXCollections.observableArrayList();
        }
    }
}