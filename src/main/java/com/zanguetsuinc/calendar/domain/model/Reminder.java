package com.zanguetsuinc.calendar.domain.model;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Getter
@Builder
@Entity
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Date data;

    protected Reminder() {
    }

    public Reminder(Long id, String title, String description, Date data) {

        Objects.requireNonNull(title);
        Objects.requireNonNull(description);
        Objects.requireNonNull(data);

        this.id = id;
        this.title = title;
        this.description = description;
        this.data = data;
    }

    public void update(Reminder reminder){

        this.title = reminder.title;
        this.description = reminder.description;
        this.data = reminder.data;

    }

}
