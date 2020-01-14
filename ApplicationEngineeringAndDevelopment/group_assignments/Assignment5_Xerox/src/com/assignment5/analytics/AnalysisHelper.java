/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.analytics;

import com.assignment5.entities.Customer;
import com.assignment5.entities.Item;
import com.assignment5.entities.Order;
import com.assignment5.entities.Product;
import com.assignment5.entities.SalesPerson;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author 15085
 */
public class AnalysisHelper {

    private FileWriter writer;
    private File file;
    private final String PROD_CAT_PATH = "./ProductCatalogue.csv";
    private final String PRODUCT_HEADER = "Product-Id,Min-Price,Max-Price,Target-Price,ModifiedTargetPrice,AvgSalesPrice,DifferenceTarget,error,DiffMod";
    private final String LINE_BREAK = "\n";

    //top 3 best negotiated products
    public void bestProducts() {

        Map<Integer, List<Order>> ordersProduct = DataStore.getInstance().getProductOfOrders();
        HashMap<Product, Integer> proudctOrdersSum = new HashMap<>();
        // key: productId value : diff between salesPrice and targetPrice
        Map<Product, Integer> sumProducts = new HashMap<>();
        for (Integer i : ordersProduct.keySet()) {
            Product p = searchByProduct(i);
            int targetPrice = p.getTargetPrice();
            List<Order> orders = ordersProduct.get(i);
            int sumOfQuantity = 0;
            for (Order o : orders) {
                Item item = o.getItem();
                if (o.getItem().getSalesPrice() > p.getTargetPrice()) {
                    sumOfQuantity += o.getItem().getQuantity();
                }
            }
            proudctOrdersSum.put(p, sumOfQuantity);
        }
        TreeMap<Product, Integer> sortedMap = sortMapByValueD(proudctOrdersSum);
        int j = 1;
        Integer sum = null;
        System.out.println("--------------------------\n1. TOP 3 PRODUCTS\n--------------------------");
        for (Product p : sortedMap.keySet()) {
            if (sum == null) {
                System.out.println("Rank: " + j);
                sum = proudctOrdersSum.get(p);
            }
            if (Integer.compare(sum, proudctOrdersSum.get(p)) != 0) {
                j++;
                if (j == 4) {
                    break;
                }
                sum = proudctOrdersSum.get(p);
                System.out.println("Rank: " + j);
            }
            System.out.println("Product ID: " + p.getProductId() + " with sum of quantites sold > than targetPrice: " + proudctOrdersSum.get(p));
        }
    }

    public static TreeMap<Product, Integer> sortMapByValueD(HashMap<Product, Integer> map) {
        Comparator<Product> comparator = new ValueComparatorDesc(map);
        //TreeMap is a map sorted by its keys. 
        //The comparator is used to sort the TreeMap by keys. 
        TreeMap<Product, Integer> result = new TreeMap<Product, Integer>(comparator);
        result.putAll(map);
        return result;
    }

    private Product searchByProduct(int productId) {
        Map<Integer, Product> prouducts = DataStore.getInstance().getProducts();
        Product prod = null;

        for (Product p : prouducts.values()) {
            if (p.getProductId() == productId) {
                prod = p;
            }
        }
        return prod;
    }

    public void get3BestCustomers() {
        Map<Integer, Customer> customers = DataStore.getInstance().getCustomers();
        Map<Integer, Product> products = DataStore.getInstance().getProducts();
        HashMap<Customer, Integer> custProfit = new HashMap<>();
        TreeMap<Customer, Integer> sortedCustProfit = new TreeMap<>();
        List<Order> orders = new ArrayList<>();
        int i, rank = 1;

        for (Customer c : customers.values()) {
            int target = 0, profit, sum = 0;
            orders.clear();
            orders = c.getOrders();
            for (Order o : orders) {
                int prodId = o.getItem().getProductId();
                for (Product p : products.values()) {
                    if (prodId == p.getProductId()) {
                        target = p.getTargetPrice();
                    }
                }
                profit = (o.getItem().getSalesPrice() - target) * o.getItem().getQuantity();
                sum += profit;
            }
            custProfit.put(c, sum);

        }
        sortedCustProfit = sort2CustomerMapByValueD(custProfit);
        Object[] arrProfit = sortedCustProfit.values().toArray();
        Object[] arrCustomer = sortedCustProfit.keySet().toArray();
        System.out.println("--------------------------\n2. TOP 3 CUSTOMERS\n--------------------------");
        for (i = 0; i < sortedCustProfit.size() && rank <= 3; i++) {
            if (i == 0) {
                System.out.println("Rank: " + rank++);
                System.out.println("Customer: " + arrCustomer[i] + " Profit: " + arrProfit[i]);
            } else if (arrProfit[i] != arrProfit[i - 1]) {
                System.out.println("Rank: " + rank++);
                System.out.println("Customer: " + arrCustomer[i] + " Profit: " + arrProfit[i]);
            } else {
                System.out.println("Customer: " + arrCustomer[i] + " Profit: " + arrProfit[i]);
            }
        }
        //System.out.println("All Customers:\n" + sortedCustProfit);

    }

