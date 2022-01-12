#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.connector.rest.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "${symbol_dollar}{rest-client.service-name.serviceCode}", url = "${symbol_dollar}{rest-client.service-name.base-url}")
public interface ServiceNameRestClient {//TODO change Name
}
