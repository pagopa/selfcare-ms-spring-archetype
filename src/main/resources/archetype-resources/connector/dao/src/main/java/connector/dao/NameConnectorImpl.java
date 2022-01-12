#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.connector.dao;

//import ${package}.connector.api.NameConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NameConnectorImpl /*implements NameConnector*/ {//TODO change Name

    private final NameRepository repository;//TODO change Name


    @Autowired
    public NameConnectorImpl(NameRepository repository) {
        this.repository = repository;
    }

    // delegate methods to repository

}
