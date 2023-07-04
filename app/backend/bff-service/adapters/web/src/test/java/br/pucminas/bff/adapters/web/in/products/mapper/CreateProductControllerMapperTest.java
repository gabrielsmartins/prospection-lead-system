package br.pucminas.bff.adapters.web.in.products.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static br.pucminas.bff.adapters.web.in.support.ProductDtoSupport.defaultCreateProductDto;
import static br.pucminas.bff.application.support.ProductSupport.defaultProduct;
import static org.assertj.core.api.Assertions.assertThat;

class CreateProductControllerMapperTest {

    @Test
    @DisplayName("Given Product When Map Then Return Product Dto")
    public void givenProductWhenMapThenReturnProductDto() {

        var product = defaultProduct().build();

        var productDto = CreateProductControllerMapper.mapToDto(product);

        assertThat(productDto).isNotNull();
        assertThat(productDto).hasNoNullFieldsOrPropertiesExcept("updatedAt", "deletedAt");
        assertThat(productDto.getId()).isEqualTo(product.getId());
        assertThat(productDto.getName()).isEqualTo(product.getName());
        assertThat(productDto.getCategory().getDescription()).isEqualTo(product.getCategory());
    }

    @Test
    @DisplayName("Given Product Dto When Map Then Return Product")
    public void givenProductDtoWhenMapThenReturnProduct() {

        var productDto = defaultCreateProductDto().build();

        var product = CreateProductControllerMapper.mapToDomain(productDto);

        assertThat(product).isNotNull();
        assertThat(product).hasNoNullFieldsOrPropertiesExcept("createdAt", "updatedAt", "deletedAt");
        assertThat(product.getName()).isEqualTo(productDto.getName());
        assertThat(product.getCategory()).isEqualTo(productDto.getCategory().getDescription());
    }

}