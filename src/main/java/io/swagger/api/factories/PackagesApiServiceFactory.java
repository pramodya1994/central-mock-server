package io.swagger.api.factories;

import io.swagger.api.PackagesApiService;
import io.swagger.api.impl.PackagesApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-10-19T18:38:01.167111+05:30[Asia/Colombo]")public class PackagesApiServiceFactory {
    private final static PackagesApiService service = new PackagesApiServiceImpl();

    public static PackagesApiService getPackagesApi() {
        return service;
    }
}
