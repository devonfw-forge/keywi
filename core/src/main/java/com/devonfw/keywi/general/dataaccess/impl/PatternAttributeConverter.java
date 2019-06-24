package com.devonfw.keywi.general.dataaccess.impl;

import java.util.regex.Pattern;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * {@link AttributeConverter} for {@link Pattern}.
 */
@Converter(autoApply = true)
public class PatternAttributeConverter implements AttributeConverter<Pattern, String> {

  @Override
  public String convertToDatabaseColumn(Pattern pattern) {

    if (pattern == null) {
      return null;
    }
    return pattern.pattern();
  }

  @Override
  public Pattern convertToEntityAttribute(String pattern) {

    if (pattern == null) {
      return null;
    }
    return Pattern.compile(pattern);
  }

}