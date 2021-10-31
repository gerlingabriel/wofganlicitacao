package com.sistema.wofganlicitacao.excecao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleTratamento {

    @ExceptionHandler(ExcecaoNoExiste.class)
    public ResponseEntity<MsgErro> entityNotFound(ExcecaoNoExiste ex, HttpServletRequest request){

        MsgErro erro = new MsgErro();
        erro.setError("Recurso não encontrado");
        erro.setMsg(ex.getMessage());
        erro.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    /** O certo é fazer me uma class separada
     * InnerHandleTratamento
     */
    public class MsgErro {

        private String msg;
        private String error;
        private Integer status;
        public String getMsg() {
            return msg;
        }
        public void setMsg(String msg) {
            this.msg = msg;
        }
        public String getError() {
            return error;
        }
        public void setError(String error) {
            this.error = error;
        }
        public Integer getStatus() {
            return status;
        }
        public void setStatus(Integer status) {
            this.status = status;
        }
    
        
    }
    
}
