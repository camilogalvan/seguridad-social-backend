package ufps.web.professionacare.backend.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ufps.web.professionacare.backend.container.UsuarioApi;
import ufps.web.professionacare.backend.container.UsuarioEntradaApi;
import ufps.web.professionacare.backend.container.UsuariosApi;
import ufps.web.professionacare.backend.model.SsptRol;
import ufps.web.professionacare.backend.model.SsptUsuario;
import ufps.web.professionacare.backend.service.SsptRolService;
import ufps.web.professionacare.backend.service.SsptTipoIdentificacionService;
import ufps.web.professionacare.backend.service.SsptUsuarioService;
import ufps.web.professionacare.backend.util.ValidationException;

@RestController
@RequestMapping("/api/usuario/")
public class UsuarioController {

	@Autowired
	private SsptUsuarioService service;

	@Autowired
	private SsptRolService rolService;

	@Autowired
	private SsptTipoIdentificacionService tipoIdService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Secured({ "ROLE_ADMIN", "ROLE_PROV" })
	@GetMapping("all")
	public UsuariosApi getListUsuarios() {

		UsuariosApi api = new UsuariosApi();

		api.setUsuarios(service.buscarTodos());

		return api;
	}

	@Secured({ "ROLE_ADMIN" })
	@GetMapping("byRol/{rol}")
	public UsuariosApi getListUsuariosByRol(@PathVariable String rol) {
		UsuariosApi api = new UsuariosApi();

		SsptRol rolSearch = rolService.buscarPorRol(rol);

		if (rolSearch != null) {
			api.setUsuarios(service.buscarPorRol(rolSearch));
		}
		return api;
	}

	@Secured({ "ROLE_ADMIN", "ROLE_PROV" })
	@GetMapping("byUsuario/{identificacion}")
	public UsuarioApi getUsuario(@PathVariable String identificacion) {
		UsuarioApi api = new UsuarioApi();

		SsptUsuario usuarioSearch = service.buscarPorIdentificacion(identificacion);

		api.setUsuario(usuarioSearch);
		return api;
	}

