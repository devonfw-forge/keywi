package com.devonfw.module.criteria.common.api.query;

import java.util.Objects;

/**
 * Abstract base implementation of {@link SearchCriteria}.
 *
 * @param <T> type of property / value to search.
 * @since 1.0.0
 */
public class AbstractSearchCriteria<T> implements SearchCriteria<T> {

  private final SearchOperator<? super T> operator;

  /**
   * The constructor.
   *
   * @param operator the {@link #getOperator() operator}.
   */
  public AbstractSearchCriteria(SearchOperator<? super T> operator) {

    super();
    Objects.requireNonNull(operator, "operator");
    this.operator = operator;
  }

  @Override
  public SearchOperator<? super T> getOperator() {

    return this.operator;
  }

  @Override
  public String toString() {

    return this.operator.toString();
  }

}
