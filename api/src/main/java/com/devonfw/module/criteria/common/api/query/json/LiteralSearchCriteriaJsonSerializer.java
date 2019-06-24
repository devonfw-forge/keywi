package com.devonfw.module.criteria.common.api.query.json;

import java.io.IOException;
import java.math.BigDecimal;

import com.devonfw.module.criteria.common.api.query.LiteralSearchCriteria;
import com.devonfw.module.criteria.common.api.query.SearchCriteria;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * {@link JsonSerializer} for {@link LiteralSearchCriteria}.
 */
@SuppressWarnings("rawtypes")
public class LiteralSearchCriteriaJsonSerializer extends JsonSerializer<LiteralSearchCriteria> {

  @Override
  public void serialize(LiteralSearchCriteria value, JsonGenerator gen, SerializerProvider serializers)
      throws IOException {

    if (value == null) {
      return;
    }
    gen.writeStartObject();
    gen.writeStringField(SearchCriteria.PROPERTY_OPERATOR, value.getOperator().toString());
    Object literal = value.getLiteral();
    if (literal instanceof Number) {
      if (literal instanceof Integer) {
        gen.writeNumberField(LiteralSearchCriteria.PROPERTY_LITERAL, ((Integer) literal).intValue());
      } else if (literal instanceof Long) {
        gen.writeNumberField(LiteralSearchCriteria.PROPERTY_LITERAL, ((Long) literal).longValue());
      } else if (literal instanceof Double) {
        gen.writeNumberField(LiteralSearchCriteria.PROPERTY_LITERAL, ((Double) literal).doubleValue());
      } else if (literal instanceof Float) {
        gen.writeNumberField(LiteralSearchCriteria.PROPERTY_LITERAL, ((Float) literal).floatValue());
      } else if (literal instanceof BigDecimal) {
        gen.writeNumberField(LiteralSearchCriteria.PROPERTY_LITERAL, (BigDecimal) literal);
      } else {
        gen.writeNumberField(LiteralSearchCriteria.PROPERTY_LITERAL, ((Number) literal).doubleValue());
      }
    } else if (literal instanceof Boolean) {
      gen.writeBooleanField(LiteralSearchCriteria.PROPERTY_LITERAL, ((Boolean) literal).booleanValue());
    } else {
      gen.writeStringField(LiteralSearchCriteria.PROPERTY_LITERAL, literal.toString());
    }
    gen.writeEndObject();
  }
}
