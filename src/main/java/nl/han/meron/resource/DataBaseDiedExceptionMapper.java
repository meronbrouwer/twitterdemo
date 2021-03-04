package nl.han.meron.resource;

import nl.han.meron.datasource.DataBaseDiedException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DataBaseDiedExceptionMapper implements ExceptionMapper<DataBaseDiedException> {

    @Override
    public Response toResponse(DataBaseDiedException e) {
        return Response.status(500).build();
    }
}
