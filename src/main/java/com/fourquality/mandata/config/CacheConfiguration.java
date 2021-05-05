package com.fourquality.mandata.config;

import java.time.Duration;

import org.ehcache.config.builders.*;
import org.ehcache.jsr107.Eh107Configuration;

import io.github.jhipster.config.jcache.BeanClassLoaderAwareJCacheRegionFactory;
import io.github.jhipster.config.JHipsterProperties;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;

@Configuration
@EnableCaching
public class CacheConfiguration {

    private final javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration;

    public CacheConfiguration(JHipsterProperties jHipsterProperties) {
        BeanClassLoaderAwareJCacheRegionFactory.setBeanClassLoader(this.getClass().getClassLoader());
        JHipsterProperties.Cache.Ehcache ehcache =
            jHipsterProperties.getCache().getEhcache();

        jcacheConfiguration = Eh107Configuration.fromEhcacheCacheConfiguration(
            CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class,
                ResourcePoolsBuilder.heap(ehcache.getMaxEntries()))
                .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(ehcache.getTimeToLiveSeconds())))
                .build());
    }

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cm -> {
            cm.createCache(com.fourquality.mandata.repository.UserRepository.USERS_BY_LOGIN_CACHE, jcacheConfiguration);
            cm.createCache(com.fourquality.mandata.repository.UserRepository.USERS_BY_EMAIL_CACHE, jcacheConfiguration);
            cm.createCache(com.fourquality.mandata.domain.Authority.class.getName(), jcacheConfiguration);

            cm.createCache(com.fourquality.mandata.domain.User.class.getName(), jcacheConfiguration);
            cm.createCache(com.fourquality.mandata.domain.User.class.getName() + ".authorities", jcacheConfiguration);
            cm.createCache(com.fourquality.mandata.domain.Advogado.class.getName(), jcacheConfiguration);
            cm.createCache(com.fourquality.mandata.domain.Area.class.getName(), jcacheConfiguration);
            cm.createCache(com.fourquality.mandata.domain.Cliente.class.getName(), jcacheConfiguration);
            cm.createCache(com.fourquality.mandata.domain.Escritorio.class.getName(), jcacheConfiguration);
            cm.createCache(com.fourquality.mandata.domain.Evento.class.getName(), jcacheConfiguration);
            cm.createCache(com.fourquality.mandata.domain.Representado.class.getName(), jcacheConfiguration);
            cm.createCache(com.fourquality.mandata.domain.Tabela.class.getName(), jcacheConfiguration);
            cm.createCache(com.fourquality.mandata.domain.TabelaEvento.class.getName(), jcacheConfiguration);
            cm.createCache(com.fourquality.mandata.domain.TipoAdvogado.class.getName(), jcacheConfiguration);
            cm.createCache(com.fourquality.mandata.domain.TipoCliente.class.getName(), jcacheConfiguration);
            cm.createCache(com.fourquality.mandata.domain.TipoEvento.class.getName(), jcacheConfiguration);
            cm.createCache(com.fourquality.mandata.domain.TipoTabela.class.getName(), jcacheConfiguration);
            cm.createCache(com.fourquality.mandata.domain.Unidade.class.getName(), jcacheConfiguration);
            cm.createCache(com.fourquality.mandata.domain.AdvogadoCliente.class.getName(), jcacheConfiguration);
            cm.createCache(com.fourquality.mandata.domain.Risco.class.getName(), jcacheConfiguration);
            cm.createCache(com.fourquality.mandata.domain.TipoDocumento.class.getName(), jcacheConfiguration);
            cm.createCache(com.fourquality.mandata.domain.Tribunal.class.getName(), jcacheConfiguration);
            // jhipster-needle-ehcache-add-entry
        };
    }
}
