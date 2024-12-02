package com.TechConnecGrupo3.TechConnecapi.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-01T13:51:22-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class PurchaseMapperImpl implements PurchaseMapper {

    @Override
    public PurchaseDTO toPurchaseDTO(Purchase purchase) {
        if ( purchase == null ) {
            return null;
        }

        PurchaseDTO purchaseDTO = new PurchaseDTO();

        purchaseDTO.setId( purchase.getId() );
        purchaseDTO.setTotal( purchase.getTotal() );
        purchaseDTO.setCreatedAt( purchase.getCreatedAt() );
        purchaseDTO.setPaymentStatus( purchase.getPaymentStatus() );
        purchaseDTO.setItems( purchaseItemListToPurchaseItemDTOList( purchase.getItems() ) );

        return purchaseDTO;
    }

    @Override
    public Purchase toPurchaseEntity(PurchaseCreateUpdateDTO purchaseDTO) {
        if ( purchaseDTO == null ) {
            return null;
        }

        Purchase purchase = new Purchase();

        purchase.setTotal( purchaseDTO.getTotal() );
        purchase.setItems( purchaseItemCreateUpdateDTOListToPurchaseItemList( purchaseDTO.getItems() ) );

        return purchase;
    }

    protected PurchaseItemDTO purchaseItemToPurchaseItemDTO(PurchaseItem purchaseItem) {
        if ( purchaseItem == null ) {
            return null;
        }

        PurchaseItemDTO purchaseItemDTO = new PurchaseItemDTO();

        purchaseItemDTO.setId( purchaseItem.getId() );
        purchaseItemDTO.setPrice( purchaseItem.getPrice() );
        purchaseItemDTO.setQuantity( purchaseItem.getQuantity() );

        return purchaseItemDTO;
    }

    protected List<PurchaseItemDTO> purchaseItemListToPurchaseItemDTOList(List<PurchaseItem> list) {
        if ( list == null ) {
            return null;
        }

        List<PurchaseItemDTO> list1 = new ArrayList<PurchaseItemDTO>( list.size() );
        for ( PurchaseItem purchaseItem : list ) {
            list1.add( purchaseItemToPurchaseItemDTO( purchaseItem ) );
        }

        return list1;
    }

    protected PurchaseItem purchaseItemCreateUpdateDTOToPurchaseItem(PurchaseItemCreateUpdateDTO purchaseItemCreateUpdateDTO) {
        if ( purchaseItemCreateUpdateDTO == null ) {
            return null;
        }

        PurchaseItem purchaseItem = new PurchaseItem();

        purchaseItem.setPrice( purchaseItemCreateUpdateDTO.getPrice() );
        purchaseItem.setQuantity( purchaseItemCreateUpdateDTO.getQuantity() );

        return purchaseItem;
    }

    protected List<PurchaseItem> purchaseItemCreateUpdateDTOListToPurchaseItemList(List<PurchaseItemCreateUpdateDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<PurchaseItem> list1 = new ArrayList<PurchaseItem>( list.size() );
        for ( PurchaseItemCreateUpdateDTO purchaseItemCreateUpdateDTO : list ) {
            list1.add( purchaseItemCreateUpdateDTOToPurchaseItem( purchaseItemCreateUpdateDTO ) );
        }

        return list1;
    }
}
