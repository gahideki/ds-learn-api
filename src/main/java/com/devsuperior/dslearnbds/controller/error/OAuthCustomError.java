package com.devsuperior.dslearnbds.controller.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonProperty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OAuthCustomError {

    private String error;

    @JsonProperty("error_description")
    private String errorDescription;

}
