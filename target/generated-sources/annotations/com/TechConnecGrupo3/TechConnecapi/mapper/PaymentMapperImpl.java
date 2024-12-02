package com.TechConnecGrupo3.TechConnecapi.mapper;

import com.TechConnecGrupo3.TechConnecapi.model.enums.PaymentStatus;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-01T13:51:21-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public PaymentDTO toDTO(Payment payment) {
        if ( payment == null ) {
            return null;
        }

        PaymentDTO paymentDTO = new PaymentDTO();

        paymentDTO.setAmount( payment.getAmount() );
        if ( payment.getPaymentStatus() != null ) {
            paymentDTO.setPaymentStatus( payment.getPaymentStatus().name() );
        }
        paymentDTO.setPaymentDate( payment.getPaymentDate() );

        return paymentDTO;
    }

    @Override
    public Payment toEntity(PaymentDTO paymentDTO) {
        if ( paymentDTO == null ) {
            return null;
        }

        Payment payment = new Payment();

        payment.setAmount( paymentDTO.getAmount() );
        if ( paymentDTO.getPaymentStatus() != null ) {
            payment.setPaymentStatus( Enum.valueOf( PaymentStatus.class, paymentDTO.getPaymentStatus() ) );
        }
        payment.setPaymentDate( paymentDTO.getPaymentDate() );

        return payment;
    }
}
