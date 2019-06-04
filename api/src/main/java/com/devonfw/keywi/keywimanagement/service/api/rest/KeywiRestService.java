package com.devonfw.keywi.keywimanagement.service.api.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/services/rest/keywimanagement/v1")
public interface KeywiRestService {

  @Path("/dummy")
  @GET
  boolean dummyGet();
}
