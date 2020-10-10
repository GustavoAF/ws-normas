package br.com.repositorio.normas.configuration;

import br.com.repositorio.normas.port.RepositorioNormasPort;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {

    private final Bus bus;

    @Autowired
    public WebServiceConfig(Bus bus) {
        this.bus = bus;
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new RepositorioNormasPort());
        endpoint.publish("/");
        return endpoint;
    }
}
