package ufps.web.professionacare.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import org.springframework.web.cors.CorsConfigurationSource;

import ufps.web.professionacare.backend.auth.EpsAuthenticationManager;
import ufps.web.professionacare.backend.auth.filter.JWTAuthenticationFilter;
import ufps.web.professionacare.backend.auth.filter.JWTAuthorizationFilter;
import ufps.web.professionacare.backend.auth.service.JWTService;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JWTService jwtService;

	@Autowired
	private AccessDeniedHandler accessDeniedHandler;

	@Autowired
	private CorsConfigurationSource corsConfigurationSource;

	@Autowired
	private EpsAuthenticationManager epsAuthenticationManager;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().cors()
				.configurationSource(corsConfigurationSource).and().csrf().disable().authorizeRequests().and()
				.authorizeRequests()
				.antMatchers("/", "/validate/", "/images/**", "/files/**", "/favicon.ico", "/api/file/**",
						"/api/facturacion/pdf/**", "/api/facturacion/pdf-fondo/**",
						"/api/suministro/xlsx-general/**/**/**/**/**/**/**", "/api/suministro/xlsx-general-file/**",
						"/api/suministro/xlsx-general-file-2/**",
						"/api/suministro/verificar-datos-facturacion/**/**/**/**",
						"/api/suministro/ReporteEntregaGeneral/**",
						"/api/suministro/plan-general-all/**/**/**/**")
				.permitAll()
				.antMatchers(HttpMethod.POST, "/cambio_servicio_entregado", "/cambio_servicio_valor", "/validadorDirs",
						"/reporteEntregaEstado/**", "/anular_servicios", "/insertar_masivo_solinsa", 
						"/insertar_masivo_solinsa_eliminar", "/consultar_masivo_solinsa", "/agregar_causal_no_entrega",  
						"/cambio_servicio_fecha", "/api/suministro/plan-general-plano", "/cambio_fecha_entrega_ambito")
				.permitAll().anyRequest().authenticated().and().exceptionHandling()
				.accessDeniedHandler(accessDeniedHandler).and()
				.addFilter(new JWTAuthenticationFilter(epsAuthenticationManager, jwtService))
				.addFilter(new JWTAuthorizationFilter(epsAuthenticationManager, jwtService));
		http.headers().frameOptions().disable();
	}

	@Bean
	public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
		StrictHttpFirewall firewall = new StrictHttpFirewall();
		firewall.setAllowUrlEncodedSlash(true);
		return firewall;
	}

}
