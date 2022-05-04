package com.chwimi.bobchoo.global.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_answer")
public class Answer extends BaseEntity {

    @Column(name = "answer", length = 500, nullable = false)
    private String answer;

    @OneToMany(mappedBy = "answer")
    private Set<QuestionAnswer> questionAnswers;

}
