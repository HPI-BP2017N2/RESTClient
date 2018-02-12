package de.hpi.restclient.properties;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
@ConfigurationProperties("shoprulesgenerator")
@Getter @Setter
public class ShopRulesGeneratorProperties {

    private String root, getRulesRoute;

}
