package com.ras.store.application.fornecedor;

import com.ras.store.api.dto.FornecedorDto;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.Option;
import java.util.Objects;
import java.util.Optional;

@Service
public class FornecedorService {
    private static final String urlbase = "http://localhost:8181/api/suppliers";

    private RestTemplate api;

    private RestTemplate api() {
        if (Objects.isNull(api)) {
            this.api = new RestTemplate();
        }
        return api;
    }

    public Optional<FornecedorDto> obterFornecedor(@NonNull String estado) {
        final ResponseEntity<FornecedorDto> fornecedorResponse = api()
                .exchange(urlbase.concat("/states/").concat(estado),
                        HttpMethod.GET, null, FornecedorDto.class);

        if (fornecedorResponse.getStatusCode().equals(HttpStatus.OK)
                && Objects.nonNull(fornecedorResponse.getBody())) {
            return Optional.of(fornecedorResponse.getBody());
        }
        return Optional.empty();
    }
}
