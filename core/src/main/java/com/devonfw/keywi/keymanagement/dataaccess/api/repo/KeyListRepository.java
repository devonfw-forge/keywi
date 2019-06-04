package com.devonfw.keywi.keymanagement.dataaccess.api.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devonfw.keywi.keymanagement.dataaccess.api.KeyListEntity;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;

/**
 * {@link DefaultRepository} for {@link KeyListEntity}
 */
public interface KeyListRepository extends DefaultRepository<KeyListEntity> {

  /**
   * @param key the {@link KeyListEntity#getKey() key} of the requested {@link KeyListEntity}.
   * @return the {@link KeyListEntity} with the given {@code key} or {@code null} if not found.
   */
  @Query("SELECT list FROM KeyListEntity list" //
      + " WHERE list.key = key")
  KeyListEntity findByKey(@Param("key") String key);

}