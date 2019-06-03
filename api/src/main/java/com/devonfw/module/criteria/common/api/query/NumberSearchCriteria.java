package com.devonfw.module.criteria.common.api.query;

/**
 * {@link SearchCriteria} for {@link Number}.
 *
 * @param <T> type of property / value to search.
 * @since 1.0.0
 */
public abstract class NumberSearchCriteria<T extends Number> extends AbstractLiteralSearchCriteria<T> {

  private final T literal1;

  private final T literal2;

  /**
   * The constructor.
   *
   * @param operator the {@link #getOperator() operator}.
   * @param literal the {@link #getLiteral() literal}.
   */
  public NumberSearchCriteria(SearchOperator<? super T> operator, T literal) {

    super(operator);
    this.literal1 = literal;
    this.literal2 = null;
  }

  /**
   * The constructor.
   *
   * @param operator the {@link #getOperator() operator}.
   * @param literal1 the first {@link #getLiteral() literal}.
   * @param literal2 the {@link #getLiteral2() second literal}.
   */
  public NumberSearchCriteria(SearchOperator<? super T> operator, T literal1, T literal2) {

    super(operator);
    this.literal1 = literal1;
    this.literal2 = literal2;
  }

  @Override
  public T getLiteral() {

    return this.literal1;
  }

  /**
   * @return the optional second literal (e.g. for BETWEEN min AND max).
   */
  public T getLiteral2() {

    return this.literal2;
  }

}
