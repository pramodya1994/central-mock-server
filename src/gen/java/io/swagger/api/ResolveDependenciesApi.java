package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.ResolveDependenciesApiService;
import io.swagger.api.factories.ResolveDependenciesApiServiceFactory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import io.swagger.model.ResolvePackagesJsonSchema;
import io.swagger.model.ResolvedPackagesJsonSchema;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;


@Path("/resolve-dependencies")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-10-19T18:38:01.167111+05:30[Asia/Colombo]")public class ResolveDependenciesApi  {
   private final ResolveDependenciesApiService delegate;

   public ResolveDependenciesApi(@Context ServletConfig servletContext) {
      ResolveDependenciesApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("ResolveDependenciesApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (ResolveDependenciesApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = ResolveDependenciesApiServiceFactory.getResolveDependenciesApi();
      }

      this.delegate = delegate;
   }

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "", description = "Resolve module versions", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Package versions are resolved", content = @Content(schema = @Schema(implementation = ResolvedPackagesJsonSchema.class))) })
    public Response resolvePackageDependencies(@Parameter(in = ParameterIn.DEFAULT, description = "" ) ResolvePackagesJsonSchema body

,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.resolvePackageDependencies(body,securityContext);
    }
}
