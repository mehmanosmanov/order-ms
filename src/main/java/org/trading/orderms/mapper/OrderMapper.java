package org.trading.orderms.mapper;

import org.mapstruct.Mapper;
import org.trading.orderms.dto.request.OrderRequest;
import org.trading.orderms.dto.response.OrderResponse;
import org.trading.orderms.entity.Order;

/**
 * @author Mehman on 18-07-2023
 * @project product-ms
 */
@Mapper(componentModel = "spring")
public interface OrderMapper {

   Order dtoToEntity(OrderRequest request);

   OrderResponse entityToDto(Order order);

}
