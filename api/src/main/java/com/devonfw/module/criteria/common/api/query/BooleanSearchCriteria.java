package com.devonfw.module.criteria.common.api.query;

/**
 * {@link SearchCriteria} for {@link Boolean}.
 *
 * @since 1.0.0
 */
public class BooleanSearchCriteria extends AbstractLiteralSearchCriteria<Boolean> {

  private final Boolean literal;

  /**
   * The constructor.
   *
   * @param operator the {@link #getOperator() operator}.
   * @param literal the {@link #getLiteral() literal}.
   */
  public BooleanSearchCriteria(SearchOperator<? super Boolean> operator, Boolean literal) {

    super(operator);
    this.literal = literal;
  }

  @Override
  public Boolean getLiteral() {

    return this.literal;
  }

  /**
   * @param value the literal value to compare with.
   * @return {@link BooleanSearchCriteria} using {@link SearchOperator#EQ}.
   */
  public static BooleanSearchCriteria eq(Boolean value) {

    return new BooleanSearchCriteria(SearchOperator.EQ, value);
  }

  /**
   * @param value the literal value to compare with.
   * @return {@link BooleanSearchCriteria} using {@link SearchOperator#NEQ}.
   */
  public static BooleanSearchCriteria neq(Boolean value) {

    return new BooleanSearchCriteria(SearchOperator.NEQ, value);
  }

}
