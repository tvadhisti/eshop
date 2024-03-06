package id.ac.ui.cs.advprog.eshop.service;

import enums.PaymentStatus;
import enums.OrderStatus;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceImplTest {
    @InjectMocks
    PaymentServiceImpl paymentService;

    @Mock
    PaymentRepository paymentRepository;

    List<Payment> payments;
    Map<String, String> paymentVoucher = new HashMap<>();

    @BeforeEach
    void setUp() {
        Map<String, String> paymentData = new HashMap<>();
        paymentVoucher.put("voucherCode", "ESHOP1234ABC5678");

        payments = new ArrayList<>();
        Payment payment1 = new Payment("ee277588-db54-4a42-b441-c8315122aa79", "voucherCode", paymentVoucher,
                PaymentStatus.SUCCESS.getValue());
        payments.add(payment1);
        Payment payment2 = new Payment("940f6c91-370c-49d1-8fb0-082cd2a1ae11", "voucherCode", paymentVoucher,
                PaymentStatus.SUCCESS.getValue());
        payments.add(payment2);
    }

    @Test
    void testCreatePayment() {
        Payment payment = payments.get(1);
        doReturn(payment).when(paymentRepository).save(payment);

        Payment result = paymentService.createPayment(payment);
        verify(paymentRepository, times(1)).save(payment);
        assertEquals(payment.getId(), result.getId());
    }

    @Test
    void testCreatePaymentIfAlreadyExist() {
        Payment payment = payments.get(1);
        doReturn(payment).when(paymentRepository).findById(payment.getId());

        assertNull(paymentService.createPayment(payment));
        verify(paymentRepository, times(0)).save(payment);
    }


    @Test
    void testUpdateStatus() {
        Payment payment = payments.get(1);
        Payment newPayment = new Payment(payment.getId(), payment.getMethod(), payment.getPaymentData(),
                OrderStatus.SUCCESS.getValue());
        doReturn(payment).when(paymentRepository).findById(payment.getId());
        doReturn(newPayment).when(paymentRepository).save(any(Payment.class));

        Payment result = paymentService.updateStatus(payment.getId(), PaymentStatus.SUCCESS.getValue());

        assertEquals(payment.getId(), result.getId());
        assertEquals(PaymentStatus.SUCCESS.getValue(), result.getStatus());
        verify(paymentRepository, times(1)).save(any(Payment.class));
    }

    @Test
    void TestUpdateStatusInvalid() {
        Payment payment = payments.get(1);
        doReturn(payment).when(paymentRepository).findById(payment.getId());

        assertThrows(IllegalArgumentException.class,
                () -> paymentService.updateStatus(payment.getId(), "MEOW"));

        verify(paymentRepository, times(0)).save(any(Payment.class));
    }


    @Test
    void testFindByIdIfIdFound() {
        Payment payment = payments.get(1);
        doReturn(payment).when(paymentRepository).findById(payment.getId());

        Payment result = paymentService.findById(payment.getId());
        assertEquals(payment.getId(), result.getId());
    }

    @Test
    void testFindByIdIfIdNotFound() {
        doReturn(null).when(paymentRepository).findById("zczc");
        assertNull(paymentService.findById("zczc"));
    }

    @Test
    void testFindAll() {

        List<Payment> results = paymentService.findAll();
        assertTrue(results.isEmpty());
    }
}