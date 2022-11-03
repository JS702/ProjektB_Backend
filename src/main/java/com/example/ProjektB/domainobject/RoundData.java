package com.example.ProjektB.domainobject;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.ProjektB.domainvalue.RoundType;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document(collection = "round")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoundData {

    @Id
    private String id;

    private String mediaFileId;

    private Position position;

    private RoundType type;

}
