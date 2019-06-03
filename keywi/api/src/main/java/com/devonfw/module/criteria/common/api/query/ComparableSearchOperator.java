package com.devonfw.module.criteria.common.api.query;

/**
 * {@link SearchOperator} for {@link Comparable}.
 *
 * @param <T> type of property / value to search.
 * @since 1.0.0
 */
@SuppressWarnings("rawtypes")
public class ComparableSearchOperator<T extends Comparable> extends SearchOperator<T> {

  /**
   * {@link SearchOperator} matching if search hit is less than search value .
   */
  public static final ComparableSearchOperator<Comparable> LT = new ComparableSearchOperator<>("<");

  /**
   * Matches if search value is less or equal to search hit(s) in {@link String#compareTo(String) lexicographical
   * order}.
   */
  public static final ComparableSearchOperator<Comparable> LE = new ComparableSearchOperator<>("<=");

  /**
   * Matches if search value is greater than search hit(s) in {@link String#compareTo(String) lexicographical order}.
   */
  public static final ComparableSearchOperator<Comparable> GT = new ComparableSearchOperator<>(">");

  /**
   * Matches if search value is greater or equal to search hit(s) in {@link String#compareTo(String) lexicographical
   * order}.
   */
  public static final ComparableSearchOperator<Comparable> GE = new ComparableSearchOperator<>(">=");

  ComparableSearchOperator(String operator) {

    super(operator);
  }

  ComparableSearchOperator(String operator, boolean inverse) {

    super(operator, inverse);
  }

}
