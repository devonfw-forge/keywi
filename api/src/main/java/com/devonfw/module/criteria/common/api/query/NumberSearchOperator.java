package com.devonfw.module.criteria.common.api.query;

/**
 * {@link SearchOperator} for {@link Number}.
 *
 * @param <T> type of property / value to search.
 * @since 1.0.0
 */
public class NumberSearchOperator<T extends Number> extends SearchOperator<T> {

  /**
   * {@link SearchOperator} matching if search hit is less than search value .
   */
  public static final NumberSearchOperator<Number> BETWEEN = new NumberSearchOperator<>("BETWEEN");

  NumberSearchOperator(String operator) {

    super(operator);
  }

  NumberSearchOperator(String operator, boolean inverse) {

    super(operator, inverse);
  }

}
