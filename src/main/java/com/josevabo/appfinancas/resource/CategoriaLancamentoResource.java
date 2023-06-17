package com.josevabo.appfinancas.resource;

import com.josevabo.appfinancas.dto.LancamentoCreateDTO;
import com.josevabo.appfinancas.dto.LancamentoDto;
import com.josevabo.appfinancas.service.LancamentoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/categorialancamento")
@ApplicationScoped
public class CategoriaLancamentoResource {

    @Inject
    LancamentoService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPaginadoPorUsuario() {
        return service.buscarPaginadoPorUsuario();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(@Valid LancamentoCreateDTO lancamento){
        service.create(lancamento);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@Valid LancamentoDto lancamento){
        return service.update(lancamento);
    }
}
