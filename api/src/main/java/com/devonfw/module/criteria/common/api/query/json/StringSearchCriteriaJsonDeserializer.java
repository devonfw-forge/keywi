package com.devonfw.module.criteria.common.api.query.json;

import java.io.IOException;

import com.devonfw.module.criteria.common.api.query.LiteralSearchCriteria;
import com.devonfw.module.criteria.common.api.query.SearchCriteria;
import com.devonfw.module.criteria.common.api.query.SearchOperator;
import com.devonfw.module.criteria.common.api.query.StringSearchCriteria;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * {@link JsonDeserializer} for {@link StringSearchCriteria}.
 */
public class StringSearchCriteriaJsonDeserializer extends JsonDeserializer<StringSearchCriteria> {

  @SuppressWarnings({ "unchecked", "rawtypes" })
  @Override
  public StringSearchCriteria deserialize(JsonParser p, DeserializationContext ctxt)
      throws IOException, JsonProcessingException {

    JsonNode node = p.getCodec().readTree(p);
    String op = readStringProperty(node, SearchCriteria.PROPERTY_OPERATOR);
    SearchOperator<?> operator = SearchOperator.get(op);
    String literal = readStringProperty(node, LiteralSearchCriteria.PROPERTY_LITERAL);
    return new StringSearchCriteria((SearchOperator) operator, literal);
  }

  private String readStringProperty(JsonNode node, String property) {

    JsonNode childNode = node.get(property);
    if (childNode == null) {
      return null;
    }
    return childNode.textValue();
  }

}
