package com.TechConnecGrupo3.TechConnecapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import com.TechConnecGrupo3.TechConnecapi.security.JWTConfigurer;
import com.TechConnecGrupo3.TechConnecapi.security.JWTFilter;
import com.TechConnecGrupo3.TechConnecapi.security.JwtAuthenticationEntryPoint;
import com.TechConnecGrupo3.TechConnecapi.security.TokenProvider;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@EnableMethodSecurity //Importante para anotaciones @PreAuthorize
public class WebSecurityConfig {

    private final TokenProvider tokenProvider;
    private final JWTFilter jwtRequestFilter;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults()) // TODO: Permite solicitudes CORS desde otros dominios
                .csrf(AbstractHttpConfigurer::disable) // TODO: Desactiva la proteccion CSRF, ya que en APIs REST no se usa (se autentica con tokens, no con cookies)

                .authorizeHttpRequests(authorize -> authorize
                        // TODO: Permitir acceso publico a las rutas de login, registro y endpoints publicos como Swagger UI
                        .requestMatchers(antMatcher("/auth/login")).permitAll()
                        .requestMatchers(antMatcher("/auth/register/customer")).permitAll()
                        
                        // Rutas de documentacion API
                        .requestMatchers("/api/v1/swagger-ui/**", 
                                       "/v3/api-docs/**", 
                                       "/swagger-ui.html",
                                         "/v3/swagger-ui.html",
                                "/v3/swagger-ui/index.html",
                                       "/swagger-ui/**",
                                       "/webjars/**").permitAll()
                        
                        // Rutas de checkout y pagos
                        .requestMatchers(antMatcher("/checkout/create-payment")).authenticated()
                        .requestMatchers(antMatcher("/checkout/capture-payment")).authenticated()

                        // Rutas de registro
                        .requestMatchers(antMatcher("/admin/users")).permitAll()

                        // Rutas de compras (purchases)
                        .requestMatchers(antMatcher("/purchases/**")).authenticated()
                        .requestMatchers(antMatcher("/purchases/history")).authenticated()
                        .requestMatchers(antMatcher("/purchases/report")).hasRole("ADMIN")
                        
                        // Rutas de eventos
                        .requestMatchers(antMatcher("/event/search")).permitAll() // GET publico
                        .requestMatchers(antMatcher("/events/**")).authenticated()

                        // Rutas de categoria
                        .requestMatchers(antMatcher("/category/**")).permitAll() // GET publico
                        
                        // Rutas de usuarios
                        .requestMatchers(antMatcher("/users/profile")).authenticated()
                        .requestMatchers(antMatcher("/users/**")).authenticated()
                        
                        // Rutas de chat
                        .requestMatchers(antMatcher("/chats/**")).authenticated()
                        .requestMatchers(antMatcher("/data/**")).authenticated()
                        
                        // Rutas de notificaciones por email
                        .requestMatchers(antMatcher("/mail/**")).permitAll()
                        .requestMatchers("/api/v1/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**", "/webjars/**").permitAll()
                        // TODO: Cualquier otra solicitud requiere autenticacion (JWT u otra autenticacion configurada)
                        .anyRequest().authenticated()
                )

                // TODO: Permite la autenticacion basica (para testing con Postman, por ejemplo)
                //.httpBasic(Customizer.withDefaults())
                // TODO: Desactiva el formulario de inicio de sesion predeterminado, ya que se usara JWT
                .formLogin(AbstractHttpConfigurer::disable)
                // TODO: Configura el manejo de excepciones para autenticacion. Usa JwtAuthenticationEntryPoint para manejar errores 401 (no autorizado)
                .exceptionHandling(e -> e.authenticationEntryPoint(jwtAuthenticationEntryPoint))
                // TODO: Configura la politica de sesiones como "sin estado" (stateless), ya que JWT maneja la autenticacion, no las sesiones de servidor
                .sessionManagement(h -> h.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // TODO: Agrega la configuracion para JWT en el filtro antes de los filtros predeterminados de Spring Security
                .with(new JWTConfigurer(tokenProvider), Customizer.withDefaults());

        // TODO: Anadir el JWTFilter antes del filtro de autenticacion de nombre de usuario/contrasena.
        //  Esto permite que el JWTFilter valide el token antes de la autenticacion
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        // TODO: Proporciona el AuthenticationManager que gestionara la autenticacion basada en los detalles de usuario y contrasena
        return authenticationConfiguration.getAuthenticationManager();
    }

}
