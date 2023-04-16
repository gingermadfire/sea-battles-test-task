package ru.redsoft.warships.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.time.Instant;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Warships {

    @Id
    @Column(nullable = false)
    private String name;

    @Enumerated
    @Column(name = "CLASS", nullable = false)
    private WarshipClass warshipClass;

    @Column(nullable = false)
    private Instant commissionDate;

    @Column(nullable = false)
    private Instant decommissionDate;

}
