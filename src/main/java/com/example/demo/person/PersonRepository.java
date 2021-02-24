package com.example.demo.person;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import reactor.core.publisher.Flux;

public interface PersonRepository extends ReactiveNeo4jRepository<Person, Long>  {

    @Query("MATCH (p:Person {name: $name}) " +
            "CALL apoc.path.subgraphAll(p, { " +
            "relationshipFilter: 'KNOWS', " +
            "   labelFilter: 'Person'," +
            "   minLevel: 0," +
            "   maxLevel: 3" +
            "})" +
            "YIELD nodes, relationships " +
            "RETURN p, nodes, relationships;")
    Flux<Person> getSubGraph(String name);

}
