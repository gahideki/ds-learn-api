package com.devsuperior.dslearnbds.dto;

import com.devsuperior.dslearnbds.model.enums.DeliverStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliverRevisionDTO {

    private DeliverStatus status;
    private String feedback;
    private Integer correctCount;
    
}
