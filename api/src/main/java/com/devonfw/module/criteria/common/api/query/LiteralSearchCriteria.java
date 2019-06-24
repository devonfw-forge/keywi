package com.devonfw.module.criteria.common.api.query;

/**
 * Interface for {@link SearchCriteria} comparing with a {@link #getLiteral() literal value}.
 *
 * @param <T> type of property / value to search.
 * @since 1.0.0
 */
public interface LiteralSearchCriteria<T> extends SearchCriteria<T> {

  /** Name of the property {@link #getLiteral() literal}. */
  String PROPERTY_LITERAL = "literal";

  /**
   * @return the literal value to {@link #getOperator() compare with}.
   */
  T getLiteral();

}
