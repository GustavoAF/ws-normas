package br.com.repositorio.normas.port;

import br.com.repositorio.normas.modelo.Norma;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import java.util.logging.Logger;

@SOAPBinding(style = javax.jws.soap.SOAPBinding.Style.RPC)
@WebService(serviceName = "Normas", portName = "RepositorioNormasPort", targetNamespace = "https://repositorionormas.com/")
public class RepositorioNormasPort {
    private final String STATUS = "EM_VIGOR";

    private static final Logger LOG = Logger.getLogger(RepositorioNormasPort.class.getName());

    @WebResult(name = "return")
    @RequestWrapper(localName = "codigoNorma", targetNamespace = "https://repositorionormas.com/",  className = "repositorionormas.com.codigoNorma")
    @WebMethod(action = "urn:normas")
    @ResponseWrapper(localName = "Norma", targetNamespace = "https://repositorionormas.com/", className = "repositorionormas.com.Norma")
    public Norma normas (@WebParam(name = "codigoNorma") String codigoNorma) {
        Norma norma = new Norma();
        norma.setCodigo("ABNT NBR 12984:2009");
        norma.setData("23/01/2009");
        norma.setDescricao("Não tecido - Determinação da massa por unidade de área");
        norma.setStatus(STATUS);
        LOG.info("Rodou!");
        return norma;

    }
}
