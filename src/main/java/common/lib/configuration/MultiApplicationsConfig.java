package common.lib.configuration;

import common.lib.filters.PingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultiApplicationsConfig {
    @Bean
    public FilterRegistrationBean<PingFilter> loggingFilter() {
        FilterRegistrationBean<PingFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new PingFilter());
        filterFilterRegistrationBean.addUrlPatterns("/ping");
        return filterFilterRegistrationBean;
    }
}
