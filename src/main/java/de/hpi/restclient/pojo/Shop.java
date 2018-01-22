package de.hpi.restclient.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shop")
@Getter @Setter
public class Shop {

    private long shopID;
    private String url;

}
