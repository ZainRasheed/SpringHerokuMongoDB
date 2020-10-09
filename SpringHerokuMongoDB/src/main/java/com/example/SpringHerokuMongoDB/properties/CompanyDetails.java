package com.example.SpringHerokuMongoDB.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Document(collection = "CompanyDetails")
public class CompanyDetails {

    @Id
    private Object id;

/*    @NotNull(message = "Nooooo")
    @NotEmpty(message = "Nooooo")*/
    @NotBlank(message = "mandatory")
    private  String name;

/*    @NotNull(message = "Nooooo")
    @NotEmpty(message = "Nooooo")*/
    @NotBlank(message = "mandatory")
    private  String description;
}
