package com.devonfw.keywi.general.common.impl.config;

import javax.inject.Named;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.web.csrf.CsrfToken;

import com.devonfw.module.basic.common.api.reference.IdRef;
import com.devonfw.module.basic.common.api.reference.json.IdRefJsonDeserializer;
import com.devonfw.module.basic.common.api.reference.json.IdRefJsonSerializer;
import com.devonfw.module.criteria.common.api.query.LiteralSearchCriteria;
import com.devonfw.module.criteria.common.api.query.StringSearchCriteria;
import com.devonfw.module.criteria.common.api.query.json.LiteralSearchCriteriaJsonSerializer;
import com.devonfw.module.criteria.common.api.query.json.StringSearchCriteriaJsonDeserializer;
import com.devonfw.module.json.common.base.ObjectMapperFactory;
import com.devonfw.module.json.common.base.type.PageableJsonDeserializer;
import com.devonfw.module.json.common.base.type.PageableJsonSerializer;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * The MappingFactory class to resolve polymorphic conflicts within the keywi application.
 */
@Named("ApplicationObjectMapperFactory")
public class ApplicationObjectMapperFactory extends ObjectMapperFactory {

  /**
   * The constructor.
   */
  public ApplicationObjectMapperFactory() {

    super();
    // see https://github.com/devonfw-wiki/devon4j/wiki/guide-json#json-and-inheritance
    SimpleModule module = getExtensionModule();
    module.addAbstractTypeMapping(CsrfToken.class, CsrfTokenImpl.class);
    // register spring-data Pageable
    module.addSerializer(Pageable.class, new PageableJsonSerializer());
    module.addDeserializer(Pageable.class, new PageableJsonDeserializer());
    // register spring-data Page
    module.addAbstractTypeMapping(Page.class, JsonPage.class);
    module.setMixInAnnotation(Page.class, JsonPage.class);
    // register IdRef mapping
    module.addSerializer(IdRef.class, new IdRefJsonSerializer());
    module.addDeserializer(IdRef.class, new IdRefJsonDeserializer());
    // register StringSearchCriteria mapping
    module.addSerializer(LiteralSearchCriteria.class, new LiteralSearchCriteriaJsonSerializer());
    module.addDeserializer(StringSearchCriteria.class, new StringSearchCriteriaJsonDeserializer());
  }
}
