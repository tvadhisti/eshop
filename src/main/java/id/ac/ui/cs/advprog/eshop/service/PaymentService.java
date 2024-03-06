package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Payment;

import java.util.List;

public interface PaymentService {
    public Payment createPayment(Payment payment);
    public Payment updateStatus(String paymentId, String status);
    Payment findById(String paymentId);
    List<Payment> findAll();
}