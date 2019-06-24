package com.devonfw.module.criteria.common.api.query;

import java.util.HashMap;
import java.util.Map;

/**
 * Operator to match values (search property, literal).
 *
 * @param <T> type of property / value to search.
 * @since 1.0.0
 */
public class SearchOperator<T> {

  private static final Map<String, SearchOperator<?>> SYNTAX2OPERATOR_MAP = new HashMap<>();

  /** {@link SearchOperator} matching if to objects are {@link #equals(Object) equal}. */
  public static final SearchOperator<Object> EQ = new SearchOperator<>("==");

  /** {@link SearchOperator} matching if to objects are not {@link #equals(Object) equal}. */
  public static final SearchOperator<Object> NEQ = new SearchOperator<>("<>");

  private final String syntax;

  private final boolean inverse;

  static {
    Class<?> loadClass = ComparableSearchOperator.class;
    if (loadClass != null) {
      loadClass = StringSearchOperator.class;
      assert (loadClass != null);
    }
  }

  SearchOperator(String operator) {

    this(operator, false);
  }

  SearchOperator(String operator, boolean inverse) {

    super();
    this.syntax = operator;
    this.inverse = inverse;
    SearchOperator<?> duplicate = SYNTAX2OPERATOR_MAP.put(toString(), this);
    assert (duplicate == null);
  }

  /**
   * @return the syntax of this operator (e.g. in SQL or JPQL).
   */
  public String getSyntax() {

    return this.syntax;
  }

  /**
   * @return {@code true} for inverse usage where literal value is first argument and matching property is second
   *         argument, {@code false} otherwise (normal match).
   */
  public boolean isInverse() {

    return this.inverse;
  }

  @Override
  public String toString() {

    if (this.inverse) {
      return "~" + this.syntax;
    } else {
      return this.syntax;
    }
  }

  /**
   * @param id the {@link #toString() string representation}.
   * @return the {@link SearchOperator} for the given {@code id} or {@code null} if not defined.
   */
  public static SearchOperator<?> get(String id) {

    return SYNTAX2OPERATOR_MAP.get(id);
  }

}
