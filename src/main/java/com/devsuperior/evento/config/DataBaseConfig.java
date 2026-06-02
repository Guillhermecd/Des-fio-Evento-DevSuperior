package com.devsuperior.evento.config;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.devsuperior.evento.entities.Atividade;
import com.devsuperior.evento.entities.Bloco;
import com.devsuperior.evento.entities.Categoria;
import com.devsuperior.evento.entities.Participante;
import com.devsuperior.evento.repositories.AtividadeRepository;
import com.devsuperior.evento.repositories.BlocoRepository;
import com.devsuperior.evento.repositories.CategoriaRepository;
import com.devsuperior.evento.repositories.ParticipanteRepository;

@Configuration
public class DataBaseConfig implements CommandLineRunner {

    private final CategoriaRepository categoriaRepository;
    private final AtividadeRepository atividadeRepository;
    private final BlocoRepository blocoRepository;
    private final ParticipanteRepository participanteRepository;

    public DataBaseConfig(CategoriaRepository categoriaRepository,
            AtividadeRepository atividadeRepository,
            BlocoRepository blocoRepository,
            ParticipanteRepository participanteRepository) {
        this.categoriaRepository = categoriaRepository;
        this.atividadeRepository = atividadeRepository;
        this.blocoRepository = blocoRepository;
        this.participanteRepository = participanteRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria c1 = new Categoria(null, "Curso");
        Categoria c2 = new Categoria(null, "Oficina");

        c1 = categoriaRepository.save(c1);
        c2 = categoriaRepository.save(c2);

        Atividade a1 = new Atividade(null, "Curso de HTML", "Aprenda HTML de forma prática", 80.00);
        Atividade a2 = new Atividade(null, "Oficina de Github", "Controle versões de seus projetos", 50.00);

        a1.setCategoria(c1);
        a2.setCategoria(c2);

        a1 = atividadeRepository.save(a1);
        a2 = atividadeRepository.save(a2);

        ZonedDateTime zdt1 = ZonedDateTime.of(2017, 9, 25, 8, 0, 0, 0, ZoneId.of("UTC"));
        ZonedDateTime zdt2 = ZonedDateTime.of(2017, 9, 25, 11, 0, 0, 0, ZoneId.of("UTC"));
        Instant inicio1 = zdt1.toInstant();
        Instant fim1 = zdt2.toInstant();

        Bloco b1 = new Bloco(null, inicio1, fim1);
        b1.setAtividade(a1);
        b1 = blocoRepository.save(b1);

        ZonedDateTime zdt3 = ZonedDateTime.of(2017, 9, 25, 14, 0, 0, 0, ZoneId.of("UTC"));
        ZonedDateTime zdt4 = ZonedDateTime.of(2017, 9, 25, 18, 0, 0, 0, ZoneId.of("UTC"));
        Instant inicio2 = zdt3.toInstant();
        Instant fim2 = zdt4.toInstant();

        Bloco b2 = new Bloco(null, inicio2, fim2);
        b2.setAtividade(a2);
        b2 = blocoRepository.save(b2);

        ZonedDateTime zdt5 = ZonedDateTime.of(2017, 9, 26, 8, 0, 0, 0, ZoneId.of("UTC"));
        ZonedDateTime zdt6 = ZonedDateTime.of(2017, 9, 26, 11, 0, 0, 0, ZoneId.of("UTC"));
        Instant inicio3 = zdt5.toInstant();
        Instant fim3 = zdt6.toInstant();

        Bloco b3 = new Bloco(null, inicio3, fim3);
        b3.setAtividade(a2);
        b3 = blocoRepository.save(b3);

        Participante p1 = new Participante(null, "José Silva", "jose@gmail.com");
        Participante p2 = new Participante(null, "Tiago Faria", "tiago@gmail.com");
        Participante p3 = new Participante(null, "Maria do Rosário", "maria@gmail.com");
        Participante p4 = new Participante(null, "Teresa Silva", "teresa@gmail.com");

        p1 = participanteRepository.save(p1);
        p2 = participanteRepository.save(p2);
        p3 = participanteRepository.save(p3);
        p4 = participanteRepository.save(p4);

        p1.getAtividades().add(a1);
        p2.getAtividades().add(a1);
        p2.getAtividades().add(a2);
        p3.getAtividades().add(a2);
        p4.getAtividades().add(a2);

        p1 = participanteRepository.save(p1);
        p2 = participanteRepository.save(p2);
        p3 = participanteRepository.save(p3);
        p4 = participanteRepository.save(p4);

        System.out.println("Dados de seeding carregados com sucesso!");
    }
}