    public static TreeMap<Customer, Integer> sort2CustomerMapByValueD(HashMap<Customer, Integer> map) {
        Comparator<Customer> comparator = new ValueComparatorDesc2Customer(map);
        TreeMap<Customer, Integer> result = new TreeMap<Customer, Integer>(comparator);
        result.putAll(map);
        return result;
    }

    public void getThreeBestSalesPeople() {
        Map<SalesPerson, List<Order>> salesPersonOrders = new HashMap<>();
        Map<Integer, Product> products = DataStore.getInstance().getProducts();
        Collection<Product> values = products.values();
        ArrayList<Product> productList = new ArrayList<Product>(values);

        Map<Integer, SalesPerson> salesPersons = DataStore.getInstance().getSalesPersons();
        HashMap<SalesPerson, Integer> salesPersonProfit = new HashMap<>();

        for (SalesPerson sp : salesPersons.values()) {
            salesPersonOrders.put(sp, sp.getOrders());
        }

        for (SalesPerson sp : salesPersonOrders.keySet()) {
            int profit = 0;
            List<Order> orderList = sp.getOrders();
            for (Order order : orderList) {
                Item item = order.getItem();
                int productId = item.getProductId();
                Product product = productList.get(productId);
                int targetPrice = product.getTargetPrice();
                int quantity = item.getQuantity();
                int salesPrice = item.getSalesPrice();
                profit += (salesPrice - targetPrice) * quantity;
            }
            salesPersonProfit.put(sp, profit);
        }

        TreeMap<SalesPerson, Integer> sortedSalesPerson = sortMapDescending(salesPersonProfit);

        Collection<Integer> valuesProfit = sortedSalesPerson.values();
        ArrayList<Integer> profit = new ArrayList<Integer>(valuesProfit);

        Collection<SalesPerson> valuesSalesPerson = sortedSalesPerson.keySet();
        ArrayList<SalesPerson> salesPersonsList = new ArrayList<SalesPerson>(valuesSalesPerson);
        int rank = 1;

//        Object[] arrProfit = sortedCustProfit.values().toArray();
//        Object[] arrCustomer = sortedCustProfit.keySet().toArray();
        System.out.println("--------------------------\n3. TOP 3 SALES PERSONS\n--------------------------");
        for (int i = 0; i < sortedSalesPerson.size() && rank <= 3; i++) {
            if (i == 0) {
                System.out.println("Rank: " + rank++);
                System.out.println("Sales Person: " + salesPersonsList.get(i) + " Profit: " + profit.get(i));
            } else if (profit.get(i) != profit.get(i - 1)) {
                System.out.println("Rank: " + rank++);
                System.out.println("Sales Person: " + salesPersonsList.get(i) + " Profit: " + profit.get(i));
            } else {
                System.out.println("Sales Person: " + salesPersonsList.get(i) + " Profit: " + profit.get(i));
            }
        }

        getTotalProfit(salesPersonProfit);
    }

    public void getTotalProfit(HashMap<SalesPerson, Integer> salesPersonProfit) {
        int totalProfit = 0;
        for (Integer profit : salesPersonProfit.values()) {
            totalProfit += profit;
        }
        System.out.println("--------------------------\n4. Total revenue for the year\n--------------------------");

        if (totalProfit > 0) {
            System.out.println("Profit of : " + totalProfit);

        } else {
            System.out.println("Loss of : " + totalProfit);

        }
    }

    public static TreeMap<SalesPerson, Integer> sortMapDescending(HashMap<SalesPerson, Integer> map) {
        Comparator<SalesPerson> comparator = new ValueComparatorDescSalesPerson(map);
        //TreeMap is a map sorted by its keys. 
        //The comparator is used to sort the TreeMap by keys. 
        TreeMap<SalesPerson, Integer> result = new TreeMap<SalesPerson, Integer>(comparator);
        result.putAll(map);
        return result;
    }