	@PostMapping("passwordEdit")
	public ResponseEntity<Boolean> editPassword(@RequestBody String passwordNew) {
		Boolean hecho = false;

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		SsptUsuario usuarioActual = service.buscarPorUsername(authentication.getName());

		if (usuarioActual != null) {

			if (passwordNew != null && passwordNew.trim().length() > 4) {

				usuarioActual.setPassword(passwordEncoder.encode(passwordNew));
				try {
					service.guardar(usuarioActual);
					hecho = true;
				} catch (Exception e) {
					throw new ValidationException(e.getMessage(), e, HttpStatus.BAD_REQUEST);
				}

			} else {
				throw new ValidationException("La contraseña no cumple con los criterios de seguiridad",
						HttpStatus.BAD_REQUEST);
			}
		} else {
			throw new ValidationException("Usuario inexistente", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(hecho, HttpStatus.OK);
	}

	@Secured({ "ROLE_ADMIN", "ROLE_PROV" })
	@PostMapping("enableEdit/{identificacion}/{enableNew}")
	public ResponseEntity<Boolean> editEstado(@PathVariable String identificacion, @PathVariable Boolean enableNew) {
		Boolean hecho = false;

		SsptUsuario usuario = service.buscarPorIdentificacion(identificacion);

		if (usuario != null) {

			if (enableNew != null && enableNew != usuario.getEnable()) {

				usuario.setEnable(enableNew);
				try {
					service.guardar(usuario);
					hecho = true;
				} catch (Exception e) {
					throw new ValidationException(e.getMessage(), e, HttpStatus.BAD_REQUEST);
				}

			} else {
				throw new ValidationException("El estado no ha cambiado", HttpStatus.BAD_REQUEST);
			}
		} else {
			throw new ValidationException("Usuario inexistente", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(hecho, HttpStatus.OK);
	}

	@Secured({ "ROLE_ADMIN", "ROLE_PROV" })
	@PostMapping("")
	public ResponseEntity<UsuarioApi> save(@RequestBody(required = false) UsuarioEntradaApi entrada) {

		if (entrada != null && entrada.getIdentificacion() != null && !entrada.getIdentificacion().isEmpty()
				&& entrada.getIdentificacion().length() > 5) {

			entrada.setIdentificacion(entrada.getIdentificacion().trim());

			SsptUsuario usuario = service.buscarPorIdentificacion(entrada.getIdentificacion());

			if (usuario == null) {

				UsuarioApi api = new UsuarioApi();

				usuario = new SsptUsuario();
				usuario.setIdentificacion(entrada.getIdentificacion());
				usuario.setNombres(entrada.getNombres());
				usuario.setApellidos(entrada.getApellidos());

				usuario.setEmail(entrada.getEmail());
				usuario.setEnable(entrada.getEnable());
				usuario.setFechaActualizacion(new Date());

				usuario.setRol(rolService.buscarPorRol(entrada.getRol()));

				try {
					usuario.setTipoIdentificacion(tipoIdService.buscarPorTipo(entrada.getTipoId()));
				} catch (Exception e) {
					throw new ValidationException(e.getMessage(), e, HttpStatus.BAD_REQUEST);
				}

				if (!verificarEmail(entrada.getEmail())) {
					throw new ValidationException("El correo electronico ingresado ya existe", HttpStatus.BAD_REQUEST);
				}

				usuario.setPassword(passwordEncoder.encode(usuario.getIdentificacion()));
				usuario.setUsername(crearNombreUsuario(usuario));

				try {
					usuario = service.guardar(usuario);
					api.setUsuario(usuario);
				} catch (Exception e) {
					throw new ValidationException(e.getMessage(), e, HttpStatus.BAD_REQUEST);
				}
				return new ResponseEntity<>(api, HttpStatus.OK);
			} else {
				throw new ValidationException(
						"El usuario con identificación '" + entrada.getIdentificacion() + "' ya existe",
						HttpStatus.BAD_REQUEST);
			}
		} else {
			throw new ValidationException("La identificación '" + entrada.getIdentificacion() + "' es invalida",
					HttpStatus.BAD_REQUEST);
		}

	}

	@Secured({ "ROLE_ADMIN" })
	@PostMapping("update")
	public ResponseEntity<UsuarioApi> update(@RequestBody(required = false) UsuarioEntradaApi entrada) {

		if (entrada != null && entrada.getIdentificacion() != null && !entrada.getIdentificacion().isEmpty()
				&& entrada.getIdentificacion().length() > 5) {

			SsptUsuario usuario = service.buscarPorIdentificacion(entrada.getIdentificacion());

			if (usuario != null) {

				UsuarioApi api = new UsuarioApi();

				SsptRol rol = usuario.getRol();
				try {
					if (rol == null || !rol.getRol().equals(entrada.getRol())) {
						rol = rolService.buscarPorRol(entrada.getRol());
					}
				} catch (Exception e) {
				}

				if (!usuario.getEmail().equalsIgnoreCase(entrada.getEmail())) {
					if (!verificarEmail(entrada.getEmail())) {
						throw new ValidationException("El correo electronico ingresado ya existe",
								HttpStatus.BAD_REQUEST);
					}
				}

				// VALORES CAMBIANTES
				usuario.setEmail(entrada.getEmail());
				usuario.setEnable(entrada.getEnable());
				usuario.setRol(rol);

				try {
					usuario = service.guardar(usuario);
					api.setUsuario(usuario);
				} catch (Exception e) {
					throw new ValidationException(e.getMessage(), HttpStatus.BAD_REQUEST);
				}
				return new ResponseEntity<>(api, HttpStatus.OK);
			} else {
				throw new ValidationException(
						"El usuario con identificación '" + entrada.getIdentificacion() + "' no existe",
						HttpStatus.BAD_REQUEST);
			}
		} else {
			throw new ValidationException("La identificación '" + entrada.getIdentificacion() + "' es invalida",
					HttpStatus.BAD_REQUEST);
		}

	}

	private boolean verificarEmail(String email) {

		if (email == null || email.isEmpty()) {
			return false;
		}

		SsptUsuario usuario = service.buscarPorEmail(email);
		if (usuario != null) {
			return false;
		}

		return true;
	}

	private String crearNombreUsuario(SsptUsuario usuario) {
		String username = "";

		if (usuario.getRol().getRol().equals("ROLE_USER")) {

			username = "USER" + usuario.getIdentificacion();

		} else {

			username = "ADMI" + usuario.getIdentificacion();

		}

		return username;
	}

}
