package com.devonfw.module.criteria.common.api.query;

/**
 * {@link SearchCriteria} for {@link Long}.
 *
 * @since 1.0.0
 */
public class LongSearchCriteria extends NumberSearchCriteria<Long> {

  /**
   * The constructor.
   *
   * @param operator the {@link #getOperator() operator}.
   * @param literal the {@link #getLiteral() literal}.
   */
  public LongSearchCriteria(SearchOperator<? super Long> operator, Long literal) {

    super(operator, literal);
  }

  /**
   * The constructor.
   *
   * @param operator the {@link #getOperator() operator}.
   * @param literal1 the first {@link #getLiteral() literal}.
   * @param literal2 the {@link #getLiteral2() second literal}.
   */
  public LongSearchCriteria(SearchOperator<? super Long> operator, Long literal1, Long literal2) {

    super(operator, literal1, literal2);
  }

  /**
   * @param value the literal value to compare with.
   * @return {@link LongSearchCriteria} using {@link SearchOperator#EQ}.
   */
  public static LongSearchCriteria eq(Long value) {

    return new LongSearchCriteria(SearchOperator.EQ, value);
  }

  /**
   * @param value the literal value to compare with.
   * @return {@link LongSearchCriteria} using {@link SearchOperator#NEQ}.
   */
  public static LongSearchCriteria neq(Long value) {

    return new LongSearchCriteria(SearchOperator.NEQ, value);
  }

  /**
   * @param value the literal value to compare with.
   * @return {@link LongSearchCriteria} using {@link ComparableSearchOperator#GT}.
   */
  public static LongSearchCriteria gt(long value) {

    return new LongSearchCriteria(ComparableSearchOperator.GT, value);
  }

  /**
   * @param value the literal value to compare with.
   * @return {@link LongSearchCriteria} using {@link ComparableSearchOperator#GE}.
   */
  public static LongSearchCriteria ge(long value) {

    return new LongSearchCriteria(ComparableSearchOperator.GE, value);
  }

  /**
   * @param value the literal value to compare with.
   * @return {@link LongSearchCriteria} using {@link ComparableSearchOperator#LT}.
   */
  public static LongSearchCriteria lt(long value) {

    return new LongSearchCriteria(ComparableSearchOperator.LT, value);
  }

  /**
   * @param value the literal value to compare with.
   * @return {@link LongSearchCriteria} using {@link ComparableSearchOperator#LE}.
   */
  public static LongSearchCriteria le(long value) {

    return new LongSearchCriteria(ComparableSearchOperator.LE, value);
  }

  /**
   * @param min the minimum value.
   * @param max the maximum value.
   * @return {@link LongSearchCriteria} using {@link NumberSearchOperator#BETWEEN}.
   */
  public static LongSearchCriteria between(long min, long max) {

    return new LongSearchCriteria(NumberSearchOperator.BETWEEN, min, max);
  }

}
