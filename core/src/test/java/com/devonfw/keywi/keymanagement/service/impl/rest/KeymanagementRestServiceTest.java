package com.devonfw.keywi.keymanagement.service.impl.rest;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import com.devonfw.keywi.general.service.base.test.RestServiceTest;
import com.devonfw.keywi.keymanagement.dataaccess.api.datatype.KeyItemProperty;
import com.devonfw.keywi.keymanagement.logic.api.to.KeyItemEto;
import com.devonfw.keywi.keymanagement.logic.api.to.KeyItemSearchCriteriaTo;
import com.devonfw.keywi.keymanagement.logic.api.to.KeyListEto;
import com.devonfw.keywi.keymanagement.service.api.rest.KeymanagementRestService;
import com.devonfw.module.basic.common.api.reference.IdRef;
import com.devonfw.module.criteria.common.api.query.StringSearchCriteria;
import com.devonfw.module.service.common.api.client.config.ServiceClientConfigBuilder;

/**
 * Test of {@link KeymanagementRestService} and {@link KeymanagementRestServiceImpl}.
 */
@RunWith(SpringRunner.class)
public class KeymanagementRestServiceTest extends RestServiceTest {

  /**
   * Test of {@link KeymanagementRestService#findKeyList(long)}.
   */
  @Test
  public void testFindKeyList() {

    KeymanagementRestService keymanagementService =
        getServiceClientFactory().create(KeymanagementRestService.class, createServiceConfig());
    KeyListEto keyList = keymanagementService.findKeyList(1L);
    verifyCountry(keyList);
  }

  private void verifyCountry(KeyListEto keyList) {

    assertThat(keyList.getId()).isEqualTo(1L);
    assertThat(keyList.getKey()).isEqualTo("country");
    assertThat(keyList.getName()).isEqualTo("Country");
    assertThat(keyList.getComment()).isEqualTo("Countries of the world");
    assertThat(keyList.getOrdering()).isEqualTo(KeyItemProperty.NAME);
    assertThat(keyList.isValueRequired()).isTrue();
    assertThat(keyList.getValuePattern().pattern()).isEqualTo("[A-Z]{3}");
    assertThat(keyList.isCacheable()).isTrue();
    assertThat(keyList.isDisabled()).isFalse();
  }

  /**
   * Test of {@link KeymanagementRestService#findKeyListByKey(String)}.
   */
  @Test
  public void testFindKeyListByKey() {

    KeymanagementRestService keymanagementService =
        getServiceClientFactory().create(KeymanagementRestService.class, createServiceConfig());
    KeyListEto keyList = keymanagementService.findKeyListByKey("country");
    verifyCountry(keyList);
  }

  /**
   * Test of
   * {@link KeymanagementRestService#findKeyItemEtos(com.devonfw.keywi.keymanagement.logic.api.to.KeyItemSearchCriteriaTo)}.
   */
  @Test
  public void testFindKeyItemEtos() {

    KeymanagementRestService keymanagementService =
        getServiceClientFactory().create(KeymanagementRestService.class, createServiceConfig());
    KeyItemSearchCriteriaTo criteria = new KeyItemSearchCriteriaTo();
    criteria.setKeyListId(IdRef.of(1L));
    criteria.setName(StringSearchCriteria.eq("Germany"));
    Page<KeyItemEto> page = keymanagementService.findKeyItemEtos(criteria);
    List<KeyItemEto> hits = page.getContent();
    assertThat(hits).hasSize(1);
    KeyItemEto hit = hits.get(0);
    assertThat(hit.getKey()).isEqualTo("DE");
    assertThat(hit.getValue()).isEqualTo("DEU");
  }

  private Map<String, String> createServiceConfig() {

    return createServiceConfig("admin", "admin");
  }

  private Map<String, String> createServiceConfig(String login, String password) {

    Map<String, String> serviceConfig = new ServiceClientConfigBuilder().host("localhost").authBasic().userLogin(login)
        .userPassword(password).buildMap();
    return serviceConfig;
  }

}
