package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
@Component()
public class ValidadorHorarioAntecedenciaAgendamento implements ValidadorAgendamentoDeConsultas {

    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferncaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();
        if(diferncaEmMinutos< 30 ){
            throw new ValidacaoException("Consulta deve ser agendada com antecedencia de no minimo 30 minutos");
        }
    }
}
