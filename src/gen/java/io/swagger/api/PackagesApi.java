package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.PackagesApiService;
import io.swagger.api.factories.PackagesApiServiceFactory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import io.swagger.model.ErrorJsonSchema;
import java.io.File;
import io.swagger.model.ModuleJsonSchema;
import io.swagger.model.PackageJsonSchema;
import io.swagger.model.PackageStatsJsonSchema;
import io.swagger.model.VersionListJsonSchema;

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


@Path("/packages")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-10-19T18:38:01.167111+05:30[Asia/Colombo]")public class PackagesApi  {
   private final PackagesApiService delegate;

   public PackagesApi(@Context ServletConfig servletContext) {
      PackagesApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("PackagesApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (PackagesApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = PackagesApiServiceFactory.getPackagesApi();
      }

      this.delegate = delegate;
   }

    @GET
    @Path("/{orgNamePath}/{packageNamePath}/{version}/{moduleNamePath}")
    
    @Produces({ "application/json" })
    @Operation(summary = "", description = "Get module information", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Module is found", content = @Content(schema = @Schema(implementation = ModuleJsonSchema.class))),
        
        @ApiResponse(responseCode = "404", description = "Matching module not found", content = @Content(schema = @Schema(implementation = ErrorJsonSchema.class))),
        
        @ApiResponse(responseCode = "500", description = "When a system error occurs", content = @Content(schema = @Schema(implementation = ErrorJsonSchema.class))) })
    public Response getModule(@Parameter(in = ParameterIn.PATH, description = "The organization name of the module.",required=true) @PathParam("orgNamePath") String orgNamePath
,@Parameter(in = ParameterIn.PATH, description = "The name of the package.",required=true) @PathParam("packageNamePath") String packageNamePath
,@Parameter(in = ParameterIn.PATH, description = "The version or version range of the package.",required=true) @PathParam("version") String version
,@Parameter(in = ParameterIn.PATH, description = "The name of the module.",required=true) @PathParam("moduleNamePath") String moduleNamePath
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getModule(orgNamePath,packageNamePath,version,moduleNamePath,securityContext);
    }

    @GET
    @Path("/{orgNamePath}/{packageNamePath}/{version}")
    
    @Produces({ "application/octet-stream", "application/json" })
    @Operation(summary = "", description = "Get package with version", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "302", description = "Package is found", content = @Content(schema = @Schema(implementation = File.class))),
        
        @ApiResponse(responseCode = "200", description = "Package Metadata", content = @Content(schema = @Schema(implementation = PackageJsonSchema.class))),
        
        @ApiResponse(responseCode = "404", description = "Matching package not found", content = @Content(schema = @Schema(implementation = ErrorJsonSchema.class))),
        
        @ApiResponse(responseCode = "500", description = "When a system error occurs", content = @Content(schema = @Schema(implementation = ErrorJsonSchema.class))) })
    public Response getPackage(@Parameter(in = ParameterIn.PATH, description = "The organization name of the package.",required=true) @PathParam("orgNamePath") String orgNamePath
,@Parameter(in = ParameterIn.PATH, description = "The name of the package.",required=true) @PathParam("packageNamePath") String packageNamePath
,@Parameter(in = ParameterIn.PATH, description = "The version or version range of the module.",required=true) @PathParam("version") String version
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getPackage(orgNamePath,packageNamePath,version,securityContext);
    }

    @GET
    @Path("/{orgNamePath}/{packageNamePath}")
    
    @Produces({ "application/json" })
    @Operation(summary = "", description = "Get the versions package", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "List of versions", content = @Content(schema = @Schema(implementation = VersionListJsonSchema.class))),
        
        @ApiResponse(responseCode = "404", description = "Matching package not found", content = @Content(schema = @Schema(implementation = ErrorJsonSchema.class))),
        
        @ApiResponse(responseCode = "500", description = "When a system error occurs", content = @Content(schema = @Schema(implementation = ErrorJsonSchema.class))) })
    public Response getPackageVersions(@Parameter(in = ParameterIn.PATH, description = "The organization name of the package.",required=true) @PathParam("orgNamePath") String orgNamePath
,@Parameter(in = ParameterIn.PATH, description = "The name of the package.",required=true) @PathParam("packageNamePath") String packageNamePath
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getPackageVersions(orgNamePath,packageNamePath,securityContext);
    }

    @GET
    @Path("/stats/{orgNamePath}/{packageNamePath}/{version}")
    
    @Produces({ "application/json" })
    @Operation(summary = "", description = "Get stats for package", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Package Stats", content = @Content(schema = @Schema(implementation = PackageStatsJsonSchema.class))),
        
        @ApiResponse(responseCode = "404", description = "Matching package not found", content = @Content(schema = @Schema(implementation = ErrorJsonSchema.class))),
        
        @ApiResponse(responseCode = "500", description = "When a system error occurs", content = @Content(schema = @Schema(implementation = ErrorJsonSchema.class))) })
    public Response getPullStatsForPackage(@Parameter(in = ParameterIn.PATH, description = "The organization name of the package.",required=true) @PathParam("orgNamePath") String orgNamePath
,@Parameter(in = ParameterIn.PATH, description = "The name of the package.",required=true) @PathParam("packageNamePath") String packageNamePath
,@Parameter(in = ParameterIn.PATH, description = "The version or version range of the module.",required=true) @PathParam("version") String version
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getPullStatsForPackage(orgNamePath,packageNamePath,version,securityContext);
    }

    @POST
    
    @Consumes({ "application/octet-stream" })
    @Produces({ "application/json" })
    @Operation(summary = "", description = "Pushing a package to registry.", security = {
        @SecurityRequirement(name = "Authorization")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Package pushed successfully."),
        
        @ApiResponse(responseCode = "400", description = "When invalid payload is received.", content = @Content(schema = @Schema(implementation = ErrorJsonSchema.class))),
        
        @ApiResponse(responseCode = "500", description = "When a system error occurs", content = @Content(schema = @Schema(implementation = ErrorJsonSchema.class))) })
    public Response pushPackage(@Parameter(in = ParameterIn.DEFAULT, description = "*.balo file." ,required=true) Object body

,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.pushPackage(body,securityContext);
    }

    @GET
    
    @Produces({ "application/json" })
    @Operation(summary = "", description = "Search packages in registry", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Search package results", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ModuleJsonSchema.class)))),
        
        @ApiResponse(responseCode = "400", description = "When invalid payload is received.", content = @Content(schema = @Schema(implementation = ErrorJsonSchema.class))),
        
        @ApiResponse(responseCode = "500", description = "When a system error occurs", content = @Content(schema = @Schema(implementation = ErrorJsonSchema.class))) })
    public Response searchPackage(@Parameter(in = ParameterIn.QUERY, description = "The number of packages in the result.") @QueryParam("limit") Integer limit
,@Parameter(in = ParameterIn.QUERY, description = "Offset for the results.") @QueryParam("offset") Integer offset
,@Parameter(in = ParameterIn.QUERY, description = "Sort order.") @DefaultValue("null") @QueryParam("sort") String sort
,@Parameter(in = ParameterIn.QUERY, description = "Search by organization name.") @QueryParam("org") String org
,@Parameter(in = ParameterIn.QUERY, description = "Search by package name.") @QueryParam("module") String module
,@Parameter(in = ParameterIn.QUERY, description = "Search by ballerina version.") @QueryParam("ballerina_version") String ballerinaVersion
,@Parameter(in = ParameterIn.QUERY, description = "Search by package platform.") @DefaultValue("null") @QueryParam("platform") String platform
,@Parameter(in = ParameterIn.QUERY, description = "Search by module.md/description.") @QueryParam("description") String description
,@Parameter(in = ParameterIn.QUERY, description = "Search by whether a package is a template or not.") @QueryParam("template") Boolean template
,@Parameter(in = ParameterIn.QUERY, description = "Search by keywords.") @DefaultValue("null") @QueryParam("keyword") String keyword
,@Parameter(in = ParameterIn.QUERY, description = "Filter modules by current user.  An empty array is returned if anonymous user. ") @DefaultValue("false") @QueryParam("my-package") Boolean myPackage
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.searchPackage(limit,offset,sort,org,module,ballerinaVersion,platform,description,template,keyword,myPackage,securityContext);
    }
}
