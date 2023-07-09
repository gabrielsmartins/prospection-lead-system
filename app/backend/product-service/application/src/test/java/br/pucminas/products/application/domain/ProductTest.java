package br.pucminas.products.application.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class ProductTest {

    @Test
    @DisplayName("Given Coverage When Add Then Return Coverages Size")
    public void givenCoverageWhenAddThenReturnCoveragesSize() {
        var product = new Product();

        product.addCoverage("Foo", BigDecimal.TEN);
        var coveragesSize = product.addCoverage("Bar", BigDecimal.TEN);

        assertThat(coveragesSize).isEqualTo(2);
        assertThat(product.getTotalCoverageAmount()).isEqualByComparingTo(BigDecimal.valueOf(20));
    }

    @Test
    @DisplayName("Given Coverage When Remove Then Return Coverages Size")
    public void givenCoverageWhenRemoveThenReturnCoveragesSize() {
        var product = new Product();

        product.addCoverage("Foo", BigDecimal.TEN);
        product.addCoverage("Bar", BigDecimal.TEN);

        var coveragesSize = product.removeCoverage("Foo");

        assertThat(coveragesSize).isEqualTo(1);
        assertThat(product.getTotalCoverageAmount()).isEqualByComparingTo(BigDecimal.TEN);
    }

    @Test
    @DisplayName("Given Assistance When Add Then Return Assistances Size")
    public void givenAssistanceWhenAddThenReturnAssistancesSize() {
        var product = new Product();

        var assistancesSize = product.addAssistance("Bar");

        assertThat(assistancesSize).isEqualTo(1);
    }

    @Test
    @DisplayName("Given Assistance When Remove Then Return Assistances Size")
    public void givenAssistanceWhenRemoveThenReturnAssistancesSize() {
        var product = new Product();

        product.addAssistance("Foo");
        var assistancesSize = product.removeAssistance("Foo");

        assertThat(assistancesSize).isZero();
    }

}