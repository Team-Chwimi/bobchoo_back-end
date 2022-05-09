package com.chwimi.bobchoo.global.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_question")
public class Question extends BaseEntity {

    @Column(name = "question", length = 200, nullable = false)
    private String question;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "overlap")
    private boolean overLap;

    @OneToMany(mappedBy = "question")
    private List<QuestionAnswer> questionAnswers;

}
