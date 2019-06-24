package com.devonfw.keywi.keymanagement.service.api.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.data.domain.Page;

import com.devonfw.keywi.keymanagement.common.api.KeyItem;
import com.devonfw.keywi.keymanagement.common.api.KeyList;
import com.devonfw.keywi.keymanagement.logic.api.to.KeyItemEto;
import com.devonfw.keywi.keymanagement.logic.api.to.KeyItemSearchCriteriaTo;
import com.devonfw.keywi.keymanagement.logic.api.to.KeyListEto;
import com.devonfw.module.rest.common.api.RestService;

/**
 * The service interface for REST calls in order to execute the logic of component Keymanagement.
 */
@Path("/keymanagement/v1")
public interface KeymanagementRestService extends RestService {

  /**
   * @return the {@link List} of all {@link KeyListEto}.
   */
  @GET
  @Path("/keylists")
  List<KeyListEto> findKeyListEtos();

  /**
   * @param id the {@link KeyListEto#getId() ID} of the {@link KeyListEto}.
   * @return the requested {@link KeyListEto}.
   */
  @GET
  @Path("/keylist/{id}/")
  KeyListEto findKeyList(@PathParam("id") long id);

  /**
   * @param key the {@link KeyListEto#getKey() business key} of the {@link KeyListEto}.
   * @return the requested {@link KeyListEto}.
   */
  @GET
  @Path("/keylist-by-key/{key}/")
  KeyListEto findKeyListByKey(@PathParam("key") String key);

  /**
   * @param keylist the {@link KeyListEto} to be saved
   * @return the recently created {@link KeyListEto}
   */
  @POST
  @Path("/keylist/")
  KeyListEto saveKeyList(KeyListEto keylist);

  /**
   * @param id ID of the {@link KeyListEto} to be deleted
   */
  @DELETE
  @Path("/keyitem/{id}/")
  void deleteKeyList(@PathParam("id") long id);

  /**
   * <b>ATTENTION:</b><br>
   * Calling this method may be very expensive. Only use it for {@link KeyList#isCacheable() cachable} {@link KeyList}s.
   * Whenever possible prefer using {@link #findKeyItemEtos(KeyItemSearchCriteriaTo)} instead.
   *
   * @param id the ID of the {@link KeyListEto key-list} {@link KeyItemEto#getKeyListId() owning} {@link KeyList}.
   * @return the {@link List} with ALL {@link KeyItemEto}s owned by the specified {@link KeyList}.
   */
  @GET
  @Path("/keyitem-for-list/{id}/")
  List<KeyItemEto> findKeyItemEtosForList(@PathParam("id") long id);

  /**
   * <b>ATTENTION:</b><br>
   * Calling this method may be very expensive. Only use it for {@link KeyList#isCacheable() cachable} {@link KeyList}s.
   * Whenever possible prefer using {@link #findKeyItemEtos(KeyItemSearchCriteriaTo)} instead.
   *
   * @param key the {@link KeyList#getKey() key} of the {@link KeyItem#getKeyListId() owning} {@link KeyList}.
   * @return the {@link List} of ALL {@link KeyItemEto}s owned by the specified {@link KeyList}.
   */
  @GET
  @Path("/keyitem-for-list-by-key/{key}/")
  List<KeyItemEto> findKeyItemEtosForListByKey(@PathParam("key") String key);

  /**
   * @param criteria the {@link KeyItemSearchCriteriaTo} specifying the search query.
   * @return the {@link Page} with the matching {@link KeyItemEto}s.
   */
  @POST
  @Path("/keyitem/search/")
  Page<KeyItemEto> findKeyItemEtos(KeyItemSearchCriteriaTo criteria);

  /**
   * @param id the ID of the {@link KeyItemEto}
   * @return the {@link KeyItemEto}
   */
  @GET
  @Path("/keyitem/{id}/")
  KeyItemEto findKeyItem(@PathParam("id") long id);

  /**
   * @param keyitem the {@link KeyItemEto} to be saved
   * @return the recently created {@link KeyItemEto}
   */
  @POST
  @Path("/keyitem/")
  KeyItemEto saveKeyItem(KeyItemEto keyitem);

  /**
   * @param id ID of the {@link KeyItemEto} to be deleted
   */
  @DELETE
  @Path("/keyitem/{id}/")
  void deleteKeyItem(@PathParam("id") long id);

}
