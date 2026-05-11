package benassila.meryem.benassilameryem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/auth")
public class SecurityController {

    @Autowired
    private AuthenticationManager authentificationManager;
    @Autowired
    private JwtEncoder jwtEncoder;


    @GetMapping("/profile")
    public Authentication authentication(Authentication authentication){
        return authentication;

    }


    @PostMapping("/login")
    public Map<String ,String> login(String username , String password){
        Authentication authentification= authentificationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        Instant instant=Instant.now();//Récupérer le temps actuel
        String scope = authentification.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(" "));
        System.out.println("SCOPE = " + scope);
        JwtClaimsSet jwtClaimsSet=JwtClaimsSet.builder()
                .issuedAt(instant)
                .expiresAt(instant.plus(100, ChronoUnit.MINUTES))
                .subject(username)
                .claim("scope",scope)
                .build();




        JwtEncoderParameters jwtEncoderParametersrers=
                JwtEncoderParameters.from(
                        JwsHeader.with(MacAlgorithm.HS512).build(),
                        jwtClaimsSet);

        String jwt = jwtEncoder.encode(jwtEncoderParametersrers).getTokenValue();
        return Map.of("acces-tocken",jwt);
    }



}
