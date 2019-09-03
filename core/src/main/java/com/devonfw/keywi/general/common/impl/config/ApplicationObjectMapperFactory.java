package com.devonfw.keywi.general.common.impl.config;

import javax.inject.Named;

import org.springframework.security.web.csrf.CsrfToken;

import com.devonfw.module.criteria.common.api.query.LiteralSearchCriteria;
import com.devonfw.module.criteria.common.api.query.StringSearchCriteria;
import com.devonfw.module.criteria.common.api.query.json.LiteralSearchCriteriaJsonSerializer;
import com.devonfw.module.criteria.common.api.query.json.StringSearchCriteriaJsonDeserializer;
import com.devonfw.module.json.common.base.ObjectMapperFactory;
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
    // register StringSearchCriteria mapping
    module.addSerializer(LiteralSearchCriteria.class, new LiteralSearchCriteriaJsonSerializer());
    module.addDeserializer(StringSearchCriteria.class, new StringSearchCriteriaJsonDeserializer());
  }
}
