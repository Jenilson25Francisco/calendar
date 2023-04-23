package com.zanguetsuinc.calendar.domain.model;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class ReminderSpecs {

    public static Specification<Reminder> usingFilter(ReminderFilter filter){

        return (root, query, builder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if(StringUtils.hasText(filter.getTitle())){
                predicates.add(builder.equal(root.get("title"), filter.getTitle()));
            }

            if(filter == null){
                return builder.and(predicates.toArray(new Predicate[0]));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };

    }

}
