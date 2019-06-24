package com.devonfw.module.criteria.common.api.query;

/**
 * Interface for search criteria.
 *
 * @param <T> type of property / value to search.
 * @since 1.0.0
 */
public interface SearchCriteria<T> {

  /** Name of the property {@link #getOperator() operator}. */
  String PROPERTY_OPERATOR = "operator";

  /**
   * @return the {@link SearchOperator}. May not be {@code null}.
   */
  SearchOperator<? super T> getOperator();

}
