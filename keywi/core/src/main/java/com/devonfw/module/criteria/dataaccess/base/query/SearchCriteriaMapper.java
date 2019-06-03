package com.devonfw.module.criteria.dataaccess.base.query;

import java.util.HashMap;
import java.util.Map;

import com.devonfw.module.criteria.common.api.query.ComparableSearchOperator;
import com.devonfw.module.criteria.common.api.query.LiteralSearchCriteria;
import com.devonfw.module.criteria.common.api.query.NumberSearchCriteria;
import com.devonfw.module.criteria.common.api.query.NumberSearchOperator;
import com.devonfw.module.criteria.common.api.query.SearchOperator;
import com.devonfw.module.criteria.common.api.query.StringSearchOperator;
import com.querydsl.core.types.Constant;
import com.querydsl.core.types.ConstantImpl;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Operator;
import com.querydsl.core.types.Ops;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * TODO hohwille This type ...
 *
 * @since 1.0.0
 */
public class SearchCriteriaMapper {

  private static final Map<String, Operator> OPERATOR_MAP = createOperatorMap();

  /**
   * @return
   */
  private static Map<String, Operator> createOperatorMap() {

    Map<String, Operator> map = new HashMap<>();
    map.put(SearchOperator.EQ.getSyntax(), Ops.EQ);
    map.put(SearchOperator.NEQ.getSyntax(), Ops.NE);
    map.put(ComparableSearchOperator.GE.getSyntax(), Ops.GOE);
    map.put(ComparableSearchOperator.GT.getSyntax(), Ops.GT);
    map.put(ComparableSearchOperator.LE.getSyntax(), Ops.LOE);
    map.put(ComparableSearchOperator.LT.getSyntax(), Ops.LT);
    map.put(StringSearchOperator.LIKE.getSyntax(), Ops.LIKE);
    map.put(NumberSearchOperator.BETWEEN.getSyntax(), Ops.BETWEEN);
    return map;
  }

  public static <T> Predicate map(Expression<T> expression, LiteralSearchCriteria<T> criteria) {

    SearchOperator<? super T> searchOperator = criteria.getOperator();
    Operator operator = map(searchOperator);
    Constant<T> literal = ConstantImpl.create(criteria.getLiteral());
    if (operator == Ops.BETWEEN) {
      Number max = ((NumberSearchCriteria<?>) criteria).getLiteral2();
      Constant<Number> literal2 = ConstantImpl.create(max);
      return Expressions.booleanOperation(operator, expression, literal, literal2);
    } else {
      if (searchOperator.isInverse()) {
        return Expressions.booleanOperation(operator, literal, expression);
      } else {
        return Expressions.booleanOperation(operator, expression, literal);
      }
    }
  }

  /**
   * @param operator
   * @return
   */
  public static Operator map(SearchOperator<?> operator) {

    return OPERATOR_MAP.get(operator.getSyntax());
  }

  public static <T> void apply(Expression<T> expression, LiteralSearchCriteria<T> criteria, JPAQuery<?> query) {

    query.where(map(expression, criteria));
  }

}
