package io.swagger.api.factories;

import io.swagger.api.ResolveDependenciesApiService;
import io.swagger.api.impl.ResolveDependenciesApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-10-19T18:38:01.167111+05:30[Asia/Colombo]")public class ResolveDependenciesApiServiceFactory {
    private final static ResolveDependenciesApiService service = new ResolveDependenciesApiServiceImpl();

    public static ResolveDependenciesApiService getResolveDependenciesApi() {
        return service;
    }
}
