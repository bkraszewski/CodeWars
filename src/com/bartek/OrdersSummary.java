package com.bartek;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class OrdersSummary {
    //"Buy: 29499 Sell: 0";
    public static String balanceStatements(String input) {
        String[] orders = Arrays.stream(input.trim()
                .split(","))
                .filter(item -> !item.isEmpty())
                .toArray(value -> new String[value]);

        List<Order> allOrders = IntStream.range(0, orders.length)
                .mapToObj(i -> new Order(orders[i]))
                .collect(Collectors.toList());

        List<Order> correct = allOrders
                .stream()
                .filter(order -> order.correct)
                .collect(Collectors.toList());

        List<Order> wrong = allOrders
                .stream()
                .filter(order -> !order.correct)
                .collect(Collectors.toList());

        BigDecimal buyTotal = BigDecimal.ZERO;
        BigDecimal sellTotal = BigDecimal.ZERO;

        for (Order order : correct) {
            if (order.status.equals("B")) {
                buyTotal = buyTotal.add(BigDecimal.valueOf(order.quantity).multiply(order.price));
            } else {
                sellTotal = sellTotal.add(BigDecimal.valueOf(order.quantity).multiply(order.price));
            }
        }

        String firstPart = String.format("Buy: %d Sell: %d", buyTotal.intValue(), sellTotal.intValue());
        if (wrong.isEmpty()) {
            return firstPart;
        } else {
            StringBuilder builder = new StringBuilder(firstPart);
            builder.append(String.format("; Badly formed %d:", wrong.size()));

            //Badly formed 1: ZNGA 1300 2.66 ;
            for (Order order : wrong) {
                builder.append(String.format("%s ;", order.input));
            }
            return builder.toString();
        }
    }

    public static class Order {
        private int quantity;
        private BigDecimal price;
        private String status;
        private boolean correct = true;
        private String input;

        public Order(String input) {
            this.input = input.trim();

            try {
                String[] fields = this.input.split(" ");
                //name = String.valueOf(fields[0]);
                quantity = Integer.parseInt(fields[1]);
                String realPrice = fields[2];
                if (!realPrice.contains(".")) {
                    throw new IllegalArgumentException("Not a double");
                }

                price = new BigDecimal(realPrice);
                status = fields[3];
                if (!status.equals("B") && !status.equals("S")) {
                    throw new IllegalArgumentException("Wrong transaction status");
                }

            } catch (Exception ex) {
                correct = false;
            }
        }
    }
}
