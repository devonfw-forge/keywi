package com.devonfw.module.criteria.common.api.query;

/**
 * {@link SearchOperator} for {@link String}.
 *
 * @since 1.0.0
 */
public class StringSearchOperator extends ComparableSearchOperator<String> {

  /** {@link SearchOperator} matching if property matches pattern. */
  public static final StringSearchOperator LIKE = new StringSearchOperator("LIKE");

  /** {@link SearchOperator} matching if property does not match pattern. */
  public static final StringSearchOperator NOT_LIKE = new StringSearchOperator("NOT LIKE");

  /** {@link SearchOperator} matching if literal value match property pattern. */
  public static final StringSearchOperator INVERSE_LIKE = new StringSearchOperator("LIKE", true);

  /** {@link SearchOperator} matching if literal value does not match property pattern. */
  public static final StringSearchOperator NOT_INVERSE_LIKE = new StringSearchOperator("NOT LIKE", true);

  StringSearchOperator(String operator) {

    super(operator);
  }

  StringSearchOperator(String operator, boolean inverse) {

    super(operator, inverse);
  }

}
