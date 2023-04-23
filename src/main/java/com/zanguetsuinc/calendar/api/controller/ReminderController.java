package com.zanguetsuinc.calendar.api.controller;

import com.zanguetsuinc.calendar.api.model.ReminderDetail;
import com.zanguetsuinc.calendar.api.model.ReminderSummary;
import com.zanguetsuinc.calendar.api.model.input.ReminderInput;
import com.zanguetsuinc.calendar.domain.model.Reminder;
import com.zanguetsuinc.calendar.domain.model.ReminderFilter;
import com.zanguetsuinc.calendar.domain.repository.ReminderRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reminders")
@AllArgsConstructor
public class ReminderController {

    private final ReminderRepository reminderRepository;

    @GetMapping
    public List<ReminderSummary> getAll(ReminderFilter filter){

        List<Reminder> reminderList = this.reminderRepository.findAll();
        return reminderList.stream().map(ReminderSummary::of).toList();

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReminderDetail create(@Valid @RequestBody ReminderInput reminderInput){
        Reminder reminder = reminderInput.toDomain();
        this.reminderRepository.save(reminder);
        return ReminderDetail.of(reminder);
    }

    @GetMapping("/{reminderId}")
    public ReminderDetail getOne(@PathVariable Long reminderId) {
        Reminder reminder = this.reminderRepository.findById(reminderId).orElseThrow();
        return ReminderDetail.of(reminder);
    }

    @PutMapping("/{reminderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody ReminderInput reminderInput, @PathVariable Long reminderId){
        Reminder actualReminder = this.reminderRepository.findById(reminderId).orElseThrow();
        actualReminder.update(reminderInput.toDomain(reminderId));
        reminderRepository.save(actualReminder);
    }

    @DeleteMapping("/{reminderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long reminderId){
        Reminder reminder = this.reminderRepository.findById(reminderId).orElseThrow();
        reminderRepository.delete(reminder);
    }

}
