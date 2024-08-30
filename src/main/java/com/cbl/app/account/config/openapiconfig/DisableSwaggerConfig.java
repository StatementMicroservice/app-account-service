package com.cbl.app.account.config.openapiconfig;


import com.cbl.app.account.config.profileconfig.ConditionalOnProfile;
import com.cbl.app.account.enums.EnvironmentProfile;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ConditionalOnProfile({EnvironmentProfile.PROD
                       , EnvironmentProfile.QA
                       , EnvironmentProfile.UAT})
@Configuration
public class DisableSwaggerConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/city-statement/app-account/v3/api-docs").addResourceLocations("classpath:/no-swagger/");
        registry.addResourceHandler("/city-statement/app-account/v3/api-docs.yml")
                .addResourceLocations("classpath:/no-swagger/");
        registry.addResourceHandler("/city-statement/app-account/v3/api-docs/**")
                .addResourceLocations("classpath:/no-swagger/");
        registry.addResourceHandler("/city-statement/app-account/swagger-resources")
                .addResourceLocations("classpath:/no-swagger/");
        registry.addResourceHandler("/city-statement/app-account/swagger-resources/**")
                .addResourceLocations("classpath:/no-swagger/");
        registry.addResourceHandler("/city-statement/app-account/swagger-ui").addResourceLocations("classpath:/no-swagger/");
        registry.addResourceHandler("/city-statement/app-account/swagger-ui.html")
                .addResourceLocations("classpath:/no-swagger/");
        registry.addResourceHandler("/city-statement/app-account/swagger-ui/index.html")
                .addResourceLocations("classpath:/no-swagger/");
    }
}
