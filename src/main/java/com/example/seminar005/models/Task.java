package com.example.seminar005.models;

import jakarta.persistence.*;
import lombok.*;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@Entity
@Table(name = "tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Task{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(columnDefinition = "varchar(15) default 'NOT_STARTED'")

    @Column(name = "NAME", nullable = false)
    private String name;
//
  //  @Column(columnDefinition = "varchar(50) default 'NOT_STARTED'")
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private TaskStatus status = TaskStatus.NOT_STARTED;
//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_CREATED")
    private LocalDateTime dtCreate = LocalDateTime.now();

    //@CreationTimestamp
    //private Timestamp dtCreate;


    public String getStatusStr(){
        return status.getTitle();
    }
}
