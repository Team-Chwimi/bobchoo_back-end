package com.chwimi.bobchoo.global.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long questionId;

    @Column(name = "question", length = 200)
    private String question;

    @Column(name = "question_description", length = 1000)
    private String questionDescription;

    @Column(name = "question_overlap")
    private Boolean questionOverLap;

    @OneToMany(mappedBy = "question")
    private Set<QuestionAnswer> questionAnswers;

}
