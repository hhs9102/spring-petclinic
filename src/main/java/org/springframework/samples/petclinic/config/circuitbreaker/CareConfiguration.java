package org.springframework.samples.petclinic.config.circuitbreaker;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class CareConfiguration {
    CircuitBreakerRegistry circuitBreakerRegistry;

    public CareConfiguration(CircuitBreakerRegistry circuitBreakerRegistry) {
        CircuitBreakerConfig config  = CircuitBreakerConfig.ofDefaults();
        this.circuitBreakerRegistry = CircuitBreakerRegistry.of(config);

        CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker("careExternal");
        circuitBreaker.getEventPublisher()
            .onStateTransition(event ->{
                log.info(String.format("name : [%s], from : [%s], to : [%s]", event.getCircuitBreakerName(), event.getStateTransition().getFromState().toString(), event.getStateTransition().getToState().toString()));
                if (CircuitBreaker.StateTransition.CLOSED_TO_OPEN.equals(event.getStateTransition())){
                    log.info(":::::::::::::CircuitBreaker is Open:::::::::::::");
                }
            });
    }


}
