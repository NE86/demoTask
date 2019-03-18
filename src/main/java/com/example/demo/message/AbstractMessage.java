package com.example.demo.message;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

import java.io.Serializable;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AdminMessage.class, name = "admin"),
        @JsonSubTypes.Type(value = UserMessage.class, name = "user")
})
@Data
public abstract class AbstractMessage implements Serializable {

    protected Long id;
    protected String type;
}
