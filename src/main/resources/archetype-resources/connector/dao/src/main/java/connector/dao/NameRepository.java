#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.connector.dao;

import ${package}.connector.dao.model.NameEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NameRepository extends MongoRepository<NameEntity, String> {//TODO change Name
}
