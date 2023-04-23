package com.zanguetsuinc.calendar.api.model.input;

import com.zanguetsuinc.calendar.domain.model.Reminder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class ReminderInput {

    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotNull
    private Date data;

    public Reminder toDomain() {
        return toDomain(null);
    }

    public Reminder toDomain(Long reminderId) {
        return Reminder.builder()
                .id(reminderId)
                .title(title)
                .description(description)
                .data(data)
                .build();
    }

}
