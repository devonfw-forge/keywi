package com.devonfw.module.criteria.common.api.query;

/**
 * {@link SearchCriteria} for {@link Integer}.
 *
 * @since 1.0.0
 */
public class IntegerSearchCriteria extends NumberSearchCriteria<Integer> {

  /**
   * The constructor.
   *
   * @param operator the {@link #getOperator() operator}.
   * @param literal the {@link #getLiteral() literal}.
   */
  public IntegerSearchCriteria(SearchOperator<? super Integer> operator, Integer literal) {

    super(operator, literal);
  }

  /**
   * The constructor.
   *
   * @param operator the {@link #getOperator() operator}.
   * @param literal1 the first {@link #getLiteral() literal}.
   * @param literal2 the {@link #getLiteral2() second literal}.
   */
  public IntegerSearchCriteria(SearchOperator<? super Number> operator, Integer literal1, Integer literal2) {

    super(operator, literal1, literal2);
  }

  /**
   * @param value the literal value to compare with.
   * @return {@link IntegerSearchCriteria} using {@link SearchOperator#EQ}.
   */
  public static IntegerSearchCriteria eq(Integer value) {

    return new IntegerSearchCriteria(SearchOperator.EQ, value);
  }

  /**
   * @param value the literal value to compare with.
   * @return {@link IntegerSearchCriteria} using {@link SearchOperator#NEQ}.
   */
  public static IntegerSearchCriteria neq(Integer value) {

    return new IntegerSearchCriteria(SearchOperator.NEQ, value);
  }

  /**
   * @param value the literal value to compare with.
   * @return {@link IntegerSearchCriteria} using {@link ComparableSearchOperator#GT}.
   */
  public static IntegerSearchCriteria gt(int value) {

    return new IntegerSearchCriteria(ComparableSearchOperator.GT, value);
  }

  /**
   * @param value the literal value to compare with.
   * @return {@link IntegerSearchCriteria} using {@link ComparableSearchOperator#GE}.
   */
  public static IntegerSearchCriteria ge(int value) {

    return new IntegerSearchCriteria(ComparableSearchOperator.GE, value);
  }

  /**
   * @param value the literal value to compare with.
   * @return {@link IntegerSearchCriteria} using {@link ComparableSearchOperator#LT}.
   */
  public static IntegerSearchCriteria lt(int value) {

    return new IntegerSearchCriteria(ComparableSearchOperator.LT, value);
  }

  /**
   * @param value the literal value to compare with.
   * @return {@link IntegerSearchCriteria} using {@link ComparableSearchOperator#LE}.
   */
  public static IntegerSearchCriteria le(int value) {

    return new IntegerSearchCriteria(ComparableSearchOperator.LE, value);
  }

  /**
   * @param min the minimum value.
   * @param max the maximum value.
   * @return {@link IntegerSearchCriteria} using {@link NumberSearchOperator#BETWEEN}.
   */
  public static IntegerSearchCriteria between(int min, int max) {

    return new IntegerSearchCriteria(NumberSearchOperator.BETWEEN, min, max);
  }

}
