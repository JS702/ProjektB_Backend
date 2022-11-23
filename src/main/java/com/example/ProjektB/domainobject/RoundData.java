package com.example.ProjektB.domainobject;

import com.example.ProjektB.domainvalue.RoundType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document( collection = "round" )
@JsonInclude( JsonInclude.Include.NON_NULL )
public class RoundData {

    @Id
    private String id;

    private String mediaFileId;

    private Position position;

    private RoundType type;

}
