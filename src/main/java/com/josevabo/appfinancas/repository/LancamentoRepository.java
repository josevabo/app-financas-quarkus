package com.josevabo.appfinancas.repository;

import com.josevabo.appfinancas.model.Lancamento;
import com.josevabo.appfinancas.dto.LancamentoCreateDTO;
import com.josevabo.appfinancas.dto.LancamentoDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class LancamentoRepository {
    @Inject
    EntityManager em;

    public Response buscarPaginadoPorUsuario() {
        return null;
    }

    public void create(Lancamento lancamento) {
        lancamento.setTsCriacao(LocalDateTime.now());
        em.persist(lancamento);
    }

    public Response update(LancamentoDto lancamento) {
        return null;
    }

    public Response buscarPorPeriodo(Date dataInicio, Date dataFim) {
        return null;
    }

    public List<Lancamento> buscarTodosPorUsuario(Long idUsuario) {
        final String HQL = "select l from Lancamento l " +
                "join l.conta c " +
                "join c.usuario u " +
                "where u.id = :idUsuario";

        return em.createQuery(HQL).setParameter("idUsuario", idUsuario).getResultList();
    }
}
