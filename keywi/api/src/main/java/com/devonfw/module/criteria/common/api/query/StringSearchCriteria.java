package com.devonfw.module.criteria.common.api.query;

/**
 * {@link SearchCriteria} for {@link String}.
 *
 * @since 1.0.0
 */
public class StringSearchCriteria extends AbstractLiteralSearchCriteria<String> {

  private final String literal;

  /**
   * The constructor.
   *
   * @param operator the {@link #getOperator() operator}.
   * @param literal the {@link #getLiteral() literal}.
   */
  public StringSearchCriteria(SearchOperator<? super String> operator, String literal) {

    super(operator);
    this.literal = literal;
  }

  @Override
  public String getLiteral() {

    return this.literal;
  }

  /**
   * @param value the literal value to compare with.
   * @return {@link StringSearchCriteria} using {@link SearchOperator#EQ}.
   */
  public static StringSearchCriteria eq(String value) {

    return new StringSearchCriteria(SearchOperator.EQ, value);
  }

  /**
   * @param value the literal value to compare with.
   * @return {@link StringSearchCriteria} using {@link SearchOperator#NEQ}.
   */
  public static StringSearchCriteria neq(String value) {

    return new StringSearchCriteria(SearchOperator.NEQ, value);
  }

  /**
   * @param value the literal value to compare with.
   * @return {@link StringSearchCriteria} using {@link ComparableSearchOperator#GT}.
   */
  public static StringSearchCriteria gt(String value) {

    return new StringSearchCriteria(ComparableSearchOperator.GT, value);
  }

  /**
   * @param value the literal value to compare with.
   * @return {@link StringSearchCriteria} using {@link ComparableSearchOperator#GE}.
   */
  public static StringSearchCriteria ge(String value) {

    return new StringSearchCriteria(ComparableSearchOperator.GE, value);
  }

  /**
   * @param value the literal value to compare with.
   * @return {@link StringSearchCriteria} using {@link ComparableSearchOperator#LT}.
   */
  public static StringSearchCriteria lt(String value) {

    return new StringSearchCriteria(ComparableSearchOperator.LT, value);
  }

  /**
   * @param value the literal value to compare with.
   * @return {@link StringSearchCriteria} using {@link ComparableSearchOperator#LE}.
   */
  public static StringSearchCriteria le(String value) {

    return new StringSearchCriteria(ComparableSearchOperator.LE, value);
  }

  /**
   * @param value the literal value to compare with.
   * @return {@link StringSearchCriteria} using {@link StringSearchOperator#LIKE}.
   */
  public static StringSearchCriteria like(String value) {

    return new StringSearchCriteria(StringSearchOperator.LIKE, value);
  }

  /**
   * @param value the literal value to compare with.
   * @return {@link StringSearchCriteria} using {@link StringSearchOperator#NOT_LIKE}.
   */
  public static StringSearchCriteria notLike(String value) {

    return new StringSearchCriteria(StringSearchOperator.NOT_LIKE, value);
  }

}
