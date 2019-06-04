package com.devonfw.keywi.keymanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devonfw.keywi.keymanagement.common.api.KeyList;
import com.devonfw.keywi.keymanagement.dataaccess.api.KeyItemEntity;
import com.devonfw.keywi.keymanagement.dataaccess.api.datatype.KeyItemProperty;
import com.devonfw.keywi.keymanagement.logic.api.to.KeyItemSearchCriteriaTo;
import com.devonfw.module.basic.common.api.reference.IdRef;
import com.devonfw.module.criteria.common.api.query.StringSearchCriteria;
import com.devonfw.module.criteria.dataaccess.base.query.SearchCriteriaMapper;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * {@link DefaultRepository} for {@link KeyItemEntity}
 */
public interface KeyItemRepository extends DefaultRepository<KeyItemEntity> {

  /**
   * @param id the {@link KeyItemEntity#getKeyListId() key-list ID}.
   * @return the {@link List} of {@link KeyItemEntity}-objects for the given {@code id}.
   */
  @Query("SELECT items FROM KeyItemEntity items" //
      + " WHERE items.keyList.id = :id")
  List<KeyItemEntity> findAllForList(@Param("id") Long id);

  /**
   * @param key the {@link KeyList#getKey() key} of the {@link KeyList}.
   * @return the {@link List} of {@link KeyItemEntity}-objects {@link KeyItemEntity#getKeyList() associated} with the
   *         {@link KeyList} of the given {@code key}.
   */
  @Query("SELECT items FROM KeyItemEntity items" //
      + " WHERE items.keyList.key = :key")
  List<KeyItemEntity> findAllForListByKey(@Param("key") String key);

  /**
   * @param criteria the {@link KeyItemSearchCriteriaTo} to search.
   * @return the {@link Page} with the matching {@link KeyItemEntity} hits.
   */
  default Page<KeyItemEntity> find(KeyItemSearchCriteriaTo criteria) {

    KeyItemEntity alias = newDslAlias();
    JPAQuery<KeyItemEntity> query = newDslQuery(alias);

    IdRef<KeyList> keyListId = criteria.getKeyListId();
    query.where($(alias.getKeyList().getId()).eq(keyListId.getId()));

    StringSearchCriteria name = criteria.getName();
    if (name != null) {
      StringPath namePath = $(alias.getName());
      SearchCriteriaMapper.apply(namePath, name, query);
    }

    KeyItemProperty ordering = criteria.getOrdering();
    applyOrdering(alias, query, ordering);

    return QueryUtil.get().findPaginated(criteria.getPageable(), query, false);
  }

  default void applyOrdering(KeyItemEntity alias, JPAQuery<KeyItemEntity> query, KeyItemProperty ordering) {

    Expression<? extends Comparable<?>> orderProperty = null;
    switch (ordering) {
    case NAME:
      orderProperty = $(alias.getName());
      break;
    case KEY:
      orderProperty = $(alias.getKey());
      break;
    case VALUE:
      orderProperty = $(alias.getValue());
      break;
    case COMMENT:
      orderProperty = $(alias.getComment());
      break;
    }
    query.orderBy(new OrderSpecifier<>(Order.ASC, orderProperty));
  }

}