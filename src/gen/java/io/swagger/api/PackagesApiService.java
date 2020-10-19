package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

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

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-10-19T18:38:01.167111+05:30[Asia/Colombo]")public abstract class PackagesApiService {
    public abstract Response getModule(String orgNamePath,String packageNamePath,String version,String moduleNamePath,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getPackage(String orgNamePath,String packageNamePath,String version,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getPackageVersions(String orgNamePath,String packageNamePath,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getPullStatsForPackage(String orgNamePath,String packageNamePath,String version,SecurityContext securityContext) throws NotFoundException;
    public abstract Response pushPackage(Object body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchPackage( Integer limit, Integer offset, String sort, String org, String module, String ballerinaVersion, String platform, String description, Boolean template, String keyword, Boolean myPackage,SecurityContext securityContext) throws NotFoundException;
}
