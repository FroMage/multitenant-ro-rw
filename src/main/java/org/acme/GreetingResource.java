package org.acme;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/")
public class GreetingResource {

	@Path("read-only/read")
    @GET
    public long readOnlyRead() {
		return MyEntity.count();
    }

	@Transactional
	@Path("read-only/write")
    @GET
    public long readOnlyWrite() {
		MyEntity entity = new MyEntity();
		entity.persist();
		return MyEntity.count();
    }

	@ReadWrite
	@Path("read-write/read")
    @GET
    public long readWriteRead() {
		return MyEntity.count();
    }

	@ReadWrite
	@Transactional
	@Path("read-write/write")
    @GET
    public long readWriteWrite() {
		MyEntity entity = new MyEntity();
		entity.persist();
		return MyEntity.count();
    }
}
