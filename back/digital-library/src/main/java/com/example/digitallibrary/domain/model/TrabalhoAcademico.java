package com.example.digitallibrary.domain.model;

import com.example.digitallibrary.domain.model.enums.Area;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
//@Table(name = "trabalho")
public class TrabalhoAcademico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", length = 100)
    private String titulo;
    @Column(name = "resumo", nullable = false)
    private String resumo;
//    @ElementCollection(fetch = FetchType.LAZY)
//    @CollectionTable(name = "palavrasChave")
//    private Set<String> palavrasChave = new LinkedHashSet<>();
    private String palavrasChave;
    private int ano;
    private String autor;
    private String orientador;


    @Enumerated(EnumType.STRING)
    private Area area;

    @OneToOne
    private Arquivo arquivo;

//    @OneToMany(mappedBy = "trabalhoAcademico")
//    @Embedded
    @ElementCollection
//    @CollectionTable(name = "membros", joinColumns = @JoinColumn(name = /*"trabalho_id"*/"trabalho_academico_id"),
//                    foreignKey = @ForeignKey(name = /*"membros_trabalho_fk"*/"membros_trabalho_academico_fk"))
    private Set<Membro> membros = new LinkedHashSet<>();

    public TrabalhoAcademico() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getPalavrasChave() {
        return palavrasChave;
    }

    public void setPalavrasChave(String palavrasChave) {
        this.palavrasChave = palavrasChave;
    }
    //    public Set<String> getPalavraChave() {
//        return palavrasChave;
//    }
//
//    public void addPalavraChave(String palavraChave) {
//        this.palavrasChave.add(palavraChave);
//    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getOrientador() {
        return orientador;
    }

    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Arquivo getArquivo() {
        return arquivo;
    }

    public void setArquivo(Arquivo arquivo) {
        this.arquivo = arquivo;
    }

    public Set<Membro> getMembros() {
        return membros;
    }

    public void setMembros(Set<Membro> membros) {
        this.membros = membros;
    }

    public Long getId() {
        return id;
    }
}
