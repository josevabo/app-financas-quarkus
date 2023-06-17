package com.josevabo.appfinancas.service;

import com.josevabo.appfinancas.model.CategoriaLancamento;
import com.josevabo.appfinancas.model.Conta;
import com.josevabo.appfinancas.model.DestinoLancamento;
import com.josevabo.appfinancas.model.Lancamento;
import com.josevabo.appfinancas.dto.LancamentoCreateDTO;
import com.josevabo.appfinancas.dto.LancamentoDto;
import com.josevabo.appfinancas.repository.LancamentoRepository;
import com.josevabo.appfinancas.resource.Mapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class LancamentoService {

    @Inject
    Mapper mapper;

    @Inject
    LancamentoRepository repository;

    public Response buscarPaginadoPorUsuario() {
        return repository.buscarPaginadoPorUsuario();
    }

    public void create(LancamentoCreateDTO lancamentoDTO) {
        Lancamento lancamento = mapper.map(lancamentoDTO, Lancamento.class);
        repository.create(lancamento);
    }

    public Response update(LancamentoDto lancamento) {
        return repository.update(lancamento);
    }

    public Response gerarRelatorioCsv(Date dataInicio, Date dataFim) {
        return repository.buscarPorPeriodo(dataInicio, dataFim);
    }

    public Response buscarTotalMensalPorCategoria(Date dataInicio, Date dataFim) {
        return null;
    }

    public List<Lancamento> buscarTodosPorUsuario() {
        Long idUsuario = 1L;
        return repository.buscarTodosPorUsuario(idUsuario);
    }
}
