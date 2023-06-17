package com.josevabo.appfinancas.resource;

import com.josevabo.appfinancas.dto.LancamentoCreateDTO;
import com.josevabo.appfinancas.dto.LancamentoDto;
import com.josevabo.appfinancas.service.LancamentoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Path("/lancamento")
@ApplicationScoped
public class LancamentoResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(LancamentoResource.class);

    @Inject
    LancamentoService service;

    @Inject
    Mapper mapper;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarTodosPorUsuario() {
        List<LancamentoDto> lancamentos = mapper.mapList(service.buscarTodosPorUsuario(), LancamentoDto.class);
        return Response.ok(lancamentos).build();
    }

    @GET
    @Path("/xxx")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPaginadoPorUsuario() {
        return service.buscarPaginadoPorUsuario();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public void create(LancamentoCreateDTO lancamento){
        service.create(lancamento);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@Valid LancamentoDto lancamento){
        return service.update(lancamento);
    }
    @GET
    @Path("/relatorio")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response exportarRelatorioCsv(@QueryParam("dataInicio") Date dataInicio, @QueryParam("dataFim") Date dataFim){
        return service.gerarRelatorioCsv(dataInicio, dataFim);
    }

    @GET
    @Path("/totalMensal")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response buscarTotalMensalPorCategoria(@QueryParam("dataInicio") Date dataInicio, @QueryParam("dataFim") Date dataFim){
        return service.buscarTotalMensalPorCategoria(dataInicio, dataFim);
    }
}
