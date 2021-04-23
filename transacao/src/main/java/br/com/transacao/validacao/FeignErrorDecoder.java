package br.com.transacao.validacao;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class FeignErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {

		switch (response.status()) {
		case 422:
			throw new ApiErroException(HttpStatus.UNPROCESSABLE_ENTITY, response.toString());
		default:
			throw new ApiErroException(HttpStatus.BAD_REQUEST, "Erro interno da outra api.");

		}

	}

}
