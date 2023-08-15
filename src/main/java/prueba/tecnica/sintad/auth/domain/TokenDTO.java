package prueba.tecnica.sintad.auth.domain;

import java.io.Serializable;

public class TokenDTO implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;

    public TokenDTO(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }
}