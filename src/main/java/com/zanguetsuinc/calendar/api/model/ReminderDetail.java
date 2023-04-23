package com.zanguetsuinc.calendar.api.model;

import com.zanguetsuinc.calendar.domain.model.Reminder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class ReminderDetail {

    private Long id;
    private String title;
    private String description;
    private Date data;

    public static ReminderDetail of(Reminder reminder){
        return ReminderDetail.builder()
                .id(reminder.getId())
                .title(reminder.getTitle())
                .description(reminder.getDescription())
                .data(reminder.getData())
                .build();
    }

}
