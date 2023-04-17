package ru.redsoft.warships.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Warship {

    private Long id;

    private String name;

    private WarshipClass warshipClass;

    private Instant commissionDate;

    private Instant decommissionDate;

}
