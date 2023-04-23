package com.zanguetsuinc.calendar.api.model;

import com.zanguetsuinc.calendar.domain.model.Reminder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class ReminderSummary {

    private Long id;
    private String title;
    private Date data;

    public static ReminderSummary of(Reminder reminder) {
        return ReminderSummary.builder()
                .id(reminder.getId())
                .title(reminder.getTitle())
                .data(reminder.getData())
                .build();
    }
}