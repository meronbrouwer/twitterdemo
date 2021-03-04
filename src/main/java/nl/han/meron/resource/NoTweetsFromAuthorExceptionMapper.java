package nl.han.meron.resource;

import nl.han.meron.datasource.NoTweetsFromAuthorException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NoTweetsFromAuthorExceptionMapper implements ExceptionMapper<NoTweetsFromAuthorException> {

    @Override
    public Response toResponse(NoTweetsFromAuthorException e) {
        return Response.status(404).build();
    }
}
