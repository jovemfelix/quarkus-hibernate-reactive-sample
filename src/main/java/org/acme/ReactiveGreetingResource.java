package org.acme;

import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional;
import io.smallrye.mutiny.Uni;
import org.jboss.resteasy.reactive.RestPath;

import javax.ws.rs.*;
import java.util.List;

@Path("fruits")
@Produces("application/json")
@Consumes("application/json")
public class ReactiveGreetingResource{
    @GET
    public Uni<List<Fruit>> listAll() { //<1>
        return Fruit.listAll();
    }

    @GET
    @Path("{id}")
    public Uni<Fruit> findById(@RestPath Long id) { //<2>
        return Fruit.findById(id);
    }

    @POST
    @ReactiveTransactional
    public Uni<Fruit> create(Fruit fruit) { //<3>
        return Fruit.persist(fruit).replaceWith(fruit);
    }

    @DELETE
    @Path("{id}")
    @ReactiveTransactional
    public Uni<Void> delete(@RestPath Long id) { //<4>
        return Fruit.deleteById(id).replaceWithVoid();
    }
}