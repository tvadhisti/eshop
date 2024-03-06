package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment createPayment(Payment payment) {
        if (paymentRepository.findById(payment.getId()) == null) {
            return paymentRepository.save(payment);
        }
        return null;
    }

    @Override
    public Payment updateStatus(String paymentId, String status) {
        Payment payment = paymentRepository.findById(paymentId);
        if (payment != null) {
            Payment newPayment = new Payment(payment.getId(), payment.getMethod(),
                    payment.getPaymentData(), status);
            paymentRepository.save(newPayment);
            return newPayment;
        } else {
            throw new NoSuchElementException();
        }
    }


    @Override
    public Payment findById(String paymentId) {
        return paymentRepository.findById(paymentId);
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.getAllPayment();
    }

    public String validateVoucher(String voucherCode) {
        if (isValidVoucher(voucherCode)) {
            return "SUCCESS";
        } else {
            return "REJECTED";
        }
    }

    private boolean isValidVoucher(String voucherCode) {
        if (voucherCode == null || voucherCode.length() != 16 || !voucherCode.startsWith("ESHOP")) {
            return false;
        }

        int digitCount = 0;
        for (int i = 5; i < voucherCode.length(); i++) {
            if (Character.isDigit(voucherCode.charAt(i))) {
                digitCount++;
            }
        }

        return digitCount >= 8;
    }

    public boolean isBankTransferValid(Map<String, String> paymentData) {
        String bankName = paymentData.get("bankName");
        String referenceCode = paymentData.get("referenceCode");

        return isStringValid(bankName) && isStringValid(referenceCode);
    }

    private boolean isStringValid(String str) {
        return str != null && !str.isEmpty();
    }
}