    public void getModifiedPricing() throws IOException {
        Map<Integer, List<Order>> ordersProduct = DataStore.getInstance().getProductOfOrders();
        // key : Product object, value: modifiedTargetPrice
        HashMap<Product, Double> proudctModTargetPrice = new HashMap<>();
        // key: Product object, value : avgSalesPrice
        HashMap<Product, Double> proudctAvgSalesPrice = new HashMap<>();
        // key: Product object, value : diff bw avgSalesPrice and targetPrice
        HashMap<Product, Double> proudctDiff = new HashMap<>();
        for (Integer i : ordersProduct.keySet()) {
            Product p = searchByProduct(i);
            int targetPrice = p.getTargetPrice();
            List<Order> orders = ordersProduct.get(i);
            int salesPrice = 0;
            for (Order o : orders) {
                Item item = o.getItem();
                salesPrice += item.getSalesPrice();
            }
            double avgSalesPrice = salesPrice / orders.size();
            proudctAvgSalesPrice.put(p, avgSalesPrice);
            proudctDiff.put(p, avgSalesPrice - targetPrice);
            double modifiedTargetPrice;
            double modifiedPlus = avgSalesPrice + (0.05 * avgSalesPrice);
            double modifiedMinus = avgSalesPrice - (0.05 * avgSalesPrice);
            if (targetPrice > modifiedPlus) {
                modifiedTargetPrice = avgSalesPrice + (avgSalesPrice * 0.05);
            } else if (targetPrice < modifiedMinus) {
                modifiedTargetPrice = avgSalesPrice  - (avgSalesPrice * 0.05);
            } else {
                modifiedTargetPrice = targetPrice;
            }
            proudctModTargetPrice.put(p, modifiedTargetPrice);
        }
        TreeMap<Product, Double> sortedMap = sortMapByValueDesc(proudctDiff);
        try {

            file = new File(PROD_CAT_PATH);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            System.out.println("New Product Catalogue Created");
            writer = new FileWriter(file);

            writer.append(PRODUCT_HEADER);
            writer.append(LINE_BREAK);

            generateModifiedProduct(proudctModTargetPrice, proudctAvgSalesPrice, proudctDiff, sortedMap);

        } finally {

            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }

    private void generateModifiedProduct(HashMap<Product, Double> proudctModTargetPrice,
            HashMap<Product, Double> proudctAvgSalesPrice,
            HashMap<Product, Double> proudctDiff,
            TreeMap<Product, Double> sortedMap) throws IOException {
        boolean newTable = true;
        for (Product p : sortedMap.keySet()) {
            int productId = p.getProductId();
            int minPrice = p.getMinPrice();
            int maxPrice = p.getMaxPrice();
            int targetPrice = p.getTargetPrice();
            double modidfiedTargetprice = proudctModTargetPrice.get(p);
            double avgSalesPrice = proudctAvgSalesPrice.get(p);
            double diff = proudctDiff.get(p);
            double error = (modidfiedTargetprice - avgSalesPrice) / avgSalesPrice;
            double difference = avgSalesPrice - modidfiedTargetprice;
            if (diff < 0 && newTable) {
                newTable = false;
                writer.append(LINE_BREAK);
            }
            String column = productId + "," + minPrice + "," + maxPrice + "," + targetPrice + "," + modidfiedTargetprice + "," + avgSalesPrice + "," + diff + "," + error + "," + difference;
            writer.append(column);
            writer.append(LINE_BREAK);
        }
    }

    public static TreeMap<Product, Double> sortMapByValueDesc(HashMap<Product, Double> map) {
        Comparator<Product> comparator = new ValueComparatorDescProd(map);
        //TreeMap is a map sorted by its keys. 
        //The comparator is used to sort the TreeMap by keys. 
        TreeMap<Product, Double> result = new TreeMap<Product, Double>(comparator);
        result.putAll(map);
        return result;
    }

}

class ValueComparatorDesc2Customer implements Comparator<Customer> {

    HashMap<Customer, Integer> map = new HashMap<Customer, Integer>();

    public ValueComparatorDesc2Customer(HashMap<Customer, Integer> map) {
        this.map.putAll(map);
    }

    @Override
    public int compare(Customer s1, Customer s2) {
        if (map.get(s1) >= map.get(s2)) {
            return -1;
        } else {
            return 1;
        }
    }
}

class ValueComparatorDesc implements Comparator<Product> {

    HashMap<Product, Integer> map = new HashMap<Product, Integer>();

    public ValueComparatorDesc(HashMap<Product, Integer> map) {
        this.map.putAll(map);
    }

    @Override
    public int compare(Product s1, Product s2) {
        if (map.get(s1) >= map.get(s2)) {
            return -1;
        } else {
            return 1;
        }
    }
}

class ValueComparatorDescProd implements Comparator<Product> {

    HashMap<Product, Double> map = new HashMap<Product, Double>();

    public ValueComparatorDescProd(HashMap<Product, Double> map) {
        this.map.putAll(map);
    }

    @Override
    public int compare(Product s1, Product s2) {
        if (map.get(s1) >= map.get(s2)) {
            return -1;
        } else {
            return 1;
        }
    }
}

class ValueComparatorDescSalesPerson implements Comparator<SalesPerson> {

    HashMap<SalesPerson, Integer> map = new HashMap<SalesPerson, Integer>();

    public ValueComparatorDescSalesPerson(HashMap<SalesPerson, Integer> map) {
        this.map.putAll(map);
    }

    @Override
    public int compare(SalesPerson s1, SalesPerson s2) {
        if (map.get(s1) >= map.get(s2)) {
            return -1;
        } else {
            return 1;
        }
    }
}
