package br.com.fatec.atividade_2_ci_cd.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/disciplinas")
public class DisciplinasController {

    private final Map<Integer, Map<String, String>> disciplinasDB = new HashMap<>();
    private int nextId = 3;

    public DisciplinasController() {
        disciplinasDB.put(1, Map.of("id", "1", "Disciplina", "Programação de Dispositivos Móveis"));
        disciplinasDB.put(2, Map.of("id", "2", "Disciplina", "Estatística Aplicada"));
        disciplinasDB.put(3, Map.of("id", "3", "Disciplina", "Engenharia de Software"));
        disciplinasDB.put(4, Map.of("id", "4", "Disciplina", "Banco de Dados"));
        disciplinasDB.put(5, Map.of("id", "5", "Disciplina", "Desenvolvimento Web"));
        disciplinasDB.put(6, Map.of("id", "6", "Disciplina", "Sistemas Operacionais e Redes de Computadores"));
    }

    @GetMapping
    public List<Map<String, String>> getDisciplinas() {
        return new ArrayList<>(disciplinasDB.values());
    }

    @GetMapping("/{id}")
    public Map<String, String> getDisciplinaById(@PathVariable int id) {
        return disciplinasDB.get(id);
    }

    @PostMapping
    public Map<String, String> createDisciplina(@RequestBody Map<String, String> data) {
        Map<String, String> novaDisciplina = new HashMap<>();
        novaDisciplina.put("id", String.valueOf(nextId));
        novaDisciplina.put("Disciplina", data.get("Disciplina"));

        disciplinasDB.put(nextId, novaDisciplina);
        nextId++;

        return novaDisciplina;
    }
}