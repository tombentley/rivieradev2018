/*
 * Copyright 2018, Strimzi authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package com.github.tombentley.rivieradev2018.model;

public class StockReserved {
    private long orderId;
    private boolean sufficientStock;

    public StockReserved() {

    }

    public StockReserved(long orderId, boolean sufficientStock) {
        this.orderId = orderId;
        this.sufficientStock = sufficientStock;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public boolean isSufficientStock() {
        return sufficientStock;
    }

    public void setSufficientStock(boolean sufficientStock) {
        this.sufficientStock = sufficientStock;
    }

    @Override
    public String toString() {
        return "StockReserved{" +
                "orderId=" + orderId +
                ", sufficientStock=" + sufficientStock +
                '}';
    }
}
