/*
 * Copyright 2018, Strimzi authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package com.github.tombentley.rivieradev2018.model;

public class PaymentResult {
    private boolean succeeded;

    private long orderId;

    public PaymentResult(long orderId, boolean succeeded) {
        this.orderId = orderId;
        this.succeeded = succeeded;
    }

    public PaymentResult() {

    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public boolean isSucceeded() {
        return succeeded;
    }

    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }
}
