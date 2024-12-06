package org.example.data.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "todos")
public class ToDo {
    @Id
    private String id;
    private String title;
    private String description;
    private LocalDate localDate;
    private boolean completed;
    private String userId;


}
