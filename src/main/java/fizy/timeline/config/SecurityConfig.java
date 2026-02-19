package fizy.timeline.config;

import fizy.timeline.security.JwtAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Configure CORS with all origins and methods allowed
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.addAllowedOrigin("*"); // Allow all origins
        corsConfig.addAllowedMethod(HttpMethod.GET); // Allow GET requests
        corsConfig.addAllowedMethod(HttpMethod.POST); // Allow POST requests
        corsConfig.addAllowedMethod(HttpMethod.PUT); // Allow PUT requests
        corsConfig.addAllowedMethod(HttpMethod.DELETE); // Allow DELETE requests
        corsConfig.addAllowedHeader("*"); // Allow all headers
        corsConfig.setAllowCredentials(true); // Allow credentials (cookies, authorization headers, etc.)

        // Register the CORS configuration for all endpoints
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig); // Apply the configuration globally

        // Configure Spring Security
        return http
                .cors(cors -> cors.configurationSource(source)) // Apply the CorsConfiguration
                .csrf(csrf -> csrf.disable())  // Disable CSRF (common for APIs)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()  // Allow OPTIONS preflight request
                        .requestMatchers("/", "/swagger-ui/**", "/v3/api-docs/**", "/api/timeline/auth/**").permitAll()  // Public access to certain endpoints
                        .anyRequest().authenticated()  // Protect other endpoints with authentication
                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)  // JWT filter
                .build();
    }
}
