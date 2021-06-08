package br.com.zup.zupacademy.daniel.proposta.common.externalServices.analiseFinanceira;

import br.com.zup.zupacademy.daniel.proposta.proposta.StatusAnalise;

public enum ResultadoSolicitacao {
    COM_RESTRICAO {
        @Override
        public StatusAnalise toStatusAnalise() {
            return StatusAnalise.NAO_ELEGIVEL;
        }
    },
    SEM_RESTRICAO {
        @Override
        public StatusAnalise toStatusAnalise() {
            return StatusAnalise.ELEGIVEL;
        }
    };

    public abstract StatusAnalise toStatusAnalise();
}
