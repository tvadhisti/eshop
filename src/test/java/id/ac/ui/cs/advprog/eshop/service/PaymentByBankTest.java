package id.ac.ui.cs.advprog.eshop.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PaymentByBankTest {
    @InjectMocks
    PaymentServiceImpl paymentService;

    @Mock
    PaymentRepository paymentRepository;

    private Map<String, String> createPaymentData(String bankName, String referenceCode) {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("bankName", bankName);
        paymentData.put("referenceCode", referenceCode);
        return paymentData;
    }

    @Test
    void testValidTfayment() {
        Map<String, String> validPaymentData = createPaymentData("ABC Bank", "654321");
        assertTrue(paymentService.isBankTransferValid(validPaymentData));
    }

    @Test
    void testInvalidTfMissingBankName() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("referenceCode", "123456");
        boolean isValid = paymentService.isBankTransferValid(paymentData);
        assertEquals(false, isValid);
    }

    @Test
    void testInvalidTfMissingReference() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("bankName", "Example Bank");
        boolean isValid = paymentService.isBankTransferValid(paymentData);
        assertEquals(false, isValid);
    }

    @Test
    void testInvalidTfEmptyBankNameAndReference() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("bankName", "");
        paymentData.put("referenceCode", "");
        boolean isValid = paymentService.isBankTransferValid(paymentData);
        assertEquals(false, isValid);
    }
}