package com.se.team19.server.Entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "DataOlder")
public class DataOlder {
    @Id
    @SequenceGenerator(name = "dataolder_seq", sequenceName = "dataolder_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dataolder_seq")
    @Column(name = "Dataolder_ID", unique = true, nullable = false)
    private @NonNull Long id;
    private @NonNull String oldername;
    private @NonNull Date olderbirth;
    private @NonNull String parentphone;


}
