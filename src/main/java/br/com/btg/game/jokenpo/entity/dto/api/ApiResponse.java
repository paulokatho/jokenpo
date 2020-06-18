package br.com.btg.game.jokenpo.entity.dto.api;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ApiResponse {

	private Meta meta;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public ApiResponse() {
    }

    public ApiResponse(T data) {
        this.meta = new Meta(new Timestamp(System.currentTimeMillis()));
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
