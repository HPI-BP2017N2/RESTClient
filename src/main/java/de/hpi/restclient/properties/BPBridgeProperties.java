package de.hpi.restclient.properties;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Component
@EnableConfigurationProperties
@ConfigurationProperties("bpbridge")
@Getter @Setter
public class BPBridgeProperties {

    private String root, shopIDToURLRoute, getRandomOfferRoute, matchAttributeRoute, matchAttributeWithMapRoute;

}
