package com.devonfw.module.criteria.common.api.query;

/**
 * Abstract base implementation of {@link LiteralSearchCriteria}.
 *
 * @param <T> type of property / value to search.
 * @since 1.0.0
 */
public abstract class AbstractLiteralSearchCriteria<T> extends AbstractSearchCriteria<T>
    implements LiteralSearchCriteria<T> {

  /**
   * The constructor.
   *
   * @param operator the {@link #getOperator() operator}.
   */
  public AbstractLiteralSearchCriteria(SearchOperator<? super T> operator) {

    super(operator);
  }

  @Override
  public String toString() {

    return super.toString() + " " + getLiteral();
  }

}
